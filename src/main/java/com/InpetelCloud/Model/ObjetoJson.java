package com.InpetelCloud.Model;

import java.util.ArrayList;

public class ObjetoJson {
	
    private String concentrator;
    private String meter;
    private String nameFile;
    private ArrayList<modelMeterMeasure> infoMeasure = new ArrayList<>();
    
    private ArrayList<ObjetoJson> arreglo = new ArrayList<>();	
	private String serialcnc;
	private String serialmet;
	private String nombreMedidas;
	private String numValor;
	private String fecha;
	private String nombreReporte;
	private String encabezado;

	
	public ObjetoJson() {
		super();
	}

	public ObjetoJson(String concentrator, String meter, String nameFile, ArrayList<modelMeterMeasure> infoMeasure, ArrayList<ObjetoJson> arreglo) {
        super();
        this.concentrator = concentrator;
        this.meter = meter;
        this.nameFile = nameFile;
        this.infoMeasure = infoMeasure;
        this.arreglo = arreglo;
    }



	public ArrayList<ObjetoJson> getArreglo() {
		return arreglo;
	}



	public String getConcentrator() {
		return concentrator;
	}



	public String getMeter() {
		return meter;
	}



	public String getNameFile() {
		return nameFile;
	}



	public ArrayList<modelMeterMeasure> getInfoMeasure() {
		return infoMeasure;
	}

	public String getNombreMedidas() {
		return nombreMedidas;
	}


	public void setNombreMedidas(String nombreMedidas) {
		this.nombreMedidas = nombreMedidas;
	}


	public String getNumValor() {
		return numValor;
	}


	public void setNumValor(String numValor) {
		this.numValor = numValor;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getNombreReporte() {
		return nombreReporte;
	}


	public void setNombreReporte(String nombreReporte) {
		this.nombreReporte = nombreReporte;
	}


	public String getEncabezado() {
		return encabezado;
	}


	public void setEncabezado(String encabezado) {
		this.encabezado = encabezado;
	}

	@Override
	public String toString() {
		return "ObjetoJson [concentrator=" + concentrator + ", meter=" + meter + ", nameFile=" + nameFile
				+ ", infoMeasure=" + infoMeasure + ", arreglo=" + arreglo + "]";
	}
	
	



}
