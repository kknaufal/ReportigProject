package com.iso.poreport.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iso.poreport.model.ImUserAbsences;

@Repository
public interface ImUserAbsencesRepository  extends JpaRepository<ImUserAbsences, Integer>{	
	@Query(nativeQuery = true)
	List<ImUserAbsences> findUserAbsencesByDateRange(@Param("fromDate") Timestamp fromDate,
			@Param("toDate") Timestamp toDate);
}
