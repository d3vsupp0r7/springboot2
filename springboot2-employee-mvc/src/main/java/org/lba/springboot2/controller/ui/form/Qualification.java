package org.lba.springboot2.controller.ui.form;

import java.io.Serializable;

public class Qualification implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8078485098883672392L;
	private Long qualificationId;
	private String qualificationCode;
	private String qualificationName;

	public Qualification() {

	}

	public Qualification(Long qualificationId, String qualificationCode, String qualificationName) {
		super();
		this.qualificationId = qualificationId;
		this.qualificationCode = qualificationCode;
		this.qualificationName = qualificationName;
	}

	public Long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getQualificationCode() {
		return qualificationCode;
	}

	public void setQualificationCode(String qualificationCode) {
		this.qualificationCode = qualificationCode;
	}

	public String getQualificationName() {
		return qualificationName;
	}

	public void setQualificationName(String qualificationName) {
		this.qualificationName = qualificationName;
	}

	
	
}
