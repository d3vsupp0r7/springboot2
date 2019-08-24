package org.lba.springboot2.controller.ui.form;

import java.io.Serializable;

public class EmployeeForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 564293892196117700L;
	
	/* Input text mapping*/
	private String name;
	private String surname;
	
	/*RadioButton*/
	private String geneder;
	
	/*Single CheckBox */
	private boolean internal;
	
	/*Select Box mapping*/
	private Long countryId;
	
	/* TextArea mapping */
	private String additionalNotes;
	
	public EmployeeForm() {
		// Implement if necessary
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

	public String getGeneder() {
		return geneder;
	}

	public void setGeneder(String geneder) {
		this.geneder = geneder;
	}

	public boolean isInternal() {
		return internal;
	}

	public void setInternal(boolean internal) {
		this.internal = internal;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getAdditionalNotes() {
		return additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	@Override
	public String toString() {
		return "EmployeeForm [name=" + name + ", surname=" + surname + ", geneder=" + geneder + ", internal=" + internal
				+ ", countryId=" + countryId + ", additionalNotes=" + additionalNotes + "]";
	}
	
	
}
