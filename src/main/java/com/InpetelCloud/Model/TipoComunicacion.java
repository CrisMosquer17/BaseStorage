package com.InpetelCloud.Model;

import javax.persistence.Id;

public class TipoComunicacion {
	
	//ATRIBUTOS
	@Id
	private int id;
	private String nombre;
	
	
	
	public TipoComunicacion() {
		super();
	}


	public TipoComunicacion(int id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	// METODOS GETTERS Y SETTERS
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
	
	
	
	
	
	

}
