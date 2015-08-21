package com.e2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "PHONE")
@NamedQueries({
    @NamedQuery(name = Phone.NamedQuery.name, query="SELECT p FROM Phone p WHERE p.employee.lastName like :lastName") , 
    @NamedQuery(name = Phone.NamedQuery.name2, query="SELECT p FROM Phone p WHERE p.employee.lastName like :lastName")
	}
		)
public class Phone extends CreateDateEntity implements Serializable {
	public interface NamedQuery {
		public static final String name = "getPhoneByName";
		public static final String name2 = "getPhoneName";
	}
	
	public enum Action {New, Update, Delete, None}
	
	@Id
	@Column(name = "PHONE_ID")
	@SequenceGenerator(name = "seqPhoneId", sequenceName = "SEQ_PHONE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPhoneId")
	private Long phoneId;

	//@Column(name = "EMPLOYEEID", nullable = false, length = 80)
	//private long employeeId;
	
	@ManyToOne
	@JoinColumn(name="EmployeeId", nullable=false) 
	private Employee employee;

	@Column(name = "PHONENUMBER", nullable = false, length = 80)
	private String phoneNumber;
	

	@Column(name = "PHONETYPE", nullable = false, length = 80)
	private String phoneType;


	public Phone() {

	}
	
	public long getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(long phoneId) {
		this.phoneId = phoneId;
	}
	
	public String getPhoneType() {
		return phoneType;
	}

	public void setPhoneType(String phoneType) {
		this.phoneType = phoneType;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}