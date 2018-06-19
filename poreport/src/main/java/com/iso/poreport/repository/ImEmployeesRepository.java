package com.iso.poreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iso.poreport.model.ImEmployees;
import com.iso.poreport.model.ImProjects;

@Repository
public interface ImEmployeesRepository extends JpaRepository<ImEmployees, Integer> {
	@Query(nativeQuery = true)
	List<ImEmployees> findEmployeesByName();
	
	@Query(nativeQuery = true)
	List<ImEmployees> findEmployeesBySupervisor(@Param("supervisorId") Integer supervisorId);
}
