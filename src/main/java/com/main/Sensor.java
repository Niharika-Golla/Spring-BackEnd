package com.main;

import org.springframework.data.annotation.CreatedDate;
import java.time.LocalDateTime;

public class Sensor {
    private String type;
    private String value;

    @CreatedDate // Automatically set by Spring Data MongoDB
    private LocalDateTime timestamp;

    public Sensor() {}

    public Sensor(String type, String value) {
        this.type = type;
        this.value = value;
        this.timestamp = LocalDateTime.now(); // Set current time
    }

    // Getters and Setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
