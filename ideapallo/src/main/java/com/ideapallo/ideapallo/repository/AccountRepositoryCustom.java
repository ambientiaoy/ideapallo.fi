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
package com.ideapallo.ideapallo.repository;

import java.time.*;
import java.util.List;
import java.util.Optional;

import com.ideapallo.ideapallo.model.*;
import com.ideapallo.ideapallo.model.enumeration.*;
import com.ideapallo.ideapallo.repository.tuple.*;


public interface AccountRepositoryCustom {

    List<AccountIdealistTuple> findUserWithStuff(Long id);

    Optional<Account> findByUsername(String username);

    List<Account> findByRole(AccountTypes role);

    List<Account> findByEmail(Optional<String> email);

    Optional<Account> findByEmailMandatory(String email);

    List<Account> findByPasswordHash(Optional<String> passwordHash);

    List<Account> findByPasswordHashMandatory(String passwordHash);

    List<Account> findByEmailVerificationCode(Optional<String> emailVerificationCode);

    Optional<Account> findByEmailVerificationCodeMandatory(String emailVerificationCode);

    List<Account> findByEmailVerificationCodeTimestamp(Optional<ZonedDateTime> emailVerificationCodeTimestamp);

    List<Account> findByEmailVerificationCodeTimestampMandatory(ZonedDateTime emailVerificationCodeTimestamp);

    List<Account> findByEmailVerified(Optional<Boolean> emailVerified);

    List<Account> findByEmailVerifiedMandatory(Boolean emailVerified);

    List<Account> findByResetPasswordCode(Optional<String> resetPasswordCode);

    Optional<Account> findByResetPasswordCodeMandatory(String resetPasswordCode);

    List<Account> findByResetPasswordCodeTimestamp(Optional<ZonedDateTime> resetPasswordCodeTimestamp);

    List<Account> findByResetPasswordCodeTimestampMandatory(ZonedDateTime resetPasswordCodeTimestamp);

    List<Account> findByFacebookId(Optional<String> facebookId);

    Optional<Account> findByFacebookIdMandatory(String facebookId);

}
