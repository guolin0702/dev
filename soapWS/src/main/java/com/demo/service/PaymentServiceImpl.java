package com.demo.service;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service("paymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

	public PaymentServiceImpl() {
		System.out.println("Default construction");
	}

	@PostConstruct
	public void init(){
		System.out.println("Init");
	}
	
	@Override
	public double deposit(String accountId, double amount) throws Exception {
		return 0;
	}

	@Override
	public double withdraw(String accountId, double amount) throws Exception {
		return 0;
	}

	@Override
	public double checkBlance(String accountId) throws Exception {
		return 0;
	}
}