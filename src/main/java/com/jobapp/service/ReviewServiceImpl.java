package com.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.entity.Review;
import com.jobapp.entity.Company;
import com.jobapp.repo.ReviewRepo;

@Service
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	ReviewRepo reviewRepo;
	
	@Autowired
	CompanyService companyService;

	@Override
	public List<Review> getReviews(Long companyId) {
		return reviewRepo.findByCompanyId(companyId);
	}

	@Override
	public boolean addReview(Long companyId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			reviewRepo.save(review);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Review getReview(Long companyId, Long reviewId) {
		List<Review> reviews = reviewRepo.findByCompanyId(companyId);
		return reviews.stream()
				.filter(review -> review.getId().equals(reviewId))
				.findFirst()
				.orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review review) {
		Company company = companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			review.setId(reviewId);
			reviewRepo.save(review);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if(companyService.getCompanyById(companyId) != null && reviewRepo.existsById(reviewId) ) {
			Review review = reviewRepo.findById(reviewId).orElse(null);
			Company company = review.getCompany();
			company.getReviews().remove(review);
			review.setCompany(null);
			companyService.upadateCompany(company);
			reviewRepo.deleteById(reviewId);
		return true;
		}else {
			return false;
		}
		
	}
	
	

}
