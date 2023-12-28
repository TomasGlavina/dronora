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

import com.ozanthongtomi.drones.model.Flight;
import com.ozanthongtomi.drones.model.NewFlightRequest;
import com.ozanthongtomi.drones.service.FlightService;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@RequestMapping("/dronora")
public class FlightsController {
    private final FlightService flightService;

    @Autowired
    public FlightsController(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/flights")
    public List<Flight> findAll() {
        return flightService.findAll();
    }

    @GetMapping("/flights/{id}")
    public Optional<Flight> getFlightById(@PathVariable Long id) {
        return flightService.getFlightById(id);
    }

    @PostMapping("/flights")
    public void createFlight(@RequestBody NewFlightRequest request) {
        flightService.createFlight(request);
    }

    @DeleteMapping("/flight/{id}")
    public void deleteFlight(@PathVariable Long id) {
        flightService.deleteFlight(id);
    }

    @PutMapping("/flight/{id}")
    public void updateFlight(@PathVariable Long id, @RequestBody NewFlightRequest request) {
        Flight flight = new Flight();
        // TODO: logic to update flight
    }

    @GetMapping("/flight/deliver/{id}")
    public void commandFly(@PathVariable Long id) {
        flightService.commandFly(id);
    }
}
