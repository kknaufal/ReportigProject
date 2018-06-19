package com.service.ems.modelMappers;

import org.modelmapper.ModelMapper;

public class ModelMapperUtil {

	private static ModelMapper modelMapper = new ModelMapper();

	public static ModelMapper getGenericMapper() {
		return modelMapper;
	}

}
