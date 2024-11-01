package com.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.main.Pond;
import com.main.Sensor;
import com.main.repository.PondRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/admin/ponds")
@CrossOrigin(origins = "http://localhost:4200")
public class PondController {

    @Autowired
    private PondRepository pondRepository;

    // Get all ponds
    @GetMapping
    public List<Pond> getAllPonds() {
        return pondRepository.findAll();
    }

    // Add a new pond
    @PostMapping
    public Pond addPond(@RequestBody Pond pond) {
        pond.setCreatedAt(LocalDateTime.now()); // Manually set the creation date
        return pondRepository.save(pond);
    }

    // Get sensors for a specific pond
    @GetMapping("/{pondId}/sensors")
    public List<Sensor> getSensorsByPond(@PathVariable String pondId) {
        Pond pond = pondRepository.findById(pondId)
                .orElseThrow(() -> new RuntimeException("Pond not found with ID: " + pondId));
        return pond.getSensors();
    }

    // Add or update a sensor to a specific pond
    @PostMapping("/{pondId}/sensors")
    public Pond addOrUpdateSensorToPond(@PathVariable String pondId, @RequestBody Sensor sensor) {
        Pond pond = pondRepository.findById(pondId)
                .orElseThrow(() -> new RuntimeException("Pond not found with ID: " + pondId));

        // Check if sensor of same type exists
        pond.getSensors().removeIf(existingSensor -> existingSensor.getType().equals(sensor.getType()));

        // Set the timestamp for the new sensor
        sensor.setTimestamp(LocalDateTime.now());
        
        pond.addSensor(sensor);
        return pondRepository.save(pond);
    }

    // Optional: Get a specific pond by ID
    @GetMapping("/{pondId}")
    public Optional<Pond> getPondById(@PathVariable String pondId) {
        return pondRepository.findById(pondId);
    }
}
