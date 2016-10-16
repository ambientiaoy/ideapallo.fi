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
package com.ideapallo.ideapallo.repository.impl;

import java.time.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.ideapallo.ideapallo.model.*;
import com.ideapallo.ideapallo.model.enumeration.*;
import com.ideapallo.ideapallo.repository.AccountRepositoryCustom;
import com.ideapallo.ideapallo.repository.tuple.*;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.JPQLQueryFactory;


public class AccountRepositoryImpl implements AccountRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(AccountRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<AccountIdealistTuple> findUserWithStuff(Long id) {
        log.trace(".findUserWithStuff(id: {})", id);
        final QIdealist idealist = QIdealist.idealist;
        final QAccount account = QAccount.account;
        final QAccount idealistAccount = new QAccount("idealistAccount");
        return factory.select(idealist, account).from(account, idealist).innerJoin(idealist.account, idealistAccount)
                .where(new BooleanBuilder().and(account.id.eq(id)).and(account.id.eq(idealistAccount.id))).fetch().stream().map(t -> new AccountIdealistTuple(t.get(account), t.get(idealist)))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Account> findByUsername(String username) {
        log.trace(".findByUsername(username: {})", username);
        final QAccount account = QAccount.account;
        return Optional.ofNullable(factory.select(account).from(account).where(account.username.eq(username)).fetchOne());
    }

    @Override
    public List<Account> findByRole(AccountTypes role) {
        log.trace(".findByRole(role: {})", role);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(account.role.eq(role)).fetch();
    }

    @Override
    public List<Account> findByEmail(Optional<String> email) {
        log.trace(".findByEmail(email: {})", email);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(email.isPresent() ? account.email.eq(email.get()) : null).fetch();
    }

    @Override
    public Optional<Account> findByEmailMandatory(String email) {
        log.trace(".findByEmailMandatory(email: {})", email);
        final QAccount account = QAccount.account;
        return Optional.ofNullable(factory.select(account).from(account).where(account.email.eq(email)).fetchOne());
    }

    @Override
    public List<Account> findByPasswordHash(Optional<String> passwordHash) {
        log.trace(".findByPasswordHash(passwordHash)");
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(passwordHash.isPresent() ? account.passwordHash.eq(passwordHash.get()) : null).fetch();
    }

    @Override
    public List<Account> findByPasswordHashMandatory(String passwordHash) {
        log.trace(".findByPasswordHashMandatory(passwordHash)");
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(account.passwordHash.eq(passwordHash)).fetch();
    }

    @Override
    public List<Account> findByEmailVerificationCode(Optional<String> emailVerificationCode) {
        log.trace(".findByEmailVerificationCode(emailVerificationCode)");
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(emailVerificationCode.isPresent() ? account.emailVerificationCode.eq(emailVerificationCode.get()) : null).fetch();
    }

    @Override
    public Optional<Account> findByEmailVerificationCodeMandatory(String emailVerificationCode) {
        log.trace(".findByEmailVerificationCodeMandatory(emailVerificationCode)");
        final QAccount account = QAccount.account;
        return Optional.ofNullable(factory.select(account).from(account).where(account.emailVerificationCode.eq(emailVerificationCode)).fetchOne());
    }

    @Override
    public List<Account> findByEmailVerificationCodeTimestamp(Optional<ZonedDateTime> emailVerificationCodeTimestamp) {
        log.trace(".findByEmailVerificationCodeTimestamp(emailVerificationCodeTimestamp: {})", emailVerificationCodeTimestamp);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(emailVerificationCodeTimestamp.isPresent() ? account.emailVerificationCodeTimestamp.eq(emailVerificationCodeTimestamp.get()) : null).fetch();
    }

    @Override
    public List<Account> findByEmailVerificationCodeTimestampMandatory(ZonedDateTime emailVerificationCodeTimestamp) {
        log.trace(".findByEmailVerificationCodeTimestampMandatory(emailVerificationCodeTimestamp: {})", emailVerificationCodeTimestamp);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(account.emailVerificationCodeTimestamp.eq(emailVerificationCodeTimestamp)).fetch();
    }

    @Override
    public List<Account> findByEmailVerified(Optional<Boolean> emailVerified) {
        log.trace(".findByEmailVerified(emailVerified: {})", emailVerified);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(emailVerified.isPresent() ? account.emailVerified.eq(emailVerified.get()) : null).fetch();
    }

    @Override
    public List<Account> findByEmailVerifiedMandatory(Boolean emailVerified) {
        log.trace(".findByEmailVerifiedMandatory(emailVerified: {})", emailVerified);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(account.emailVerified.eq(emailVerified)).fetch();
    }

    @Override
    public List<Account> findByResetPasswordCode(Optional<String> resetPasswordCode) {
        log.trace(".findByResetPasswordCode(resetPasswordCode)");
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(resetPasswordCode.isPresent() ? account.resetPasswordCode.eq(resetPasswordCode.get()) : null).fetch();
    }

    @Override
    public Optional<Account> findByResetPasswordCodeMandatory(String resetPasswordCode) {
        log.trace(".findByResetPasswordCodeMandatory(resetPasswordCode)");
        final QAccount account = QAccount.account;
        return Optional.ofNullable(factory.select(account).from(account).where(account.resetPasswordCode.eq(resetPasswordCode)).fetchOne());
    }

    @Override
    public List<Account> findByResetPasswordCodeTimestamp(Optional<ZonedDateTime> resetPasswordCodeTimestamp) {
        log.trace(".findByResetPasswordCodeTimestamp(resetPasswordCodeTimestamp: {})", resetPasswordCodeTimestamp);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(resetPasswordCodeTimestamp.isPresent() ? account.resetPasswordCodeTimestamp.eq(resetPasswordCodeTimestamp.get()) : null).fetch();
    }

    @Override
    public List<Account> findByResetPasswordCodeTimestampMandatory(ZonedDateTime resetPasswordCodeTimestamp) {
        log.trace(".findByResetPasswordCodeTimestampMandatory(resetPasswordCodeTimestamp: {})", resetPasswordCodeTimestamp);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(account.resetPasswordCodeTimestamp.eq(resetPasswordCodeTimestamp)).fetch();
    }

    @Override
    public List<Account> findByFacebookId(Optional<String> facebookId) {
        log.trace(".findByFacebookId(facebookId: {})", facebookId);
        final QAccount account = QAccount.account;
        return factory.select(account).from(account).where(facebookId.isPresent() ? account.facebookId.eq(facebookId.get()) : null).fetch();
    }

    @Override
    public Optional<Account> findByFacebookIdMandatory(String facebookId) {
        log.trace(".findByFacebookIdMandatory(facebookId: {})", facebookId);
        final QAccount account = QAccount.account;
        return Optional.ofNullable(factory.select(account).from(account).where(account.facebookId.eq(facebookId)).fetchOne());
    }

}
