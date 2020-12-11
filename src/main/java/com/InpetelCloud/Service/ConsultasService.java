package com.InpetelCloud.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.ConsultasDao;
import com.InpetelCloud.Interfaces.ConsultasInterface;
import com.InpetelCloud.Model.Usuarios;
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

	@Override
	public boolean validarSerialConcentrador(String cnc) {
		boolean resultado = false;
		List<String> serialesConcentradores = new ArrayList<String>();
		List<Map<String, Object>> concentradores = dao.serialConcentradores();
		for (Map<String, Object> map : concentradores) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				serialesConcentradores.add((String) value);
			}
		}
		for (int i = 0; i < serialesConcentradores.size(); i++) {
			if (serialesConcentradores.get(i).equals(cnc)) {
				resultado = true;
			}
		}
		return resultado;
	}

	@Override
	public boolean validarSerialMedidor(String met) {
		boolean resultado = false;
		List<String> serialesMedidores = new ArrayList<String>();
		// dao.serialMedidores: se trae todos los seriales de los medidores que estan en
		// la base de datos
		List<Map<String, Object>> medidores = dao.serialMedidores();
		for (Map<String, Object> map : medidores) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				serialesMedidores.add((String) value);
			}
		}
		for (int i = 0; i < serialesMedidores.size(); i++) {
			if (serialesMedidores.get(i).equals(met)) {
				resultado = true;
			}
		}
		return resultado;
	}

	@Override
	public List<Map<String, Object>> cncSerial(String cnsS) {
		return dao.cncSerial(cnsS);
	}

	@Override
	public List<Map<String, Object>> metSerial(String metS) {
		return dao.metSerial(metS);
	}

	@Override
	public boolean login(Usuarios u) {
		return false;
	}
	
	
	
}
