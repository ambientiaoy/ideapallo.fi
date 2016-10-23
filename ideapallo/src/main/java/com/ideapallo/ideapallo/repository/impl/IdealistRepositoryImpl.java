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

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.swing.text.html.Option;

import com.ideapallo.ideapallo.model.*;

import com.ideapallo.ideapallo.repository.IdealistRepositoryCustom;

import com.querydsl.jpa.JPQLQueryFactory;


public class IdealistRepositoryImpl implements IdealistRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(IdealistRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public Optional<Idealist> findByAccount(Long accountId) {
        log.trace(".findByAccount(accountId: {})", accountId);
        final QIdealist idealist = QIdealist.idealist;
        return Optional.ofNullable(factory.select(idealist).from(idealist).where(idealist.account.id.eq(accountId)).fetchOne());
    }

}
