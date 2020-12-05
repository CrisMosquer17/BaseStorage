package com.InpetelCloud.Model;

import java.util.ArrayList;

public class ObjetoJson {
	


    private String concentrator;
    private String meter;
    private String nameFile;
    private ArrayList<modelMeterMeasure> infoMeasure = new ArrayList<>();
    private ArrayList<ObjetoJson> arreglo = new ArrayList<>();



	public ObjetoJson() {
		super();
	}



	public ObjetoJson(String concentrator, String meter, String nameFile, ArrayList<modelMeterMeasure> infoMeasure) {
        super();
        this.concentrator = concentrator;
        this.meter = meter;
        this.nameFile = nameFile;
        this.infoMeasure = infoMeasure;
    }



	public ArrayList<ObjetoJson> getArreglo() {
		return arreglo;
	}



	public String getConcentrator() {
		return concentrator;
	}



	public String getMeter() {
		return meter;
	}



	public String getNameFile() {
		return nameFile;
	}



	public ArrayList<modelMeterMeasure> getInfoMeasure() {
		return infoMeasure;
	}

	

	
	
	
	
	}