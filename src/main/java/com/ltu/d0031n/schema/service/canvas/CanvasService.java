package com.ltu.d0031n.schema.service.canvas;

import com.ltu.d0031n.schema.exception.UserNotFoundException;
import com.ltu.d0031n.schema.model.canvas.CalendarEvent;
import com.ltu.d0031n.schema.model.canvas.CalendarEventCanvasPayload;
import com.ltu.d0031n.schema.model.canvas.CanvasResponseUserObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public void createCaledarEvent(CalendarEvent event){
        CalendarEventCanvasPayload payload = new CalendarEventCanvasPayload();
        payload.setCalendarEvent(event);
        restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + this.token);
        HttpEntity<CalendarEventCanvasPayload> entity = new HttpEntity<>(payload, headers);
        ResponseEntity<CalendarEvent> responseEntity = restTemplate.postForEntity(createCaledarEventUrl, entity, CalendarEvent.class);
    }

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
