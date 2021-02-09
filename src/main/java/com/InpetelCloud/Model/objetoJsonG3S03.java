package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonG3S03 {

	private String meter;
	private String idProfile;
	private String nameFile;
	private ArrayList<modelRegister> register = new ArrayList<modelRegister>();
	//nombre del arreglo para medidas de g3 por horas
	private ArrayList<objetoJsonG3> daysg3 = new ArrayList<>();
	
	
	public objetoJsonG3S03(String meter, String idProfile,String nameFile, ArrayList<modelRegister> register,
			ArrayList<objetoJsonG3> daysg3) {
		super();
		this.meter = meter;
		this.idProfile = idProfile;
		this.nameFile = nameFile;
		this.register = register;
		this.daysg3 = daysg3;
	}


	public String getMeter() {
		return meter;
	}


	public String getIdProfile() {
		return idProfile;
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


	public ArrayList<objetoJsonG3> getDaysg3() {
		return daysg3;
	}


	@Override
	public String toString() {
		return "objetoJsonG3S03 [meter=" + meter + ", idProfile=" + idProfile + ", nameFile=" + nameFile + ", register=" + register + ", daysg3="
				+ daysg3 + "]";
	}
	
	
	
	
}
