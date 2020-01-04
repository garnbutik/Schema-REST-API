package com.ltu.d0031n.schema.model.canvas;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "context_code",
        "title",
        "start_at",
        "end_at"
})
public class CanvasCalendarEvent {

    @JsonProperty("context_code")
    private String contextCode;
    @JsonProperty("title")
    private String title;
    @JsonProperty("start_at")
    private String startAt;
    @JsonProperty("end_at")
    private String endAt;
    @JsonProperty("location_name")
    private String location;

    //Slås ihop med title
    private String teacher;
    @JsonProperty("description")
    private String activity;
    @JsonProperty("location_address")
    private String city;
    @JsonProperty("comments")
    private String additionalProps;

    @JsonProperty("context_code")
    public String getContextCode() {
        return contextCode;
    }

    @JsonProperty("context_code")
    public void setContextCode(String contextCode) {
        this.contextCode = contextCode;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    @JsonProperty("start_at")
    public String getStartAt() {
        return startAt;
    }

    @JsonProperty("start_at")
    public void setStartAt(String startAt) {
        this.startAt = startAt;
    }

    @JsonProperty("end_at")
    public String getEndAt() {
        return endAt;
    }

    @JsonProperty("end_at")
    public void setEndAt(String endAt) {
        this.endAt = endAt;
    }


}