package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Modem {
	
	// ATRIBUTOS
	@Id
	private int id;
	private String serial;
	private String nombre;
	private String imei;
	private String marca;
	
	
	
	public Modem() {
		super();
	}

	public Modem(int id, String serial, String nombre, String imei, String marca) {
		super();
		this.id = id;
		this.serial = serial;
		this.nombre = nombre;
		this.imei = imei;
		this.marca = marca;
	}
	
	//METODOS GETTERS Y SETTERS

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getImei() {
		return imei;
	}

	public void setImei(String imei) {
		this.imei = imei;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
	
	
	

}
