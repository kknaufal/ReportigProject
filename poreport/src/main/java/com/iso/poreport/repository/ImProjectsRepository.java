package com.iso.poreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iso.poreport.model.ImProjects;

@Repository
public interface ImProjectsRepository extends JpaRepository<ImProjects, Integer> {
	@Query(nativeQuery = true)
	List<ImProjects> findParentProjectsByName();
}
