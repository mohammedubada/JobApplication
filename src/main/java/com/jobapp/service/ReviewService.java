package com.jobapp.service;

import java.util.List;

import com.jobapp.entity.Review;

public interface ReviewService {

	List<Review> getReviews(Long companyId);

	boolean addReview(Long companyId, Review review);

	Review getReview(Long companyId, Long reviewId);

	boolean updateReview(Long companyId, Long reviewId, Review review);

	boolean deleteReview(Long companyId, Long reviewId);

	

}
