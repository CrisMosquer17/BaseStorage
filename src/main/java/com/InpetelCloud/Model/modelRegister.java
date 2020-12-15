package com.InpetelCloud.Model;

public class modelRegister {

	private String idRegister;
	private String date;
	private String value;
	private String status;
	private String unit;
	
	
	public modelRegister() {
		super();
	}


	public modelRegister(String idRegister, String date, String value, String status, String unit) {
		super();
		this.idRegister = idRegister;
		this.date = date;
		this.value = value;
		this.status = status;
		this.unit = unit;
	}


	public String getIdRegister() {
		return idRegister;
	}


	public String getDate() {
		return date;
	}


	public String getValue() {
		return value;
	}


	public String getStatus() {
		return status;
	}


	public String getUnit() {
		return unit;
	}
	
	
	
	
	
	
}
