package com.service.ems.services;

import com.service.ems.models.DoctorScheduleRequestModel;
import com.service.ems.models.DoctorScheduleResponseModel;

public interface DoctorScheduleService {

	DoctorScheduleResponseModel getDoctorSchedule(DoctorScheduleRequestModel doctorScheduleRequest);

}
