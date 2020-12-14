package com.InpetelCloud.Model;

import java.util.ArrayList;

public class ObjetoJsonEventos {

	 private String concentrator;
	 private String meter;
	 private String nameFile;
	 private ArrayList<InfoEventos> infoEvento = new ArrayList<InfoEventos>();
	 
	 private ArrayList<ObjetoJsonEventos> eventos = new ArrayList<>();

	public ObjetoJsonEventos(String concentrator, String meter, String nameFile, ArrayList<InfoEventos> infoEvento,
			ArrayList<ObjetoJsonEventos> eventos) {
		super();
		this.concentrator = concentrator;
		this.meter = meter;
		this.nameFile = nameFile;
		this.infoEvento = infoEvento;
		this.eventos = eventos;
	}

	public String getConcentrator() {
		return concentrator;
	}

	public void setConcentrator(String concentrator) {
		this.concentrator = concentrator;
	}

	public String getMeter() {
		return meter;
	}

	public void setMeter(String meter) {
		this.meter = meter;
	}

	public String getNameFile() {
		return nameFile;
	}

	public void setNameFile(String nameFile) {
		this.nameFile = nameFile;
	}

	public ArrayList<InfoEventos> getInfoEvento() {
		return infoEvento;
	}

	public void setInfoEvento(ArrayList<InfoEventos> infoEvento) {
		this.infoEvento = infoEvento;
	}

	public ArrayList<ObjetoJsonEventos> getEventos() {
		return eventos;
	}

	public void setEventos(ArrayList<ObjetoJsonEventos> eventos) {
		this.eventos = eventos;
	}
	 
	 
	 
	 

	 
}
