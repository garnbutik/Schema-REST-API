package com.ltu.d0031n.schema.service;

import com.ltu.d0031n.schema.model.apiResponse.ApiResponseModel;
import com.ltu.d0031n.schema.model.apiResponse.ResponseLesson;
import com.ltu.d0031n.schema.model.timedit.TimeEditLesson;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.*;

@Component
public class ResponseTransformer {

    /*
    Transforms response from TimeEdit to API response
     */
    public ApiResponseModel transformToResponse(Set<TimeEditLesson> timeEditLessons){
        ApiResponseModel responseModel = new ApiResponseModel(new ArrayList<>());

        //Get first object in set and set course code and name
        responseModel.setCourse(getFirstObject(timeEditLessons).getColumns().get(5));

        //Loop the lessons and convert to API response
        for (TimeEditLesson lesson : timeEditLessons){
            ResponseLesson rs = new ResponseLesson();
            rs.setId(lesson.getId()  != null ? lesson.getId() : "");
            try {
                rs.setStartdate(lesson.getStartdate() != null ? LocalDate.parse(lesson.getStartdate()) : LocalDate.of(1970, 1, 1));
            } catch (DateTimeParseException exception) {
                rs.setStartdate(LocalDate.of(1970, 1, 1));
            }
            try {
                rs.setStarttime(lesson.getStarttime() != null ? LocalTime.parse(lesson.getStarttime()) : LocalTime.MIDNIGHT);
            } catch (DateTimeParseException e) {
                rs.setStarttime(LocalTime.MIDNIGHT);
            }
            try {
                rs.setEnddate(lesson.getEnddate() != null ? LocalDate.parse(lesson.getEnddate()) : LocalDate.of(1970, 1, 1));
            } catch (DateTimeParseException e) {
                rs.setEnddate(LocalDate.of(1970, 1, 1));
            }
            try {
                rs.setEndtime(lesson.getEndtime()!= null ? LocalTime.parse(lesson.getEndtime()) : LocalTime.MIDNIGHT);
            } catch (DateTimeParseException e) {
                rs.setEndtime(LocalTime.MIDNIGHT);
            }
            rs.setLocation(lesson.getColumns().get(1) != null ? lesson.getColumns().get(1) : "");
            rs.setTeacher(lesson.getColumns().get(2) != null ? lesson.getColumns().get(2) : "");
            rs.setActivity(lesson.getColumns().get(3) != null ? lesson.getColumns().get(3) : "");
            rs.setCity(lesson.getColumns().get(6) != null ? lesson.getColumns().get(6) : "");
            rs.setAdditionalProps(lesson.getColumns().get(7) != null ? lesson.getColumns().get(7) : "");
            responseModel.getLessons().add(rs);
        }

        //Sort list on start date and time
        Collections.sort(responseModel.getLessons());
        return responseModel;
    }

    //Get first object in set
    private TimeEditLesson getFirstObject(Set<TimeEditLesson> lessons){
        Iterator<TimeEditLesson> iterator = lessons.iterator();
        return iterator.next();
    }
}
