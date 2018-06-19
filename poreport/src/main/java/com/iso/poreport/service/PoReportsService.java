package com.iso.poreport.service;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iso.poreport.model.ImProjects;
import com.iso.poreport.model.ResourceHours;
import com.iso.poreport.model.ResourceUtilization;
import com.iso.poreport.model.Timesheet;
import com.iso.poreport.model.Users;
import com.iso.poreport.repository.ImProjectsRepository;
import com.iso.poreport.repository.UsersRepository;

@Service
public class PoReportsService {
	
	@Autowired
	private ReportsUtilities finalReport;	

	@Autowired
	private ImProjectsRepository projectRepository;

	@Autowired
	private UsersRepository userRepo;

	@PersistenceContext
	private EntityManager entityManager;

	private List<ImProjects> imProjects;

	private List<Users> users;

	public PoReportsService() {
		super();
	}

	public List<ResourceUtilization> retrieveResourceUtilization(Integer supervisorId, Integer projectId, Long fromtDate, Long toDate)
			throws Exception {

		StoredProcedureQuery storedProcedure = entityManager
				.createStoredProcedureQuery("nest_ins_resource_utilization");

		// Set the parameters of the stored procedure.
		String uidParam = "uid";
		storedProcedure.registerStoredProcedureParameter(uidParam, Integer.class, ParameterMode.IN);
		storedProcedure.setParameter(uidParam, supervisorId);

		String pidParam = "pid";
		storedProcedure.registerStoredProcedureParameter(pidParam, Integer.class, ParameterMode.IN);
		storedProcedure.setParameter(pidParam, projectId);

		// Timestamp secondParamValue = java.sql.Timestamp.valueOf("2018-01-15
		// 00:00:00");
		LocalDate fromDtParamValue = Instant.ofEpochMilli(fromtDate).atZone(ZoneId.systemDefault()).toLocalDate();
		// Timestamp fromDtParamValue = new java.sql.Timestamp(fromtDate);
		// System.out.println("fromDtParamValue : "+ fromDtParamValue);
		storedProcedure.registerStoredProcedureParameter("start_date", LocalDate.class, ParameterMode.IN);
		storedProcedure.setParameter("start_date", fromDtParamValue);

		// Timestamp thirdParamValue = java.sql.Timestamp.valueOf("2018-01-30
		// 00:00:00");
		// Timestamp toDtParamValue = new java.sql.Timestamp(toDate);
		LocalDate toDtParamValue = Instant.ofEpochMilli(toDate).atZone(ZoneId.systemDefault()).toLocalDate();
		// System.out.println("toDtParamValue : "+ toDtParamValue);
		storedProcedure.registerStoredProcedureParameter("end_date", LocalDate.class, ParameterMode.IN);
		storedProcedure.setParameter("end_date", toDtParamValue);

		boolean status = storedProcedure.execute();
		// System.out.println("storedProcedure status : "+ status);
		// Call the stored procedure.
		List<Object[]> storedProcedureResults = storedProcedure.getResultList();

		/**
		 * return storedProcedureResults.stream().map(result -> { return new
		 * ResourceUtilization( (String) result[0], (int) result[1], (BigDecimal)
		 * result[2], (String) result[3] ); } ).collect(Collectors.toList());
		 **/
		/**
		 * return storedProcedureResults.stream().map(result -> { return
		 * getComputedResul(result); }).collect(Collectors.toList());
		 **/
		// RUFinalReport finalReport = new RUFinalReport();
		return finalReport.convertToRUReport(storedProcedureResults, supervisorId, projectId, fromtDate, toDate);

	}

	public List<ImProjects> getParentProjectsByName(String projectName) throws Exception {
		if (imProjects == null) {
			imProjects = projectRepository.findParentProjectsByName();
		}
		List<ImProjects> forAdd= imProjects.stream().filter(p -> p.getProjectName().toLowerCase().contains(projectName.toLowerCase()))
				.collect(Collectors.toList());
		forAdd.add(0, new ImProjects() {{setProjectId(-1); setProjectName("ALL"); }});
		return forAdd;
	}

