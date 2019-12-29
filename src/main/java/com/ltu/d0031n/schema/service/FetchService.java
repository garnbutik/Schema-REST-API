package com.ltu.d0031n.schema.service;


import com.ltu.d0031n.schema.configuration.MediaTypeConverter;
import com.ltu.d0031n.schema.model.Lesson;
import com.ltu.d0031n.schema.model.TimeEditResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class FetchService {

    private RestTemplate restTemplate;
    private String idFetchUrl = "https://cloud.timeedit.net/ltu/web/schedule1/ri.json?h=t&sid=3&objects=102098&ox=0&types=0&fe=0&p=20000901.x,20200906.x";

    @Autowired
    private MediaTypeConverter converter;

    public List<Lesson> fetchFromTimeEdit(){
        restTemplate = converter.getRestTemplateForHtml(new RestTemplate());
        TimeEditResponseObject responseObject = restTemplate.getForObject(idFetchUrl, TimeEditResponseObject.class);
        return responseObject.getLessons();
    }
}
