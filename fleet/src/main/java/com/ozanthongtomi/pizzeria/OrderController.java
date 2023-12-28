package com.ozanthongtomi.pizzeria;

import com.ozanthongtomi.drones.model.NewFlightRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3001/")
@RequestMapping("/dronepizza")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/pizzaorders")
    public void placeOrder(@RequestBody NewFlightRequest order) {
        // Process the order and send it to the server
        orderService.processOrder(order);
    }
}