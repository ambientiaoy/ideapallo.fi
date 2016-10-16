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

import com.codahale.metrics.annotation.Timed;
import com.ideapallo.ideapallo.model.Account;
import com.ideapallo.ideapallo.service.AccountService;
import com.ideapallo.ideapallo.web.rest.dto.ChangePasswordRequest;
import com.ideapallo.ideapallo.web.rest.dto.ChangePasswordResponse;
import com.ideapallo.ideapallo.web.rest.dto.EmailSignInRequest;
import com.ideapallo.ideapallo.web.rest.dto.EmailSignInResponse;
import com.ideapallo.ideapallo.web.rest.dto.EmailSignUpRequest;
import com.ideapallo.ideapallo.web.rest.dto.EmailSignUpResponse;
import com.ideapallo.ideapallo.web.rest.dto.FacebookSignInRequest;
import com.ideapallo.ideapallo.web.rest.dto.FacebookSignInResponse;
import com.ideapallo.ideapallo.web.rest.dto.ForgotPasswordRequest;
import com.ideapallo.ideapallo.web.rest.dto.ResetPasswordRequest;
import com.ideapallo.ideapallo.web.rest.dto.VerifyEmailRequest;
import com.ideapallo.ideapallo.web.rest.dto.VerifyEmailResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/")
public class AuthenticationApi {

    private final Logger log = LoggerFactory.getLogger(AuthenticationApi.class);

    @Inject
    private AccountService accountService;


    @RequestMapping(value = "/email-sign-up", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<EmailSignUpResponse> emailSignUp(@Valid @RequestBody EmailSignUpRequest request) {
        log.debug("POST /email-sign-up {}", request);
        final Account account = accountService.emailSignUp(request.getEmail(), request.getPassword());
        return ResponseEntity.ok().body(convertToEmailSignUpResponse(account));
    }

    @RequestMapping(value = "/email-sign-in", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<EmailSignInResponse> emailSignIn(@Valid @RequestBody EmailSignInRequest request) {
        log.debug("POST /email-sign-in {}", request);
        final EmailSignInResponse response = accountService.emailSignIn(request.getEmail(), request.getPassword());
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/forgot-password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> forgotPassword(@Valid @RequestBody ForgotPasswordRequest request) {
        log.debug("POST /forgot-password {}", request);
        accountService.forgotPassword(request.getEmail());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/reset-password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<Void> resetPassword(@Valid @RequestBody ResetPasswordRequest request) {
        log.debug("POST /reset-password {}", request);
        accountService.resetPassword(request.getResetPasswordCode(), request.getNewPassword());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/verify-email", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<VerifyEmailResponse> verifyEmail(@Valid @RequestBody VerifyEmailRequest request) {
        log.debug("POST /verify-email {}", request);
        final Account account = accountService.verifyEmail(request.getEmailVerificationCode());
        return ResponseEntity.ok().body(convertToVerifyEmailResponse(account));
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<ChangePasswordResponse> changePassword(@Valid @RequestBody ChangePasswordRequest request, @ApiIgnore @AuthenticationPrincipal Long principalId) {
        log.debug("POST /change-password {}", request);
        final Account account = accountService.changePassword(principalId, request.getOldPassword(), request.getNewPassword());
        return ResponseEntity.ok().body(convertToChangePasswordResponse(account));
    }

    @RequestMapping(value = "/facebook-sign-in", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @Timed
    @Transactional
    public ResponseEntity<FacebookSignInResponse> facebookSignIn(@Valid @RequestBody FacebookSignInRequest request) {
        log.debug("POST /facebook-sign-in {}", request);
        final Optional<FacebookSignInResponse> response = accountService.facebookSignIn(request.getFacebookAccessToken());
        if (response.isPresent()) {
            return ResponseEntity.ok().body(response.get());
        }
        return new ResponseEntity<>(HttpStatus.FOUND);
    }

    private EmailSignUpResponse convertToEmailSignUpResponse(Account model) {
        final EmailSignUpResponse dto = new EmailSignUpResponse();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setRole(model.getRole());
        dto.setEmail(model.getEmail().orElse(null));
        return dto;
    }

    private VerifyEmailResponse convertToVerifyEmailResponse(Account model) {
        final VerifyEmailResponse dto = new VerifyEmailResponse();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setRole(model.getRole());
        dto.setEmail(model.getEmail().orElse(null));
        return dto;
    }

    private ChangePasswordResponse convertToChangePasswordResponse(Account model) {
        final ChangePasswordResponse dto = new ChangePasswordResponse();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setRole(model.getRole());
        dto.setEmail(model.getEmail().orElse(null));
        return dto;
    }
}