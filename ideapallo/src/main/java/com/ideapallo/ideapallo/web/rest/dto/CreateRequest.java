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
package com.ideapallo.ideapallo.web.rest.dto;

import java.io.Serializable;

import java.time.*;

import javax.validation.constraints.*;

import com.ideapallo.ideapallo.model.enumeration.*;


public class CreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @Size(min = 4, max = 40)
    private String username;

    @NotNull
    private AccountTypes role;

    @Size(min = 6, max = 128)
    @Pattern(regexp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")
    private String email;

    @Size(min = 6, max = 128)
    private String passwordHash;

    @Size(min = 64, max = 64)
    private String emailVerificationCode;

    private ZonedDateTime emailVerificationCodeTimestamp;

    private Boolean emailVerified;

    @Size(min = 64, max = 64)
    private String resetPasswordCode;

    private ZonedDateTime resetPasswordCodeTimestamp;

    @Size(min = 6, max = 255)
    private String facebookId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public AccountTypes getRole() {
        return role;
    }

    public void setRole(AccountTypes role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getEmailVerificationCode() {
        return emailVerificationCode;
    }

    public void setEmailVerificationCode(String emailVerificationCode) {
        this.emailVerificationCode = emailVerificationCode;
    }

    public ZonedDateTime getEmailVerificationCodeTimestamp() {
        return emailVerificationCodeTimestamp;
    }

    public void setEmailVerificationCodeTimestamp(ZonedDateTime emailVerificationCodeTimestamp) {
        this.emailVerificationCodeTimestamp = emailVerificationCodeTimestamp;
    }

    public Boolean getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(Boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getResetPasswordCode() {
        return resetPasswordCode;
    }

    public void setResetPasswordCode(String resetPasswordCode) {
        this.resetPasswordCode = resetPasswordCode;
    }

    public ZonedDateTime getResetPasswordCodeTimestamp() {
        return resetPasswordCodeTimestamp;
    }

    public void setResetPasswordCodeTimestamp(ZonedDateTime resetPasswordCodeTimestamp) {
        this.resetPasswordCodeTimestamp = resetPasswordCodeTimestamp;
    }

    public String getFacebookId() {
        return facebookId;
    }

    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CreateRequest other = (CreateRequest) obj;
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
        return "CreateRequest[" + "username=" + username + ", role=" + role + ", email=" + email + ", emailVerificationCodeTimestamp=" + emailVerificationCodeTimestamp + ", emailVerified="
                + emailVerified + ", resetPasswordCodeTimestamp=" + resetPasswordCodeTimestamp + ", facebookId=" + facebookId + "]";
    }

}
