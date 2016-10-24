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

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;
import javax.validation.Valid;
import com.ideapallo.ideapallo.model.*;
import com.ideapallo.ideapallo.web.rest.dto.*;

import com.ideapallo.ideapallo.repository.*;


@RestController
@RequestMapping("/api/")
public class TagApi {

    private final Logger log = LoggerFactory.getLogger(TagApi.class);

    @Inject
    private TagRepository tagRepository;

    @RequestMapping(value = "/tags", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    public ResponseEntity<List<TagsResponse>> tags() {
        log.debug("GET /tags");
        final List<Tag> result = tagRepository.tags();
        return ResponseEntity.ok().body(result.stream().map(this::convertToTagsResponse).collect(Collectors.toList()));
    }

    private TagsResponse convertToTagsResponse(Tag model) {
        final TagsResponse dto = new TagsResponse();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }
}
