package com.e2.web.form;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.action.ActionForm;

import com.e2.domain.Employee;
import com.e2.domain.Phone;

@SuppressWarnings("serial")
public class EmployeeInfoListForm extends ActionForm {
	protected List<Employee> employees;
	
	protected List<Phone> phones;

	public List<Employee> getEmployees() {
		if (employees == null) {
			employees = new ArrayList<Employee>();
		}
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public List<Phone> getPhones() {
		if (phones == null) {
			phones = new ArrayList<Phone>();
		}
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}
}