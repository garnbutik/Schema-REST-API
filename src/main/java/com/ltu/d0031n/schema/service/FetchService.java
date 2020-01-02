package com.ltu.d0031n.schema.service;

import com.ltu.d0031n.schema.exception.CourseNotFoundException;
import com.ltu.d0031n.schema.exception.NoLessonsFoundException;
import com.ltu.d0031n.schema.model.apiResponse.ApiResponseModel;
import com.ltu.d0031n.schema.model.timedit.TimeEditLesson;
import com.ltu.d0031n.schema.model.timedit.TimeEditIdResponseObject;
import com.ltu.d0031n.schema.model.timedit.TimeEditLessonsResponseObject;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.time.LocalDate;
import java.util.*;

@Service
public class FetchService {

    private RestTemplate restTemplate;
    private String idFetchUrl =
            "https://cloud.timeedit.net/ltu/web/schedule1/objects.json?max=10&fr=s&partajax=t&im=t&sid=3&l=sv_SE&search_text={courseCode}&types=28";
    private String lessonsFetchUrl =
            "https://cloud.timeedit.net/ltu/web/schedule1/ri.json?h=t&sid=3&ox=0&types=0&fe=0&p={startDate}.x,{endDate}.x";

    public ApiResponseModel fetchFromTimeEdit(String courseCode, String startDate, String endDate){

        /*
        Parsing date to check if date is properly formatted. Exception handled by RestExceptionHandler.class
         */
        LocalDate.parse(startDate);
        LocalDate.parse(endDate);

        //Use set to eliminate duplicates
        Set<TimeEditLesson> timeEditLessons = new HashSet<>();
        List<String> ids = fetchIdFromTimeEdit(courseCode);

        //Looping id's to fetch all lessons
        for (String idString: ids) {
            timeEditLessons.addAll(fetchLessonsFromTimeEdit(idString, startDate, endDate, courseCode));
        }

        ResponseTransformer transformer = new ResponseTransformer();
        return transformer.transformToResponse(timeEditLessons);
    }

    private List<String> fetchIdFromTimeEdit(String courseCode){
        restTemplate = new RestTemplate();
        TimeEditIdResponseObject responseObject =
                restTemplate.getForObject(idFetchUrl, TimeEditIdResponseObject.class, courseCode);

        if (responseObject == null || responseObject.getIds() == null || responseObject.getIds().isEmpty()) {
            throw new CourseNotFoundException(courseCode);
        }
        return responseObject.getIds();
    }

    private List<TimeEditLesson> fetchLessonsFromTimeEdit(String timeEditObjectCode,
                                                          String startDate,
                                                          String endDate,
                                                          String courseCode){

        //Adding html-to-json-converter
        restTemplate = new RestTemplate(Arrays.asList(getHtmlToJsonConverter()));

        //removing hyphens for timeEdit request
        startDate = startDate.replace("-", "");
        endDate = endDate.replace("-", "");

        Map<String, String> params = new HashMap<>();
        params.put("startDate", startDate);
        params.put("endDate", endDate);


        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(lessonsFetchUrl)
                .queryParam("objects", timeEditObjectCode);

        TimeEditLessonsResponseObject responseObject =
                restTemplate.getForObject(builder.buildAndExpand(params).toUriString(),
                        TimeEditLessonsResponseObject.class);

        if (
                responseObject == null ||
                responseObject.getTimeEditLessons() == null ||
                responseObject.getTimeEditLessons().isEmpty()
        ) {
            throw new NoLessonsFoundException(courseCode, startDate, endDate);
        }
        return responseObject.getTimeEditLessons();
    }

    //Util method for adding html-to-json converter to rest-template
    private HttpMessageConverter getHtmlToJsonConverter(){
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Collections.singletonList(MediaType.TEXT_HTML));
        return converter;
    }
}
