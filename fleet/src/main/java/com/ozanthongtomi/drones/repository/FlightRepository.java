package com.ozanthongtomi.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ozanthongtomi.drones.model.Flight;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long> {

}