package com.InpetelCloud.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ModificacionInterface;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.TipoMedidor;
import com.InpetelCloud.Model.TipoPuerto;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Repository
public class ModificacionDao implements ModificacionInterface{
	
	@Autowired
	JdbcTemplate template;

	

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
	
	@Override
	public int modificarTipoMedidor(Long id, TipoMedidor tipoMedidor) {
		int value = template.update("UPDATE Inpetel_Cloud.TipoMedidor set NombreMedidor='"+ tipoMedidor.getNombre() +  "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarTipoPuerto(Long id, TipoPuerto tipoPuerto) {
		int value = template.update("UPDATE Inpetel_Cloud.TipoPuerto set Nombre_Puerto='"+ tipoPuerto.getNombre() +  "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarEstado(Long id, Estados estado) {
		int value = template.update("UPDATE Inpetel_Cloud.Estados set Nombre_Est='"+ estado.getNombre() +  "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarTransformador(Long id, Transformador transformador) {
		int value = template.update("UPDATE Inpetel_Cloud.Transformador set Address='"+ transformador.getAddress() + "', Codigo='"+ transformador.getCodigo()+ "', Capacidad='"+ transformador.getCapacidad() + "', Nodo='"+ transformador.getNodo() + "', CargaAforada='"+ transformador.getCargaAforada() + "', TipoTrafo='"+ transformador.getTipoTrafo() + "', Concentrador_ID='"+ transformador.getConcentradorId() + "', States_ID='"+ transformador.getEstadoId() + "' where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarUsuario(Long id, Usuarios usuario) {
		int value = template.update("UPDATE Inpetel_Cloud.Usuarios set Nombres='"+usuario.getNombres()+ "', Login='"+ usuario.getLogin()+ "', Password='"+ usuario.getPassword()+ "', Password_salt='"+ usuario.getPassword_salt()+ "', Correo='"+ usuario.getCorreo()+ "', Fecha_modifica=now() ,Usu_modifica='"+ usuario.getUsuModifica()  + "' ,SistemaExteno_ID='"+ usuario.getSistemaExternoId()  + "', States_ID='"+ usuario.getEstadoId() +"'  where ID="+ id +";");
		return value;
	}

	@Override
	public int modificarFtp( Ftp f) {
		int value= template.update("UPDATE Inpetel_Cloud.FTP set Descripcion='"+f.getDescripcion()+"', EndPoint='"+f.getEndPoint()+"', Puerto='"+f.getPuerto()+"', Password='"+f.getPassword()+"', Carpeta_Entrada='"+f.getCarpeta_En()+"', Carpeta_Procesad='"+f.getCarpeta_Pr()+"', Fh_update=now(), Usu_update='"+f.getUsu_modifica()+"', Carpeta_Errores='"+f.getCarpeta_Er()+"' WHERE ID_FTP= "+f.getId()+";");
		return value;
	}

	@Override
	public int modificarConcentrador(Long id, modelConcentrator concentrador) {
		int value=0;
		List<String> marcaId = marcaConcentrador(concentrador);
		if(marcaId.get(0).equals("1") ) {
			value= template.update("UPDATE Inpetel_Cloud.Concentrador set Ip_real='"+ concentrador.getIpReal() +"', NombreConcentrador='"+concentrador.getConcentrator()+"', TipoComunicacion_ID='"+concentrador.getTipoComunicacionId()+"', Imei='"+concentrador.getImei()+"', Serial='"+concentrador.getSerial()+"', TiempoConectado_ID='"+concentrador.getTiempoConectadoId()+"', Modem_Embedido='"+concentrador.getModemEmbebidoId()+"', IOmodule='"+concentrador.getIoModule()+"', Modem_ID='"+concentrador.getModemId()+"', Marca_ID='"+marcaId.get(0)+"', pass='NA', user='NA', States_ID='"+concentrador.getEstadoId()+"'  where ID="+ id +";");
		}
		else {
			value= template.update("UPDATE Inpetel_Cloud.Concentrador set Ip_real='"+ concentrador.getIpReal() +"', NombreConcentrador='"+concentrador.getConcentrator()+"', TipoComunicacion_ID='"+concentrador.getTipoComunicacionId()+"', Imei='"+concentrador.getImei()+"', Serial='"+concentrador.getSerial()+"', TiempoConectado_ID='"+concentrador.getTiempoConectadoId()+"', Modem_Embedido='"+concentrador.getModemEmbebidoId()+"', IOmodule='"+concentrador.getIoModule()+"', Modem_ID='"+concentrador.getModemId()+"', Marca_ID='"+marcaId.get(0)+"', pass='"+concentrador.getPass()+"', user='"+concentrador.getUser()+"', States_ID='"+concentrador.getEstadoId()+"'  where ID="+ id +";");

		}
		
		return value;
	}

	@Override
	public int modificarMedidor(Long id, modelMeter medidor) {
		List<String> tipoMet = tipoMedidor(medidor);
		List<String> marcaId = marcaMedidor(medidor);
		int value= template.update("UPDATE Inpetel_Cloud.Medidor set TipoMedidor_ID='"+ tipoMet.get(0) +"', Magnitud='"+medidor.getMagnitud()+"', NumCuadrantes='"+medidor.getNumberQuadrants()+"', TipoPuerto_ID='"+medidor.getTipoPuertoId()+"', Prepago='"+medidor.getPrepago()+"', Sync_reloj='"+medidor.getSyncReloj()+"', Modelo='"+medidor.getModel()+"', Serial='"+medidor.getMeter()+"', Marca_ID='"+marcaId.get(0)+"', logicalName='"+medidor.getLogicalName()+"', States_ID='"+medidor.getEstadoId()+"'  where ID="+ id +";");
		return value;
	}
	
	public List<String> tipoMedidor(modelMeter medidor){
		List<Map<String, Object>> tipoMedidor = new ArrayList<>();
		List<Object> resultado = new ArrayList<Object>();
		List<String> tipo = new ArrayList<String>();

		String monofasico="Monofasico";
		String trifasico="Trifasico";
		String monofasicoTrifilar="Monofasico Trifilar";
		String trifasicoSemidirecta = "Trifasico Semidirecta";
		
		
		switch (medidor.getTypeMeter()) {
		case "Monofasico":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ monofasico +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Trifasico":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ trifasico +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Monofasico Trifilar":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ monofasicoTrifilar +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Trifasico Semidirecta":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ trifasicoSemidirecta +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		default:
			break;
		}
		tipo.add(resultado.get(0).toString());
		return tipo;
	}
	
	public List<String> marcaMedidor(modelMeter medidor){
		List<Map<String, Object>> tipoMedidor = new ArrayList<>();
		List<Object> resultado = new ArrayList<Object>();
		List<String> tipoMarca = new ArrayList<String>();

		String circutor="CIRCUTOR";
		String meter="METER AND CONTROL";
		String add="ADD";
		
		switch (medidor.getBrand().toUpperCase()) {
		case "CIRCUTOR":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ circutor +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "METER AND CONTROL":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ meter +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "ADD":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ add +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		default:
			break;
		}
		tipoMarca.add(resultado.get(0).toString());

		return tipoMarca;
	}
	
	
	public List<String> marcaConcentrador(modelConcentrator concentrador){
		List<Map<String, Object>> tipoConcentrador = new ArrayList<>();
		List<Object> resultado = new ArrayList<Object>();
		List<String> tipoMarca = new ArrayList<String>();

		String circutor="CIRCUTOR";
		String meter="METER AND CONTROL";
		String add="ADD";
		
		
		switch (concentrador.getBrand().toUpperCase()) {
		case "CIRCUTOR":
			tipoConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ circutor +"';");			
			for (Map<String, Object> map : tipoConcentrador) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "METER AND CONTROL":
			tipoConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ meter +"';");			
			for (Map<String, Object> map : tipoConcentrador) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "ADD":
			tipoConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ add +"';");			
			for (Map<String, Object> map : tipoConcentrador) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		default:
			break;
		}
		tipoMarca.add(resultado.get(0).toString());

		return tipoMarca;
	}

	@Override
	public int modificarMedidorVista(Long id, modelMeter medidor) {
		List<String> tipoMet = tipoMedidor(medidor);
		List<String> marcaId = marcaMedidor(medidor);
		int value= template.update("UPDATE Inpetel_Cloud.Medidor set TipoMedidor_ID='"+ tipoMet.get(0) +"', Magnitud='"+medidor.getMagnitud()+"', NumCuadrantes='"+medidor.getNumberQuadrants()+"', TipoPuerto_ID='"+medidor.getTipoPuertoId()+"', Prepago='"+medidor.getPrepago()+"', Sync_reloj='"+medidor.getSyncReloj()+"', Modelo='"+medidor.getModel()+"', Serial='"+medidor.getMeter()+"', Marca_ID='"+marcaId.get(0)+"',States_ID='"+medidor.getEstadoId()+"'  where ID="+ id +";");
		return value;
	}

	


}
