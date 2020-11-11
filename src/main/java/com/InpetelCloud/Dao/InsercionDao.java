package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.InsercionInterface;
import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Repository
public class InsercionDao implements InsercionInterface{
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public Usuarios saveUsuario(Usuarios usuario) {
		return null;
	}

	@Override
	public Medidor saveMedidor(Medidor medidor) {
		return null;
	}

	@Override
	public Concentrador saveConcentrador(Concentrador concentrador) {
		return null;
	}

	@Override
	public Transformador saveTransformador(Transformador transformador) {
		return null;
	}

	

}
