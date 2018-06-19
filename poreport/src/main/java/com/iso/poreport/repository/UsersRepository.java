package com.iso.poreport.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iso.poreport.model.ImEmployees;
import com.iso.poreport.model.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	@Query/*(nativeQuery = true)*/
	List<Users> findUserByName();
	
	@Query/*(nativeQuery = true)*/
	List<Users> findUsersBySupervisor(@Param("supervisorId") Integer supervisorId);
}
