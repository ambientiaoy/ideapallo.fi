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

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "Tag")
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 255)
    @Column(name = "name")
    private String name;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "relatedId")
    private Tag related;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag getRelated() {
        return related;
    }

    public void setRelated(Tag related) {
        this.related = related;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Tag other = (Tag) obj;
        if ((id == null && other.id != null) || !id.equals(other.id))
            return false;
        if ((name == null && other.name != null) || !name.equals(other.name))
            return false;
        if ((related == null && other.related != null) || !related.equals(other.related))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((related == null) ? 0 : related.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Tag[" + "id=" + id + ", name=" + name + ", related=" + related + "]";
    }

}
