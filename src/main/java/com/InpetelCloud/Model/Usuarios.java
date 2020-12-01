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
	
	
	
		
	public Usuarios() {
		super();
	}

	public Usuarios(int id, String nombres, String login, String password, String password_salt, String correo,
			String fechaCreate, String fechaModifica, int sistemaExternoId) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.login = login;
		this.password = password;
		this.password_salt = password_salt;
		this.correo = correo;
		this.fechaCreate = fechaCreate;
		this.fechaModifica = fechaModifica;
		this.sistemaExternoId = sistemaExternoId;
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
	
	
	
	
	
	

	

}
