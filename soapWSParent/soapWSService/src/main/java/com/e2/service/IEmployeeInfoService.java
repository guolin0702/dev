package com.e2.service;

import java.util.List;

import com.e2.domain.Employee;
import com.e2.domain.Phone;

public interface IEmployeeInfoService {
	public Employee addEmployee(Employee employee);

	public void addPhone(Phone phone);

	public void deleteEmployee(long employeeId);

	public void deletePhone(long phoneNumber);

	public void updateEmployee(Employee employee);

	public void updatePhone(Phone phone);

	public List<Employee> getEmployee();

	public List<Phone> getPhone();
	
	public Employee getEmployeeById(long employeeId);
}
