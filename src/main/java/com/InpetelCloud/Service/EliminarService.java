package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.EliminarDao;
import com.InpetelCloud.Interfaces.EliminarInterface;
import com.InpetelCloud.Model.SistemExterno;


@Service
public class EliminarService implements EliminarInterface {
	
	@Autowired
	EliminarDao dao;

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

	@Override
	public int eliminarSistemaExterno(Long id) {
		return dao.eliminarSistemaExterno(id);
	}

}
