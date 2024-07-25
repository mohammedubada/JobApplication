package com.jobapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobapp.entity.Company;
import com.jobapp.repo.CompanyRepo;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepo companyRepo;

	@Override
	public List<Company> getAllCompanies() {
		return companyRepo.findAll();
	}

	@Override
	public Company getCompanyById(Long id) {
		Optional<Company> companyDB = companyRepo.findById(id);
		Company company = companyDB.get();
		return company;
	}

	@Override
	public String addCompany(Company company) {
		companyRepo.save(company);
		return "Company added";
	}

	@Override
	public String upadateCompany(Company company) {
		companyRepo.save(company);
		return "updated success";
	}

	@Override
	public String deletecompany() {
		companyRepo.deleteAll();
		return "Deleted all";
	}
}
