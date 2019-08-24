package org.lba.springboot2.controller.ui.form;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class EmployeeForm implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 564293892196117700L;
	
	/* Input text mapping*/
	private String name;
	private String surname;
	
	/*RadioButton*/
	private String gender;
	
	/*Select Box mapping*/
	private Long countryId;
	
	private List<String> countries;
	
	/*Single CheckBox */
	private boolean internal;
	
	private String[] multiCheckboxSelectedValues;
	
	/* TextArea mapping */
	private String additionalNotes;
	
	public EmployeeForm() {
		// Implement if necessary
	}

	public String[] getMultiCheckboxSelectedValues() {
		return multiCheckboxSelectedValues;
	}

	public void setMultiCheckboxSelectedValues(String[] multiCheckboxSelectedValues) {
		this.multiCheckboxSelectedValues = multiCheckboxSelectedValues;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
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
	
	public List<String> getCountries() {
		return countries;
	}

	public void setCountries(List<String> countries) {
		this.countries = countries;
	}

	@Override
	public String toString() {
		return "EmployeeForm [name=" + name + ", surname=" + surname + ", gender=" + gender + ", countryId=" + countryId
				+ ", countries=" + countries + ", internal=" + internal + ", multiCheckboxSelectedValues="
				+ Arrays.toString(multiCheckboxSelectedValues) + ", additionalNotes=" + additionalNotes + "]";
	}
	
	
	
}
