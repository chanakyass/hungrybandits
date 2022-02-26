package com.hungrybandits.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationsService {

    private final NotificationRepository notificationRepository;

    @Autowired
    public NotificationsService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void saveNotificationToDB(NotificationRequest notificationRequest) {
        Notification notification = Notification.builder()
                .notificationAlertText(notificationRequest.getNotificationAlertText())
                .customerId(notificationRequest.getCustomerId())
                .notificationTime(LocalDateTime.now())
                .build();
        notificationRepository.save(notification);
    }

    public NotificationResponse getNotificationFromDB(Integer customerId) {
        Notification notification = notificationRepository.findByCustomerId(customerId)
                                                            .orElseThrow(() -> new IllegalStateException("Unable to fetch"));
        return NotificationResponse.builder()
                .id(notification.getId())
                .notificationAlertText(notification.getNotificationAlertText())
                .build();
    }
}
