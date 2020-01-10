package com.ltu.d0031n.schema.model.apiResponse;

import java.io.Serializable;
import java.util.List;

public class ApiResponseModel implements Serializable {

    private String course;
    private List<ResponseLesson> lessons;

    public String getCourse() {
        return course;
    }

    public ApiResponseModel(List<ResponseLesson> lessons) {
        this.lessons = lessons;
    }

    public ApiResponseModel() {
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
