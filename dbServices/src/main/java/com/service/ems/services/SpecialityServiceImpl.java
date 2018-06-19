package com.service.ems.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ems.domain.Speciality;
import com.service.ems.modelMappers.ModelMapperUtil;
import com.service.ems.models.SpecialityModel;
import com.service.ems.repositories.SpecialityRepository;

@Service
@Transactional
public class SpecialityServiceImpl implements SpecialityService {

	@Autowired
	SpecialityRepository specialityRepository;
	
	@Override
	public List<SpecialityModel> getAllSpeciality() {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		List<SpecialityModel> specialityModels;
		specialityModels = specialityRepository.findAll().stream().map(speciality -> {
			return modelMapper.map(speciality, SpecialityModel.class);
		}).collect(Collectors.toList());
		return specialityModels;
	}

	@Override
	public List<SpecialityModel> getSpecialityById(long id) {

		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		List<SpecialityModel> specialityModels;
		specialityModels = specialityRepository.findAllById(id).stream().map(speciality -> {
			return modelMapper.map(speciality, SpecialityModel.class);
		}).collect(Collectors.toList());
		return specialityModels;
	}

	@Override
	public SpecialityModel addSpeciality(SpecialityModel specialitymodel) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		Speciality speciality = modelMapper.map(specialitymodel, Speciality.class);
		SpecialityModel specialityModel = modelMapper.map(specialityRepository.saveAndFlush(speciality), SpecialityModel.class);
		return specialityModel;
	}

	@Override
	public SpecialityModel updateSpeciality(SpecialityModel specialitymodel) {
		ModelMapper modelMapper = ModelMapperUtil.getGenericMapper();
		Speciality speciality = modelMapper.map(specialitymodel, Speciality.class);
		SpecialityModel specialityModel = modelMapper.map(specialityRepository.saveAndFlush(speciality), SpecialityModel.class);
		return specialityModel;
	}

	@Override
	public void deleteSpeciality(long id) {
		specialityRepository.delete(id);
		
	}

}
