package com.InpetelCloud.Model;

import java.util.ArrayList;

public class modelProfiles {

	private String meter;
	private String idProfile;
	private ArrayList<modelRegister> register;
	
	
	public modelProfiles() {
		super();
	}


	public modelProfiles(String meter, String idProfile, ArrayList<modelRegister> register) {
		super();
		this.meter = meter;
		this.idProfile = idProfile;
		this.register = register;
	}


	public String getMeter() {
		return meter;
	}


	public String getIdProfile() {
		return idProfile;
	}


	public ArrayList<modelRegister> getRegister() {
		return register;
	}
	
	
	
	
	
	
}
