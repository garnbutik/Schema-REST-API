package com.ltu.d0031n.schema.model.timedit;

import java.util.List;

import com.fasterxml.jackson.annotation.*;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "columnheaders",
        "reservations"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeEditLessonsResponseObject {

    @JsonProperty("columnheaders")
    private List<String> columnheaders = null;
    @JsonProperty("reservations")
    private List<TimeEditLesson> timeEditLessons = null;


    @JsonProperty("columnheaders")
    public List<String> getColumnheaders() {
        return columnheaders;
    }

    @JsonProperty("columnheaders")
    public void setColumnheaders(List<String> columnheaders) {
        this.columnheaders = columnheaders;
    }

    @JsonProperty("reservations")
    public List<TimeEditLesson> getTimeEditLessons() {
        return timeEditLessons;
    }

    @JsonProperty("reservations")
    public void setTimeEditLessons(List<TimeEditLesson> timeEditLessons) {
        this.timeEditLessons = timeEditLessons;
    }

}
