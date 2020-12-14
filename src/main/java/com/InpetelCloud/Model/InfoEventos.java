package com.InpetelCloud.Model;

import java.util.ArrayList;

public class InfoEventos {

	private String date;
	private String eventGroup;
	private String codeGroup;
	private ArrayList<String> D= new ArrayList<String>();
	
	
	public InfoEventos(String date, String eventGroup, String codeGroup, ArrayList<String> d) {
		super();
		this.date = date;
		this.eventGroup = eventGroup;
		this.codeGroup = codeGroup;
		D = d;
	}


	public InfoEventos() {
		super();
	}


	public String getDate() {
		return date;
	}


	public String getEventGroup() {
		return eventGroup;
	}


	public String getCodeGroup() {
		return codeGroup;
	}


	public ArrayList<String> getD() {
		return D;
	}
	
	
	
	
}
