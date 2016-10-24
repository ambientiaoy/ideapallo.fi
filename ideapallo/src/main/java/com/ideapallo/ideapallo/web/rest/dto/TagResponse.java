package com.ideapallo.ideapallo.web.rest.dto;

import java.io.Serializable;

public class TagResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private String name;

    private String url;


    public TagResponse(String tagName) {
        this.name = tagName;
        this.url = "/tag/by/" + tagName;
    }
}
