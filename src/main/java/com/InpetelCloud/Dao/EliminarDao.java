package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.EliminarInterface;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;

@Repository
public class EliminarDao implements EliminarInterface {
	
	@Autowired
	JdbcTemplate template;

	@Override
	public int eliminarSistemaExterno(SistemExterno se, Long id) {
		int value = 0;
		if(se.getObservacion().equals("")) {
			System.out.println(value);
			return value;
		}else {
			value = template.update("UPDATE Inpetel_Cloud.SistemaExteno set States_ID = 2 where ID="+ id +";");
			}
		return value;
	}
	
	@Override
	public int eliminarRol(Long id) {
		int value = template.update("DELETE FROM  Inpetel_Cloud.Roles where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarMarca(Long id, String nombre) {
		int value = template.update("DELETE FROM Inpetel_Cloud.Marca where ID="+ id +" and Nombre_Marca='"+nombre+"';");
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

	@Override
	public int eliminarTransformador(Transformador transformador, Long id) {
		int value;
		if(transformador.getObservacion().equals("")) {
			value=0;
		}
		else {
			 value = template.update("UPDATE Inpetel_Cloud.Transformador set States_ID =2, Observacion='"+ transformador.getObservacion() + "' where ID="+ id +";");
			}
		return value;
	}

	@Override
	public int eliminarUsuario(Long id) {
		int value = template.update("UPDATE Inpetel_Cloud.Usuarios set States_ID =3 where ID="+ id +";");
		return value;
	}

	@Override
	public int eliminarMedidor(modelMeter medidor, Long id) {
		int value;
		if(medidor.getObservacion().equals("")) {
			value=0;
		}
		else {
			value = template.update("UPDATE Inpetel_Cloud.Medidor set States_ID =2, Observacion='"+ medidor.getObservacion() + "' where ID="+ id +";");
			}

		return value;
	}

	@Override
	public int eliminarConcentrador(modelConcentrator concentrador, Long id) {
		int value=0;
		if(concentrador.getObservacion().equals("")) {
			value=0;
		}
		else {
			value = template.update("UPDATE Inpetel_Cloud.Concentrador set States_ID =2, Observacion='"+ concentrador.getObservacion() + "' where ID="+ id +";");
			}
		return value;
	}


}
