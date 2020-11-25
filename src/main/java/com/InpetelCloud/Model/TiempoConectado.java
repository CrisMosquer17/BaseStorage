package com.InpetelCloud.Model;

import javax.persistence.Id;

public class TiempoConectado {
	
	// ATRIBUTOS 
	@Id
	private int id;
	private String comStatus;
	private String descripcion;
	
	
	
	public TiempoConectado() {
		super();
	}



	public TiempoConectado(int id, String comStatus, String descripcion) {
		super();
		this.id = id;
		this.comStatus = comStatus;
		this.descripcion = descripcion;
	}

	// METODOS SETTERS Y GETTERS
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getComStatus() {
		return comStatus;
	}



	public void setComStatus(String comStatus) {
		this.comStatus = comStatus;
	}



	public String getDescripcion() {
		return descripcion;
	}



	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
		
	

}
