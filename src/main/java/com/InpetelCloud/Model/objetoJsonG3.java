package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonG3 {

	private String meter;
	private String idProfile;
	private ArrayList<modelRegister> register = new ArrayList<modelRegister>();
	private ArrayList<objetoJsonG3> g3 = new ArrayList<>();

	
	
	public objetoJsonG3(String meter, String idProfile, ArrayList<modelRegister> register, ArrayList<objetoJsonG3> g3) {
		super();
		this.meter = meter;
		this.idProfile = idProfile;
		this.register = register;
		this.g3=g3;
	}


	public objetoJsonG3() {
		super();
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
	
	


	public ArrayList<objetoJsonG3> getG3() {
		return g3;
	}


	@Override
	public String toString() {
		return "objetoJsonG3 [meter=" + meter + ", idProfile=" + idProfile + ", register=" + register + ", g3=" + g3
				+ "]";
	}


	
	
	
	
	
}
