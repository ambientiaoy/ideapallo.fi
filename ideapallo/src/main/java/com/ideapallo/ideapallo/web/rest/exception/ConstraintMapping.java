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
package com.ideapallo.ideapallo.web.rest.exception;

import java.util.HashMap;
import java.util.Map;


public final class ConstraintMapping {

    private static final Map<String, String> mappings = new HashMap<>();

    static {
        mappings.put("UNQ_ACCO_E_637A1E", "Account.email.unique");
        mappings.put("UNQ_ACCO_EVC_9F1591", "Account.emailVerificationCode.unique");
        mappings.put("UNQ_ACCO_RPC_402383", "Account.resetPasswordCode.unique");
        mappings.put("UNQ_ACCO_FI_16E314", "Account.facebookId.unique");
        mappings.put("UNQ_IDEA_II_II_5EC54F", "IdeaIdealist.ideaId-idealistId.unique");
    }

    private ConstraintMapping() {
    };

    public static String getErrorCodeForConstraint(String constraint) {
        return mappings.get(constraint);
    }

}
