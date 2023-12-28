package com.ozanthongtomi.drones.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.ozanthongtomi.drones.model.Drone;
import com.ozanthongtomi.drones.repository.DroneRepository;

@Service
public class DroneService {
    private final DroneRepository droneRepository;

    @Autowired
    public DroneService(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    public List<Drone> findAll() {
        return droneRepository.findAll();
    }
    
    public Optional<Drone> getDroneById(@PathVariable Long id){
        try {
            return Optional.ofNullable(droneRepository.findById(id)
            .orElseThrow(() -> new ChangeSetPersister.NotFoundException()));
        } catch (ChangeSetPersister.NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Drone createDrone(Drone drone) {
        
        return droneRepository.save(drone);
    }

    public Drone updateDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public void deleteDrone(Long id) {
        droneRepository.deleteById(id);
    }
}
