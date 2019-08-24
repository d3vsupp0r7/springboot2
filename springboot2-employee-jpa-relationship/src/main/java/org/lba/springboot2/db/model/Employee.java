package org.lba.springboot2.db.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String surname;

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "address_id", referencedColumnName = "id")
	private Address address;

	@ManyToOne
	@JoinColumn(name ="DEPT_ID", referencedColumnName = "id")
	private Department department;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(
			name = "Employee_Qualification", 
			joinColumns = { @JoinColumn(name = "emp_id") }, 
			inverseJoinColumns = { @JoinColumn(name = "qualification_id") }
			)
	List<Qualification> qualifications = new ArrayList<>();

	public Employee() {
		super();
	}

	public Employee( String name, String surname) {
		super();
		this.name = name;
		this.surname = surname;
	}

	public Employee(Long id, String name, String surname) {
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", surname=" + surname + ", address=" + address + "]";
	}



}