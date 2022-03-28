package org.lba.springboot2.mybatis.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="EMPLOYEE")
public class EmployeeModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "employeeSeq")
	@SequenceGenerator(name = "employeeSeq", sequenceName = "EMPLOYEE_SEQ", allocationSize=1)
	@Column(name = "ID")
	@XmlTransient
	private Long id;
	private String name;
	private String surname;
	private String departmentcode;
	
	public EmployeeModel() {
		super();
	}

	public EmployeeModel( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public EmployeeModel(Long id, String name, String surname) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getDepartmentcode() {
		return departmentcode;
	}

	public void setDepartmentcode(String departmentcode) {
		this.departmentcode = departmentcode;
	}

	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", name=" + name + ", surname=" + surname + ", departmentcode=" + departmentcode + "]";
	}
	
}
