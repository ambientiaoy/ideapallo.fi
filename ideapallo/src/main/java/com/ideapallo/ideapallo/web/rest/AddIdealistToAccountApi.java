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

import org.springframework.format.annotation.DateTimeFormat;


@RestController
@RequestMapping("/api/")
public class AddIdealistToAccountApi {

    private final Logger log = LoggerFactory.getLogger(AddIdealistToAccountApi.class);

    @Inject
    private AccountRepository accountRepository;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("hasAuthority('CLIENT') or hasAuthority('ADMIN')")
    public ResponseEntity<CreateResponse> create(@Valid @RequestBody CreateRequest request) throws URISyntaxException {
        log.debug("POST /create {}", request);
        final Account account = convertToAccount(request);
        final Account result = accountRepository.save(account);
        return ResponseEntity.created(new URI("/create/" + result.getId())).body(convertToCreateResponse(result));
    }

    private Account convertToAccount(CreateRequest dto) {
        final Account account = new Account();
        account.setUsername(Optional.ofNullable(dto.getUsername()));
        account.setRole(dto.getRole());
        account.setEmail(Optional.ofNullable(dto.getEmail()));
        account.setPasswordHash(Optional.ofNullable(dto.getPasswordHash()));
        account.setEmailVerificationCode(Optional.ofNullable(dto.getEmailVerificationCode()));
        account.setEmailVerificationCodeTimestamp(Optional.ofNullable(dto.getEmailVerificationCodeTimestamp()));
        account.setEmailVerified(Optional.ofNullable(dto.getEmailVerified()));
        account.setResetPasswordCode(Optional.ofNullable(dto.getResetPasswordCode()));
        account.setResetPasswordCodeTimestamp(Optional.ofNullable(dto.getResetPasswordCodeTimestamp()));
        account.setFacebookId(Optional.ofNullable(dto.getFacebookId()));
        return account;
    }

    private CreateResponse convertToCreateResponse(Account model) {
        final CreateResponse dto = new CreateResponse();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername().orElse(null));
        dto.setRole(model.getRole());
        dto.setEmail(model.getEmail().orElse(null));
        dto.setPasswordHash(model.getPasswordHash().orElse(null));
        dto.setEmailVerificationCode(model.getEmailVerificationCode().orElse(null));
        dto.setEmailVerificationCodeTimestamp(model.getEmailVerificationCodeTimestamp().orElse(null));
        dto.setEmailVerified(model.getEmailVerified().orElse(null));
        dto.setResetPasswordCode(model.getResetPasswordCode().orElse(null));
        dto.setResetPasswordCodeTimestamp(model.getResetPasswordCodeTimestamp().orElse(null));
        dto.setFacebookId(model.getFacebookId().orElse(null));
        return dto;
    }
}
