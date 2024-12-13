package com.project.Covoiturage.controller;

import com.project.Covoiturage.entity.Review;
import com.project.Covoiturage.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReviews() {
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long id) {
        Review review = reviewService.getReviewById(id);
        if (review != null) {
            return ResponseEntity.ok(review);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/driver/{driverId}")
    public List<Review> getReviewsByDriver(@PathVariable Long driverId) {
        return reviewService.getReviewsByDriverId(driverId);
    }

    @GetMapping("/passenger/{passengerId}")
    public List<Review> getReviewsByPassenger(@PathVariable Long passengerId) {
        return reviewService.getReviewsByPassengerId(passengerId);
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
        return ResponseEntity.noContent().build();
    }
}
