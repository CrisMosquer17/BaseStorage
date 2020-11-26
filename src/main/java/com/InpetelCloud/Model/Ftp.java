package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Ftp {

	@Id
	private int id;
	private String descripcion;
	private String EndPoint;
	private String puerto;
	private String Usuario;
	private String password;
	private String Carpeta_En;
	private String Carpeta_Pr;
	private String Usu_crea;
	private String Usu_modifica;
	private String Carpeta_Er;
	
	public Ftp() {
		super();
	}

	public Ftp(int id, String descripcion, String endPoint, String puerto, String usuario, String password,
			String carpeta_En, String carpeta_Pr, String usu_crea, String usu_modifica, String carpeta_Er) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		EndPoint = endPoint;
		this.puerto = puerto;
		Usuario = usuario;
		this.password = password;
		Carpeta_En = carpeta_En;
		Carpeta_Pr = carpeta_Pr;
		Usu_crea = usu_crea;
		Usu_modifica = usu_modifica;
		Carpeta_Er = carpeta_Er;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEndPoint() {
		return EndPoint;
	}

	public void setEndPoint(String endPoint) {
		EndPoint = endPoint;
	}

	public String getPuerto() {
		return puerto;
	}

	public void setPuerto(String puerto) {
		this.puerto = puerto;
	}

	public String getUsuario() {
		return Usuario;
	}

	public void setUsuario(String usuario) {
		Usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCarpeta_En() {
		return Carpeta_En;
	}

	public void setCarpeta_En(String carpeta_En) {
		Carpeta_En = carpeta_En;
	}

	public String getCarpeta_Pr() {
		return Carpeta_Pr;
	}

	public void setCarpeta_Pr(String carpeta_Pr) {
		Carpeta_Pr = carpeta_Pr;
	}

	public String getUsu_crea() {
		return Usu_crea;
	}

	public void setUsu_crea(String usu_crea) {
		Usu_crea = usu_crea;
	}

	public String getUsu_modifica() {
		return Usu_modifica;
	}

	public void setUsu_modifica(String usu_modifica) {
		Usu_modifica = usu_modifica;
	}

	public String getCarpeta_Er() {
		return Carpeta_Er;
	}

	public void setCarpeta_Er(String carpeta_Er) {
		Carpeta_Er = carpeta_Er;
	}
	
	

}
