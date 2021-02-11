package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonG3 {

	private String meter;
	private String idProfile;
	private String concentrator;
	private String nameFile;
	private ArrayList<modelRegister> register = new ArrayList<modelRegister>();
	//nombre del arreglo para medidas de g3 por horas
	private ArrayList<objetoJsonG3> g3 = new ArrayList<>();

	
	
	public objetoJsonG3(String meter, String idProfile, String concentrator, String nameFile, ArrayList<modelRegister> register, ArrayList<objetoJsonG3> g3) {
		super();
		this.meter = meter;
		this.idProfile = idProfile;
		this.concentrator = concentrator;
		this.nameFile = nameFile;
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
	

	public String getConcentrator() {
		return concentrator;
	}


	public void setConcentrator(String concentrator) {
		this.concentrator = concentrator;
	}


	public String getNameFile() {
		return nameFile;
	}


	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}


	public ArrayList<modelRegister> getRegister() {
		return register;
	}
	

	public ArrayList<objetoJsonG3> getG3() {
		return g3;
	}


	@Override
	public String toString() {
		return "objetoJsonG3 [meter=" + meter + ", idProfile=" + idProfile + ", concentrator="+ concentrator +",  nameFile=" + nameFile + ", register=" + register + ", g3=" + g3
				+ "]";
	}


	
	
	
	
	
}
