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
package com.ideapallo.ideapallo.model;

import java.io.Serializable;

import java.time.*;

import java.util.Optional;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.ideapallo.ideapallo.model.enumeration.*;


@Entity
@Table(name = "Account")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Size(min = 4, max = 40)
    @Column(name = "username")
    private String username;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AccountTypes role;

    @Size(min = 6, max = 128)
    @Pattern(regexp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")
    @Column(name = "email")
    private String email;

    @Size(min = 6, max = 128)
    @Column(name = "passwordHash")
    private String passwordHash;

    @Size(min = 64, max = 64)
    @Column(name = "emailVerificationCode")
    private String emailVerificationCode;

    @Column(name = "emailVerificationCodeTimestamp")
    private ZonedDateTime emailVerificationCodeTimestamp;

    @Column(name = "emailVerified")
    private Boolean emailVerified;

    @Size(min = 64, max = 64)
    @Column(name = "resetPasswordCode")
    private String resetPasswordCode;

    @Column(name = "resetPasswordCodeTimestamp")
    private ZonedDateTime resetPasswordCodeTimestamp;

    @Size(min = 6, max = 255)
    @Column(name = "facebookId")
    private String facebookId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }

    public void setUsername(Optional<String> username) {
        this.username = username.orElse(null);
    }

    public AccountTypes getRole() {
        return role;
    }

    public void setRole(AccountTypes role) {
        this.role = role;
    }

    public Optional<String> getEmail() {
        return Optional.ofNullable(email);
    }

    public void setEmail(Optional<String> email) {
        this.email = email.orElse(null);
    }

    public Optional<String> getPasswordHash() {
        return Optional.ofNullable(passwordHash);
    }

    public void setPasswordHash(Optional<String> passwordHash) {
        this.passwordHash = passwordHash.orElse(null);
    }

    public Optional<String> getEmailVerificationCode() {
        return Optional.ofNullable(emailVerificationCode);
    }

    public void setEmailVerificationCode(Optional<String> emailVerificationCode) {
        this.emailVerificationCode = emailVerificationCode.orElse(null);
    }

    public Optional<ZonedDateTime> getEmailVerificationCodeTimestamp() {
        return Optional.ofNullable(emailVerificationCodeTimestamp);
    }

    public void setEmailVerificationCodeTimestamp(Optional<ZonedDateTime> emailVerificationCodeTimestamp) {
        this.emailVerificationCodeTimestamp = emailVerificationCodeTimestamp.orElse(null);
    }

    public Optional<Boolean> getEmailVerified() {
        return Optional.ofNullable(emailVerified);
    }

    public void setEmailVerified(Optional<Boolean> emailVerified) {
        this.emailVerified = emailVerified.orElse(null);
    }

    public Optional<String> getResetPasswordCode() {
        return Optional.ofNullable(resetPasswordCode);
    }

    public void setResetPasswordCode(Optional<String> resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode.orElse(null);
    }

    public Optional<ZonedDateTime> getResetPasswordCodeTimestamp() {
        return Optional.ofNullable(resetPasswordCodeTimestamp);
    }

    public void setResetPasswordCodeTimestamp(Optional<ZonedDateTime> resetPasswordCodeTimestamp) {
        this.resetPasswordCodeTimestamp = resetPasswordCodeTimestamp.orElse(null);
    }

    public Optional<String> getFacebookId() {
        return Optional.ofNullable(facebookId);
    }

    public void setFacebookId(Optional<String> facebookId) {
        this.facebookId = facebookId.orElse(null);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Account other = (Account) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if ((username == null && other.username != null) || !username.equals(other.username))
            return false;
        if ((role == null && other.role != null) || !role.equals(other.role))
            return false;
        if ((email == null && other.email != null) || !email.equals(other.email))
            return false;
        if ((passwordHash == null && other.passwordHash != null) || !passwordHash.equals(other.passwordHash))
            return false;
        if ((emailVerificationCode == null && other.emailVerificationCode != null) || !emailVerificationCode.equals(other.emailVerificationCode))
            return false;
        if ((emailVerificationCodeTimestamp == null && other.emailVerificationCodeTimestamp != null) || !emailVerificationCodeTimestamp.equals(other.emailVerificationCodeTimestamp))
            return false;
        if ((emailVerified == null && other.emailVerified != null) || !emailVerified.equals(other.emailVerified))
            return false;
        if ((resetPasswordCode == null && other.resetPasswordCode != null) || !resetPasswordCode.equals(other.resetPasswordCode))
            return false;
        if ((resetPasswordCodeTimestamp == null && other.resetPasswordCodeTimestamp != null) || !resetPasswordCodeTimestamp.equals(other.resetPasswordCodeTimestamp))
            return false;
        if ((facebookId == null && other.facebookId != null) || !facebookId.equals(other.facebookId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((username == null) ? 0 : username.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((passwordHash == null) ? 0 : passwordHash.hashCode());
        result = prime * result + ((emailVerificationCode == null) ? 0 : emailVerificationCode.hashCode());
        result = prime * result + ((emailVerificationCodeTimestamp == null) ? 0 : emailVerificationCodeTimestamp.hashCode());
        result = prime * result + ((emailVerified == null) ? 0 : emailVerified.hashCode());
        result = prime * result + ((resetPasswordCode == null) ? 0 : resetPasswordCode.hashCode());
        result = prime * result + ((resetPasswordCodeTimestamp == null) ? 0 : resetPasswordCodeTimestamp.hashCode());
        result = prime * result + ((facebookId == null) ? 0 : facebookId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Account[" + "id=" + id + ", username=" + username + ", role=" + role + ", email=" + email + ", emailVerificationCodeTimestamp=" + emailVerificationCodeTimestamp + ", emailVerified="
                + emailVerified + ", resetPasswordCodeTimestamp=" + resetPasswordCodeTimestamp + ", facebookId=" + facebookId + "]";
    }

}
