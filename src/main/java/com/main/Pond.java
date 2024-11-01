package com.main;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "ponds")
public class Pond {
    
    @Id
    private String id;
    private String name;
    private List<Sensor> sensors = new ArrayList<>();

    @CreatedDate // Automatically sets the creation date
    private LocalDateTime createdAt;

    public Pond() {}

    public Pond(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getters and Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sensor> getSensors() {
        return sensors;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensors = sensors;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void addSensor(Sensor sensor) {
        this.sensors.add(sensor);
    }
}
