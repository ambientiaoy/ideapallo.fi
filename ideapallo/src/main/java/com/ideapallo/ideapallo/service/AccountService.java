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
package com.ideapallo.ideapallo.service;

import java.time.*;
import java.util.Locale;
import org.apache.commons.lang.RandomStringUtils;

import java.util.Optional;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ideapallo.ideapallo.config.CustomProperties;
import com.ideapallo.ideapallo.model.*;
import com.ideapallo.ideapallo.model.enumeration.*;
import com.ideapallo.ideapallo.repository.*;
import com.ideapallo.ideapallo.web.rest.dto.*;
import com.ideapallo.ideapallo.web.rest.exception.*;
import com.ideapallo.ideapallo.security.JWTUtils;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;


@Service
public class AccountService {

    private final Logger log = LoggerFactory.getLogger(AccountService.class);

    @Inject
    private CustomProperties customProperties;

    @Inject
    private PasswordEncoder passwordEncoder;

    @Inject
    private MailService mailService;

    @Inject
    private AccountRepository accountRepository;

    public Account changePassword(Long accountId, String oldPassword, String newPassword) {

        log.debug("changePassword(accountId: {})", accountId);

        final Account account = accountRepository.findOne(accountId);
        if (account == null) {
            throw new AuthenticationError("credentials.invalid", "Credentials are invalid!");
        }
        if (!passwordEncoder.matches(oldPassword, account.getPasswordHash().get())) {
            throw new AuthenticationError("credentials.invalid", "Credentials are invalid!");
        }
        account.setPasswordHash(Optional.of(passwordEncoder.encode(newPassword)));
        accountRepository.save(account);
        return account;
    }

    public Account emailSignUp(String email, String password) {

        log.debug("emailSignUp(email: {})", email);

        final Optional<Account> optionalAccount = accountRepository.findByEmailMandatory(email);
        if (optionalAccount.isPresent()) {
            throw new AccountWithEmailAlreadyExists("Account with email: " + email + " already exists.");
        }

        final Account account = new Account();
        account.setEmail(Optional.ofNullable(email));
        account.setRole(AccountTypes.CLIENT);
        account.setPasswordHash(Optional.of(passwordEncoder.encode(password)));
        account.setEmailVerificationCode(Optional.of(RandomStringUtils.randomAlphanumeric(64)));
        account.setEmailVerificationCodeTimestamp(Optional.of(ZonedDateTime.now(ZoneId.of("UTC")).plusDays(1)));
        account.setEmailVerified(Optional.of(false));
        accountRepository.save(account);

        mailService.sendVerificationEmail(email, account.getEmailVerificationCode().get(), Locale.ENGLISH);

        return account;
    }

    public EmailSignInResponse emailSignIn(String email, String password) {

        log.debug("emailSignIn(email: {})", email);

        final Account account = accountRepository.findByEmailMandatory(email).orElseThrow(() -> new AuthenticationError("credentials.invalid", "Credentials are invalid!"));
        if (!passwordEncoder.matches(password, account.getPasswordHash().get()))
            throw new AuthenticationError("credentials.invalid", "Credentials are invalid!");

        final EmailSignInResponse response = new EmailSignInResponse();
        final String accessToken = JWTUtils.createToken(account.getId(), account.getRole(), customProperties.getSecretKey());
        response.setAccessToken(accessToken);
        response.setId(account.getId());
        response.setUsername(account.getUsername());
        response.setRole(account.getRole());
        response.setEmail(account.getEmail().orElse(null));
        return response;
    }

    public Account verifyEmail(String emailVerificationCode) {

        log.debug("verifyEmail(emailVerificationCode: {})", emailVerificationCode);

        final Optional<Account> optionalAccount = accountRepository.findByEmailVerificationCodeMandatory(emailVerificationCode);
        if (!optionalAccount.isPresent()) {
            throw new AuthenticationError("credentials.invalid", "Invalid email verification code!");
        }

        final Account account = optionalAccount.get();
        if (account.getEmailVerificationCodeTimestamp().get().isBefore(ZonedDateTime.now(ZoneId.of("UTC")))) {
            throw new AuthenticationError("emailVerificationCode.expired", "Email verification code expired!");
        }

        account.setEmailVerified(Optional.of(true));
        accountRepository.save(account);
        return account;
    }

    public void forgotPassword(String email) {

        log.debug("forgotPassword(email: {})", email);

        final Optional<Account> optionalAccount = accountRepository.findByEmailMandatory(email).filter(account -> account.getEmailVerified().get());
        if (!optionalAccount.isPresent()) {
            throw new BadRequestError("invalid.email", "Email: " + email + " does not exist or is not registered.");
        }

        final Account account = optionalAccount.get();
        final String resetPasswordCode = RandomStringUtils.randomAlphabetic(64);
        account.setResetPasswordCode(Optional.of(resetPasswordCode));
        account.setResetPasswordCodeTimestamp(Optional.of(ZonedDateTime.now(ZoneOffset.UTC).plusHours(1)));
        accountRepository.save(account);

        mailService.sendResetPasswordEmail(account.getEmail().get(), resetPasswordCode, Locale.ENGLISH);
    }

    public void resetPassword(String resetPasswordCode, String newPassword) {

        log.debug("resetPassword()");

        final Optional<Account> optionalAccount = accountRepository.findByResetPasswordCodeMandatory(resetPasswordCode);
        if (!optionalAccount.isPresent()) {
            throw new BadRequestError("resetPasswordCode.invalid", "Invalid reset password code!");
        }

        final Account account = optionalAccount.get();
        if (account.getResetPasswordCodeTimestamp().get().isBefore(ZonedDateTime.now(ZoneOffset.UTC))) {
            throw new AuthenticationError("resetPasswordCode.expired", "Reset password code expired!");
        }

        account.setPasswordHash(Optional.of(passwordEncoder.encode(newPassword)));
        account.setResetPasswordCodeTimestamp(Optional.empty());
        accountRepository.save(account);
    }

    public Optional<FacebookSignInResponse> facebookSignIn(String facebookAccessToken) {
        log.debug("facebookSignIn(facebookAccessToken: {})", facebookAccessToken);

        final Facebook facebook = new FacebookTemplate(facebookAccessToken);
        final String accountId = facebook.userOperations().getUserProfile().getId();

        Account account = accountRepository.findByFacebookIdMandatory(accountId).orElse(null);
        if (account == null) {
            account = new Account();
            account.setFacebookId(Optional.of(accountId));
            account.setRole(AccountTypes.CLIENT);
            accountRepository.save(account);
        }

        final FacebookSignInResponse response = new FacebookSignInResponse();
        final String accessToken = JWTUtils.createToken(account.getId(), account.getRole(), customProperties.getSecretKey());

        response.setAccessToken(accessToken);
        response.setId(account.getId());
        response.setUsername(account.getUsername());
        response.setRole(account.getRole());
        response.setEmail(account.getEmail().orElse(null));
        return Optional.of(response);
    }

}
