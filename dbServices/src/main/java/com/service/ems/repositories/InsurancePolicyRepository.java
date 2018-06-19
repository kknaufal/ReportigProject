package com.service.ems.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.ems.domain.InsurancePolicy;
import com.service.ems.models.InsurancePolicyModel;

@Repository("InsurancePolicy")
public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy,Long> {

	Collection<InsurancePolicy> findAllById(long id);
	
}
