package com.ozanthongtomi.drones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Table(name = "dronoraDB")
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Drone {

    @Id
    @NotNull
    private Long id;

    @NotBlank
    private String name;

    @NotNull
    private int capacity;

    @NotNull
    private String status;
    // status can be either AVAILABLE or RESERVED
}
