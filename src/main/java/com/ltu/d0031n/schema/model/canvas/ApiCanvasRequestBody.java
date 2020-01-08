package com.ltu.d0031n.schema.model.canvas;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ltu.d0031n.schema.model.apiResponse.ApiResponseModel;

public class ApiCanvasRequestBody extends ApiResponseModel {

    @JsonProperty("user")
    private String contextCode;

    public String getContextCode() {
        return contextCode;
    }

    public void setContextCode(String contextCode) {
        this.contextCode = contextCode;
    }
}
