package com.e2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.CascadeType.REMOVE;
import static javax.persistence.CascadeType.REFRESH;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.ALL;

@SuppressWarnings("serial")
@Entity
@Table(name = "EMPLOYEE")
public class Employee extends CreateDateEntity implements Serializable  {
	@Id
	@Column(name = "EMPLOYEE_ID")
	@SequenceGenerator(name = "seqEmployeeId", sequenceName = "SEQ_EMPLOYEE_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEmployeeId")
	private long employeeId;

	@Column(name = "FIRSTNAME", nullable = false, length = 80)
	private String firstName;

	@Column(name = "LASTNAME", nullable = false, length = 80)
	private String lastName;

	@OneToMany(cascade={ ALL }, fetch = FetchType.EAGER, orphanRemoval=true)
	@JoinColumn(name="EmployeeId")
	private List<Phone> phones;
	
//	@ManyToMany(cascade ={ REFRESH, REMOVE}, fetch = FetchType.EAGER)
//    @JoinTable(name="EMP_SKILL", joinColumns={@JoinColumn(name="EMPLOYEE_ID1", referencedColumnName="EMPLOYEE_ID")},
//                inverseJoinColumns=@JoinColumn(name="SKILL2", referencedColumnName="SKILL_ID"))
//    private List<Skill> skills;
	
	public Employee() {

	}
	
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
	
	public void addPhone(Phone phone)
	{
		if(this.phones == null)
		{
			this.phones = new ArrayList<Phone>();
		}
		this.phones.add(phone);
	}
	
	public List<Phone> getPhone()
	{
		return this.phones;
	}
}