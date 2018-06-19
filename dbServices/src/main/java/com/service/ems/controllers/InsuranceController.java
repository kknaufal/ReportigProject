package com.service.ems.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.ems.domain.InsuranceCompany;
import com.service.ems.models.InsuranceCompanyModel;
import com.service.ems.models.InsurancePolicyModel;
import com.service.ems.services.InsuranceService;

@RestController
@RequestMapping(value="/insurance")
public class InsuranceController {

	@Autowired
	private InsuranceService insuranceService;
	
	@GetMapping("/company")
	ResponseEntity<List<InsuranceCompanyModel>> getCompany(){
		return  ResponseEntity.ok(insuranceService.getCompany());
	}
	
	@GetMapping("/company/{id}")
	ResponseEntity<List<InsuranceCompanyModel>> getCompanyById(@PathVariable(value = "id") final long id){
		return  ResponseEntity.ok(insuranceService.getCompanyById(id));
	}
	
	@PostMapping("/company")
	ResponseEntity<InsuranceCompanyModel> postCompany(@RequestBody final InsuranceCompanyModel insuranceCompany) {
		return  ResponseEntity.ok(insuranceService.addCompany(insuranceCompany));
	}
	
	@PutMapping("/company")
	ResponseEntity<InsuranceCompanyModel> putCompany(@RequestBody final InsuranceCompanyModel insuranceCompany) {
		insuranceService.updateCompany(insuranceCompany);
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/company/{id}")
	ResponseEntity deleteCompany(@PathVariable(value = "id") final long id) {
		insuranceService.deleteCompany(id);
		return ResponseEntity.ok("Delete Successful");
	}
	

	@GetMapping("/policy")
	ResponseEntity<List<InsurancePolicyModel>> getPolicy(){
		return  ResponseEntity.ok(insuranceService.getPolicy());
	}
	
	@PostMapping("/policy")
	ResponseEntity<InsurancePolicyModel> postPolicy(@RequestBody final InsurancePolicyModel insurancePolicy) {
		return  ResponseEntity.ok(insuranceService.addPolicy(insurancePolicy));
	}
		
	@PutMapping("/policy")
	ResponseEntity<InsurancePolicyModel> putPolicy(@RequestBody final InsurancePolicyModel insurancePolicy) {
		return ResponseEntity.ok(insuranceService.updatePolicy(insurancePolicy));
	}
	
	@DeleteMapping("/policy/{id}")
	ResponseEntity deletePolicy(@PathVariable(value = "id") final long id) {
		insuranceService.deletePolicy(id);
		return ResponseEntity.ok("Delete Successful");
	}
	@GetMapping("/policy/{id}")
	ResponseEntity<List<InsurancePolicyModel>> getPolicyById(@PathVariable(value = "id") final long id){
		return  ResponseEntity.ok(insuranceService.getPolicyById(id));
	}

	@GetMapping("/company/default")
	ResponseEntity<InsuranceCompanyModel> postCompanyDefault() {
		InsuranceCompanyModel insuranceCompany = new InsuranceCompanyModel();
		insuranceCompany.setName("test1");
		return  ResponseEntity.ok(insuranceService.addCompany(insuranceCompany));
	}
	
	@GetMapping("/policy/default")
	ResponseEntity postPolicyDefault(){
		InsurancePolicyModel insurancePolicy = new InsurancePolicyModel();
		insurancePolicy.setName("Policy1");
		InsuranceCompany insuranceCompany = new	InsuranceCompany();
		insuranceCompany.setId(1);
		//insurancePolicy.setInsuranceCompany(insuranceCompany);
		insuranceService.addPolicy(insurancePolicy);
		return  ResponseEntity.ok().build();
	}
	
	
}
