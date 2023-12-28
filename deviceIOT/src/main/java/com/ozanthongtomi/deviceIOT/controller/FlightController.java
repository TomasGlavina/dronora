package com.ozanthongtomi.deviceIOT.controller;
import org.springframework.web.bind.annotation.PathVariable;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ozanthongtomi.deviceIOT.service.FlightCommander;

@RestController
@RequestMapping(path="/device")
public class FlightController {
    
    @Autowired
    private FlightCommander flightCommander;

    @GetMapping
    public void test() {
        flightCommander.pingDroneUnit();
    }

    @GetMapping(path="/deliver/{deliverStatus}")
    public String deliverProcess(@PathVariable int deliverStatus) {
       return flightCommander.deliverProcess(deliverStatus); 
    }

}
