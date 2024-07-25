package com.jobapp.service;

import java.util.List;

import com.jobapp.entity.Job;

public interface JobService {

    List<Job> getAllJobs();

    Job getJobById(Long id);


    Job saveJob(Job job);

    Job updateJob(Job job);


}
