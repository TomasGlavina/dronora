package com.ozanthongtomi.deviceIOT.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;


@Component
public class FlightCommander {

    public void pingDroneUnit() {
        System.out.println("Drone now online.");
    }

    public String deliver() {
        String response = "Now delivering... ";
        return response;
    }


    public String waitForPizza() {
        String response = "Now waiting for Pizza... ";
        return response;
    }


    public String pickUp() {
        String response = "Picking up pizza... ";
        return response;
    }

    public String comeBack() {
        String response = "Now coming back... ";
        return response;
    }

    public String deliverProcess(@PathVariable int deliverStatus) {
        String response = "";
        switch(deliverStatus) {
            case 1 -> response = pickUp();
            case 2 -> response = waitForPizza();
            case 3 -> response = deliver();
            case 4 -> response = comeBack();
        }

        return response;
    }
}
