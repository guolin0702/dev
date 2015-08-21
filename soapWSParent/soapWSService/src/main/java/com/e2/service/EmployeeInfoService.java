package com.e2.service;

import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e2.dao.EmployeeInfoDao;
import com.e2.domain.Employee;
import com.e2.domain.Phone;


@Transactional
@Service("employeeInfoService")
public class EmployeeInfoService implements IEmployeeInfoService{

	@Autowired
	@Qualifier("employeeInfoDaoImpl")
	
	EmployeeInfoDao serviceDao;
	
	@Override
	public Employee addEmployee(Employee employee) {
		serviceDao.addEmployee(employee);
		return employee;
	}

	@Override
	public void addPhone(Phone phone) {
		serviceDao.addPhone(phone);
	}

	@Override
	public void deleteEmployee(long employeeId) {
		serviceDao.deleteEmployee(employeeId);
	}

	@Override
	public void deletePhone(long phoneNumber) {
		serviceDao.deletePhone(phoneNumber);
	}

	@Override
	public void updateEmployee(Employee employee) {
		serviceDao.updateEmployee(employee);
	}

	@Override
	public void updatePhone(Phone phone) {
		serviceDao.updatePhone(phone);
	}

	@Override
	public List<Employee> getEmployee() {
		return serviceDao.getEmployee();
	}

	@Override
	public List<Phone> getPhone() {
		return serviceDao.getPhone();
	}
	
	@Override
	public Employee getEmployeeById(long employeeId) {
    	return serviceDao.getEmployeeById(employeeId);
	}
	
}
