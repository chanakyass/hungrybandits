package com.hungrybandits.notifications;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;

@RestController
@RequestMapping("api/v1")
public class NotificationsController {

    private final NotificationsService notificationService;

    @Autowired
    public NotificationsController(NotificationsService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("notifications")
    public void addNotification(@RequestBody NotificationRequest notificationRequest) {
        notificationService.saveNotificationToDB(notificationRequest);
    }

    @GetMapping("{customerId}/notifications")
    public NotificationResponse getNotification(@PathVariable("customerId") Integer customerId) {
        return notificationService.getNotificationFromDB(customerId);
    }
}
