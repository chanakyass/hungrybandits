package com.hungrybandits.customer;

import com.hungrybandits.clients.fraud.FraudCheckResponse;
import com.hungrybandits.clients.fraud.FraudClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
@Slf4j
public class CustomerService {
    private final CustomerRepo customerRepo;
    private final RestTemplate restTemplate;
    private final FraudClient fraudClient;

    @Autowired
    public CustomerService(CustomerRepo customerRepo, RestTemplate restTemplate, FraudClient fraudClient) {
        this.customerRepo = customerRepo;
        this.restTemplate = restTemplate;
        this.fraudClient = fraudClient;
    }

    @Transactional
    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder().
                            name(customerRegistrationRequest.getName()).
                            email(customerRegistrationRequest.getEmail()).
                            age(customerRegistrationRequest.getAge()).
                            build();
        customerRepo.saveAndFlush(customer);
//        FraudCheckResponse fraudCheckResponse = restTemplate
//                .getForObject("http://FRAUD/api/v1/fraud_check/{customerId}",
//                        FraudCheckResponse.class, customer.getId());
//            Optional.ofNullable(fraudCheckResponse).orElseThrow(() -> new IllegalStateException("There has been a fraud"));

        FraudCheckResponse fraudCheckResponse = fraudClient.checkFraudOrNot(customer.getId()) ;

    }
}
