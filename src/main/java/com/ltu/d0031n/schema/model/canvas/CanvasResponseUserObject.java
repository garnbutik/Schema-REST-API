package com.ltu.d0031n.schema.model.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.NumberFormat;
import java.text.ParsePosition;

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
        if (isNumeric(id)) {
            this.id = "user_" + id;
        } else {
            this.id = id;
        }

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

    private boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
