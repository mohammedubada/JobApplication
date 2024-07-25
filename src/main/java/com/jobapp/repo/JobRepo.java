package com.jobapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobapp.entity.Job;

@Repository
public interface JobRepo extends JpaRepository<Job,Long>{

}
