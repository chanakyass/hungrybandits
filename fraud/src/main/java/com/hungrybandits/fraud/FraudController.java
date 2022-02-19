package com.hungrybandits.fraud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud_check")
public class FraudController {
    private final FraudService fraudService;

    @Autowired
    public FraudController(FraudService fraudService) {
        this.fraudService = fraudService;
    }

    @GetMapping("{customerId}")
    public FraudCheckResponse checkFraudOrNot(@PathVariable("customerId") Integer customerId) {
        return FraudCheckResponse.builder().isFraudster(fraudService.isFraudster(customerId)).build();
    }
}
