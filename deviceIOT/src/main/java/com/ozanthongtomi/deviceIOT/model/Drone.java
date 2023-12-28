package com.ozanthongtomi.deviceIOT.model;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;
import jakarta.validation.constraints.*;
import lombok.*;
import org.springframework.web.client.RestTemplate;
import org.json.simple.JSONObject;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component; // For @Component
import org.springframework.beans.factory.annotation.Autowired; // For @Autowired
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

@Component
@Getter
@Setter
public class Drone {
    private Long id;
    private String name;
    private int capacity;
    private String status;

    @Autowired
    public Drone(
        @Value("${drone.id}") Long id,
        @Value("${drone.name}") String name,
        @Value("${drone.capacity}") int capacity,
        @Value("${drone.status}") String status
    ) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }

    @EventListener(ContextRefreshedEvent.class)
    public void onApplicationStart() {
        // This method will be called when the application context is fully initialized.
        sendDrone();
    }

    public void sendDrone() {
        String uri = "http://localhost:8082/dronora/drones";
        RestTemplate restTemplate = new RestTemplate();
        // Create a NewDroneRequest object with the desired status
        System.out.println(this);
        // Make the PUT request
        JSONObject droneJSON = new JSONObject();
        droneJSON.put("id", this.getId());
        droneJSON.put("name", this.getName());
        droneJSON.put("capacity", this.getCapacity());
        droneJSON.put("status", this.getStatus());


        String requestBody = droneJSON.toString();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
    
        // Create the HTTP entity with headers and the request body
        HttpEntity<String> requestEntity = new HttpEntity<>(requestBody, headers);

        System.out.println(requestEntity);
    
        // Make the POST request
        restTemplate.postForObject(
            uri,            // Replace with your API endpoint URL
            requestEntity,  // Use the HttpEntity with headers and request body
            String.class    // Replace with the expected response class type
        );
        
        
    };
}
