package com.springboot.practice;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "payment.provider", havingValue = "razor")
public class RarozPaymentService implements PaymentService {
    @Override
    public String pay(){
        return "Raroz Payment Service starts payment";
    }

    public RarozPaymentService(){
        System.out.println("Raroz Payment Service is created");
    }
}
