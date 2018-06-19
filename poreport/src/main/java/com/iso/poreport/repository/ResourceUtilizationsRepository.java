package com.iso.poreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;

import com.iso.poreport.model.ResourceUtilization;

public interface ResourceUtilizationsRepository// extends CrudRepository<ResourceUtilization, Long> 
{
	//@Procedure
	public List<ResourceUtilization> retrieveResourceUtilizations();
}
