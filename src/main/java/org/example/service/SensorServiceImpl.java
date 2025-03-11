package org.example.service;

import org.example.converter.SensorConverter;
import org.example.dto.SensorDTO;
import org.example.entity.Sensor;
import org.example.entity.SensorType;
import org.example.entity.Unit;
import org.example.repository.SensorRepository;
import org.example.repository.SensorTypeRepository;
import org.example.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SensorServiceImpl implements SensorService {

    @Autowired
    private SensorRepository sensorRepository;
    @Autowired
    private SensorTypeRepository sensorTypeRepository;
    @Autowired
    private UnitRepository unitRepository;
    @Autowired
    private SensorConverter sensorConverter;


    @Transactional(readOnly = true)
    @Override
    public List<SensorDTO> getAllSensors(String name, String model) {
        List<Sensor> sensors;
        if (name != null && model != null) {
            sensors = sensorRepository.findByNameContainingAndModelContaining(name, model);
        } else if (name != null) {
            sensors = sensorRepository.findByNameContaining(name);
        } else if (model != null) {
            sensors = sensorRepository.findByModelContaining(model);
        } else {
            sensors = sensorRepository.findAll();
        }
        return sensors.stream().map(sensorConverter::toDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    @Override
    public SensorDTO getSensor(Long id) {
        return sensorConverter.toDTO(sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor not found")));
    }

    @Transactional
    @Override
    public SensorDTO createSensor(SensorDTO sensorDTO) {
        Sensor sensor = sensorConverter.toEntity(sensorDTO);
        return sensorConverter.toDTO(sensorRepository.save(sensor));
    }

    @Transactional
    @Override
    public SensorDTO updateSensor(Long id, SensorDTO sensorDTO) {
        Sensor sensor = sensorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Sensor not found"));
        updateSensorFromDTO(sensor, sensorDTO);
        return sensorConverter.toDTO(sensorRepository.save(sensor));
    }

    @Transactional
    @Override
    public void deleteSensor(Long id) {
        if (!sensorRepository.existsById(id)) {
            throw new EntityNotFoundException("Sensor not found");
        }
        sensorRepository.deleteById(id);
    }

    private void updateSensorFromDTO(Sensor sensor, SensorDTO dto) {
        sensor.setName(dto.getName());
        sensor.setModel(dto.getModel());
        sensor.setRangeFrom(dto.getRangeFrom());
        sensor.setRangeTo(dto.getRangeTo());

        SensorType type = sensorTypeRepository.findByName(SensorType.SensorTypeEnum.valueOf(dto.getType()))
                .orElseThrow(() -> new EntityNotFoundException("Sensor type not found"));
        sensor.setType(type);

        if (dto.getUnit() != null) {
            Unit unit = unitRepository.findByName(Unit.UnitEnum.valueOf(dto.getUnit()))
                    .orElseThrow(() -> new EntityNotFoundException("Unit not found"));
            sensor.setUnit(unit);
        }

        sensor.setLocation(dto.getLocation());
        sensor.setDescription(dto.getDescription());
    }
} 