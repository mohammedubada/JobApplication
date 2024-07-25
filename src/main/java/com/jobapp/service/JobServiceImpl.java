package com.jobapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.entity.Job;
import com.jobapp.repo.JobRepo;

@Service
public class JobServiceImpl implements JobService{

    @Autowired
    JobRepo jobRepo;

    @Override
    public List<Job> getAllJobs() {
        return jobRepo.findAll();
    }

    @Override
    public Job getJobById(Long id) {
        return jobRepo.findById(id).get();
    }

    @Override
    public Job saveJob(Job job) {
        return jobRepo.save(job);
    }

    @Override
    public Job updateJob(Job job) {
        return jobRepo.save(job);
    }

}
