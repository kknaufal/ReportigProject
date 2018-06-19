package com.service.ems.services;


import com.service.ems.models.SystemSettingsModel;

public interface SystemSettingsService {

	SystemSettingsModel saveSystemSettings(SystemSettingsModel systemSettingsModel);

	SystemSettingsModel getSystemSettings(long settingId);

	SystemSettingsModel updateSystemSettings(SystemSettingsModel systemSettingsModel);

}
