package org.example.service;

import org.example.dto.SensorDTO;

import java.util.List;

public interface SensorService {

    List<SensorDTO> getAllSensors(String name, String model);

    SensorDTO getSensor(Long id);

    SensorDTO createSensor(SensorDTO sensorDTO);

    SensorDTO updateSensor(Long id, SensorDTO sensorDTO);

    void deleteSensor(Long id);
}
