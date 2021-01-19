package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Transformador {

	// ATRIBUTOS
	
	@Id
	private int id;
	private String address;
	private String codigo;
	private int capacidad;
	private int nodo;
	private int cargaAforada;
	private int tipoTrafo;
	private int concentradorId;
	private String estadoId;
	private String observacion;
	
	
	
	
	public Transformador() {
		super();
	}

	public Transformador(int id, String address, String codigo, int capacidad, int nodo, int cargaAforada, int tipoTrafo,
			int concentradorId, String estadoId) {
		super();
		this.id = id;
		this.address = address;
		this.codigo = codigo;
		this.capacidad = capacidad;
		this.nodo = nodo;
		this.cargaAforada = cargaAforada;
		this.tipoTrafo = tipoTrafo;
		this.concentradorId = concentradorId;
		this.estadoId=estadoId;
	}
	
	public Transformador(int id, String codigo) {
		super();
		this.id = id;
		this.codigo = codigo;
	}

	//METODOS GETTERS Y SETTERS	


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public int getNodo() {
		return nodo;
	}

	public void setNodo(int nodo) {
		this.nodo = nodo;
	}

	public int getCargaAforada() {
		return cargaAforada;
	}

	public void setCargaAforada(int cargaAforada) {
		this.cargaAforada = cargaAforada;
	}

	public int getTipoTrafo() {
		return tipoTrafo;
	}

	public void setTipoTrafo(int tipoTrafo) {
		this.tipoTrafo = tipoTrafo;
	}

	public int getConcentradorId() {
		return concentradorId;
	}

	public void setConcentradorId(int concentradorId) {
		this.concentradorId = concentradorId;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	
	
	
	
	
	
	
	
}
