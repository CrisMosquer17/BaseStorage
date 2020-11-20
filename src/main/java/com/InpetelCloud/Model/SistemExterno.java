package com.InpetelCloud.Model;

import javax.persistence.Id;

public class SistemExterno {
	
	@Id
	private int id;
	private String nit;
	private String nombre;
	private String telefono;
	private String direccion;
	private String tipoSistema;
	
	public SistemExterno() {
		super();
	}
	
	
	
	public SistemExterno(int id, String nit, String nombre, String telefono, String direccion,String tipoSistema) {
		super();
		this.id = id;
		this.nit = nit;
		this.nombre = nombre;
		this.telefono = telefono;
		this.direccion = direccion;
		this.tipoSistema = tipoSistema;
	}


	//Para modificar un sistema externo
	public SistemExterno(int id, String nit, String telefono, String direccion) {
		super();
		this.id = id;
		this.nit = nit;
		this.telefono = telefono;
		this.direccion = direccion;
	}



	public int getId() {
		return id;
	}

	



	public void setId(int id) {
		this.id = id;
	}

	public String getNit() {
		return nit;
	}

	public void setNit(String nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public String getTipoSistema() {
		return tipoSistema;
	}

	public void setTipoSistema(String tipoSistema) {
		this.tipoSistema = tipoSistema;
	}
	
	
	
	
	
}
