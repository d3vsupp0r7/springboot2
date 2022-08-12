package org.lba.springboot2.activemq.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
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

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeDBModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1443105386164947351L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "employeeSeq")
	@SequenceGenerator(name = "employeeSeq", sequenceName = "EMPLOYEE_SEQ", allocationSize = 1)
	@Column(name="ID")
	private BigDecimal id;

	@Column(name = "FIRST_NAME", nullable = true, length = 50)
	private String firstName;

	@Column(name = "LAST_NAME", nullable = true, length = 50)
	private String lastName;

	@Column(name = "CODE", nullable = true, length = 50)
	private String code;

	@Column(name = "DOB", nullable = true)
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern="dd/MM/yyyy", shape = JsonFormat.Shape.STRING, locale = "it-IT", timezone = "Europe/Rome")
	private Date dob;
	
	public EmployeeDBModel() {
		// Implement if necessary
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "EmployeeDBModel{" +
				"id=" + id +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", code='" + code + '\'' +
				", dob=" + dob +
				'}';
	}
}
