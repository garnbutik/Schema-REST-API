package com.ltu.d0031n.schema.model.apiResponse;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ResponseLesson implements Comparable<ResponseLesson>, Serializable {

    private String id;
    private LocalDate startdate;
    private LocalTime starttime;
    private LocalDate enddate;
    private LocalTime endtime;
    private String location;
    private String teacher;
    private String activity;
    private String city;
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
