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
package com.ideapallo.ideapallo.repository;

import java.util.List;
import java.util.Optional;

import com.ideapallo.ideapallo.model.*;

import com.ideapallo.ideapallo.repository.tuple.*;


public interface IdeaRepositoryCustom {

    Optional<Idea> byId(Long id);

    List<IdeaIdealistTuple> findByIdealist();

    List<Idea> findByTitle(String title);

    List<Idea> findByContent(String content);

    List<Idea> ideas();

    List<IdeaTagTuple> findIdeaByTag(String name);
}
