package com.hungrybandits.fraud;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FraudCheckRequest {
    private Integer customerId;
    private Boolean isFraud;
    private LocalDate timestamp;
}
