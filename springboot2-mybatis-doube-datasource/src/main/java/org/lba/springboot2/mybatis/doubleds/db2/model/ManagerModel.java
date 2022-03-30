package org.lba.springboot2.mybatis.doubleds.db2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="MANAGER")
public class ManagerModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "managerSeq")
	@SequenceGenerator(name = "managerSeq", sequenceName = "MANAGER_SEQ", allocationSize=1)
	@Column(name = "ID")
	@XmlTransient
	private Long id;
	private String name;
	private String surname;
	private String departmentcode;
	
	public ManagerModel() {
		super();
	}

	public ManagerModel( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}
	
	public ManagerModel(Long id, String name, String surname) {
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
		return "ManagerModel [id=" + id + ", name=" + name + ", surname=" + surname + ", departmentcode=" + departmentcode + "]";
	}
	
}
