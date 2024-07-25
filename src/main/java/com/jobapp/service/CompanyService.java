package com.jobapp.service;

import java.util.List;

import com.jobapp.entity.Company;

public interface CompanyService {

	List<Company> getAllCompanies();

	Company getCompanyById(Long id);

	String addCompany(Company company);

	String upadateCompany(Company company);

	String deletecompany();

}
