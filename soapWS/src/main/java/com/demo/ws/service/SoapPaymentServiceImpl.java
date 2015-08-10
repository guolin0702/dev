package com.demo.ws.service;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.demo.service.PaymentService;

@Service("soapPaymentServiceImpl")
@WebService(endpointInterface = "com.demo.ws.service.ISoapPaymentService", serviceName = "paymentService")
public class SoapPaymentServiceImpl implements ISoapPaymentService {
	@Resource(name="paymentServiceImpl")
	//@Autowired
	//@Qualifier("paymentServiceImpl")
	private PaymentService paymentService;

	@Override
	public double deposit(String accountId, double amount) throws Exception {
		return paymentService.deposit(accountId, amount);
	}

	@Override
	public double withdraw(String accountId, double amount) throws Exception {
		return paymentService.withdraw(accountId, amount);
	}

	@Override
	public double checkBlance(String accountId) throws Exception {
		return paymentService.checkBlance(accountId);
	}

//	public void setPaymentService(PaymentService paymentService) {
//		this.paymentService = paymentService;
//	}
}