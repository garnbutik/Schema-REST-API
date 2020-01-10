package com.ltu.d0031n.schema.model.canvas;

import java.text.NumberFormat;
import java.text.ParsePosition;

public class ContextObject {

    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (isNumeric(id)) {
            this.id = "user_" + id;
        } else {
            this.id = id;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private boolean isNumeric(String str) {
        NumberFormat formatter = NumberFormat.getInstance();
        ParsePosition pos = new ParsePosition(0);
        formatter.parse(str, pos);
        return str.length() == pos.getIndex();
    }
}
