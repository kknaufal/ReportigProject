package com.iso.poreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iso.poreport.model.AcsRels;

@Repository
public interface ImAcsRelsRepository extends JpaRepository<AcsRels, Integer> {
	@Query/*(nativeQuery=true)*/
	List<AcsRels> findEmployeesFromProject(@Param("projectId") Integer projectId);
}
