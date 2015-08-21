package com.e2.dao.hibernate;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.e2.dao.EmployeeInfoDao;
import com.e2.domain.Employee;
import com.e2.domain.Phone;

@Repository("employeeInfoDaoImpl")
public class EmployeeInfoDaoHibernateImpl implements EmployeeInfoDao {

	@Resource(name = "sessionFactory")
	private SessionFactory sessionFactory;
	boolean jta = true;

	public boolean isJta() {
		return jta;
	}

	public void setJta(boolean jta) {
		this.jta = jta;
	}

	protected Session getSession() {
		if (this.isJta()) {
			return sessionFactory.getCurrentSession();
		} else {
			return sessionFactory.openSession();
		}
	}

	@Override
	public void addEmployee(Employee employee) {
		Session session = getSession();
		session.persist(employee);
		session.flush();
	}

	@Override
	public void addPhone(Phone phone) {
		Session session = getSession();
		session.persist(phone);
		session.flush();
	}

	@Override
	public void deleteEmployee(long employeeId) {
		Session session = getSession();
		Employee employee = (Employee) session.load(Employee.class, employeeId);
		if (session != null) {
			session.delete(employee);
		}
	}

	@Override
	public void deletePhone(long phoneNumber) {
		Session session = getSession();
		Phone phone = (Phone) session.load(Phone.class, phoneNumber);
		if (session != null) {
			session.delete(phone);
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updatePhone(Phone phone) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Employee> getEmployee() {
		Session session = getSession();
		Query q = session.createQuery("SELECT * FROM Employee");
		return (List<Employee>) q.list();
	}

	@Override
	public List<Phone> getPhone() {
		Session session = getSession();
		Query q = session.createQuery("SELECT * FROM Phone");
		return (List<Phone>) q.list();
	}

	@Override
	public Employee getEmployeeById(long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}
}
