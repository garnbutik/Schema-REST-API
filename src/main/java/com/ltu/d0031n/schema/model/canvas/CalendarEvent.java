package com.ltu.d0031n.schema.model.canvas;

import com.fasterxml.jackson.annotation.*;

public class CalendarEvent {

    private long id;
    private String title;
    private String startAt;
    private String endAt;
    private String workflowState;
    private String createdAt;
    private String updatedAt;
    private boolean allDay;
    private String allDayDate;
    private Object comments;
    private Object locationAddress;
    private Object locationName;
    private String type;
    private Object description;
    private long childEventsCount;
    private String allContextCodes;
    private String contextCode;
    private Object parentEventID;
    private boolean hidden;
    private Object[] childEvents;
    private String url;
    private String htmlURL;
    private Object[] duplicates;

    public CalendarEvent() {
    }

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("start_at")
    public String getStartAt() { return startAt; }
    @JsonProperty("start_at")
    public void setStartAt(String value) { this.startAt = value; }

    @JsonProperty("end_at")
    public String getEndAt() { return endAt; }
    @JsonProperty("end_at")
    public void setEndAt(String value) { this.endAt = value; }

    @JsonProperty("workflow_state")
    public String getWorkflowState() { return workflowState; }
    @JsonProperty("workflow_state")
    public void setWorkflowState(String value) { this.workflowState = value; }

    @JsonProperty("created_at")
    public String getCreatedAt() { return createdAt; }
    @JsonProperty("created_at")
    public void setCreatedAt(String value) { this.createdAt = value; }

    @JsonProperty("updated_at")
    public String getUpdatedAt() { return updatedAt; }
    @JsonProperty("updated_at")
    public void setUpdatedAt(String value) { this.updatedAt = value; }

    @JsonProperty("all_day")
    public boolean getAllDay() { return allDay; }
    @JsonProperty("all_day")
    public void setAllDay(boolean value) { this.allDay = value; }

    @JsonProperty("all_day_date")
    public String getAllDayDate() { return allDayDate; }
    @JsonProperty("all_day_date")
    public void setAllDayDate(String value) { this.allDayDate = value; }

    @JsonProperty("comments")
    public Object getComments() { return comments; }
    @JsonProperty("comments")
    public void setComments(Object value) { this.comments = value; }

    @JsonProperty("location_address")
    public Object getLocationAddress() { return locationAddress; }
    @JsonProperty("location_address")
    public void setLocationAddress(Object value) { this.locationAddress = value; }

    @JsonProperty("location_name")
    public Object getLocationName() { return locationName; }
    @JsonProperty("location_name")
    public void setLocationName(Object value) { this.locationName = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("description")
    public Object getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(Object value) { this.description = value; }

    @JsonProperty("child_events_count")
    public long getChildEventsCount() { return childEventsCount; }
    @JsonProperty("child_events_count")
    public void setChildEventsCount(long value) { this.childEventsCount = value; }

    @JsonProperty("all_context_codes")
    public String getAllContextCodes() { return allContextCodes; }
    @JsonProperty("all_context_codes")
    public void setAllContextCodes(String value) { this.allContextCodes = value; }

    @JsonProperty("context_code")
    public String getContextCode() { return contextCode; }
    @JsonProperty("context_code")
    public void setContextCode(String value) { this.contextCode = value; }

    @JsonProperty("parent_event_id")
    public Object getParentEventID() { return parentEventID; }
    @JsonProperty("parent_event_id")
    public void setParentEventID(Object value) { this.parentEventID = value; }

    @JsonProperty("hidden")
    public boolean getHidden() { return hidden; }
    @JsonProperty("hidden")
    public void setHidden(boolean value) { this.hidden = value; }

    @JsonProperty("child_events")
    public Object[] getChildEvents() { return childEvents; }
    @JsonProperty("child_events")
    public void setChildEvents(Object[] value) { this.childEvents = value; }

    @JsonProperty("url")
    public String getURL() { return url; }
    @JsonProperty("url")
    public void setURL(String value) { this.url = value; }

    @JsonProperty("html_url")
    public String getHTMLURL() { return htmlURL; }
    @JsonProperty("html_url")
    public void setHTMLURL(String value) { this.htmlURL = value; }

    @JsonProperty("duplicates")
    public Object[] getDuplicates() { return duplicates; }
    @JsonProperty("duplicates")
    public void setDuplicates(Object[] value) { this.duplicates = value; }

}
