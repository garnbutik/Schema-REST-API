package com.ltu.d0031n.schema.model.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiResponseModel {

    @JsonProperty("course")
    private String course;

    @JsonProperty("lessons")
    private List<ResponseLesson> lessons;

    public String getCourse() {
        return course;
    }

    public ApiResponseModel(List<ResponseLesson> lessons) {
        this.lessons = lessons;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public List<ResponseLesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<ResponseLesson> lessons) {
        this.lessons = lessons;
    }
}
