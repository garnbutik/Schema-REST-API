package com.ltu.d0031n.schema.model.timedit;


import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "startdate",
        "starttime",
        "enddate",
        "endtime",
        "columns"
})
@JsonIgnoreProperties(ignoreUnknown = true)
public class TimeEditLesson {

    @JsonProperty("id")
    private String id;
    @JsonProperty("startdate")
    private String startdate;
    @JsonProperty("starttime")
    private String starttime;
    @JsonProperty("enddate")
    private String enddate;
    @JsonProperty("endtime")
    private String endtime;
    @JsonProperty("columns")
    private List<String> columns = null;


    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("startdate")
    public String getStartdate() {
        return startdate;
    }

    @JsonProperty("startdate")
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }

    @JsonProperty("starttime")
    public String getStarttime() {
        return starttime;
    }

    @JsonProperty("starttime")
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    @JsonProperty("enddate")
    public String getEnddate() {
        return enddate;
    }

    @JsonProperty("enddate")
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }

    @JsonProperty("endtime")
    public String getEndtime() {
        return endtime;
    }

    @JsonProperty("endtime")
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    @JsonProperty("columns")
    public List<String> getColumns() {
        return columns;
    }

    @JsonProperty("columns")
    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TimeEditLesson that = (TimeEditLesson) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
