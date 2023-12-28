package com.ozanthongtomi.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozanthongtomi.drones.model.Drone;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long> {
    
}
