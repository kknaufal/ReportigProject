package com.service.ems.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "NOTIFICATION")
public class NotificationModel {
	
	long userId;
	
	@Id
	@Column(name="NOTIFICATION_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	long notificationId;
	
	@Column(name="MESSAGE")
	String message;
	
	@Column(name="READ_STATUS")
	String readStatus;
	
	public NotificationModel() {
		
	}
	
	public NotificationModel(long userId, long notificationId, String message, String readStatus) {
		super();
		this.userId = userId;
		this.notificationId = notificationId;
		this.message = message;
		this.readStatus = readStatus;
	}
	
	public NotificationModel(long userId, String message, String readStatus) {
		super();
		this.userId = userId;
		this.message = message;
		this.readStatus = readStatus;
	}

	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}

	/**
	 * @return the notificationId
	 */
	public long getNotificationId() {
		return notificationId;
	}

	/**
	 * @param notificationId the notificationId to set
	 */
	public void setNotificationId(long notificationId) {
		this.notificationId = notificationId;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the readStatus
	 */
	public String getReadStatus() {
		return readStatus;
	}

	/**
	 * @param readStatus the readStatus to set
	 */
	public void setReadStatus(String readStatus) {
		this.readStatus = readStatus;
	}
		
}
