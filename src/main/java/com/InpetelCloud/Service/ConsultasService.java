package com.InpetelCloud.Service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.ConsultasDao;
import com.InpetelCloud.Interfaces.ConsultasInterface;

@Service
public class ConsultasService implements ConsultasInterface {

	@Autowired
	ConsultasDao dao;

	@Override
	public List<Map<String, Object>> Usuarios() {
		return dao.Usuarios();
	}

	@Override
	public List<Map<String, Object>> Concentradores() {
		return dao.Concentradores();
	}

	@Override
	public List<Map<String, Object>> Transformadores() {
		return dao.Transformadores();
	}

	@Override
	public List<Map<String, Object>> Medidores() {
		return dao.Medidores();
	}

	@Override
	public List<Map<String, Object>> Medidas() {
		return dao.Medidas();
	}

	@Override
	public List<Map<String, Object>> SistemasExternos() {
		return dao.SistemasExternos();
	}
	
	
}
