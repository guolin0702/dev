package com.e2.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.e2.dao.EmployeeInfoDao;
import com.e2.domain.Book;
import com.e2.domain.Employee;
import com.e2.domain.Phone;

@Repository("employeeInfoDaoImpl")
public class EmployeeInfoDaoImpl implements EmployeeInfoDao {

	@PersistenceContext
	protected EntityManager entityManager;

	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
		entityManager.flush();
	}

	@Override
	public void addPhone(Phone phone) {
		entityManager.persist(phone);
		entityManager.flush();
	}

	@Override
	public void deleteEmployee(long employeeId) {
		Employee employee = entityManager.getReference(Employee.class,
				employeeId);
		entityManager.remove(employee);
		entityManager.flush();
	}

	@Override
	public void deletePhone(long phoneNumber) {
		Phone phone = entityManager.getReference(Phone.class, phoneNumber);
		entityManager.remove(phone);
		entityManager.flush();
	}

	@Override
	public void updateEmployee(Employee employee) {

//		Employee employeeToUpdate = entityManager.find(Employee.class,
//				employee.getEmployeeId());
//		employeeToUpdate.setFirstName(employee.getFirstName());
//		employeeToUpdate.setLastName(employee.getLastName());
//		employeeToUpdate.setEmployeeId(employee.getEmployeeId());
//
//		List<Phone> phones = employee.getPhone();
//		List<Phone> phonesToUpdate = employeeToUpdate.getPhone();
//
//		for (Phone phone : phones) {
//			long id = phone.getPhoneId();
//			if (id == 0) {
//				// insert new phone
//				phonesToUpdate.add(phone);
//				phone.setEmployee(employeeToUpdate);
//			} else {
//				for (Phone phoneDB : phonesToUpdate) {
//					if (phoneDB.getPhoneId() == id) {
//						// update existing phone info
//						phoneDB.setPhoneNumber(phone.getPhoneNumber());
//						phoneDB.setPhoneType(phone.getPhoneType());
//						phoneDB.setEmployee(employeeToUpdate);
//					}
//				}
//			}
//		}
//		List<Phone> phoneToRemove = new ArrayList<Phone>();
//		
//		for (Phone phoneDB : phonesToUpdate) {
//			boolean flag = false;
//			for (Phone phone : phones) {
//				if (phoneDB.getPhoneType().equals("work")
//						&& phone.getPhoneType().equals("work")) {
//					flag = true;
//				} else if (phoneDB.getPhoneType().equals("home")
//						&& phone.getPhoneType().equals("home")) {
//					flag = true;
//				} else if (phoneDB.getPhoneType().equals("mobile")
//						&& phone.getPhoneType().equals("mobile")) {
//					flag = true;
//				}
//			}
//			if(!flag)
//			{
//				phoneToRemove.add(phoneDB);
//			}
//		}
		
		Phone phoneDB = entityManager.find(Phone.class, 2352l);
		//phoneDB.setEmployee(null);
		this.entityManager.remove(phoneDB);
		entityManager.flush();
		
//		for(Phone phone : phonesToUpdate)
//		{
//			
//
//			//phonesToUpdate.remove(phone);
//		}
//		phonesToUpdate.clear();
	}

	@Override
	public void updatePhone(Phone phone) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getEmployee() {
		Query q = entityManager.createQuery("SELECT b FROM Employee b");
		List<Employee> result = (List<Employee>) q.getResultList();
		return result;
	}

	@Override
	public List<Phone> getPhone() {
		Query q = entityManager.createQuery("SELECT b FROM Phone b");
		List<Phone> result = (List<Phone>) q.getResultList();
		return result;
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		Employee result = entityManager.find(Employee.class, employeeId);
		return result;
	}
}
