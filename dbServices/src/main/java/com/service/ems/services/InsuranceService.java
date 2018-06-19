package com.service.ems.services;

import java.util.List;

import com.service.ems.models.InsuranceCompanyModel;
import com.service.ems.models.InsurancePolicyModel;

public interface InsuranceService {

	List<InsuranceCompanyModel> getCompany();

	InsuranceCompanyModel addCompany(InsuranceCompanyModel insuranceCompany);

	InsuranceCompanyModel updateCompany(InsuranceCompanyModel insuranceCompany);

	void deleteCompany(long id);

	List<InsurancePolicyModel> getPolicy();

	InsurancePolicyModel addPolicy(InsurancePolicyModel insurancePolicy);

	InsurancePolicyModel updatePolicy(InsurancePolicyModel insurancePolicy);

	void deletePolicy(long id);

	List<InsuranceCompanyModel> getCompanyById(long id);
	
	List<InsurancePolicyModel> getPolicyById(long id);

}
