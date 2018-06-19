package com.service.ems.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
@Table(name = "insurance_company")
public class InsuranceCompany{


	private long id;
	
	private String name;
	
	private Set<InsurancePolicy> insurancePolicy;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@OneToMany(mappedBy = "insuranceCompany", fetch = FetchType.LAZY)
	@Cascade({CascadeType.SAVE_UPDATE})
	@Column(nullable = true)
	public Set<InsurancePolicy> getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(Set<InsurancePolicy> insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}


}
