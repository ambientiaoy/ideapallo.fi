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

import java.util.Locale;

import javax.inject.Inject;
import javax.mail.internet.MimeMessage;

import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import com.ideapallo.ideapallo.config.CustomProperties;


@Service
public class MailService {

    private final Logger log = LoggerFactory.getLogger(MailService.class);

    @Inject
    private CustomProperties customProperties;

    @Inject
    private JavaMailSender mailSender;

    @Inject
    private MessageSource messageSource;

    @Inject
    private SpringTemplateEngine templateEngine;

    public void sendVerificationEmail(String to, String emailVerificationCode, Locale locale) {
        final Context context = new Context(locale);
        context.setVariable("emailVerificationCode", emailVerificationCode);
        context.setVariable("clientUrl", customProperties.getClientUrl());
        final String content = templateEngine.process("verificationEmail", context);
        final String subject = messageSource.getMessage("email.verification.title", null, locale);
        sendEmail(to, subject, content);
    }

    public void sendResetPasswordEmail(String to, String resetPasswordCode, Locale locale) {
        final Context context = new Context(locale);
        context.setVariable("email", to);
        context.setVariable("clientUrl", customProperties.getClientUrl());
        context.setVariable("resetPasswordCode", resetPasswordCode);
        final String content = templateEngine.process("resetPasswordEmail", context);
        final String subject = messageSource.getMessage("reset.password.title", null, locale);
        sendEmail(to, subject, content);
    }

    @Async
    public void sendEmail(String to, String subject, String content) {

        log.debug("sendEmail(to: {}, subject: {}, content: {})", to, subject, content);

        final MimeMessage mimeMessage = mailSender.createMimeMessage();
        try {
            final MimeMessageHelper message = new MimeMessageHelper(mimeMessage, CharEncoding.UTF_8);
            message.setTo(to);
            message.setFrom(customProperties.getMail().getFrom());
            message.setSubject(subject);
            message.setText(content, true);
            mailSender.send(mimeMessage);
        } catch (Throwable e) {
            log.error("Email sending failed!", e);
        }
    }
}