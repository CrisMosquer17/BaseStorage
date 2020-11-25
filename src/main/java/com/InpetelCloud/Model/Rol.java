package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Rol {
	
	//ATRIBUTOS
	
	@Id
	private int id;
	private String nombre;
	private String descripcion;
	//id del estado
	private String estadoId;
	
	
	public Rol() {
		super();
	}


	public Rol(int id, String nombre, String descripcion, String estadoId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estadoId = estadoId;
	}
	
	//METODOS SETTERS Y GETTERS


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


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getEstadoId() {
		return estadoId;
	}


	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}
	
	
	
	

}
