package com.InpetelCloud.Model;

import javax.persistence.Id;

public class TecnologiaComponente {
	
	// ATRIBUTOS
	@Id
	private String id;
	private String nombre;
	

	
	public TecnologiaComponente() {
		super();
	}

	public TecnologiaComponente(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}
	
	// METODOS GETTERS Y SETTERS

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombreTecnologia(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
