package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.EliminarInterface;

@Repository
public class EliminarDao implements EliminarInterface {
	
	@Autowired
	JdbcTemplate template;
	

	@Override
	public boolean deleteUsuario(Long id) {
		return false;
	}

	@Override
	public boolean deleteMedidor(Long id) {
		return false;
	}

	@Override
	public boolean deleteConcentrador(Long id) {
		return false;
	}

	@Override
	public boolean deleteTransformador(Long id) {
		return false;
	}

	@Override
	public boolean deleteMedidas(Long id) {
		return false;
	}

}
