package com.InpetelCloud.Model;

import javax.persistence.Id;

public class modelMeter {
	
	@Id
	private int id;
	private String typeMeter;
	private String magnitud;
	private int numberQuadrants;
	private String tipoPuertoId;
	private int prepago;
	private int syncReloj;
	private String model;
	private String meter;
	private String brand;
	private String concentrator;
	private String logicalName;
	private String estadoId;
	private String observacion;

	
	
	
	public modelMeter() {
		super();
	}


	//CREATE
	public modelMeter(String concentrator, String typeMeter, String magnitud, int numberQuadrants, String tipoPuertoId,
			int prepago, int syncReloj, String model, String meter, String brand,
			String technology, String logicalName, String estadoId) {
		super();
		this.concentrator=concentrator;
		this.typeMeter = typeMeter;
		this.magnitud = magnitud;
		this.numberQuadrants = numberQuadrants;
		this.tipoPuertoId = tipoPuertoId;
		this.prepago = prepago;
		this.syncReloj = syncReloj;
		this.model = model;
		this.meter = meter;
		this.brand = brand;
		this.logicalName=logicalName;
		this.estadoId= estadoId;
	}
	
	

	// CREAR MEDIDOR PARA FRONTEND
	public modelMeter(String concentrator, String typeMeter, String magnitud, int numberQuadrants, String tipoPuertoId, int prepago,
			int syncReloj, String model, String meter, String brand) {
		super();
		this.concentrator = concentrator;
		this.typeMeter = typeMeter;
		this.magnitud = magnitud;
		this.numberQuadrants = numberQuadrants;
		this.tipoPuertoId = tipoPuertoId;
		this.prepago = prepago;
		this.syncReloj = syncReloj;
		this.model = model;
		this.meter = meter;
		this.brand = brand;
	}


	public int getId() {
		return id;
	}


	public String getTypeMeter() {
		return typeMeter;
	}


	public String getMagnitud() {
		return magnitud;
	}


	public int getNumberQuadrants() {
		return numberQuadrants;
	}


	public String getTipoPuertoId() {
		return tipoPuertoId;
	}


	public int getPrepago() {
		return prepago;
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


	public String getConcentrator() {
		return concentrator;
	}


	public String getLogicalName() {
		return logicalName;
	}


	public String getEstadoId() {
		return estadoId;
	}


	public String getObservacion() {
		return observacion;
	}


	
	
	
	
	
	

}
