package com.service.ems.services;



import com.service.ems.models.NotificationModel;

public interface NotificationService {

	NotificationModel getNotification(long userId, long notificationId);

	NotificationModel addNotification(NotificationModel notificationModel);

	void updateReadStatus(NotificationModel notificationModel);

}
