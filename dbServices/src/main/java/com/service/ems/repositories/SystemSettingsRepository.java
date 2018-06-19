package com.service.ems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ems.models.SystemSettingsModel;

public interface SystemSettingsRepository extends JpaRepository<SystemSettingsModel, Long>{

}
