package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "sensor_types")
public class SensorType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    private SensorTypeEnum name;

    public enum SensorTypeEnum {
        PRESSURE,
        VOLTAGE,
        TEMPERATURE,
        HUMIDITY
    }
} 