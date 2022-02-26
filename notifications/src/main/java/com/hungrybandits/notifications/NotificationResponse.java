package com.hungrybandits.notifications;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationResponse {
    private Integer id;
    private String notificationAlertText;
}
