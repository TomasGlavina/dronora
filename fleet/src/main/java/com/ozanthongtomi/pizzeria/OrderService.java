package com.ozanthongtomi.pizzeria;

import com.ozanthongtomi.drones.model.Flight;
import com.ozanthongtomi.drones.model.NewFlightRequest;
import org.springframework.stereotype.Service;
import com.ozanthongtomi.drones.service.FlightService;

@Service
public class OrderService {
    private FlightService flightService;

    public OrderService(FlightService flightService) {
        this.flightService = flightService;
    }
    public void processOrder(NewFlightRequest order) {
        // Process the order logic (e.g., save order details)
        Flight newFlight = flightService.createFlight(order);

        if (newFlight != null) {
            System.out.println("Order placed successfully!");
        } else {
            System.out.println("Order placed unsuccessfully, there was no drone available from us...");
        }

        System.out.println("Finish!");
    }
}