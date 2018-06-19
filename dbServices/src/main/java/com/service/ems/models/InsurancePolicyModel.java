package com.service.ems.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.service.ems.domain.InsuranceCompany;

public class InsurancePolicyModel {

	private long id;
	private String name;
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
}