	public List<Users> getEmployees(String employeeName) throws Exception {
		if (users == null) {
			users = userRepo.findUserByName();
		}
		if (employeeName == null) {
			return users;
		} else {
			return users.stream().filter(usr -> usr.getUsername().toLowerCase().contains(employeeName.toLowerCase()))
					.collect(Collectors.toList());
		}

	}

	public List<Timesheet> getTimesheetReport(Long fromtDate, Long toDate) throws Exception {
		StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("nest_ins_timesheet_report");

		LocalDate fromDtParamValue = Instant.ofEpochMilli(fromtDate).atZone(ZoneId.systemDefault()).toLocalDate();
		storedProcedure.registerStoredProcedureParameter("start_date", LocalDate.class, ParameterMode.IN);
		storedProcedure.setParameter("start_date", fromDtParamValue);

		LocalDate toDtParamValue = Instant.ofEpochMilli(toDate).atZone(ZoneId.systemDefault()).toLocalDate();
		storedProcedure.registerStoredProcedureParameter("end_date", LocalDate.class, ParameterMode.IN);
		storedProcedure.setParameter("end_date", toDtParamValue);

		boolean status = storedProcedure.execute();
		List<Object[]> storedProcedureResults = storedProcedure.getResultList();
		String dateRange = convertToDateRangeString(fromtDate, toDate);
		return storedProcedureResults.stream().map(result -> new Timesheet() {
			{
				setUserName((String) result[0]);
				setClient((String) result[1]);
				String descri = result[2] == null ? " ": (String)result[2];
				setDescription((String) result[1] + " " + descri);
				setTfs((String) result[3]);
				setEmployeeId((Integer) result[4]);
				setEffort((BigDecimal) result[5]);
				setDateRange(dateRange);
			}
		}

		).collect(Collectors.toList());
	}

	private String convertToDateRangeString(Long fromDt, Long toDt) {
		DateFormat format = new SimpleDateFormat("dd-MMM-YY");
		return format.format(new Date(fromDt)) + " - " + format.format(new Date(toDt));
	}

	public List<ResourceHours> retrieveResourceHours(Integer leadId, Integer projectId, Long fromDate, Long toDate) {
		
		StoredProcedureQuery storedProcedure = entityManager
				.createStoredProcedureQuery("nest_ins_resource_hours_report");

		// Set the parameters of the stored procedure.
		String uidParam = "uid";
		storedProcedure.registerStoredProcedureParameter(uidParam, Integer.class, ParameterMode.IN);
		storedProcedure.setParameter(uidParam, leadId);

		String pidParam = "pid";
		storedProcedure.registerStoredProcedureParameter(pidParam, Integer.class, ParameterMode.IN);
		storedProcedure.setParameter(pidParam, projectId);

		LocalDate fromDtParamValue = Instant.ofEpochMilli(fromDate).atZone(ZoneId.systemDefault()).toLocalDate();
		storedProcedure.registerStoredProcedureParameter("start_date", LocalDate.class, ParameterMode.IN);
		storedProcedure.setParameter("start_date", fromDtParamValue);

		LocalDate toDtParamValue = Instant.ofEpochMilli(toDate).atZone(ZoneId.systemDefault()).toLocalDate();
		storedProcedure.registerStoredProcedureParameter("end_date", LocalDate.class, ParameterMode.IN);
		storedProcedure.setParameter("end_date", toDtParamValue);
		
		boolean status = storedProcedure.execute();
		List<Object[]> storedProcedureResults = storedProcedure.getResultList();
		List<ResourceHours> resourceHours  =storedProcedureResults.stream()
				.map(hrs -> new ResourceHours() {
					{
						setUserName((String) hrs[0]);
						setTotalHours((BigDecimal) hrs[1]);
						setUserId((Integer) hrs[2] );
					}
				}).collect(Collectors.toList());
		if(projectId!=0) {
			finalReport.taskNotEnteredResourceHourseByProject(projectId, resourceHours, toDate);
		}else {
			finalReport.taskNotEnteredResourceHourseBySupervisor(leadId, resourceHours, toDate);
		}
		finalReport.addAbsentTaskHours(resourceHours, fromDate, toDate);
		return resourceHours;
	}

}
