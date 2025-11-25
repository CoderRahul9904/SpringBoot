package com.springboot.practice;

import org.springframework.stereotype.Component;

@Component
public class StripePaymentService implements PaymentService {
    @Override
    public String pay(){
        return "Stripe Payment Service";
    }
}
