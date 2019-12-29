package com.ltu.d0031n.schema.restController;

import com.ltu.d0031n.schema.model.Lesson;
import com.ltu.d0031n.schema.service.FetchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SchemaRestAPIController {

    private FetchService fetchService;

    @Autowired
    public SchemaRestAPIController(FetchService fetchService){
        this.fetchService = fetchService;
    }

    @CrossOrigin(origins = "http://localhost:8081")
    @GetMapping("/lessons")
    public List<Lesson> getLessons(){
        return fetchService.fetchFromTimeEdit();
    }
}
