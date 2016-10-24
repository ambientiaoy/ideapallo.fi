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

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

import com.ideapallo.ideapallo.model.*;

import com.ideapallo.ideapallo.repository.TagRepositoryCustom;
import com.ideapallo.ideapallo.repository.tuple.*;

import com.querydsl.jpa.JPQLQueryFactory;


public class TagRepositoryImpl implements TagRepositoryCustom {

    private final Logger log = LoggerFactory.getLogger(TagRepositoryImpl.class);

    @Inject
    private JPQLQueryFactory factory;

    @Override
    public List<IdeaTagTuple> findIdeaByTag(String name) {
        log.trace(".findIdeaByTag(name: {})", name);
        final QIdea idea = QIdea.idea;
        final QTag tag = QTag.tag;
        return factory.select(idea, tag).from(idea).leftJoin(idea.tags, tag).where(tag.name.eq(name)).fetch().stream().map(t -> new IdeaTagTuple(t.get(idea), t.get(tag))).collect(Collectors.toList());
    }

    @Override
    public List<Tag> findByName(String name) {
        log.trace(".findByName(name: {})", name);
        final QTag tag = QTag.tag;
        return factory.select(tag).from(tag).where(tag.name.eq(name)).fetch();
    }

}
