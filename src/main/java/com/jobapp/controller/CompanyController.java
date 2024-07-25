package com.jobapp.controller;

import java.util.List;import org.hibernate.mapping.SemanticsResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobapp.entity.Company;
import com.jobapp.service.CompanyService;

@RestController
public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping("/company")
	public List<Company> getAllCompanies(){
		return companyService.getAllCompanies();
	}
	
	@GetMapping("/company/{id}")
	public Company getCompanyById(@PathVariable Long id){
		return companyService.getCompanyById(id);
	}
	
	@PostMapping("/company")
	public String addCompany(@RequestBody Company company) {
		companyService.addCompany(company);
		return "Company added success";
	}
	
	@PutMapping("/company")
	public String upadateCompany(@RequestBody Company company) {
		companyService.upadateCompany(company);
		return "Company updated success";
	}
	
	@DeleteMapping("/company")
	public String deletecompany() {
		return companyService.deletecompany();
	}
	
}
