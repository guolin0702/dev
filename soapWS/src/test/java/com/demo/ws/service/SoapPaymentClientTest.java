package com.demo.ws.service;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

public class SoapPaymentClientTest {
	private final static String URL = "http://localhost:8080/soapWS/services/paymentService?wsdl";

	public static void main(String args[]) throws Exception {
		ISoapPaymentService client = createSoapClient(ISoapPaymentService.class);
		String acountId = "acount one";
		double balance = client.checkBlance(acountId);
		balance = client.deposit(acountId, 5000d);
		balance = client.withdraw(acountId, 50000d);
		System.out.println("<--------------------------------------------->"
				+ balance);
	}

	@SuppressWarnings("unchecked")
	public static <T> T createSoapClient(Class<T> cls) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();

		factory.setServiceClass(cls);
		factory.setAddress(URL);
		factory.getInInterceptors().add(new LoggingInInterceptor());
		factory.getOutInterceptors().add(new LoggingOutInterceptor());
		T client = (T) factory.create();
		return client;
	}
}