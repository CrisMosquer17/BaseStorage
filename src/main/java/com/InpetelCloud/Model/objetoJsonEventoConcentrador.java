package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonEventoConcentrador {

	 private String concentrator;
	 private ArrayList<Evento> eventos = new ArrayList<Evento>();
	 private ArrayList<objetoJsonEventoConcentrador> eventoConcentrador = new ArrayList<objetoJsonEventoConcentrador>();
	 
	 
	public objetoJsonEventoConcentrador(String concentrator, ArrayList<objetoJsonEventoConcentrador> eventoConcentrador, ArrayList<Evento> eventos) {
		super();
		this.concentrator = concentrator;
		this.eventoConcentrador = eventoConcentrador;
		this.eventos = eventos;
	}


	public String getConcentrator() {
		return concentrator;
	}


	public ArrayList<objetoJsonEventoConcentrador> getEventoConcentrador() {
		return eventoConcentrador;
	}
	
	


	public ArrayList<Evento> getEventos() {
		return eventos;
	}


	@Override
	public String toString() {
		return "objetoJsonEventoConcentrador [concentrator=" + concentrator + ", eventos=" + eventos
				+ ", eventoConcentrador=" + eventoConcentrador + "]";
	}


	
	
	
	 
	 
	 
	 


}
