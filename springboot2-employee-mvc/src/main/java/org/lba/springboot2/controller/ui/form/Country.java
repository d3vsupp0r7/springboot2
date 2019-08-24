package org.lba.springboot2.controller.ui.form;

import java.io.Serializable;

public class Country implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8078485098883672392L;
	private Long countryId;
	private String countryCode;
	private String countryName;

	public Country() {

	}

	public Country(Long countryId, String countryCode, String countryName) {
		super();
		this.countryId = countryId;
		this.countryCode = countryCode;
		this.countryName = countryName;
	}

	public Long getCountryId() {
		return countryId;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
}
