package com.jobapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.entity.Job;
import com.jobapp.service.JobService;

@RestController
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/jobs/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @PostMapping("/jobs")
    public Job saveJob(@RequestBody Job job){
        return jobService.saveJob(job);
    }

    @PutMapping("/jobs")
    public Job updateJob(@RequestBody Job job){
        return jobService.updateJob(job);
    }

    @GetMapping("/come")
    public String welcome(){
        return "Hello there";
    }


    }

