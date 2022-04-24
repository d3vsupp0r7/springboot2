package org.lba.springboot2.kafka.model.json;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeJSONModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9165280606049697296L;
	private int id;
    private String name;
    private String surname;
    private BigDecimal salary;
    @JsonFormat(pattern="dd-MM-yyyy")
    private Date dateOfBorn;
    @JsonFormat(pattern="dd-MM-yyyy HH:mm:ss")
    private Timestamp registrationDate;

    public EmployeeJSONModel() {
		//Implement if necessary
	}

	public EmployeeJSONModel( @JsonProperty int id, 
			@JsonProperty String name, 
			@JsonProperty String surname, 
			@JsonProperty BigDecimal salary, 
			@JsonProperty Date dateOfBorn,
			@JsonProperty Timestamp registrationDate) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.salary = salary;
		this.dateOfBorn = dateOfBorn;
		this.registrationDate = registrationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Date getDateOfBorn() {
		return dateOfBorn;
	}

	public void setDateOfBorn(Date dateOfBorn) {
		this.dateOfBorn = dateOfBorn;
	}

	public Timestamp getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Timestamp registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "EmployeeJSONModel [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", dateOfBorn=" + dateOfBorn + ", registrationDate=" + registrationDate + "]";
	}
	
	
}
