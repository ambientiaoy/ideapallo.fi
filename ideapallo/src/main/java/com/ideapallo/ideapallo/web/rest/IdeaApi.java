/**
* Copyright 2016 dryTools doo
* Email: contact@drytools.co
* 
* This file is part of ideapallo.
* 
* ideapallo is free software: you can redistribute it and/or modify
* it under the terms of the GNU General Public License as published by
* the Free Software Foundation, either version 3 of the License, or
* (at your option) any later version.
* 
* ideapallo is distributed in the hope that it will be useful,
* but WITHOUT ANY WARRANTY; without even the implied warranty of
* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
* GNU General Public License for more details.
* 
* You should have received a copy of the GNU General Public License
* along with ideapallo. If not, see <http://www.gnu.org/licenses/>.*
**/
package com.ideapallo.ideapallo.web.rest;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.ideapallo.ideapallo.security.JWTFilter;
import com.ideapallo.ideapallo.security.JWTUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;
import javax.validation.Valid;
import com.ideapallo.ideapallo.model.*;
import com.ideapallo.ideapallo.web.rest.dto.*;

import com.ideapallo.ideapallo.repository.*;


@RestController
@RequestMapping("/api/")
public class IdeaApi {

    private final Logger log = LoggerFactory.getLogger(IdeaApi.class);

    @Inject
    private IdeaRepository ideaRepository;

    @Inject
    private IdealistRepository idealistRepository;

    @Inject
    private TagRepository tagRepository;

    @RequestMapping(value = "/idea/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<ReadIdeaResponse> readIdea(@PathVariable Long id) {
        log.debug("GET /idea/{}", id);
        final Optional<Idea> result = Optional.ofNullable(ideaRepository.findOne(id));
        if (result.isPresent()) {
            return ResponseEntity.ok().body(convertToReadIdeaResponse(result.get()));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/idea", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<CreateIdeaResponse> createIdea(@Valid @RequestBody CreateIdeaRequest request) throws URISyntaxException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Long userId = (Long) authentication.getPrincipal();
        Idealist idealist = idealistRepository.findOne( userId );
        log.debug("POST /idea {}", request);
        final Idea idea = convertToIdea(request);
        idea.addIdealist( idealist );
        // TODO AkS: Add idealist here!
        final Idea result = ideaRepository.save(idea);
        return ResponseEntity.created(new URI("/idea/" + result.getId())).body(convertToCreateIdeaResponse(result));
    }

    @RequestMapping(value = "/idea/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<UpdateIdeaResponse> updateIdea(@PathVariable Long id, @Valid @RequestBody RestUpdateIdeaRequest request) {
        log.debug("PUT /idea/{} {}", id, request);
        final Idea idea = convertToIdea(id, request);
        final Idea result = ideaRepository.save(idea);
        return ResponseEntity.ok().body(convertToUpdateIdeaResponse(result));
    }

    @RequestMapping(value = "/idea/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteIdea(@PathVariable Long id) {
        log.debug("DELETE /idea/{}", id);
        ideaRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/ideas", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<List<IdeasResponse>> ideas() {
        log.debug("GET /ideas");
        final List<Idea> result = ideaRepository.ideas();
        return ResponseEntity.ok().body(result.stream().map(this::convertToIdeasResponse).collect(Collectors.toList()));
    }

    @RequestMapping(value = "/find-by-id", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<FindByIdResponse> findById(@RequestParam("id") Long id) {
        log.debug("GET /find-by-id");
        final Optional<Idea> result = ideaRepository.byId(id);
        if (result.isPresent()) {
            return ResponseEntity.ok().body(convertToFindByIdResponse(result.get()));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    private ReadIdeaResponse convertToReadIdeaResponse(Idea model) {
        final ReadIdeaResponse dto = new ReadIdeaResponse();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setContent(model.getContent());
        dto.setTagsId(model.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        return dto;
    }

    private Idea convertToIdea(CreateIdeaRequest dto) {
        final Idea idea = new Idea();
        idea.setTitle(dto.getTitle());
        idea.setContent(dto.getContent());
        final List<Tag> tags = tagRepository.findAll(dto.getTagsIds());
        idea.setTags(tags);
        return idea;
    }

    private CreateIdeaResponse convertToCreateIdeaResponse(Idea model) {
        final CreateIdeaResponse dto = new CreateIdeaResponse();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setContent(model.getContent());
        dto.setTagsId(model.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        return dto;
    }

    private Idea convertToIdea(Long id, RestUpdateIdeaRequest dto) {
        final Idea idea = new Idea();
        idea.setId(id);
        idea.setTitle(dto.getTitle());
        idea.setContent(dto.getContent());
        final List<Tag> tags = tagRepository.findAll(dto.getTagsIds());
        idea.setTags(tags);
        return idea;
    }

    private UpdateIdeaResponse convertToUpdateIdeaResponse(Idea model) {
        final UpdateIdeaResponse dto = new UpdateIdeaResponse();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setContent(model.getContent());
        dto.setTagsId(model.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        return dto;
    }

    private IdeasResponse convertToIdeasResponse(Idea model) {
        // TODO AkS: here was a merge conflict.
        final IdeasResponse dto = new IdeasResponse();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setContent(model.getContent());
        return dto;
    }

    private FindByIdResponse convertToFindByIdResponse(Idea model) {
        final FindByIdResponse dto = new FindByIdResponse();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setContent(model.getContent());
        dto.setIdealistId(model.getIdealist().stream().map(idealist -> idealist.getId()).collect(Collectors.toList()));
        dto.setTagsId(model.getTags().stream().map(Tag::getId).collect(Collectors.toList()));
        return dto;
    }
}
