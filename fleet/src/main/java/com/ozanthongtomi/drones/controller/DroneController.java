package com.ozanthongtomi.drones.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ozanthongtomi.drones.model.Drone;
import com.ozanthongtomi.drones.model.NewDroneRequest;
import com.ozanthongtomi.drones.service.DroneService;


@RestController
@RequestMapping("/dronora")
public class DroneController {
    private final DroneService droneService;

    @Autowired
    public DroneController(DroneService droneService) {
        this.droneService = droneService;
    }

    @GetMapping("/info")
    public String greet(){
        String s =  "Hello World";
        return s;
    }

    @GetMapping("/drones")
    public List<Drone> findAll() {
        return droneService.findAll();
    }

    @GetMapping("/drones/{id}")
    public Optional<Drone> getDroneById(@PathVariable Long id){
        return droneService.getDroneById(id);
    }

    @PostMapping("/drones")
    public void createDrone(@RequestBody NewDroneRequest request) {
        Drone drone = new Drone();
        drone.setId(request.getId());
        drone.setName(request.getName());
        drone.setCapacity(request.getCapacity());
        drone.setStatus(request.getStatus());
        droneService.createDrone(drone);
    }

    @DeleteMapping("/drones/{id}")
    public void deleteDrone(@PathVariable Long id) {
        droneService.deleteDrone(id);
    }

    @PutMapping("/drones/{id}")
    public void updateDrone(@PathVariable Long id, @RequestBody NewDroneRequest request) {
        Drone drone = new Drone();
        drone.setId(id);
        drone.setName(request.getName());
        drone.setCapacity(request.getCapacity());
        drone.setStatus(request.getStatus());
        droneService.updateDrone(drone);
    }
}
