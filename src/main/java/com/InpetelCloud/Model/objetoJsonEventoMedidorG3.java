package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonEventoMedidorG3 {

	private String meter;
	private String idProfile;
	private ArrayList<modelRegister> register = new ArrayList<modelRegister>();
	//nombre del arreglo para eventos de g3 
	private ArrayList<objetoJsonEventoMedidorG3> g3EventoMedidor = new ArrayList<>();
	
	
	public objetoJsonEventoMedidorG3(String meter, String idProfile, ArrayList<modelRegister> register,
			ArrayList<objetoJsonEventoMedidorG3> g3EventoMedidor) {
		super();
		this.meter = meter;
		this.idProfile = idProfile;
		this.register = register;
		this.g3EventoMedidor = g3EventoMedidor;
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


	public ArrayList<objetoJsonEventoMedidorG3> getG3EventoMedidor() {
		return g3EventoMedidor;
	}


	
	

}
