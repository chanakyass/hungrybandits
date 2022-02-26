package com.hungrybandits.clients.notifications;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "notifications",
            path = "api/v1")
public interface NotificationsClient {
    @PostMapping("notifications")
    public void addNotification(@RequestBody NotificationRequest notificationRequest);
}
