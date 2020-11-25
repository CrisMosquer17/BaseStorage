package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ModificacionInterface;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Repository
public class ModificacionDao implements ModificacionInterface{
	
	@Autowired
	JdbcTemplate template;

	@Override
	public Usuarios updateUser(Long id, Usuarios usuario) {
		return null;
	}

	/*@Override
	public Medidor updateMedidor(Long id, Medidor medidor) {
		return null;
	}*/

	/*@Override
	public Concentrador updateConcentrador(Long id, Concentrador concentrador) {
		return null;
	}*/

	@Override
	public Transformador updateTransformador(Long id, Transformador transformador) {
		return null;
	}

	@Override
	public int modificarSistemaExterno(Long id, SistemExterno se) {
		int value = template.update("UPDATE Inpetel_Cloud.SistemaExteno set Nit='"+ se.getNit() + "', Telefono_SE='"+ se.getTelefono() + "', Direccion_SE='"+ se.getDireccion() + "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarRol(Long id, Rol rol) {
		int value = template.update("UPDATE Inpetel_Cloud.Roles set Nombre_Rol='"+ rol.getNombre() + "', Descripcion_Rol='"+ rol.getDescripcion() + "', States_ID='"+ rol.getEstadoId() + "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarMarca(Long id, Marca marca) {
		int value = template.update("UPDATE Inpetel_Cloud.Marca set Nombre_Marca='"+ marca.getNombre() + "', TecnologiaComponente_ID='"+ marca.getTecnologiaComponenteId() +  "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarTecnologiaComponente(Long id, TecnologiaComponente tecnologiaComponente) {
		int value = template.update("UPDATE Inpetel_Cloud.TecnologiaComponente set Nombre_Tecnologia='"+ tecnologiaComponente.getNombre() + "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarModem(Long id, Modem modem) {
		int value = template.update("UPDATE Inpetel_Cloud.Modem set Serial='"+ modem.getSerial() + "', Nombre='"+ modem.getNombre() + "', Imei='"+ modem.getImei() + "', Marca='"+ modem.getMarca() + "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarTipoComunicacion(Long id, TipoComunicacion tipoComunicacion) {
		int value = template.update("UPDATE Inpetel_Cloud.TipoComunicacion set Nombre='"+ tipoComunicacion.getNombre() + "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarTiempoConectado(Long id, TiempoConectado tiempoConectado) {
		int value = template.update("UPDATE Inpetel_Cloud.TiempoConectado set ComStatus='"+ tiempoConectado.getComStatus() + "', Descripcion='"+ tiempoConectado.getDescripcion() + "' where ID="+ id +";");
		return value;
	}

	


}
