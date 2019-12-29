package com.ltu.d0031n.schema.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "columnheaders",
        "reservations"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeEditResponseObject {

    @JsonProperty("columnheaders")
    private List<String> columnheaders = null;
    @JsonProperty("reservations")
    private List<Lesson> lessons = null;


    @JsonProperty("columnheaders")
    public List<String> getColumnheaders() {
        return columnheaders;
    }

    @JsonProperty("columnheaders")
    public void setColumnheaders(List<String> columnheaders) {
        this.columnheaders = columnheaders;
    }

    @JsonProperty("reservations")
    public List<Lesson> getLessons() {
        return lessons;
    }

    @JsonProperty("reservations")
    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

}
