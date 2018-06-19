package com.service.ems.services;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.ems.models.NotificationModel;
import com.service.ems.repositories.NotificationRepository;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	@Autowired
	NotificationRepository notificationRepository;
		
	public static final Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);

	@Override
	public NotificationModel getNotification(long userId, long notificationId) {
		
		NotificationModel notificationModel = null;
		
		notificationModel = notificationRepository.findByUserIdAndNotificationId(userId, notificationId);

		if(notificationModel != null) {
			notificationModel.setReadStatus("true");
			notificationRepository.save(notificationModel);					
		}		
		return notificationModel;
	}

	@Override
	public NotificationModel addNotification(NotificationModel notificationModel) {
				
		NotificationModel savedNotification = notificationRepository.save(notificationModel);
		return savedNotification;
	}

	@Override
	public void updateReadStatus(NotificationModel notificationModel) {
		
		 notificationRepository.save(notificationModel);
	}

}
