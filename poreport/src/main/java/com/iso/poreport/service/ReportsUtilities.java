package com.iso.poreport.service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iso.poreport.model.AcsRels;
import com.iso.poreport.model.ImUserAbsences;
import com.iso.poreport.model.ResourceHours;
import com.iso.poreport.model.ResourceUtilization;
import com.iso.poreport.model.Users;
import com.iso.poreport.repository.ImAcsRelsRepository;
import com.iso.poreport.repository.ImUserAbsencesRepository;
import com.iso.poreport.repository.UsersRepository;

@Component
public class ReportsUtilities {
	@Autowired
	private ImUserAbsencesRepository absencesRepository;
	@Autowired
	private ImAcsRelsRepository imAcsRelsRepository;
	@Autowired
	private UsersRepository usersRepository;
	

	@PersistenceContext
	private EntityManager entityManager;

	ImUserAbsences lastObjAbsences = new ImUserAbsences();

	public List<ResourceUtilization> convertToRUReport(List<Object[]> resultSets, Integer supervisorId, Integer projectId, Long fromtDate,
			Long toDate) throws Exception {

		final List<ResourceUtilization> resourceUtilizations = resultSets.stream()
				.map(result -> new ResourceUtilization() {
					{
						setUsername((String) result[0]);
						setSum((BigDecimal) result[1]);
						setProject((String) result[2]);
						setSbu((String) result[3]);
						setSystem((String) result[4]);
						setuId((int) result[6]);
						setMonth(new SimpleDateFormat("MMMM").format(new Date(toDate)));
						setWeekEndingDate(new SimpleDateFormat("dd-MMM-YY").format(new Date(toDate)));
					}
				}).collect(Collectors.toList());

		List<ImUserAbsences> absences = absencesRepository
				.findUserAbsencesByDateRange(new java.sql.Timestamp(fromtDate), new java.sql.Timestamp(toDate));
		Map<Integer, List<ImUserAbsences>> absencesGroup = absences.stream()
				.collect(Collectors.groupingBy(ImUserAbsences::getOwnerId));
		for (Map.Entry<Integer, List<ImUserAbsences>> absenceItem : absencesGroup.entrySet()) {
			List<ResourceUtilization> localRur = resourceUtilizations.stream()
					.filter(res -> res.getuId().equals(absenceItem.getKey())).collect(Collectors.toList());
			if (localRur.size() > 0) {
				Long totalAbsent = absenceItem.getValue().stream()
						.collect(Collectors.summingLong(ImUserAbsences::getDurationHours));
				String comment = absenceItem.getValue().stream()
						.filter(ab -> ab.getDescription() !=null)
						.map(absent -> absent.getDescription())
						.collect(Collectors.joining("-"));
				localRur.get(0).setAbsencesCount(totalAbsent);
				localRur.get(0).setAbsencesComment(comment);
			}
		}
		if (projectId != 0) {
			taskNotEnteredUsersByproject(projectId, resourceUtilizations, toDate);
		}else {
			taskNotEnteredUsersBySupervisor(supervisorId, resourceUtilizations, toDate);
		}

		return resourceUtilizations;
	}

	private void taskNotEnteredUsersBySupervisor(Integer supervisorId, List<ResourceUtilization> resourceUtilizations,
			Long toDate) {
		List<Users> employees = usersRepository.findUsersBySupervisor(supervisorId);
		Map<Integer, List<Integer>> groupedRURUid = resourceUtilizations.stream().map(RURUid -> RURUid.getuId())
				.collect(Collectors.groupingBy(Function.identity()));
		List<Users> notPresentEmp = employees.stream()
				.filter(emp -> (groupedRURUid.entrySet().stream()
						.filter(res -> res.getKey().equals(emp.getUserId())).count()) < 1)
				.collect(Collectors.toList());
		notPresentEmp.forEach(rel -> {
			resourceUtilizations.add(new ResourceUtilization() {
				{
					setUsername(rel.getUsername());
					setuId(rel.getUserId());
					//setProject(rel.getImProjects().getProjectName());
					setMonth(new SimpleDateFormat("MMMM").format(new Date(toDate)));
					setWeekEndingDate(new SimpleDateFormat("dd-MMM-YY").format(new Date(toDate)));
				}
			});
		});
	}

