
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

import java.util.List;

import javax.validation.constraints.*;


public class TagResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @Size(max = 255)
    private String title;

    @NotNull
    @Size(max = 6000)
    private String content;

    @NotNull
    private List<Long> idealistId;

    @NotNull
    private List<Long> tagsId;

    @Size(max = 255)
    private String tagName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public List<Long> getIdealistId() {
        return idealistId;
    }

    public void setIdealistId(List<Long> idealistId) {
        this.idealistId = idealistId;
    }

    public List<Long> getTagsId() {
        return tagsId;
    }

    public void setTagsId(List<Long> tagsId) {
        this.tagsId = tagsId;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final TagResponse other = (TagResponse) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if ((title == null && other.title != null) || !title.equals(other.title))
            return false;
        if ((content == null && other.content != null) || !content.equals(other.content))
            return false;
        if ((idealistId == null && other.idealistId != null) || !idealistId.equals(other.idealistId))
            return false;
        if ((tagsId == null && other.tagsId != null) || !tagsId.equals(other.tagsId))
            return false;
        if ((tagName == null && other.tagName != null) || !tagName.equals(other.tagName))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((idealistId == null) ? 0 : idealistId.hashCode());
        result = prime * result + ((tagsId == null) ? 0 : tagsId.hashCode());
        result = prime * result + ((tagName == null) ? 0 : tagName.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "TagResponse[" + "id=" + id + ", title=" + title + ", content=" + content + ", idealistId=" + idealistId + ", tagsId=" + tagsId + ", tagName=" + tagName + "]";
    }

}
