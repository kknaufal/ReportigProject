package com.service.ems.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.service.ems.models.NotificationModel;

public interface NotificationRepository extends JpaRepository<NotificationModel, Long> {
	
	
	NotificationModel findByUserIdAndNotificationId(long userId, long notificationId);
	
//	@Query("select message from Notifications where userId = :userId and notificationId= :notificationId")
//	NotificationModel getNotification(long userId, long notificationId);

}
