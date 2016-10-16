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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.ideapallo.ideapallo.model.*;

import com.ideapallo.ideapallo.repository.IdeaRepositoryCustom;

import com.querydsl.jpa.JPQLQueryFactory;


public class IdeaRepositoryImpl implements IdeaRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(IdeaRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<Idea> findByTitle(String title) {
        log.trace(".findByTitle(title: {})", title);
        final QIdea idea = QIdea.idea;
        return factory.select(idea).from(idea).where(idea.title.eq(title)).fetch();
    }

    @Override
    public List<Idea> findByContent(String content) {
        log.trace(".findByContent(content: {})", content);
        final QIdea idea = QIdea.idea;
        return factory.select(idea).from(idea).where(idea.content.eq(content)).fetch();
    }

    @Override
    public List<Idea> ideas() {
        log.trace(".ideas()");
        final QIdea idea = QIdea.idea;
        return factory.select(idea).from(idea).fetch();
    }

}
