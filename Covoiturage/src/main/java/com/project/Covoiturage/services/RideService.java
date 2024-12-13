package com.project.Covoiturage.services;

import com.project.Covoiturage.entity.Ride;
import com.project.Covoiturage.repository.RideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RideService {
    @Autowired
    private RideRepository rideRepository;

    public List<Ride> getAllRides() {
        return rideRepository.findAll();
    }

    public Ride getRideById(Long id) {
        return rideRepository.findById(id).get();
    }

    public List<Ride> searchRide(String departure, String destination) {
        return rideRepository.findByDepartureAndDestination(departure, destination);
    }

    public Ride saveRide(Ride ride) {
        return rideRepository.save(ride);
    }

    public void deleteRide(Long id) {
        rideRepository.deleteById(id);
    }
}
