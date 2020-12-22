package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonEventoMedidor {

	 private String concentrator;
	 private String meter;
	 private ArrayList<Evento> eventos = new ArrayList<Evento>();
	 private ArrayList<objetoJsonEventoMedidor> eventoMedidor = new ArrayList<objetoJsonEventoMedidor>();
	
	 
	 public objetoJsonEventoMedidor(String concentrator, String meter, ArrayList<Evento> eventos,
			ArrayList<objetoJsonEventoMedidor> eventoMedidor) {
		super();
		this.concentrator = concentrator;
		this.meter = meter;
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


	 

}
