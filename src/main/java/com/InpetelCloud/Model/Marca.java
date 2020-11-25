package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Marca {
	
	//ATRIBUTOS
	
	@Id
	private int id;
	private String nombre;
	//Es el id de la tecnologia de componente
	private String tecnologiaComponenteId;
	
	
	public Marca() {
		super();
	}

	public Marca(int id, String nombre, String tecnologiaComponenteId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tecnologiaComponenteId = tecnologiaComponenteId;
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

	public String getTecnologiaComponenteId() {
		return tecnologiaComponenteId;
	}

	public void setTecnologiaComponenteId(String tecnologiaComponenteId) {
		this.tecnologiaComponenteId = tecnologiaComponenteId;
	}
	
	
	
	

}
