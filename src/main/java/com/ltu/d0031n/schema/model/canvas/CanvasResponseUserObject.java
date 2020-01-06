package com.ltu.d0031n.schema.model.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CanvasResponseUserObject {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("full_name")
    private String fullName;



    @JsonProperty("id")
    public String getId() {
        return id;
    }
    @JsonProperty("id")
    public void setId(String id) {
        this.id = "user_" + id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }
    @JsonProperty("fullName")
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
