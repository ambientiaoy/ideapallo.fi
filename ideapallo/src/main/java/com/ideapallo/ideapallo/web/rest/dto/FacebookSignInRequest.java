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


public class FacebookSignInRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(min = 6, max = 255)
    private String facebookAccessToken;

    public String getFacebookAccessToken() {
        return facebookAccessToken;
    }

    public void setFacebookAccessToken(String facebookAccessToken) {
        this.facebookAccessToken = facebookAccessToken;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final FacebookSignInRequest other = (FacebookSignInRequest) obj;
        if ((facebookAccessToken == null && other.facebookAccessToken != null) || !facebookAccessToken.equals(other.facebookAccessToken))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((facebookAccessToken == null) ? 0 : facebookAccessToken.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "FacebookSignInRequest[" + "facebookAccessToken=" + facebookAccessToken + "]";
    }

}
