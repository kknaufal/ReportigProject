package com.service.ems.services;

import java.util.List;

import com.service.ems.models.SpecialityModel;

public interface SpecialityService {

	List<SpecialityModel> getAllSpeciality();

	List<SpecialityModel> getSpecialityById(long id);

	SpecialityModel addSpeciality(SpecialityModel practice);

	SpecialityModel updateSpeciality(SpecialityModel practice);

	void deleteSpeciality(long id);

}
