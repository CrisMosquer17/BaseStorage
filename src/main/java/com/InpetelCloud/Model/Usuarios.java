package com.InpetelCloud.Model;

import javax.persistence.Id;

public class Usuarios {
	
	@Id
	private int id;
	private String nombres;
	private String login;
	private String password;
	private String password_salt;
	private String correo;
	private String fechaCreate;
	private String fechaModifica;
	private int sistemaExternoId;
	private String estadoId;
	private String usuCrea;
	private String usuModifica;
	
	
	public Usuarios() {
		super();
	}

	//CREATE
	public Usuarios(String nombres, String login, String password, String password_salt, String correo,
			int sistemaExternoId, String estadoId, String usuCrea) {
		super();
		this.nombres = nombres;
		this.login = login;
		this.password = password;
		this.password_salt = password_salt;
		this.correo = correo;
		this.sistemaExternoId = sistemaExternoId;
		this.estadoId = estadoId;
		this.usuCrea = usuCrea;
	}
	
	//UPDATE
	public Usuarios(int id, String nombres, String login, String password, String password_salt, String correo,
			int sistemaExternoId, String estadoId, String usuModifica) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.login = login;
		this.password = password;
		this.password_salt = password_salt;
		this.correo = correo;
		this.sistemaExternoId = sistemaExternoId;
		this.estadoId = estadoId;
		this.usuModifica = usuModifica;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) { 
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword_salt() {
		return password_salt;
	}

	public void setPassword_salt(String password_salt) {
		this.password_salt = password_salt;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getFechaCreate() {
		return fechaCreate;
	}

	public void setFechaCreate(String fechaCreate) {
		this.fechaCreate = fechaCreate;
	}

	public String getFechaModifica() {
		return fechaModifica;
	}

	public void setFechaModifica(String fechaModifica) {
		this.fechaModifica = fechaModifica;
	}

	public int getSistemaExternoId() {
		return sistemaExternoId;
	}

	public void setSistemaExternoId(int sistemaExternoId) {
		this.sistemaExternoId = sistemaExternoId;
	}

	public String getEstadoId() {
		return estadoId;
	}

	public void setEstadoId(String estadoId) {
		this.estadoId = estadoId;
	}

	public String getUsuCrea() {
		return usuCrea;
	}

	public void setUsuCrea(String usuCrea) {
		this.usuCrea = usuCrea;
	}

	public String getUsuModifica() {
		return usuModifica;
	}

	public void setUsuModifica(String usuModifica) {
		this.usuModifica = usuModifica;
	}
	
	
	
	
	
	

	

}
