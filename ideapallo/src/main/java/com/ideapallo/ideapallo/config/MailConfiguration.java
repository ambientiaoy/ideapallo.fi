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
package com.ideapallo.ideapallo.config;

import javax.inject.Inject;

import org.apache.commons.lang.CharEncoding;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import java.util.Properties;


@Configuration
public class MailConfiguration {

    private final Logger log = LoggerFactory.getLogger(MailConfiguration.class);

    @Inject
    private CustomProperties customProperties;

    @Bean
    public JavaMailSender mailSender() {

        log.debug("Initializing mail sender...");

        final JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(customProperties.getMail().getHost());
        mailSender.setPort(customProperties.getMail().getPort());
        mailSender.setUsername(customProperties.getMail().getUsername());
        mailSender.setPassword(customProperties.getMail().getPassword());

        final Properties properties = new Properties();
        properties.setProperty("mail.smtp.starttls.enable", customProperties.getMail().getStarttls());
        properties.setProperty("mail.smtp.auth", customProperties.getMail().getAuth());

        mailSender.setJavaMailProperties(properties);

        return mailSender;
    }

    @Bean
    public ClassLoaderTemplateResolver emailTemplateResolver() {

        log.debug("Initializing template resolver...");

        final ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setOrder(1);
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML5");
        resolver.setCharacterEncoding(CharEncoding.UTF_8);
        return resolver;
    }

    @Bean
    public MessageSource messageSource() {

        log.debug("Initializing message source...");

        final ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename("i18n/messages");
        return messageSource;
    }

}