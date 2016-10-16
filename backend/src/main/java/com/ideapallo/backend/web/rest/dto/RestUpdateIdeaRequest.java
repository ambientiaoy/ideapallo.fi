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
package com.ideapallo.backend.web.rest.dto;

import java.io.Serializable;

import javax.validation.constraints.*;


public class RestUpdateIdeaRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    @Size(max = 255)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final RestUpdateIdeaRequest other = (RestUpdateIdeaRequest) obj;
        if ((title == null && other.title != null) || !title.equals(other.title))
            return false;
        if ((content == null && other.content != null) || !content.equals(other.content))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "RestUpdateIdeaRequest[" + "title=" + title + ", content=" + content + "]";
    }

}
