package com.iso.poreport.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="im_user_absences")
@NamedNativeQuery(name="ImUserAbsences.findUserAbsencesByDateRange", query="select * from im_user_absences where owner_id in "
		+ "(select employee_id from im_employees where department_id=62540) "
		+ "and start_date >= :fromDate and end_date <= :toDate ", resultClass=ImUserAbsences.class)
public class ImUserAbsences {

	@Id
	@GeneratedValue
	@Column(name="absence_id")
	private Integer absenceId;
	@Column(name="owner_id")
    private Integer ownerId;
	@Column(name="start_date")
    private Date startDate;
	@Column(name="end_date")
    private Date endDate;
	@Column(name="description")
    private String description= " ";
	@Column(name="contact_info")
    private String contactInfo;
	@Column(name="receive_email_p")
    private String receiveEmailP;
	@Column(name="last_modified")
    private Date lastModified;
	@Column(name="absence_type_id")
    private Integer absenceTypeId;
	@Column(name="absence_status_id")
    private Integer absenceStatusId;
	@Column(name="absence_name")
    private String absenceName;
	@Column(name="duration_days")
    private long durationDays = 0;
	@Column(name="group_id")
    private Integer groupId;
	@Column(name="vacation_replacement_id")
    private Integer vacationReplacementId;
	
	@Transient
	private long durationHours = 0;
    
    public long getDurationHours() {
		return durationDays * 8;
	}

	public void setDurationHours(long durationHours) {
		this.durationHours = durationHours;
	}

	public ImUserAbsences() {
		super();
	}
	
	public ImUserAbsences(Integer absenceId, Integer ownerId, Date startDate, Date endDate, String description,
			String contactInfo, String receiveEmailP, Date lastModified, Integer absenceTypeId, Integer absenceStatusId,
			String absenceName, long durationDays, Integer groupId, Integer vacationReplacementId) {
		super();
		this.absenceId = absenceId;
		this.ownerId = ownerId;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
		this.contactInfo = contactInfo;
		this.receiveEmailP = receiveEmailP;
		this.lastModified = lastModified;
		this.absenceTypeId = absenceTypeId;
		this.absenceStatusId = absenceStatusId;
		this.absenceName = absenceName;
		this.durationDays = durationDays;
		this.groupId = groupId;
		this.vacationReplacementId = vacationReplacementId;
	}

	public Integer getAbsenceId() {
		return absenceId;
	}
	public void setAbsenceId(Integer absenceId) {
		this.absenceId = absenceId;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	
	public String getReceiveEmailP() {
		return receiveEmailP;
	}
	public void setReceiveEmailP(String receiveEmailP) {
		this.receiveEmailP = receiveEmailP;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getContactInfo() {
		return contactInfo;
	}
	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}	
	public Date getLastModified() {
		return lastModified;
	}
	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}
	public Integer getAbsenceTypeId() {
		return absenceTypeId;
	}
	public void setAbsenceTypeId(Integer absenceTypeId) {
		this.absenceTypeId = absenceTypeId;
	}
	public Integer getAbsenceStatusId() {
		return absenceStatusId;
	}
	public void setAbsenceStatusId(Integer absenceStatusId) {
		this.absenceStatusId = absenceStatusId;
	}
	public String getAbsenceName() {
		return absenceName;
	}
	public void setAbsenceName(String absenceName) {
		this.absenceName = absenceName;
	}
	
	public long getDurationDays() {
		return durationDays;
	}

	public void setDurationDays(long durationDays) {
		this.durationDays = durationDays;
	}

	public Integer getGroupId() {
		return groupId;
	}
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}
	public Integer getVacationReplacementId() {
		return vacationReplacementId;
	}
	public void setVacationReplacementId(Integer vacationReplacementId) {
		this.vacationReplacementId = vacationReplacementId;
	}

	@Override
	public String toString() {
		return "ImUserAbsences [absenceId=" + absenceId + ", ownerId=" + ownerId + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", description=" + description + ", contactInfo=" + contactInfo
				+ ", receiveEmailP=" + receiveEmailP + ", lastModified=" + lastModified + ", absenceTypeId="
				+ absenceTypeId + ", absenceStatusId=" + absenceStatusId + ", absenceName=" + absenceName
				+ ", durationDays=" + durationDays + ", groupId=" + groupId + ", vacationReplacementId="
				+ vacationReplacementId + "]";
	}
    
    
}
