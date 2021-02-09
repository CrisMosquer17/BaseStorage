package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonEventoMedidor {

	 private String concentrator;
	 private String meter;
	 private String nameFile;
	 private ArrayList<Evento> eventos = new ArrayList<Evento>();
	 private ArrayList<objetoJsonEventoMedidor> eventoMedidor = new ArrayList<objetoJsonEventoMedidor>();
	
	 
	 public objetoJsonEventoMedidor(String concentrator, String meter,String nameFile, ArrayList<Evento> eventos,
			ArrayList<objetoJsonEventoMedidor> eventoMedidor) {
		super();
		this.concentrator = concentrator;
		this.meter = meter;
		this.nameFile = nameFile;
		this.eventos = eventos;
		this.eventoMedidor = eventoMedidor;
	}


	public String getConcentrator() {
		return concentrator;
	}


	public String getMeter() {
		return meter;
	}


	public ArrayList<Evento> getEventos() {
		return eventos;
	}


	public ArrayList<objetoJsonEventoMedidor> getEventoMedidor() {
		return eventoMedidor;
	}


	public String getNameFile() {
		return nameFile;
	}


	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}
	
	


	 

}
