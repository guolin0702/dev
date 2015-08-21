package com.e2.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@SuppressWarnings("serial")
@Entity
@Table(name = "SKILL")
public class Skill extends CreateDateEntity implements Serializable {
	@Id
	@Column(name = "SKILL_ID")
	@SequenceGenerator(name = "seqSkillId", sequenceName = "SEQ_SKILL_ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSkillId")
	private long skillId;

	@Column(name = "EMPLOYEEID", nullable = false, length = 80)
	private String employeeId;

	@Column(name = "SKILLNAME", nullable = false, length = 80)
	private String skillName;

	public Skill() {

	}
}