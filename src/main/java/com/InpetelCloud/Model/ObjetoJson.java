package com.InpetelCloud.Model;

import org.json.JSONObject;

public class ObjetoJson {
	
	
	private String serialcnc;
	private String serialmet;
	private String nombreMedidas;
	private String numValor;
	private String fecha;
	private String nombreReporte;
	private String encabezado;
	private JSONObject json;
	
	
	public ObjetoJson() {
		super();
	}



	public ObjetoJson(String serialcnc, String serialmet, String nombreMedidas, String numValor, String fecha,
			String nombreReporte, String encabezado) {
		super();
		this.serialcnc = serialcnc;
		this.serialmet = serialmet;
		this.nombreMedidas = nombreMedidas;
		this.numValor = numValor;
		this.fecha = fecha;
		this.nombreReporte = nombreReporte;
		this.encabezado = encabezado;
	}


	public String getSerialcnc() {
		return serialcnc;
	}


	public void setSerialcnc(String serialcnc) {
		this.serialcnc = serialcnc;
	}


	public String getSerialmet() {
		return serialmet;
	}


	public void setSerialmet(String serialmet) {
		this.serialmet = serialmet;
	}


	public String getNombreMedidas() {
		return nombreMedidas;
	}


	public void setNombreMedidas(String nombreMedidas) {
		this.nombreMedidas = nombreMedidas;
	}


	public String getNumValor() {
		return numValor;
	}


	public void setNumValor(String numValor) {
		this.numValor = numValor;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getNombreReporte() {
		return nombreReporte;
	}


	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}


	public String getEncabezado() {
		return encabezado;
	}


	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}
	
	

	public JSONObject getJson() {
		return json;
	}


	public void setJson(JSONObject json) {
		this.json = json;
	}

	
	


}