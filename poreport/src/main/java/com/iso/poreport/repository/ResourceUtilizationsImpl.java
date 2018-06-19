package com.iso.poreport.repository;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.stereotype.Service;

import com.iso.poreport.model.ResourceUtilization;

@Service
public class ResourceUtilizationsImpl implements ResourceUtilizationsRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ResourceUtilization> retrieveResourceUtilizations() {
		StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("public.resource_utilization");
		   
		   // Set the parameters of the stored procedure.
		   String firstParam = "uid";		   
		   storedProcedure.registerStoredProcedureParameter(firstParam, Integer.class, ParameterMode.IN);
		   storedProcedure.setParameter(firstParam, 66673);
		   
		   Timestamp secondParamValue = java.sql.Timestamp.valueOf("01/15/2018");
		   storedProcedure.registerStoredProcedureParameter("start_date", Timestamp.class, ParameterMode.IN);
		   storedProcedure.setParameter("start_date", secondParamValue);
		   
		   Timestamp thirdParamValue = java.sql.Timestamp.valueOf("01/30/2018");
		   storedProcedure.registerStoredProcedureParameter("end_date", Timestamp.class, ParameterMode.IN);
		   storedProcedure.setParameter("end_date", thirdParamValue);
		   
	 
		   // Call the stored procedure. 
		   List<Object[]> storedProcedureResults = storedProcedure.getResultList();
	 
		   // Use Java 8's cool new functional programming paradigm to map the objects from the stored procedure results
		   /**return storedProcedureResults.stream().map(result -> new ResourceUtilization(
		         (String) result[0],
		         (int) result[1],
		         (BigDecimal) result[2],
		         (String) result[3]
		   )).collect(Collectors.toList());**/
		   return null;
	}

}
