package com.service.ems.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.service.ems.domain.DoctorScheduleModel;


public interface DoctorScheduleRepository extends JpaRepository<DoctorScheduleModel, Long> { 

	List<DoctorScheduleModel> findByDoctorIdAndDateBetween (long doctorId, Date startDate, Date endDate);
		
	@Query(value="select * from DOCTOR_SCHEDULE ds where ds.doctor_id = :id AND  ds.date between :startDate and :endDate and DAYNAME(ds.date) in (:days)",nativeQuery = true)
	List<DoctorScheduleModel> findByDoctorIdAndDateBetweenForDAYs
	(@Param("id")long doctorId, @Param("startDate")Date startDate, @Param("endDate")Date endDate, @Param("days")List<String> days);

}
