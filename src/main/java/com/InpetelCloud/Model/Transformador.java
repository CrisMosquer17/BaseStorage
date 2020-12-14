package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Transformador {

	// ATRIBUTOS
	
	@Id
	private int id;
	private String nombre;
	private String address;
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

	public Transformador(int id, String nombre, String address, int capacidad, int nodo, int cargaAforada, int tipoTrafo,
			int concentradorId, String estadoId) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.address = address;
		this.capacidad = capacidad;
		this.nodo = nodo;
		this.cargaAforada = cargaAforada;
		this.tipoTrafo = tipoTrafo;
		this.concentradorId = concentradorId;
		this.estadoId=estadoId;
	}
	
	
	
	//METODOS GETTERS Y SETTERS	


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

	
	
	
	
	
	
	
	
}
