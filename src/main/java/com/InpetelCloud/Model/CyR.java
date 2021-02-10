package com.InpetelCloud.Model;

import javax.persistence.Id;

/*
 * Corte y reconeccion
 */
public class CyR {
	
	@Id
	private int id;
	
	private String idMet;
	
	private String valorEnvio;
	
	private String estadoFinal;
	
	private String estadoPeticion;
	
	private String usuCrea;
	
	private String fechaFin;
	
	private String descripcion;

	
	public CyR() {
		super();
	}
	
	//PARA INSERTAR
	public CyR(int id, String idMet, String valorEnvio, String usuCrea, String descripcion) {
		super();
		this.id = id;
		this.idMet = idMet;
		this.valorEnvio = valorEnvio;
		this.usuCrea = usuCrea;
		this.descripcion = descripcion;
	}

	//PARA UPDATE
	public CyR(String idMet, String valorEnvio, String estadoFinal, String estadoPeticion) {
		super();
		this.idMet = idMet;
		this.valorEnvio = valorEnvio;
		this.estadoFinal = estadoFinal;
		this.estadoPeticion = estadoPeticion;
	}

	public String getIdMet() {
		return idMet;
	}

	public void setIdMet(String idMet) {
		this.idMet = idMet;
	}

	public String getValorEnvio() {
		return valorEnvio;
	}

	public void setValorEnvio(String valorEnvio) {
		this.valorEnvio = valorEnvio;
	}

	public String getEstadoFinal() {
		return estadoFinal;
	}

	public void setEstadoFinal(String estadoFinal) {
		this.estadoFinal = estadoFinal;
	}

	public String getEstadoPeticion() {
		return estadoPeticion;
	}

	public void setEstadoPeticion(String estadoPeticion) {
		this.estadoPeticion = estadoPeticion;
	}

	public String getUsuCrea() {
		return usuCrea;
	}

	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
