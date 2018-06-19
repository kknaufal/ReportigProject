package com.service.ems.services;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ems.domain.DoctorScheduleModel;
import com.service.ems.models.DoctorScheduleDate;
import com.service.ems.models.DoctorScheduleRequestModel;
import com.service.ems.models.DoctorScheduleResponseModel;
import com.service.ems.repositories.DoctorScheduleRepository;

@Service
public class DoctorScheduleServiceImpl implements DoctorScheduleService {
	
	@Autowired
	DoctorScheduleRepository doctorScheduleRepository;
		
	/**
	 * Method to get the doctor schedule from the repository based on request body send along with the request
	 * @param doctorScheduleRequest
	 * @return {@link DoctorScheduleResponseModel}
	 */
	@Override
	public DoctorScheduleResponseModel getDoctorSchedule(DoctorScheduleRequestModel doctorScheduleRequest) {
	
		
			
		DoctorScheduleResponseModel doctorScheduleResponseModel = null;
		
		List<DoctorScheduleModel> doctorScheduleModelList = null;	
		
		long doctorId = doctorScheduleRequest.getDoctorId();	
		Date startDate = doctorScheduleRequest.getStartDate();
		Date endDate =  doctorScheduleRequest.getEndDate();
		int daysListSize = doctorScheduleRequest.getDays().size();
		
		//Getting the Doctor schedule based on 'DoctorId, StartDate, EndDate, and List of Days if they given along with the request'//
		if(startDate != endDate && daysListSize == 0) {
			
			doctorScheduleModelList = doctorScheduleRepository.findByDoctorIdAndDateBetween(doctorId, startDate, endDate);
		}
		else {	
			
			List<String> days = doctorScheduleRequest.getDays();
			doctorScheduleModelList = doctorScheduleRepository.findByDoctorIdAndDateBetweenForDAYs(doctorId, startDate, endDate, days);
		}
		
		if(doctorScheduleModelList != null) {
			
			//Getting the doctor schedule from the list of doctor schedules//
			doctorScheduleResponseModel = getDoctorSchedule(doctorScheduleModelList, doctorId);			
		}
		
		return doctorScheduleResponseModel;
	}

	/**
	 * Method to generate the doctor schedule from the list of doctor schedules 
	 * @param doctorScheduleModelList
	 * @param doctorId
	 * @return {@link DoctorScheduleResponseModel}
	 */
	private DoctorScheduleResponseModel getDoctorSchedule(List<DoctorScheduleModel> doctorScheduleModelList, long doctorId) {
		
		DoctorScheduleResponseModel doctorScheduleResponseModel = null;
		DoctorScheduleDate doctorScheduleDate = null;
		doctorScheduleResponseModel= new DoctorScheduleResponseModel();
		doctorScheduleResponseModel.setDoctorId(doctorId);
					
		//Getting the doctor schedule slots grouped by date into a map in which 'date' as the key// 
		Map<Date, List<DoctorScheduleModel>> doctorSchedulesGroup = doctorScheduleModelList.stream()
																	  	  .collect(Collectors.groupingBy(DoctorScheduleModel::getDate));
								
		for(Map.Entry<Date, List<DoctorScheduleModel>> entry : doctorSchedulesGroup.entrySet()) {
			
			doctorScheduleDate = new DoctorScheduleDate();
			doctorScheduleDate.setDate(entry.getKey());						
			doctorScheduleDate.setSlots(entry.getValue().stream()
												.map(DoctorScheduleModel::getStartTime)
												.collect(Collectors.toSet()));	
			doctorScheduleResponseModel.addDoctorScheduleDate(doctorScheduleDate);
		}
		return doctorScheduleResponseModel;
	}

}
