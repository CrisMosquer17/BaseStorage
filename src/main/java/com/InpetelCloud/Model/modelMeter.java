package com.InpetelCloud.Model;

import javax.persistence.Id;

public class modelMeter {
	
	@Id
	private int id;
	private String typeMeter;
	private String mang;
	private int numberQuadrants;
	private String medidorCol;
	private String tipoPuertoId;
	private int prepago;
	private int saldoPrepago;
	private int recargaPrepago;
	private int syncReloj;
	private String model;
	private String meter;
	private String brand;
	private String technology;
	private String concentrator;
	
	
	
	public modelMeter() {
		super();
	}


	public modelMeter(String concentrator, String typeMeter, String mang, int numberQuadrants, String medidorCol, String tipoPuertoId,
			int prepago, int saldoPrepago, int recargaPrepago, int syncReloj, String model, String meter, String brand,
			String technology) {
		super();
		this.concentrator=concentrator;
		this.typeMeter = typeMeter;
		this.mang = mang;
		this.numberQuadrants = numberQuadrants;
		this.medidorCol = medidorCol;
		this.tipoPuertoId = tipoPuertoId;
		this.prepago = prepago;
		this.saldoPrepago = saldoPrepago;
		this.recargaPrepago = recargaPrepago;
		this.syncReloj = syncReloj;
		this.model = model;
		this.meter = meter;
		this.brand = brand;
		this.technology = technology;
	}


	public int getId() {
		return id;
	}


	public String getTypeMeter() {
		return typeMeter;
	}


	public String getMang() {
		return mang;
	}


	public int getNumberQuadrants() {
		return numberQuadrants;
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


	public String getModel() {
		return model;
	}


	public String getMeter() {
		return meter;
	}


	public String getBrand() {
		return brand;
	}


	public String getTechnology() {
		return technology;
	}


	public String getConcentrator() {
		return concentrator;
	}
	
	
	
	
	

}
