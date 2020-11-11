package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.InsercionDao;
import com.InpetelCloud.Interfaces.InsercionInterface;
import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Service
public class InsercionService implements InsercionInterface {
	
	@Autowired
	InsercionDao dao;

	@Override
	public Medidor saveMedidor(Medidor medidor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Concentrador saveConcentrador(Concentrador concentrador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transformador saveTransformador(Transformador transformador) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuarios saveUsuario(Usuarios usuario) {
		// TODO Auto-generated method stub
		return null;
	}

}
