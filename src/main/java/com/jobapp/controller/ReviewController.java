package com.jobapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.entity.Review;
import com.jobapp.service.ReviewService;

@RestController
@RequestMapping("/company/{companyId}")
public class ReviewController {
	
	@Autowired
	ReviewService reviewService;

	@GetMapping("/review")// All reviews of particular company
	public ResponseEntity<List<Review>> getReviews(@PathVariable Long companyId){
		return new ResponseEntity<>(reviewService.getReviews(companyId),HttpStatus.OK);
	}
	
	@PostMapping("/review")
	public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
		boolean reviewSaved = reviewService.addReview(companyId, review);
		if(reviewSaved)
			return new ResponseEntity<>("Review added",HttpStatus.OK);
		else 
			return new ResponseEntity<>("Review not added ",HttpStatus.OK);
	}
	
	@GetMapping("/review/{reviewId}")// One review of particular company using reviewId
	public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
		return new ResponseEntity<>(reviewService.getReview(companyId, reviewId), HttpStatus.OK);
	}
	
	@PutMapping("/review/{reviewId}")
	public String updateReview(@PathVariable Long companyId, @PathVariable Long reviewId,
							   @RequestBody Review review) {
		boolean saved = reviewService.updateReview(companyId, reviewId, review);
		if(saved)
			return "Review added";
		else
			return "Review not added";
	}
	
	@DeleteMapping("/review/{reviewId}")
	public String deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
		reviewService.deleteReview(companyId, reviewId);
		return "Deleted";
	}
	

}
