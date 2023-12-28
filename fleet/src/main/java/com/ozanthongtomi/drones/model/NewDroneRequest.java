package com.ozanthongtomi.drones.model;

import java.util.Objects;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@EqualsAndHashCode
public class NewDroneRequest {

    private Long id;
    private String name;
    private int capacity;
    private String status;

    public NewDroneRequest(Long id, String name, int capacity, String status){
        this.id = id;
        this.name = name;
        this.capacity = capacity;
        this.status = status;
    }
}
