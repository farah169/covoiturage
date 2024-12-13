package com.project.Covoiturage.controller;

import com.project.Covoiturage.entity.Ride;
import com.project.Covoiturage.services.RideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rides")
public class RideController {
    @Autowired
    private RideService rideService;

    @GetMapping
    public List<Ride> getAllRides() {
        return rideService.getAllRides();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ride> getRideById(@PathVariable Long id) {
        Ride ride = rideService.getRideById(id);
        if (ride != null) {
            return ResponseEntity.ok(ride);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/search")
    public List<Ride> searchRide(@RequestParam String departure, @RequestParam String destination) {
        return rideService.searchRide(departure, destination);
    }

    @PostMapping
    public Ride createRide(@RequestBody Ride ride) {
        return rideService.saveRide(ride);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRide(@PathVariable Long id) {
        rideService.deleteRide(id);
        return ResponseEntity.noContent().build();
    }
}
