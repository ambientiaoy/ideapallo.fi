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

import javax.validation.constraints.*;


public class EmailSignInRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 6, max = 128)
    @Pattern(regexp = "^([\\w-]+(?:\\.[\\w-]+)*)@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$")
    private String email;

    @NotNull
    @Size(min = 6, max = 32)
    @Pattern(regexp = "^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$")
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final EmailSignInRequest other = (EmailSignInRequest) obj;
        if ((email == null && other.email != null) || !email.equals(other.email))
            return false;
        if ((password == null && other.password != null) || !password.equals(other.password))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "EmailSignInRequest[" + "email=" + email + "]";
    }

}