package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.EliminarDao;
import com.InpetelCloud.Interfaces.EliminarInterface;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;


@Service
public class EliminarService implements EliminarInterface {
	
	@Autowired
	EliminarDao dao;

	@Override
	public int eliminarSistemaExterno( SistemExterno se, Long id) {
		return dao.eliminarSistemaExterno(se,id);
	}
	
	@Override
	public int eliminarRol(Long id) {
		return dao.eliminarRol(id);
	}

	@Override
	public int eliminarMarca(Long id, String nombre) {
		return dao.eliminarMarca(id, nombre);
	}

	@Override
	public int eliminarTeconologiaComponente(Long id) {
		return dao.eliminarTeconologiaComponente(id);
	}

	@Override
	public int eliminarModem(Long id) {
		return dao.eliminarModem(id);
	}

	@Override
	public int eliminarTipoComunicacion(Long id) {
		return dao.eliminarTipoComunicacion(id);
	}

	@Override
	public int eliminarTiempoConectado(Long id) {
		return dao.eliminarTiempoConectado(id);
	}

	@Override
	public int eliminarTipoMedidor(Long id) {
		return dao.eliminarTipoMedidor(id);
	}

	@Override
	public int eliminarTipoPuerto(Long id) {
		return dao.eliminarTipoPuerto(id);
	}

	@Override
	public int eliminarEstado(Long id) {
		return dao.eliminarEstado(id);
	}

	@Override
	public int eliminarTransformador(Transformador transformador, Long id) {
		return dao.eliminarTransformador(transformador, id);
	}

	@Override
	public int eliminarUsuario(Long id) {
		return dao.eliminarUsuario(id);
	}

	@Override
	public int eliminarMedidor(modelMeter medidor,Long id) {
		return dao.eliminarMedidor(medidor, id);
	}

	@Override
	public int eliminarConcentrador(modelConcentrator concentrador, Long id) {
		return dao.eliminarConcentrador(concentrador, id);
	}

	@Override
	public int eliminarMacro(Long id) {
		return dao.eliminarMacro(id);
	}


}
