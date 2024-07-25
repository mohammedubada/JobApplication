package com.jobapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobapp.entity.Review;

@Repository
public interface ReviewRepo extends JpaRepository<Review, Long> {

	List<Review> findByCompanyId(Long companyId);

}
