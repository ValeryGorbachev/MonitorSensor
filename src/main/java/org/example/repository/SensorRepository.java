package org.example.repository;

import org.example.entity.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
    List<Sensor> findByNameContainingAndModelContaining(String name, String model);
    List<Sensor> findByNameContaining(String name);
    List<Sensor> findByModelContaining(String model);
}