package com.ozanthongtomi.drones.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;


@Table(name="dronoraDBflights")
@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Flight {
    @Id
    @NotNull
    private Long id;

    @NotNull
    private int weight;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "starting_point_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "starting_point_longitude"))
    })
    @NotNull
    private Location startingPoint;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "latitude", column = @Column(name = "destination_latitude")),
            @AttributeOverride(name = "longitude", column = @Column(name = "destination_longitude"))
    })
    @NotNull
    private Location destination;

    @Column(name = "drone_id")
    @NotNull
    private Long droneId;

    @NotNull
    private String status;
}

