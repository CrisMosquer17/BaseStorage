package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Medidor {
	
	@Id
	private int id;
	private String tipoMedidorId;
	private String magnitud; 
	private int numeroCuadrantes;
	private String medidorCol;
	private String tipoPuertoId;
	private int prepago;
	private int saldoPrepago;
	private int recargaPrepago;
	private int syncReloj;
	private String modelo;
	private String serialmet;
	private String marcaId;
	private String technology;
	
	
	public Medidor(int id, String tipoMedidorId, String magnitud, int numeroCuadrantes, String medidorCol,
			String tipoPuertoId, int prepago, int saldoPrepago, int recargaPrepago, int syncReloj, String modelo,
			String serialmet, String marcaId, String technology) {
		super();
		this.id = id;
		this.tipoMedidorId = tipoMedidorId;
		this.magnitud = magnitud;
		this.numeroCuadrantes = numeroCuadrantes;
		this.medidorCol = medidorCol;
		this.tipoPuertoId = tipoPuertoId;
		this.prepago = prepago;
		this.saldoPrepago = saldoPrepago;
		this.recargaPrepago = recargaPrepago;
		this.syncReloj = syncReloj;
		this.modelo = modelo;
		this.serialmet = serialmet;
		this.marcaId = marcaId;
		this.technology = technology;
	}
	
	public Medidor() {
		super();
	}




	public int getId() {
		return id;
	}


	public String getTipoMedidorId() {
		return tipoMedidorId;
	}


	public String getMagnitud() {
		return magnitud;
	}


	public int getNumeroCuadrantes() {
		return numeroCuadrantes;
	}


	public String getMedidorCol() {
		return medidorCol;
	}


	public String getTipoPuertoId() {
		return tipoPuertoId;
	}


	public int getPrepago() {
		return prepago;
	}


	public int getSaldoPrepago() {
		return saldoPrepago;
	}


	public int getRecargaPrepago() {
		return recargaPrepago;
	}


	public int getSyncReloj() {
		return syncReloj;
	}


	public String getModelo() {
		return modelo;
	}


	public String getSerial() {
		return serialmet;
	}


	public String getMarcaId() {
		return marcaId;
	}


	public String getTechnology() {
		return technology;
	}

	@Override
	public String toString() {
		return "Medidor [serialmet=" + serialmet + "]";
	}
	
	
	
	


}
