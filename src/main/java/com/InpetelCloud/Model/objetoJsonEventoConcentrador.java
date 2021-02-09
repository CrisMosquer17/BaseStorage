package com.InpetelCloud.Model;

import java.util.ArrayList;

public class objetoJsonEventoConcentrador {

	 private String concentrator;
	 private String nameFile;
	 private ArrayList<Evento> eventos = new ArrayList<Evento>();
	 private ArrayList<objetoJsonEventoConcentrador> eventoConcentrador = new ArrayList<objetoJsonEventoConcentrador>();
	 
	 
	public objetoJsonEventoConcentrador(String concentrator,String nameFile, ArrayList<objetoJsonEventoConcentrador> eventoConcentrador, ArrayList<Evento> eventos) {
		super();
		this.concentrator = concentrator;
		this.nameFile = nameFile;
		this.eventoConcentrador = eventoConcentrador;
		this.eventos = eventos;
	}


	public String getConcentrator() {
		return concentrator;
	}

	public String getNameFile() {
		return nameFile;
	}


	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}


	public ArrayList<objetoJsonEventoConcentrador> getEventoConcentrador() {
		return eventoConcentrador;
	}
	
	


	public ArrayList<Evento> getEventos() {
		return eventos;
	}


	@Override
	public String toString() {
		return "objetoJsonEventoConcentrador [concentrator=" + concentrator + ", nameFile=" + nameFile + ", eventos=" + eventos
				+ ", eventoConcentrador=" + eventoConcentrador + "]";
	}


	
	
	
	 
	 
	 
	 


}
