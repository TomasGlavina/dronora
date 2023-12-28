package com.ozanthongtomi.drones.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class NewFlightRequest {
    private Location destination;
    private Location startingPoint;
    private int weight;

    public NewFlightRequest(int weight, Location destination, Location startingPoint){
        this.weight = weight;
        this.destination = destination;
        this.startingPoint = startingPoint;
    }
}
