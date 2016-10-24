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
package com.ideapallo.ideapallo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Idea")
public class Idea implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(max = 6000)
    @Column(name = "content")
    private String content;

    @NotNull
    @ManyToMany
    @JoinTable(name = "IdeaIdealist", joinColumns = {@JoinColumn(name = "ideaId")}, inverseJoinColumns = {@JoinColumn(name = "idealistId")})
    private List<Idealist> idealist = new ArrayList<>();

    @NotNull
    @ManyToMany
    @JoinTable(name = "IdeaTag", joinColumns = {@JoinColumn(name = "ideaId")}, inverseJoinColumns = {@JoinColumn(name = "tagId")})
    private List<Tag> tags = new ArrayList<>();

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

    public List<Idealist> getIdealist() {
        return idealist;
    }

    public void setIdealist(List<Idealist> idealist) {
        this.idealist = idealist;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Idea other = (Idea) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if ((title == null && other.title != null) || !title.equals(other.title))
            return false;
        if ((content == null && other.content != null) || !content.equals(other.content))
            return false;
        if ((idealist == null && other.idealist != null) || !idealist.equals(other.idealist))
            return false;
        if ((tags == null && other.tags != null) || !tags.equals(other.tags))
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
        result = prime * result + ((idealist == null) ? 0 : idealist.hashCode());
        result = prime * result + ((tags == null) ? 0 : tags.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Idea[" + "id=" + id + ", title=" + title + ", content=" + content + ", idealist=" + idealist + ", tags=" + tags + "]";
    }

    public void addIdealist(Idealist idealist) {
        if (this.idealist == null){
            this.idealist = new ArrayList<>();
        }
        this.idealist.add( idealist );
    }

    public void addTag(Tag tag) {
        this.tags.add( tag );
    }
}
