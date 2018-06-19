package com.service.ems.services;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ems.domain.InsuranceCompany;
import com.service.ems.domain.InsurancePolicy;
import com.service.ems.modelMappers.ModelMapperUtil;
import com.service.ems.models.InsuranceCompanyModel;
import com.service.ems.models.InsurancePolicyModel;
import com.service.ems.repositories.InsuranceCompanyRepository;
import com.service.ems.repositories.InsurancePolicyRepository;

@Service
@Transactional
public class InsuranceServiceImpl implements InsuranceService {

	@Autowired
	InsuranceCompanyRepository companyRepository;
	
	@Autowired
	InsurancePolicyRepository policyRepository;
	
	@Override
	public List<InsuranceCompanyModel> getCompany() {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		List<InsuranceCompanyModel> companiesModel;
		List<InsuranceCompany> companies = companyRepository.findAll(); // companies.get(0).getProducts()
		companiesModel = companies.stream().map(company -> {
			return modelMapper.map(company, InsuranceCompanyModel.class);
		}).collect(Collectors.toList());
		return companiesModel;
	}

	@Override
	public List<InsuranceCompanyModel> getCompanyById(long id) {
		
		ModelMapper modelMapper1 = ModelMapperUtil.getGenericMapper();
		List<InsuranceCompanyModel> companiesModel;
		Collection<InsuranceCompany> companies = companyRepository.findAllById(id); // companies.get(0).getProducts()
		companiesModel = companies.stream().map(company -> {
			return modelMapper1.map(company, InsuranceCompanyModel.class);
		}).collect(Collectors.toList());
		return companiesModel;
	}
	
	@Override
	public InsuranceCompanyModel addCompany(InsuranceCompanyModel insuranceCompany) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		InsuranceCompany insuranceCompanyDomain = modelMapper.map(insuranceCompany,InsuranceCompany.class);
		InsuranceCompanyModel insuranceCompanyModel = modelMapper.map(companyRepository.saveAndFlush(insuranceCompanyDomain), InsuranceCompanyModel.class);
		return insuranceCompanyModel;
	}

	@Override
	public InsuranceCompanyModel updateCompany(InsuranceCompanyModel insuranceCompany) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		InsuranceCompany insuranceCompanyDomain = modelMapper.map(insuranceCompany,InsuranceCompany.class);
		InsuranceCompanyModel insuranceCompanyModel = modelMapper.map(companyRepository.saveAndFlush(insuranceCompanyDomain), InsuranceCompanyModel.class);
		return insuranceCompanyModel;
	}

	@Override
	public void deleteCompany(long id) {
		companyRepository.delete(id);
		
	}

	@Override
	public List<InsurancePolicyModel> getPolicy() {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		List<InsurancePolicyModel> policiesModel;
		List<InsurancePolicy> policies = policyRepository.findAll(); // companies.get(0).getProducts()
		policiesModel = policies.stream().map(policy -> {
			return modelMapper.map(policy, InsurancePolicyModel.class);
		}).collect(Collectors.toList());
		return policiesModel;

	}
	
	@Override
	public List<InsurancePolicyModel> getPolicyById(long id) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		List<InsurancePolicyModel> policiesModel;
		Collection<InsurancePolicy> policies = policyRepository.findAllById(id); // companies.get(0).getProducts()
		policiesModel = policies.stream().map(policy -> {
			return modelMapper.map(policy, InsurancePolicyModel.class);
		}).collect(Collectors.toList());
		return policiesModel;
		
//		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
//		List<InsurancePolicyModel> insurancePolicy;
//		insurancePolicy = policyRepository.findAllById(id).stream().map(policy -> {
//			return modelMapper.map(policy, InsurancePolicyModel.class);
//		}).collect(Collectors.toList());
//
//		return insurancePolicy;
		
	}
	

	@Override
	public InsurancePolicyModel addPolicy(InsurancePolicyModel insurancePolicy) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		InsurancePolicy insurancePolicyDomain = modelMapper.map(insurancePolicy,InsurancePolicy.class);
		InsurancePolicyModel insurancePolicyModel = modelMapper.map(policyRepository.saveAndFlush(insurancePolicyDomain), InsurancePolicyModel.class);
		return insurancePolicyModel;
	}

	@Override
	public InsurancePolicyModel updatePolicy(InsurancePolicyModel insurancePolicy) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		InsurancePolicy insurancePolicyDomain = modelMapper.map(insurancePolicy,InsurancePolicy.class);
		InsurancePolicyModel insurancePolicyModel = modelMapper.map(policyRepository.saveAndFlush(insurancePolicyDomain), InsurancePolicyModel.class);
		return insurancePolicyModel;
	}

	@Override
	public void deletePolicy(long id) {
		policyRepository.delete(id);
	}

}
