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

	/*@Override
	public boolean deleteMedidor(Long id) {
		return false;
	}*/

	/*@Override
	public boolean deleteConcentrador(Long id) {
		return false;
	}*/


	/*@Override
	public boolean deleteMedidas(Long id) {
		return false;
	}*/

	@Override
	public int eliminarSistemaExterno(Long id) {
		return dao.eliminarSistemaExterno(id);
	}
	
	@Override
	public int eliminarRol(Long id) {
		return dao.eliminarRol(id);
	}

	@Override
	public int eliminarMarca(Long id) {
		return dao.eliminarMarca(id);
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
	public int eliminarTransformador(Long id) {
		return dao.eliminarTransformador(id);
	}

	@Override
	public int eliminarUsuario(Long id) {
		return dao.eliminarUsuario(id);
	}


}
