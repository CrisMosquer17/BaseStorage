package com.InpetelCloud.Model;

import java.util.ArrayList;

import javax.persistence.Id;

public class modelConcentrator {

	@Id
	private int id;
	private String ipReal;
	private String concentrator;
	private String tipoComunicacionId;
	private String imei;
	private String serial;
	private String tiempoConectadoId;
	private String modemEmbebidoId;
	private String ioModule;
	private String modemId;	
	private String brand;
	private String pass;
	private String user;
	private String estadoId;
	private String observacion;



	
	
	public modelConcentrator() {
		super();
	}


	public modelConcentrator(String ipReal, String concentrator, String tipoComunicacionId, String imei, String serial,
			String tiempoConectadoId, String modemEmbebidoId, String ioModule, String modemId, String brand, String pass, String user, String estadoId) {
		super();
		this.ipReal = ipReal;
		this.concentrator = concentrator;
		this.tipoComunicacionId = tipoComunicacionId;
		this.imei = imei;
		this.serial = serial;
		this.tiempoConectadoId = tiempoConectadoId;
		this.modemEmbebidoId = modemEmbebidoId;
		this.ioModule = ioModule;
		this.modemId = modemId;
		this.brand = brand;
		this.pass=pass;
		this.user=user;
		this.estadoId=estadoId;
}
	
	

	//CREAR CONCENTRADOR PARA VISTA
	public modelConcentrator(String ipReal, String concentrator, String tipoComunicacionId, String imei, String serial,
			String tiempoConectadoId, String modemEmbebidoId, String ioModule, String modemId, String brand,
			String pass, String user) {
		super();
		this.ipReal = ipReal;
		this.concentrator = concentrator;
		this.tipoComunicacionId = tipoComunicacionId;
		this.imei = imei;
		this.serial = serial;
		this.tiempoConectadoId = tiempoConectadoId;
		this.modemEmbebidoId = modemEmbebidoId;
		this.ioModule = ioModule;
		this.modemId = modemId;
		this.brand = brand;
		this.pass = pass;
		this.user = user;
	}
	
	


	public int getId() {
		return id;
	}


	public String getIpReal() {
		return ipReal;
	}


	public String getConcentrator() {
		return concentrator;
	}


	public String getTipoComunicacionId() {
		return tipoComunicacionId;
	}


	public String getImei() {
		return imei;
	}


	public String getSerial() {
		return serial;
	}


	public String getTiempoConectadoId() {
		return tiempoConectadoId;
	}


	public String getModemEmbebidoId() {
		return modemEmbebidoId;
	}


	public String getIoModule() {
		return ioModule;
	}


	public String getModemId() {
		return modemId;
	}


	public String getBrand() {
		return brand;
	}


	public String getPass() {
		return pass;
	}


	public String getUser() {
		return user;
	}


	public String getEstadoId() {
		return estadoId;
	}


	public String getObservacion() {
		return observacion;
	}


	

	
	
	
	
}
