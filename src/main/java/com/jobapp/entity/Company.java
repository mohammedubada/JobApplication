package com.jobapp.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {
																	// adding job in postman
	@Id																// {id	:1;
	@GeneratedValue(strategy = GenerationType.IDENTITY)				// title:"";
	private Long id;												// "company":{
	private String name;											//		id:
	private String description;										//}}
	
	//line 30 creates company pkey in job table... if mappedby isnt mentioned then separate company_job table will b created
	@JsonIgnore	// to get rid of infinite loop
	@OneToMany(mappedBy = "company") 
	private List<Job> jobs;

	@OneToMany(mappedBy = "company")
	private List<Review> reviews;

}
