package com.ltu.d0031n.schema.model.apiResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ResponseLesson implements Comparable<ResponseLesson> {

    @JsonProperty("id")
    private String id;

    @JsonProperty("startdate")
    private LocalDate startdate;

    @JsonProperty("starttime")
    private LocalTime starttime;

    @JsonProperty("enddate")
    private LocalDate enddate;

    @JsonProperty("endtime")
    private LocalTime endtime;

    @JsonProperty("location")
    private String location;

    @JsonProperty("teacher")
    private String teacher;

    @JsonProperty("activity")
    private String activity;

    @JsonProperty("city")
    private String city;

    @JsonProperty("additionalProps")
    private String additionalProps;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAdditionalProps() {
        return additionalProps;
    }

    public void setAdditionalProps(String additionalProps) {
        this.additionalProps = additionalProps;
    }

    @Override
    public int compareTo(ResponseLesson o) {
        LocalDateTime localDateTime = LocalDateTime.of(this.startdate, this.starttime);
        LocalDateTime otherLocalDateTime = LocalDateTime.of(o.startdate, o.starttime);
        return localDateTime.compareTo(otherLocalDateTime);
    }
}
