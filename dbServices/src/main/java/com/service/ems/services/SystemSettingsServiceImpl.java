package com.service.ems.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ems.models.SystemSettingsModel;
import com.service.ems.repositories.SystemSettingsRepository;

@Service
public class SystemSettingsServiceImpl implements SystemSettingsService {
	
	@Autowired
	SystemSettingsRepository systemSettingsRepository;
	
	public static final Logger logger = LoggerFactory.getLogger(SystemSettingsServiceImpl.class);

	@Override
	public SystemSettingsModel saveSystemSettings(SystemSettingsModel systemSettingsModel) {
		
		SystemSettingsModel savedSystemSettings;
		savedSystemSettings = systemSettingsRepository.save(systemSettingsModel);
		return savedSystemSettings;
		
	}
	
	@Override
	public SystemSettingsModel updateSystemSettings(SystemSettingsModel systemSettingsModel) {
		
		SystemSettingsModel updatedSystemSettings = null;
		updatedSystemSettings = systemSettingsRepository.save(systemSettingsModel);
		return updatedSystemSettings;
		
	}

	@Override
	public SystemSettingsModel getSystemSettings(long settingId) {
		
		SystemSettingsModel systemSettingsModel = null;
		systemSettingsModel = systemSettingsRepository.findOne(settingId);
		return systemSettingsModel;
	}

}
