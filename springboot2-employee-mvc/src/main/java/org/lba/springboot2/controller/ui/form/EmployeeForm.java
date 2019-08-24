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
	
	private List<String> technologiesMultipleSelect;
	
	/*Single CheckBox */
	private boolean internal;
	
	private String[] multiCheckboxQualificationValues;
	
	/* TextArea mapping */
	private String additionalNotes;
	
	public EmployeeForm() {
		// Implement if necessary
	}

	public String[] getMultiCheckboxQualificationValues() {
		return multiCheckboxQualificationValues;
	}

	public void setMultiCheckboxQualificationValues(String[] multiCheckboxQualificationValues) {
		this.multiCheckboxQualificationValues = multiCheckboxQualificationValues;
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
	
	public List<String> getTechnologiesMultipleSelect() {
		return technologiesMultipleSelect;
	}

	public void setTechnologiesMultipleSelect(List<String> countries) {
		this.technologiesMultipleSelect = countries;
	}

	@Override
	public String toString() {
		return "EmployeeForm [name=" + name + ", surname=" + surname + ", gender=" + gender + ", countryId=" + countryId
				+ ", technologiesMultipleSelect=" + technologiesMultipleSelect + ", internal=" + internal + ", multiCheckboxQualificationValues="
				+ Arrays.toString(multiCheckboxQualificationValues) + ", additionalNotes=" + additionalNotes + "]";
	}
	
	
	
}
