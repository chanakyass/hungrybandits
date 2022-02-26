package com.hungrybandits.clients.notifications;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NotificationRequest {
    private Integer customerId;
    private String notificationAlertText;
}
