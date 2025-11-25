package com.springboot.practice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PracticeApplication implements CommandLineRunner {


	private final RarozPaymentService paymentService;

	@Override
	public void run(String... args) throws Exception {
		System.out.println(paymentService.pay());
		System.out.println("Payment Done");
	}

	public PracticeApplication(RarozPaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
	}

}
