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

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;

import java.io.IOException;
import org.springframework.social.NotAuthorizedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class ExceptionResolver {

    private final Logger log = LoggerFactory.getLogger(ExceptionResolver.class);

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public @ResponseBody ErrorResponse validationException(HttpServletRequest request, MethodArgumentNotValidException exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        final List<String> errorCodes = exception.getBindingResult().getFieldErrors().stream().map(e -> String.format("%s.%s.%s", e.getObjectName(), e.getField(), e.getCode()))
                .collect(Collectors.toList());
        return new ErrorResponse(exception.getMessage(), errorCodes);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DataIntegrityViolationException.class)
    public @ResponseBody ErrorResponse dataIntegrityException(HttpServletRequest request, DataIntegrityViolationException exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        // example: Duplicate entry 'field1-field2' for key 'UNQ_MODE_F1_F2_251F9D'
        final String message = exception.getRootCause().getMessage();
        if (message.contains("'UNQ")) {
            final String constraint = message.substring(message.indexOf("'UNQ") + 1, message.lastIndexOf("'"));
            return new ErrorResponse(ConstraintMapping.getErrorCodeForConstraint(constraint), message);
        }
        return new ErrorResponse(message, Collections.emptyList());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccessDeniedException.class)
    public @ResponseBody ErrorResponse accessDenied(HttpServletRequest request, AccessDeniedException exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        return new ErrorResponse("access.denied", "Access is denied!");
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthenticationError.class)
    public @ResponseBody ErrorResponse authenticationError(HttpServletRequest request, AuthenticationError exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        return new ErrorResponse(exception.getErrorCode(), exception.getErrorMessage());
    }

    @ResponseStatus(value = HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(NotAuthorizedException.class)
    public @ResponseBody ErrorResponse facebookSignInError(HttpServletRequest request, NotAuthorizedException exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        return new ErrorResponse("facebook.access.denied", "Facebook sign in failed!");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(IOException.class)
    public @ResponseBody ErrorResponse fileStorageError(HttpServletRequest request, IOException exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        return new ErrorResponse("file.storage.error", "File upload/retrieval failed!");
    }

    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(AccountWithEmailAlreadyExists.class)
    public @ResponseBody ErrorResponse emailExists(HttpServletRequest request, AccountWithEmailAlreadyExists exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        return new ErrorResponse("email.exists", exception.getMessage());
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public @ResponseBody ErrorResponse serverError(HttpServletRequest request, Throwable exception) {
        if (log.isErrorEnabled()) {
            log.error(exception.getMessage(), exception);
        }
        return new ErrorResponse(exception.getClass().getSimpleName(), exception.getMessage());
    }
}
