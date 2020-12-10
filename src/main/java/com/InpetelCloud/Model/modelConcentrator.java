package com.InpetelCloud.Model;

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
	
	
	public modelConcentrator() {
		super();
	}


	public modelConcentrator(String ipReal, String concentrator, String tipoComunicacionId, String imei, String serial,
			String tiempoConectadoId, String modemEmbebidoId, String ioModule, String modemId, String brand) {
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


	
	
	
	
	
	
}
