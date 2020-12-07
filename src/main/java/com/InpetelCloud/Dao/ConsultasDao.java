package com.InpetelCloud.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ConsultasInterface;

@Repository
public class ConsultasDao implements ConsultasInterface{

	@Autowired
	JdbcTemplate template;

	@Override
	public List<Map<String, Object>> Usuarios() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Usuarios");
		return view;
	}

	@Override
	public List<Map<String, Object>> Concentradores() {
		List<Map<String, Object>> view = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador");
		return view;
	}

	@Override
	public List<Map<String, Object>> Medidores() {
		List<Map<String, Object>> view = template.queryForList("SELECT * FROM Inpetel_Cloud.Medidor");
		return view;
	}

	@Override
	public List<Map<String, Object>> Medidas() {
		List<Map<String, Object>> view = template.queryForList("SELECT * FROM Inpetel_Cloud.Medidas");
		return view;
	}

	@Override
	public List<Map<String, Object>> SistemasExternos() {
		List<Map<String, Object>> view = template.queryForList("SELECT * FROM Inpetel_Cloud.SistemaExteno");
		return view;
	}

	@Override
	public List<Map<String, Object>> Roles() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Roles");
		return view;
	}

	@Override
	public List<Map<String, Object>> Marcas() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Marca");
		return view;
	}

	@Override
	public List<Map<String, Object>> TecnologiasComponentes() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TecnologiaComponente");
		return view;
	}

	@Override
	public List<Map<String, Object>> Modems() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Modem");
		return view;
	}

	@Override
	public List<Map<String, Object>> TiposComunicacion() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TipoComunicacion");
		return view;
	}

	@Override
	public List<Map<String, Object>> TiemposConectado() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TiempoConectado");
		return view;
	}

	@Override
	public List<Map<String, Object>> TiposMedidor() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TipoMedidor");
		return view;
	}

	@Override
	public List<Map<String, Object>> TiposPuerto() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TipoPuerto");
		return view;
	}

	@Override
	public List<Map<String, Object>> Estados() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Estados");
		return view;
	}

	@Override
	public List<Map<String, Object>> Transformadores() {
		List<Map<String, Object>> view = template.queryForList("SELECT * FROM Inpetel_Cloud.Transformador");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> Ftps() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.FTP");
		return view;
	}

	@Override
	public boolean validarSerialConcentrador(String cnc) {
		return false;
	}
	
	public List<Map<String,Object>> serialConcentradores(){
		List<Map<String,Object>>medidores = template.queryForList("SELECT Serial FROM Inpetel_Cloud.Concentrador");
		return medidores;
	}
	
	public List<Map<String,Object>> serialMedidores(){
		List<Map<String,Object>>medidores = template.queryForList("SELECT Serial FROM Inpetel_Cloud.Medidor");
		return medidores;
	}

	@Override
	public boolean validarSerialMedidor(String met) {
		return false;
	}
}
