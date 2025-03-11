package org.example.controller;

import org.example.dto.SensorDTO;
import org.example.service.SensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorService sensorService;

    @GetMapping
    public ResponseEntity<List<SensorDTO>> getAllSensors(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String model) {
        return ResponseEntity.ok(sensorService.getAllSensors(name, model));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SensorDTO> getSensor(@PathVariable Long id) {
        return ResponseEntity.ok(sensorService.getSensor(id));
    }

    @PostMapping("/create")
    public ResponseEntity<SensorDTO> createSensor(@Valid @RequestBody SensorDTO sensorDTO) {
        return ResponseEntity.ok(sensorService.createSensor(sensorDTO));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<SensorDTO> updateSensor(
            @PathVariable Long id,
            @Valid @RequestBody SensorDTO sensorDTO) {
        return ResponseEntity.ok(sensorService.updateSensor(id, sensorDTO));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteSensor(@PathVariable Long id) {
        sensorService.deleteSensor(id);
        return ResponseEntity.ok().build();
    }
} 