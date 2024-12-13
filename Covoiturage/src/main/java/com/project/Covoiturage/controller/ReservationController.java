package com.project.Covoiturage.controller;

import com.project.Covoiturage.entity.Reservation;
import com.project.Covoiturage.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationService.getAllReservations();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservationById(@PathVariable Long id) {
        Reservation reservation = reservationService.getReservationById(id);
        if (reservation != null) {
            return ResponseEntity.ok(reservation);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/passenger/{passengerId}")
    public List<Reservation> getReservationsByPassenger(@PathVariable Long passengerId) {
        return reservationService.getReservationsByPassengerId(passengerId);
    }

    @GetMapping("/ride/{rideId}")
    public List<Reservation> getReservationsByRide(@PathVariable Long rideId) {
        return reservationService.getReservationsByRideId(rideId);
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationService.saveReservation(reservation);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long id) {
        reservationService.deleteReservation(id);
        return ResponseEntity.noContent().build();
    }
}
