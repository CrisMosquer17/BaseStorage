package com.InpetelCloud.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.ConsultasDao;
import com.InpetelCloud.Interfaces.ConsultasInterface;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
@Service
public class ConsultasService implements ConsultasInterface {

	@Autowired
	ConsultasDao dao;
	
	
    private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<Map<String, Object>> Usuarios() {
		return dao.Usuarios();
	}

	@Override
	public List<Map<String, Object>> Concentradores() {
		return dao.Concentradores();
	}
	@Override
	public List<Map<String, Object>> verConcentradorIndividual(Long id) {
		List<Map<String, Object>> concentradores = dao.verConcentradorIndividual(id);
		if(concentradores.size()>0) {
			return concentradores;
		}
		else {
			log.info("no hay ningun concentrador con ese id ");
		return concentradores;
	}
	}

	@Override
	public List<Map<String, Object>> Medidores() {
		return dao.Medidores();
	}
	
	@Override
	public List<Map<String, Object>> verMedidorIndividual(Long id) {
		List<Map<String, Object>> medidores = dao.verMedidorIndividual(id);
		if(medidores.size()>0) {
			return medidores;
		}
		else {
			log.info("no hay ningun medidor con ese id ");
		return medidores;
	}
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
	public List<Map<String, Object>> Marcas(String id) {
		return dao.Marcas(id);
	}

	@Override
	public List<Map<String, Object>> TecnologiasComponentes() {
		return dao.TecnologiasComponentes();
	}
	
	@Override
	public List<Map<String, Object>> TecnologiasComponentes(String id) {
		return dao.TecnologiasComponentes(id);
	}

	@Override
	public List<Map<String, Object>> Modems() {
		return dao.Modems();
	}
	
	@Override
	public List<Map<String, Object>> verModemIndividual(Long id) {
		List<Map<String, Object>> modems = dao.verModemIndividual(id);
		if(modems.size()>0) {
			return modems;
		}
		else {
			log.info("no hay ningun modem con ese id ");
		return modems;
	}
		
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
	public List<Map<String, Object>> verTransformadorIndividual(Long id) {
		List<Map<String, Object>> transformadores = dao.verTransformadorIndividual(id);
		if(transformadores.size()>0) {
			return transformadores;
		}
		else {
			log.info("no hay ningun transformador con ese id ");
		return transformadores;
	}
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
		u.setPassword(DigestUtils.md5Hex(DigestUtils.md5Hex(u.getPassword())));
		return dao.login(u);
	}

	@Override

	public List<Map<String, Object>> medidoresNoAsociados() {
		return dao.medidoresNoAsociados();
	}

	public boolean MUnRepeat(Modem m) {
		return dao.MUnRepeat(m);
	}

	@Override
	public boolean Concentradores(modelConcentrator cnc) {
		return dao.Concentradores(cnc);
	}

	@Override
	public boolean Medidores(modelMeter met) {
		return dao.Medidores(met);
	}

	@Override
	public boolean Transformadores(Transformador tf) {
		return dao.Transformadores(tf);
	}
		
	
}
