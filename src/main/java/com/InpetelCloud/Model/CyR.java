package com.InpetelCloud.Model;

import javax.persistence.Id;

/*
 * Corte y reconeccion
 */
public class CyR {
	
	@Id
	private int idpetition;
	
	private String idMet;
	
	private String valorEnvio;
	
	private String status_end;
	
	private String status_petition;
	
	private String usuCrea;
	
	private String fechaFin;
	
	private String descripcion;

	
	public CyR() {
		super();
	}
	
	//PARA INSERTAR
	public CyR(int idpetition, String idMet, String valorEnvio, String usuCrea, String descripcion) {
		super();
		this.idpetition = idpetition;
		this.idMet = idMet;
		this.valorEnvio = valorEnvio;
		this.usuCrea = usuCrea;
		this.descripcion = descripcion;
	}

	//PARA UPDATE
	public CyR(int idpetition, String valorEnvio, String status_end, String status_petition) {
		super();
		this.idpetition =idpetition;
		this.valorEnvio = valorEnvio;
		this.status_end = status_end;
		this.status_petition = status_petition;
	}
	
	

	

	public int getIdpetition() {
		return idpetition;
	}

	public void setIdpetition(int idpetition) {
		this.idpetition = idpetition;
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


	public String getStatus_end() {
		return status_end;
	}

	public void setStatus_end(String status_end) {
		this.status_end = status_end;
	}

	public String getStatus_petition() {
		return status_petition;
	}

	public void setStatus_petition(String status_petition) {
		this.status_petition = status_petition;
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
