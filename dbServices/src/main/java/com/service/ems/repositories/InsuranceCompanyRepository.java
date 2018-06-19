package com.service.ems.repositories;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.ems.domain.InsuranceCompany;

@Repository("InsuranceCompany")
public interface InsuranceCompanyRepository extends JpaRepository<InsuranceCompany,Long> {

	Collection<InsuranceCompany> findAllById(long id);
}
