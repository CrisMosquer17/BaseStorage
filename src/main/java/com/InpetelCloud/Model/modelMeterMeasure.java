package com.InpetelCloud.Model;

import java.util.ArrayList;

import javax.persistence.Id;

public class modelMeterMeasure {

	@Id
	private int id;

	public String activeImport;
	public String activeExpor;
	public String bitOfQuality;
	public String date;
	public ArrayList<String> Q = new ArrayList<>();

	public modelMeterMeasure(String activeImport, String activeExpor, String bitOfQuality, String date, ArrayList<String> q) {
		super();
		this.activeImport = activeImport;
		this.activeExpor = activeExpor;
		this.bitOfQuality = bitOfQuality;
		this.date = date;
		Q = q;
	}

	public modelMeterMeasure() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getActiveImport() {
		return activeImport;
	}

	public String getActiveExpor() {
		return activeExpor;
	}

	public String getBitOfQuality() {
		return bitOfQuality;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<String> getQ() {
		return Q;
	}
	
	

}
