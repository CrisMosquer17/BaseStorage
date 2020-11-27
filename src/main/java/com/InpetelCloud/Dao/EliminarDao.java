package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.EliminarInterface;

@Repository
public class EliminarDao implements EliminarInterface {
	
	@Autowired
	JdbcTemplate template;
	

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
		int value = template.update("UPDATE Inpetel_Cloud.SistemaExteno set States_ID = 2 where ID="+ id +";");
		return value;
	}
	
	@Override
	public int eliminarRol(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.Roles where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarMarca(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.Marca where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarTeconologiaComponente(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.TecnologiaComponente where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarModem(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.Modem where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarTipoComunicacion(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.TipoComunicacion where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarTiempoConectado(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.TiempoConectado where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarTipoMedidor(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.TipoMedidor where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarTipoPuerto(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.TipoPuerto where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarEstado(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.Estados where ID="+ id +";");
		return value;
	}


}
