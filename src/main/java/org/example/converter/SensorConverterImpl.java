package org.example.converter;

import org.example.dto.SensorDTO;
import org.example.entity.Sensor;
import org.example.entity.SensorType;
import org.example.entity.Unit;
import org.example.repository.SensorTypeRepository;
import org.example.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class SensorConverterImpl implements SensorConverter {

    @Autowired
    private SensorTypeRepository sensorTypeRepository;
    @Autowired
    private UnitRepository unitRepository;

    @Override
    public SensorDTO toDTO(Sensor sensor) {
        SensorDTO dto = new SensorDTO();
        dto.setId(sensor.getId());
        dto.setName(sensor.getName());
        dto.setModel(sensor.getModel());
        dto.setRangeFrom(sensor.getRangeFrom());
        dto.setRangeTo(sensor.getRangeTo());
        dto.setType(sensor.getType().getName().name());
        if (sensor.getUnit() != null) {
            dto.setUnit(sensor.getUnit().getName().name());
        }
        dto.setLocation(sensor.getLocation());
        dto.setDescription(sensor.getDescription());
        return dto;
    }

    @Override
    public Sensor toEntity(SensorDTO sensorDTO) {
        Sensor sensor = new Sensor();
        sensor.setName(sensorDTO.getName());
        sensor.setModel(sensorDTO.getModel());
        sensor.setRangeFrom(sensorDTO.getRangeFrom());
        sensor.setRangeTo(sensorDTO.getRangeTo());

        SensorType type = sensorTypeRepository.findByName(SensorType.SensorTypeEnum.valueOf(sensorDTO.getType()))
                .orElseThrow(() -> new EntityNotFoundException("Sensor type not found"));
        sensor.setType(type);

        if (sensorDTO.getUnit() != null) {
            Unit unit = unitRepository.findByName(Unit.UnitEnum.valueOf(sensorDTO.getUnit()))
                    .orElseThrow(() -> new EntityNotFoundException("Unit not found"));
            sensor.setUnit(unit);
        }

        sensor.setLocation(sensorDTO.getLocation());
        sensor.setDescription(sensorDTO.getDescription());
        return sensor;
    }
}
