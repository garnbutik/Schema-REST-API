package com.ltu.d0031n.schema.model.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CalendarEventCanvasPayload {

    private CalendarEvent calendarEvent;

    public CalendarEventCanvasPayload() {
    }

    @JsonProperty("calendar_event")
    public CalendarEvent getCalendarEvent() { return calendarEvent; }
    @JsonProperty("calendar_event")
    public void setCalendarEvent(CalendarEvent value) { this.calendarEvent = value; }

}
