package com.service.ems.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SYSTEM_SETTINGS")
public class SystemSettingsModel {
	
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="PARAMETER_NAME")
	private String parameterName;
	
	@Column(name="PARAMETER_VALUE")
	private String parameterValue;
	
	/**
	 * 
	 */
	public SystemSettingsModel() {
		super();
	}
	/**
	 * @param parameterName
	 * @param parameterValue
	 */
	public SystemSettingsModel(long id, String parameterName, String parameterValue) {
		super();
		this.id = id;
		this.parameterName = parameterName;
		this.parameterValue = parameterValue;
	}
	/**
	 * @return the parameterName
	 */
	public String getParameterName() {
		return parameterName;
	}
	/**
	 * @param parameterName the parameterName to set
	 */
	public void setParameterName(String parameterName) {
		this.parameterName = parameterName;
	}
	/**
	 * @return the parameterValue
	 */
	public String getParameterValue() {
		return parameterValue;
	}
	/**
	 * @param parameterValue the parameterValue to set
	 */
	public void setParameterValue(String parameterValue) {
		this.parameterValue = parameterValue;
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}	
}