	private void taskNotEnteredUsersByproject(Integer projectId, final List<ResourceUtilization> resourceUtilizations,
			Long toDate) {
		
		List<AcsRels> usrsInProject = usersInProject(projectId);
		Map<Integer, List<Integer>> groupedRURUid = resourceUtilizations.stream().map(RURUid -> RURUid.getuId())
				.collect(Collectors.groupingBy(Function.identity()));
		List<AcsRels> notPresentEmp = usrsInProject.stream()
				.filter(emp -> (groupedRURUid.entrySet().stream()
						.filter(res -> res.getKey().equals(emp.getObjectIdTwo())).count()) < 1)
				.collect(Collectors.toList());
		notPresentEmp.forEach(rel -> {
			resourceUtilizations.add(new ResourceUtilization() {
				{
					setUsername(rel.getUsers().getUsername());
					setuId(rel.getObjectIdTwo());
					setProject(rel.getImProjects().getProjectName());
					setMonth(new SimpleDateFormat("MMMM").format(new Date(toDate)));
					setWeekEndingDate(new SimpleDateFormat("dd-MMM-YY").format(new Date(toDate)));
				}
			});
		});

	}

	protected void taskNotEnteredResourceHourseByProject(Integer projectId, final List<ResourceHours> resourceHours,
			Long toDate) {
		Map<Integer, List<Integer>> groupedRHRUid = resourceHours.stream().map(RHRUid -> RHRUid.getUserId())
				.collect(Collectors.groupingBy(Function.identity()));
		usersInProject(projectId).stream().filter(emp -> (groupedRHRUid.entrySet().stream()
				.filter(res -> res.getKey().equals(emp.getObjectIdTwo())).count()) < 1).forEach(rel -> {
					resourceHours.add(new ResourceHours() {
						{
							setUserId(rel.getUsers().getUserId());
							setUserName(rel.getUsers().getUsername());
							setTotalHours(new BigDecimal(0));
						}
					});
				});
	}
	
	protected void taskNotEnteredResourceHourseBySupervisor(Integer supervisorId, final List<ResourceHours> resourceHours,
			Long toDate) {
		List<Users> employees = usersRepository.findUsersBySupervisor(supervisorId);
		Map<Integer, List<Integer>> groupedRHRUid = resourceHours.stream().map(RHRUid -> RHRUid.getUserId())
				.collect(Collectors.groupingBy(Function.identity()));
		employees.stream().filter(emp -> (groupedRHRUid.entrySet().stream()
				.filter(res -> res.getKey().equals(emp.getUserId())).count()) < 1).forEach(rel -> {
					resourceHours.add(new ResourceHours() {
						{
							setUserId(rel.getUserId());
							setUserName(rel.getUsername());
							setTotalHours(new BigDecimal(0));
						}
					});
				});
	}

	protected List<AcsRels> usersInProject(Integer projectId) {
		List<AcsRels> usrsInProjectObj = imAcsRelsRepository.findEmployeesFromProject(projectId);
		return usrsInProjectObj;
	}

	public void addAbsentTaskHours(final List<ResourceHours> resourceHours, Long fromDate, Long toDate) {
		List<ImUserAbsences> absences = absencesRepository
				.findUserAbsencesByDateRange(new java.sql.Timestamp(fromDate), new java.sql.Timestamp(toDate));
		Map<Integer, List<ImUserAbsences>> absencesGroup = absences.stream()
				.collect(Collectors.groupingBy(ImUserAbsences::getOwnerId));
		absencesGroup.entrySet().forEach(absenceItem->{
			List<ResourceHours> localRhr = resourceHours.stream()
					.filter(rHours-> rHours.getUserId().equals(absenceItem.getKey()))
					.collect(Collectors.toList());
			if (localRhr.size() > 0) {		
				Long totalAbsent = absenceItem.getValue().stream()
						.collect(Collectors.summingLong(ImUserAbsences::getDurationHours));
				BigDecimal contCatinateAbsent = localRhr.get(0).getTotalHours().add(new BigDecimal(totalAbsent));
				localRhr.get(0).setTotalHours(contCatinateAbsent);
			}
			
		});
	}

}
