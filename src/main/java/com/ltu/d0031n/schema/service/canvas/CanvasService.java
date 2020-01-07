package com.ltu.d0031n.schema.service.canvas;

import com.ltu.d0031n.schema.exception.CouldNotPostToCanvasException;
import com.ltu.d0031n.schema.exception.UserNotFoundException;
import com.ltu.d0031n.schema.model.apiResponse.ApiResponseModel;
import com.ltu.d0031n.schema.model.canvas.ApiCanvasRequestBody;
import com.ltu.d0031n.schema.model.canvas.CalendarEvent;
import com.ltu.d0031n.schema.model.canvas.CalendarEventCanvasPayload;
import com.ltu.d0031n.schema.model.canvas.CanvasResponseUserObject;

import com.ltu.d0031n.schema.service.ResponseTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CanvasService {

    private final String token;
    RestTemplate restTemplate;
    String searchUrl = "https://ltu.instructure.com/api/v1/search/recipients?search=";
    String createCaledarEventUrl = "https://ltu.instructure.com/api/v1/calendar_events";

    @Autowired  //Bind value of access token from the application.propery file
    public CanvasService(@Value("${access-token}") String token) {
        this.token = token;
    }

    public Map<String, List<CalendarEvent>> postToCanvas(ApiCanvasRequestBody requestModel) {

        //Map to hold map of responses from Canvas
        Map<String, List<CalendarEvent>> responses = new HashMap<>();

        //List for created events
        List<CalendarEvent> eventsSuccess = new ArrayList<>();

        //List for failed events
        List<CalendarEvent> eventsFailed = new ArrayList<>();

        //Transform to Canvas request body
        ResponseTransformer transformer = new ResponseTransformer();
        List<CalendarEventCanvasPayload> payloads = transformer.fromApiToCanvas(requestModel);

        //Loop list to post all elements of list
        for (CalendarEventCanvasPayload payload : payloads) {
            ResponseEntity<CalendarEvent> responseEntity = createCaledarEvent(payload);

            //If request failed add to failed list
            if (responseEntity.getStatusCode().value() != 201) {
                eventsFailed.add(responseEntity.getBody());

            } else { //if request succeeded add to success list
                eventsSuccess.add(responseEntity.getBody());
            }
        }

        //if none succeeded throw exception
        if (eventsSuccess.size() == 0) {
            throw new CouldNotPostToCanvasException();
        }

        // add success list to map
        responses.put("success", eventsSuccess);

        //if one or more failed events exists list is added to map
        if (eventsFailed.size() > 0) {
            responses.put("failed", eventsFailed);
        }
        return responses;
    }

    private ResponseEntity<CalendarEvent> createCaledarEvent(CalendarEventCanvasPayload payload){
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.token);
        HttpEntity<CalendarEventCanvasPayload> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<CalendarEvent> responseEntity = restTemplate.postForEntity(createCaledarEventUrl, entity, CalendarEvent.class);
        return responseEntity;
    }

//    public void createCaledarEvent(CalendarEvent event){
//        CalendarEventCanvasPayload payload = new CalendarEventCanvasPayload();
//        payload.setCalendarEvent(event);
//        restTemplate = new RestTemplate();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.set("Authorization", "Bearer " + this.token);
//        HttpEntity<CalendarEventCanvasPayload> entity = new HttpEntity<>(payload, headers);
//        ResponseEntity<CalendarEvent> responseEntity = restTemplate.postForEntity(createCaledarEventUrl, entity, CalendarEvent.class);
//    }

    //Get user id from Canvas
    public CanvasResponseUserObject[] getUserId(String name) {
        String url = searchUrl + name;
        restTemplate = new RestTemplate();

        //Specify header with authorization token
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + this.token);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        
        //Get array of users
        ResponseEntity<CanvasResponseUserObject[]> response = restTemplate.exchange(
            url, HttpMethod.GET, entity, CanvasResponseUserObject[].class);
        CanvasResponseUserObject[] users = response.getBody();

        if (response == null || users == null || users.length == 0 || users[0].getId() == null) {
            throw new UserNotFoundException(name);
        }

        return users;
    }
}
