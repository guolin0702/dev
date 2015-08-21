package com.e2.web.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.e2.domain.Employee;
import com.e2.domain.Phone;

public class EmployeeInfoForm extends ActionForm {
	private long employeeId;

	private String firstName;

	private String lastName;

	private String workPhoneNumber;

	private String homePhoneNumber;
	
	private String mobilePhoneNumber;

	private long workPhoneId; 
	
	private long homePhoneId;
	
	private long mobilePhoneId;
	
	private String phoneType;

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (getFirstName().isEmpty()) {
			errors.add("employee.err.firstname", new ActionMessage(
					"employee.err.firstname.required"));
		}

		return errors;
	}

	public String getWorkPhoneNumber() {
		return workPhoneNumber;
	}

	public void setWorkPhoneNumber(String workPhoneNumber) {
		this.workPhoneNumber = workPhoneNumber;
	}

	public String getHomePhoneNumber() {
		return homePhoneNumber;
	}

	public void setHomePhoneNumber(String homePhoneNumber) {
		this.homePhoneNumber = homePhoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}

	public long getWorkPhoneId() {
		return workPhoneId;
	}

	public void setWorkPhoneId(long workPhoneId) {
		this.workPhoneId = workPhoneId;
	}

	public long getHomePhoneId() {
		return homePhoneId;
	}

	public void setHomePhoneId(long homePhoneId) {
		this.homePhoneId = homePhoneId;
	}

	public long getMobilePhoneId() {
		return mobilePhoneId;
	}

	public void setMobilePhoneId(long mobilePhoneId) {
		this.mobilePhoneId = mobilePhoneId;
	}
	
}
