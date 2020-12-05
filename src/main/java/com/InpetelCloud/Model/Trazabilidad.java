package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Trazabilidad {

	@Id
	private int id;
	private String encabezado;
	private String nombreReporte;
	
	
	public Trazabilidad(int id, String encabezado, String nombreReporte) {
		super();
		this.id = id;
		this.encabezado = encabezado;
		this.nombreReporte = nombreReporte;
	}


	public Trazabilidad() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getEncabezado() {
		return encabezado;
	}


	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}


	public String getNombreReporte() {
		return nombreReporte;
	}


	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}


	@Override
	public String toString() {
		return "Trazabilidad [encabezado=" + encabezado + ", nombreReporte=" + nombreReporte + "]";
	}
	
	
	
	
}
