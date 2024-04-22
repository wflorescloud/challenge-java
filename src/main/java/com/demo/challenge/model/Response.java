package com.demo.challenge.model;

import com.lob.model.Suggestions;


import java.util.List;


public class Response {

    private String id;
    private List<Suggestions> suggestions;
    private String object;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Suggestions> getSuggestions() {
        return suggestions;
    }


    public String getObject() {
        return object;
    }

    public void setObject(String object) {
        this.object = object;
    }

    public void setSuggestions(List<Suggestions> suggestions) {
        this.suggestions = suggestions;
    }
}
