package com.InpetelCloud.Model;

import java.util.ArrayList;

public class Evento {

	private String date;
	private String eventGroup;
	private String eventCode;
	private ArrayList<String> observation = new ArrayList<String>();
	


	public Evento(String date, String eventGroup, String eventCode, ArrayList<String> observation) {
		super();
		this.date = date;
		this.eventGroup = eventGroup;
		this.eventCode = eventCode;
		this.observation = observation;
	}


	public String getDate() {
		return date;
	}


	public String getEventGroup() {
		return eventGroup;
	}


	public String getEventCode() {
		return eventCode;
	}


	public ArrayList<String> getObservaciones() {
		return observation;
	}
	
	
	
	
}
