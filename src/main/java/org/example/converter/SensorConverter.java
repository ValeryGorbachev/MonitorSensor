package org.example.converter;

import org.example.dto.SensorDTO;
import org.example.entity.Sensor;

public interface SensorConverter {

    SensorDTO toDTO(Sensor sensor);

    Sensor toEntity(SensorDTO sensorDTO);
}
