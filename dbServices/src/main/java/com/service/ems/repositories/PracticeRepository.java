package com.service.ems.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.ems.domain.Practice;

@Repository("PracticeRepository")
public interface PracticeRepository extends JpaRepository<Practice,Long> {

	List<Practice> findAllById(long id);

}
