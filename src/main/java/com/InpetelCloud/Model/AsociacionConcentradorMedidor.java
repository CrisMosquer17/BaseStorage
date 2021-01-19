package com.InpetelCloud.Model;

public class AsociacionConcentradorMedidor {

	private String serialConcentrador;
	private String serialMedidor;
	
	public AsociacionConcentradorMedidor(String serialConcentrador, String serialMedidor) {
		super();
		this.serialConcentrador = serialConcentrador;
		this.serialMedidor = serialMedidor;
	}
	
	
	
	public String getSerialConcentrador() {
		return serialConcentrador;
	}
	public void setSerialConcentrador(String serialConcentrador) {
		this.serialConcentrador = serialConcentrador;
	}
	public String getSerialMedidor() {
		return serialMedidor;
	}
	public void setSerialMedidor(String serialMedidor) {
		this.serialMedidor = serialMedidor;
	}
	
	
}
