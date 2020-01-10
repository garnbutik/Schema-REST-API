package com.ltu.d0031n.schema.restController;

import com.ltu.d0031n.schema.model.apiResponse.ApiResponseModel;
import com.ltu.d0031n.schema.model.canvas.ApiCanvasRequestBody;
import com.ltu.d0031n.schema.model.canvas.CalendarEvent;
import com.ltu.d0031n.schema.model.canvas.ContextObject;
import com.ltu.d0031n.schema.service.timeEdit.TimeEditService;
import com.ltu.d0031n.schema.service.canvas.CanvasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class SchemaRestAPIController {

    private TimeEditService timeEditService;
    private CanvasService canvasService;

    @Autowired
    public SchemaRestAPIController(TimeEditService timeEditService, CanvasService canvasService){
        this.timeEditService = timeEditService;
        this.canvasService = canvasService;
    }

    @GetMapping("/lessons/{courseCode}")
    public ResponseEntity<ApiResponseModel> getLessons(
            @PathVariable("courseCode") String courseCode,
            @RequestParam(value = "startDate", defaultValue = "2000-01-01") String startDate,
            @RequestParam(value = "endDate", defaultValue = "2050-12-31") String endDate){
        ApiResponseModel response = timeEditService.fetchFromTimeEdit(courseCode, startDate, endDate);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/canvas")
    public ResponseEntity<Map<String, List<CalendarEvent>>> postToCanvas(
            @RequestBody ApiCanvasRequestBody requestObject){
        return canvasService.postToCanvas(requestObject);
    }

    @GetMapping("/context-codes/{name}")
    public ResponseEntity<ContextObject[]> getContext(
            @PathVariable("name") String name){
        ContextObject[] response = canvasService.getContext(name);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
