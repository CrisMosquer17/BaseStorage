package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ModificacionInterface;
import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Repository
public class ModificacionDao implements ModificacionInterface{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public Usuarios updateUser(Long id, Usuarios usuario) {
		return null;
	}

	@Override
	public Medidor updateMedidor(Long id, Medidor medidor) {
		return null;
	}

	@Override
	public Concentrador updateConcentrador(Long id, Concentrador concentrador) {
		return null;
	}

	@Override
	public Transformador updateTransformador(Long id, Transformador transformador) {
		return null;
	}

}
