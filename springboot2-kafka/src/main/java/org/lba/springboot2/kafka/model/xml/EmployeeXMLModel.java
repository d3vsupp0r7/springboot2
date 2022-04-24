package org.lba.springboot2.kafka.model.xml;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.lba.springboot2.kafka.model.xml.adapters.MyDateXMLParserAdapter;
import org.lba.springboot2.kafka.model.xml.adapters.MyTimestampXMLParserAdapter;


@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeXMLModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9165280606049697296L;
	private int id;
    private String name;
    private String surname;
    private BigDecimal salary;
    @XmlJavaTypeAdapter(MyDateXMLParserAdapter.class)
    private Date dateOfBorn;
    @XmlJavaTypeAdapter(MyTimestampXMLParserAdapter.class)
    private Timestamp registrationDate;

    public EmployeeXMLModel() {
		//Implement if necessary
	}

	public EmployeeXMLModel(  int id, 
			 String name, 
			 String surname, 
			 BigDecimal salary, 
			 Date dateOfBorn,
			 Timestamp registrationDate) {
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
		return "EmployeeXMLModel [id=" + id + ", name=" + name + ", surname=" + surname + ", salary=" + salary
				+ ", dateOfBorn=" + dateOfBorn + ", registrationDate=" + registrationDate + "]";
	}
	
	
}
