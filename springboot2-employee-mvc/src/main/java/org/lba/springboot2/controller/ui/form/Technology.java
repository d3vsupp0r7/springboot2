package org.lba.springboot2.controller.ui.form;

import java.io.Serializable;

public class Technology implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3962295545267590989L;
	
	private Long technologyId;
	private String technologyCode;
	private String technologyName;
	
	public Technology() {
		// Implement if necessary
	}
	
	public Technology(Long technologyId, String technologyCode, String technologyName) {
		super();
		this.technologyId = technologyId;
		this.technologyCode = technologyCode;
		this.technologyName = technologyName;
	}
	public Long getTechnologyId() {
		return technologyId;
	}
	public void setTechnologyId(Long technologyId) {
		this.technologyId = technologyId;
	}
	public String getTechnologyCode() {
		return technologyCode;
	}
	public void setTechnologyCode(String technologyCode) {
		this.technologyCode = technologyCode;
	}
	public String getTechnologyName() {
		return technologyName;
	}
	public void setTechnologyName(String technologyName) {
		this.technologyName = technologyName;
	}
	
	

}
