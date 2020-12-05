package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Concentrador {

	@Id
	private int id;
	private String ipReal;
	private String nombreConcentrador;
	private String tipoComunicacionId;
	private String imei;
	private String serialcnc;
	private String tiempoConectadoId;
	private String modemEmbebidoId;
	private String ioModule;
	private String modemId;
	private String marcaId;
	
	
	public Concentrador( String ipReal, String nombreConcentrador, String tipoComunicacionId, String imei,
			String serialcnc, String tiempoConectadoId, String modemEmbebidoId, String ioModule, String modemId,
			String marcaId) {
		super();
		this.ipReal = ipReal;
		this.nombreConcentrador = nombreConcentrador;
		this.tipoComunicacionId = tipoComunicacionId;
		this.imei = imei;
		this.serialcnc = serialcnc;
		this.tiempoConectadoId = tiempoConectadoId;
		this.modemEmbebidoId = modemEmbebidoId;
		this.ioModule = ioModule;
		this.modemId = modemId;
		this.marcaId = marcaId;
	}


	public Concentrador() {
		super();
	}





	public int getId() {
		return id;
	}


	public String getIpReal() {
		return ipReal;
	}


	public String getNombreConcentrador() {
		return nombreConcentrador;
	}


	public String getTipoComunicacionId() {
		return tipoComunicacionId;
	}


	public String getImei() {
		return imei;
	}


	public String getSerial() {
		return serialcnc;
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


	public String getMarcaId() {
		return marcaId;
	}


	@Override
	public String toString() {
		return "Concentrador [serialcnc=" + serialcnc + "]";
	}
	
	
	
	
	
	

}
