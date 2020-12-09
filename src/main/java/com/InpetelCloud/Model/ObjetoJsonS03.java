package com.InpetelCloud.Model;

import java.util.ArrayList;

public class ObjetoJsonS03 {

	 private String concentrator;
	 private String meter;
	 private String nameFile;
	 private ArrayList<modelMeterMeasure> infoMeasure = new ArrayList<>();    
	 private ArrayList<ObjetoJson> Days = new ArrayList<>();
	 
	 
	public ObjetoJsonS03(String concentrator, String meter, String nameFile, ArrayList<modelMeterMeasure> infoMeasure,
			ArrayList<ObjetoJson> days) {
		super();
		this.concentrator = concentrator;
		this.meter = meter;
		this.nameFile = nameFile;
		this.infoMeasure = infoMeasure;
		Days = days;
	}
	
	
	public ObjetoJsonS03() {
		super();
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


	public ArrayList<ObjetoJson> getDays() {
		return Days;
	}


	@Override
	public String toString() {
		return "ObjetoJsonS03 [concentrator=" + concentrator + ", meter=" + meter + ", nameFile=" + nameFile
				+ ", infoMeasure=" + infoMeasure + ", Days=" + Days + "]";
	}
	
	
	 
	 
	 
}
