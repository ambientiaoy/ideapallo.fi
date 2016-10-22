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

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.codahale.metrics.annotation.Timed;
import javax.validation.Valid;
import com.ideapallo.ideapallo.model.*;
import com.ideapallo.ideapallo.web.rest.dto.*;

import com.ideapallo.ideapallo.repository.*;


@RestController
@RequestMapping("/api/")
public class IdealistApi {

    private final Logger log = LoggerFactory.getLogger(IdealistApi.class);

    @Inject
    private AccountRepository accountRepository;

    @Inject
    private IdealistRepository idealistRepository;

    @RequestMapping(value = "/idealist/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional(readOnly = true)
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<ReadIdealistResponse> readIdealist(@PathVariable Long id) {
        log.debug("GET /idealist/{}", id);
        final Optional<Idealist> result = Optional.ofNullable(idealistRepository.findOne(id));
        if (result.isPresent()) {
            return ResponseEntity.ok().body(convertToReadIdealistResponse(result.get()));
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/idealist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<CreateIdealistResponse> createIdealist(@Valid @RequestBody CreateIdealistRequest request) throws URISyntaxException {
        log.debug("POST /idealist {}", request);
        final Idealist idealist = convertToIdealist(request);
        final Idealist result = idealistRepository.save(idealist);
        return ResponseEntity.created(new URI("/idealist/" + result.getId())).body(convertToCreateIdealistResponse(result));
    }

    @RequestMapping(value = "/idealist/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<UpdateIdealistResponse> updateIdealist(@PathVariable Long id, @Valid @RequestBody RestUpdateIdealistRequest request) {
        log.debug("PUT /idealist/{} {}", id, request);
        final Idealist idealist = convertToIdealist(id, request);
        final Idealist result = idealistRepository.save(idealist);
        return ResponseEntity.ok().body(convertToUpdateIdealistResponse(result));
    }

    @RequestMapping(value = "/idealist/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<Void> deleteIdealist(@PathVariable Long id) {
        log.debug("DELETE /idealist/{}", id);
        idealistRepository.delete(id);
        return ResponseEntity.ok().build();
    }

    private ReadIdealistResponse convertToReadIdealistResponse(Idealist model) {
        final ReadIdealistResponse dto = new ReadIdealistResponse();
        dto.setId(model.getId());
        dto.setAccountId(model.getAccount().getId());
        return dto;
    }

    private Idealist convertToIdealist(CreateIdealistRequest dto) {
        final Idealist idealist = new Idealist();
        final Account account = accountRepository.findOne(dto.getAccountId());
        idealist.setAccount(account);
        return idealist;
    }

    private CreateIdealistResponse convertToCreateIdealistResponse(Idealist model) {
        final CreateIdealistResponse dto = new CreateIdealistResponse();
        dto.setId(model.getId());
        dto.setAccountId(model.getAccount().getId());
        return dto;
    }

    private Idealist convertToIdealist(Long id, RestUpdateIdealistRequest dto) {
        final Idealist idealist = new Idealist();
        idealist.setId(id);
        final Account account = accountRepository.findOne(dto.getAccountId());
        idealist.setAccount(account);
        return idealist;
    }

    private UpdateIdealistResponse convertToUpdateIdealistResponse(Idealist model) {
        final UpdateIdealistResponse dto = new UpdateIdealistResponse();
        dto.setId(model.getId());
        dto.setAccountId(model.getAccount().getId());
        return dto;
    }
}
