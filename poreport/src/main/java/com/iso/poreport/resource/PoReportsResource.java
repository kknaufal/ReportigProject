package com.iso.poreport.resource;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.iso.poreport.model.ImProjects;
import com.iso.poreport.model.ResourceHours;
import com.iso.poreport.model.ResourceUtilization;
import com.iso.poreport.model.Timesheet;
import com.iso.poreport.model.Users;
import com.iso.poreport.service.PoReportsService;

@RestController
public class PoReportsResource {
	
	@Autowired
	private PoReportsService poReportsService; 
	
	/**@GetMapping("/Resouces")
	public List<ResourceUtilization> getResourceReports(){
		return poReportsService.retrieveResourceUtilization();
	}
	 * @throws Exception **/
	
	@GetMapping(value = {"/Resources/{id}/{projectId}/{fromDate}", "/Resources/{id}/{projectId}/{fromDate}/{toDate}"})
	//@RequestMapping(value = {"/Resouces", "/Resouces/{id}"})
	//@GetMapping("/Resouces/{id}/{fromDate}/{toDate}")
	public List<ResourceUtilization> getResourceReports(@PathVariable Integer id, @PathVariable Integer projectId,
			@PathVariable(name="fromDate", required=true) Long fromDate,
			@PathVariable(name="toDate", required=true) Long toDate) throws Exception{
		return poReportsService.retrieveResourceUtilization(id, projectId , fromDate, toDate);
	}
	
	@GetMapping(value= {"/Projects/{projectName}"})
	public List<ImProjects> getParentProjecsByName(@PathVariable String projectName) throws Exception{
		return poReportsService.getParentProjectsByName(projectName);
	}
	
	@GetMapping(value = {"/Employees", "/Employees/{employeeName}"})
	public List<Users> getEmployeeByName(@PathVariable(name="employeeName", required=false) String employeeName) throws Exception{
		return poReportsService.getEmployees(employeeName);
	}
	
	@GetMapping(value = {"/Timesheets/{fromDate}/{toDate}"})
	public List<Timesheet> getTimesheetReports(@PathVariable(name="fromDate", required=true) Long fromDate,
			@PathVariable(name="toDate", required=true) Long toDate) throws Exception{
		return poReportsService.getTimesheetReport(fromDate, toDate);
	}
	
	@GetMapping(value="/user")
	public Principal user(Principal user) {
		return user;
	}
	
	@GetMapping(value = {"/ResourcesHours/{leadId}/{projectId}/{fromDate}/{toDate}"})
	public List<ResourceHours> getResourceHoursReports(@PathVariable Integer leadId, @PathVariable Integer projectId,
			@PathVariable(name="fromDate", required=true) Long fromDate,
			@PathVariable(name="toDate", required=true) Long toDate) throws Exception{
		return poReportsService.retrieveResourceHours(leadId, projectId , fromDate, toDate);
	}
}
