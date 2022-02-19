package com.hungrybandits.clients.fraud;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = "fraud",
        path = "api/v1/fraud_check"
)
public interface FraudClient {
    @GetMapping("{customerId}")
    public FraudCheckResponse checkFraudOrNot(@PathVariable("customerId") Integer customerId);
}
