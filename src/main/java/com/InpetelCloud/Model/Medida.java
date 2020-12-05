package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Medida {

	@Id
	private int id;
	private int contador;
	private String idMedidor;
	private String idConcentrador;
	private String numValor;
	private String fecha;
	private String horaInicio;
	private String horaFin;
	private String trazabilidadId;
	private String infoMedidaId;
//	private String serialcnc;
//	private String serialmet;
//	private String nombreMedidas;
//	private String nombreReporte;
//	private String encabezado;
	
	
	public Medida(int contador, String idMedidor, String idConcentrador, String numValor, String fecha, String horaInicio,
			String horaFin, String trazabilidadId, String infoMedidaId) {
		super();
		this.contador = contador;
		this.idMedidor = idMedidor;
		this.idConcentrador = idConcentrador;
		this.numValor = numValor;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.trazabilidadId = trazabilidadId;
		this.infoMedidaId = infoMedidaId;
	}


	public Medida() {
		super();
	}


	public int getContador() {
		return contador;
	}


	public int getId() {
		return id;
	}


	public String getIdMedidor() {
		return idMedidor;
	}


	public String getIdConcentrador() {
		return idConcentrador;
	}


	public String getNumValor() {
		return numValor;
	}


	public String getFecha() {
		return fecha;
	}


	public String getHoraInicio() {
		return horaInicio;
	}


	public String getHoraFin() {
		return horaFin;
	}


	public String getTrazabilidadId() {
		return trazabilidadId;
	}


	public String getInfoMedidaId() {
		return infoMedidaId;
	}


//	public String getSerialcnc() {
//		return serialcnc;
//	}
//
//
//	public String getSerialmet() {
//		return serialmet;
//	}
//
//
//	public String getNombreMedidas() {
//		return nombreMedidas;
//	}
//
//
//	public String getNombreReporte() {
//		return nombreReporte;
//	}
//
//
//	public String getEncabezado() {
//		return encabezado;
//	}
//

	@Override
	public String toString() {
		return "{ medida:[{"
				//+ "serialcnc:" + serialcnc + ","
				//+ "serialmet:" + serialmet + ","
				//+ "nombreMedidas:" + nombreMedidas + ","
				+ " numValor:" + numValor + ","
				+ " fecha:" + fecha + ","
				//+ " nombreReporte:" + nombreReporte + ","
				//+ " encabezado:" + encabezado + ","
				+ "	idMedidor:" + idMedidor + ","
				+ " idConcentrador:" + idConcentrador + ","
				+ " horaInicio:" + horaInicio + ","
				+ " horaFin:" + horaFin + ","
				+ " trazabilidadId:" + trazabilidadId + ","
				+ " infoMedidaId:" + infoMedidaId + "}]"
				+ "}";
	}
	
	
}