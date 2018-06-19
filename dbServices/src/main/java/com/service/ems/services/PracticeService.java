package com.service.ems.services;

import java.util.List;

import com.service.ems.domain.Practice;
import com.service.ems.models.AppointmentSearchModel;
import com.service.ems.models.PracticeModel;

public interface PracticeService {

	List<PracticeModel> getAllPractice();

	List<PracticeModel> getPracticeById(long id);

	PracticeModel addPractice(PracticeModel practice);

	PracticeModel updatePractice(PracticeModel practice);

	void deletePractice(long id);

	List<Practice> getSearchAppointment(AppointmentSearchModel appointmentSearchModel);

	
}
