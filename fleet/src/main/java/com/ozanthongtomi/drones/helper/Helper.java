package com.ozanthongtomi.drones.helper;

import com.ozanthongtomi.drones.model.Drone;
import com.ozanthongtomi.drones.model.Location;

import java.util.List;

public class Helper {
    public double calculateDistance(Location startingPoint , Location endPoint) {
        double EARTH_RADIUS = 6371; // in kilometers

        double lat1Rad = Math.toRadians(startingPoint.getLatitude());
        double lat2Rad = Math.toRadians(endPoint.getLatitude());
        double lon1Rad = Math.toRadians(startingPoint.getLongitude());
        double lon2Rad = Math.toRadians(endPoint.getLongitude());

        double x = (lon2Rad - lon1Rad) * Math.cos((lat1Rad + lat2Rad) / 2);
        double y = (lat2Rad - lat1Rad);

        return Math.sqrt(x * x + y * y) * EARTH_RADIUS; // in kilometers
    }

    public Drone getSuitableDrone(List<Drone> drones, int minimumCapacity ) {
        for (Drone drone : drones) {
            if (drone.getCapacity() > minimumCapacity && "AVAILABLE".equals(drone.getStatus())) {
                return drone;
            }
        }
        return null;
    }
}
