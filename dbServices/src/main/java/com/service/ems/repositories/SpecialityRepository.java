package com.service.ems.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.ems.domain.Speciality;

@Repository("SpecialityRepository")
public interface SpecialityRepository extends JpaRepository<Speciality,Long> {
	
	List<Speciality> findAllById(long id);
}
