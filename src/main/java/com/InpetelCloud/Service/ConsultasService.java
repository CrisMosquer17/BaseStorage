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

	@Override
	public List<Map<String, Object>> Roles() {
		return dao.Roles();
	}

	@Override
	public List<Map<String, Object>> Marcas() {
		return dao.Marcas();
	}

	@Override
	public List<Map<String, Object>> TecnologiasComponentes() {
		return dao.TecnologiasComponentes();
	}

	@Override
	public List<Map<String, Object>> Modems() {
		return dao.Modems();
	}

	@Override
	public List<Map<String, Object>> TiposComunicacion() {
		return dao.TiposComunicacion();
	}

	@Override
	public List<Map<String, Object>> TiemposConectado() {
		return dao.TiemposConectado();
	}

	@Override
	public List<Map<String, Object>> TiposMedidor() {
		return dao.TiposMedidor();
	}

	@Override
	public List<Map<String, Object>> TiposPuerto() {
		return dao.TiposPuerto();
	}

	@Override
	public List<Map<String, Object>> Estados() {
		return dao.Estados();
	}

	@Override
	public List<Map<String, Object>> Transformadores() {
		return dao.Transformadores();
	}

	@Override
	public List<Map<String, Object>> Ftps() {
		return dao.Ftps();
	}
	
	
	
}
