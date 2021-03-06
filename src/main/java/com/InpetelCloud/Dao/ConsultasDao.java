package com.InpetelCloud.Dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ConsultasInterface;
import com.InpetelCloud.Model.Macro;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
@Repository
public class ConsultasDao implements ConsultasInterface{

	@Autowired
	JdbcTemplate template;
	
	@Override
	public List<Map<String, Object>> Concentradores() {
		List<Map<String, Object>> view = template.queryForList("SELECT c.ID,c.Ip_real, NombreConcentrador,\r\n"
				+ "(SELECT tp.Nombre FROM Inpetel_Cloud.TipoComunicacion tp WHERE tp.ID = c.TipoComunicacion_ID)Comunicacion,\r\n"
				+ "c.Imei,\r\n"
				+ "c.Serial,\r\n"
				+ "(SELECT tc.ComStatus FROM Inpetel_Cloud.TiempoConectado tc WHERE tc.ID = c.TiempoConectado_ID)Conectado,\r\n"
				+ "c.Modem_Embedido,\r\n"
				+ "c.IOmodule,\r\n"
				+ "c.Modem_ID,\r\n"
				+ "(SELECT m.Imei FROM Inpetel_Cloud.Modem m WHERE m.ID = c.Modem_ID )ModemImei,\r\n"
				+ "(SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = c.Marca_ID)Marca,\r\n"
				+ "c.Marca_ID,\r\n"
				+ "(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = c.Marca_ID)Tecnologia,\r\n"
				+ "c.user, c.pass, c.States_ID,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = c.States_ID)Estado,\r\n"
				+ "c.Observacion\r\n"
				+ "FROM Inpetel_Cloud.Concentrador c;");
		return view;
	}

	@Override
	public List<Map<String, Object>> Usuarios() {
		List<Map<String,Object>>view = template.queryForList("SELECT usu.ID, usu.Nombres, usu.Login, usu.Password, usu.Password_salt, usu.Correo, usu.Fecha_crea, usu.Usu_crea, usu.Fecha_modifica, usu.Usu_modifica,\r\n"
				+ "(SELECT se.Nombre_SE FROM Inpetel_Cloud.SistemaExteno se WHERE se.ID = usu.SistemaExteno_ID)NombreSistemaExterno,\r\n"
				+ "usu.SistemaExteno_ID,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = usu.States_ID)Estado,\r\n"
				+ "usu.States_ID\r\n"
				+ "FROM Inpetel_Cloud.Usuarios usu;");
		return view;
	}
	
	@Override
	public boolean Usuarios(Usuarios usu) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.Usuarios WHERE Correo = '"+ usu.getCorreo()+"' OR Login = '"+usu.getLogin()+"';").size()>0;

	}
	
	@Override
	public List<Map<String, Object>> verUsuarioIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList ("SELECT usu.ID, usu.Nombres, usu.Login, usu.Password, usu.Password_salt, usu.Correo, usu.Fecha_crea, usu.Usu_crea, usu.Fecha_modifica, usu.Usu_modifica,\r\n"
				+ "(SELECT se.Nombre_SE FROM Inpetel_Cloud.SistemaExteno se WHERE se.ID = usu.SistemaExteno_ID)NombreSistemaExterno,\r\n"
				+ "usu.SistemaExteno_ID,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = usu.States_ID)Estado,\r\n"
				+ "usu.States_ID\r\n"
				+ "FROM Inpetel_Cloud.Usuarios usu WHERE ID='"+id+"';" );
		return view;
	}

	
	
	@Override
	public boolean Concentradores(modelConcentrator cnc) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador WHERE NombreConcentrador = '"+cnc.getConcentrator()+"' OR Serial ='"+cnc.getSerial()+"' OR Imei='"+cnc.getImei()+"' OR Ip_real= '"+cnc.getIpReal()+"';").size()>0;
	}

	
	@Override
	public List<Map<String, Object>> verConcentradorIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList("SELECT c.ID,c.Ip_real, NombreConcentrador,\r\n"
				+ "(SELECT tp.Nombre FROM Inpetel_Cloud.TipoComunicacion tp WHERE tp.ID = c.TipoComunicacion_ID)Comunicacion,\r\n"
				+ "c.Imei,\r\n"
				+ "c.Serial,\r\n"
				+ "(SELECT tc.ComStatus FROM Inpetel_Cloud.TiempoConectado tc WHERE tc.ID = c.TiempoConectado_ID)Conectado,\r\n"
				+ "c.Modem_Embedido,\r\n"
				+ "c.IOmodule,\r\n"
				+ "c.Modem_ID,\r\n"
				+ "(SELECT m.Imei FROM Inpetel_Cloud.Modem m WHERE m.ID = c.Modem_ID )ModemImei,\r\n"
				+ "(SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = c.Marca_ID)Marca,\r\n"
				+ "c.Marca_ID,\r\n"
				+ "(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = c.Marca_ID)Tecnologia,\r\n"
				+ "c.user, c.pass, c.States_ID,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = c.States_ID)Estado,\r\n"
				+ "c.Observacion\r\n"
				+ "FROM Inpetel_Cloud.Concentrador c where ID="+ id +"\r\n"
				+ "ORDER BY ID ASC;") ;
		return view;
	}

	@Override
	public List<Map<String, Object>> Medidores() {
		List<Map<String, Object>> view = template.queryForList("SELECT m.ID,\r\n"
				+ "				 (SELECT tm.NombreMedidor FROM Inpetel_Cloud.TipoMedidor tm WHERE tm.ID = m.TipoMedidor_ID)TipoMET,\r\n"
				+ "				 m.Magnitud, m.NumCuadrantes,\r\n"
				+ "				 (SELECT tp.Nombre_Puerto FROM Inpetel_Cloud.TipoPuerto tp WHERE tp.ID = m.TipoPuerto_ID)Puerto,\r\n"
				+ "				 m.Prepago, m.Sync_reloj, m.Modelo, m.Serial,\r\n"
				+ "				 (SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = m.Marca_ID)Marca,\r\n"
				+ "				(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "				 WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = m.Marca_ID)Tecnologia,\r\n"
				+ "				 m.logicalName, m.States_ID,\r\n"
				+ "                 (SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = m.States_ID)Estado,\r\n"
				+ "                 m.Observacion\r\n"
				+ "				  FROM Inpetel_Cloud.Medidor m;");
		return view;
	}
	
	@Override
	public boolean Medidores(modelMeter met) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.Medidor WHERE Serial = '"+ met.getMeter()+"'; ").size()>0;
	}

	
	@Override
	public List<Map<String, Object>> verMedidorIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList(" SELECT m.ID,\r\n"
				+ "				 (SELECT tm.NombreMedidor FROM Inpetel_Cloud.TipoMedidor tm WHERE tm.ID = m.TipoMedidor_ID)TipoMET,\r\n"
				+ "				 m.Magnitud, m.NumCuadrantes,\r\n"
				+ "				 (SELECT tp.Nombre_Puerto FROM Inpetel_Cloud.TipoPuerto tp WHERE tp.ID = m.TipoPuerto_ID)Puerto,\r\n"
				+ "				 m.Prepago, m.Sync_reloj, m.Modelo, m.Serial,\r\n"
				+ "				 (SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = m.Marca_ID)Marca,\r\n"
				+ "				(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "				 WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = m.Marca_ID)Tecnologia,\r\n"
				+ "				 m.logicalName, m.States_ID,\r\n"
				+ "                 (SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = m.States_ID)Estado,\r\n"
				+ "                 m.Observacion\r\n"
				+ "				  FROM Inpetel_Cloud.Medidor m where ID="+ id +"\r\n"
				+ " ORDER BY ID ASC;") ;
		return view;
	}

	@Override
	public List<Map<String, Object>> Medidas() {
		List<Map<String, Object>> view = template.queryForList("SELECT * FROM Inpetel_Cloud.Medidas");
		return view;
	}

	@Override
	public List<Map<String, Object>> SistemasExternos() {
		List<Map<String, Object>> view = template.queryForList("SELECT se.ID, se.Nit, se.Nombre_SE, se.Telefono_SE, se.Direccion_SE, se.Tipo_SistemaExterno_ID,\r\n"
				+ "(SELECT ts.Nombre_TSE FROM Inpetel_Cloud.Tipo_SistemaExterno ts WHERE ts.ID = se.Tipo_SistemaExterno_ID)TipoSistemaExterno,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = se.States_ID)Estado,\r\n"
				+ "se.States_ID\r\n"
				+ "FROM Inpetel_Cloud.SistemaExteno se;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> verSistemaExternoIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList("SELECT se.ID, se.Nit, se.Nombre_SE, se.Telefono_SE, se.Direccion_SE, se.Tipo_SistemaExterno_ID,\r\n"
				+ "(SELECT ts.Nombre_TSE FROM Inpetel_Cloud.Tipo_SistemaExterno ts WHERE ts.ID = se.Tipo_SistemaExterno_ID)TipoSistemaExterno,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = se.States_ID)Estado,\r\n"
				+ "se.States_ID\r\n"
				+ "FROM Inpetel_Cloud.SistemaExteno se where ID="+ id +"\r\n;");
		return view;
	}
	
	@Override
	public boolean SistemasExternos(SistemExterno se) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.SistemaExteno WHERE Nit = '"+ se.getNit()+"'; ").size()>0;

	}


	@Override
	public List<Map<String, Object>> Roles() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Roles");
		return view;
	}

	@Override
	public List<Map<String, Object>> Marcas() {
		List<Map<String,Object>>view = template.queryForList("SELECT ma.ID, ma.Nombre_Marca, ma.TecnologiaComponente_ID,\r\n"
				+ "(SELECT tp.Nombre_Tecnologia FROM Inpetel_Cloud.TecnologiaComponente tp WHERE tp.ID = ma.TecnologiaComponente_ID)Tecnologia\r\n"
				+ "from Inpetel_Cloud.Marca ma;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> Marcas(String id) {
		List<Map<String, Object>>view = template.queryForList("SELECT ma.ID, ma.Nombre_Marca, ma.TecnologiaComponente_ID,\r\n"
				+ "(SELECT tp.Nombre_Tecnologia FROM Inpetel_Cloud.TecnologiaComponente tp WHERE tp.ID = ma.TecnologiaComponente_ID)Tecnologia\r\n"
				+ "from Inpetel_Cloud.Marca ma\r\n"
				+ "WHERE ID = '"+id +"';");
		return view;
	}

	@Override
	public List<Map<String, Object>> TecnologiasComponentes() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TecnologiaComponente;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> TecnologiasComponentes(String id) {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TecnologiaComponente WHERE ID='"+id+"'");
		return view;
	}

	@Override
	public List<Map<String, Object>> Modems() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Modem");
		return view;
	}
	
	public List<Map<String, Object>> verModemIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Modem where ID="+ id +";");
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
	public List<Map<String, Object>> CortesReconeccion() {
		List<Map<String,Object>>view = template.queryForList("SELECT\r\n"
				+ "IC.Ip_real,IC.user,IC.pass,ACM.ID,\r\n"
				+ "IM.ID as IDMETER,IM.Serial as METER,IM.logicalName,IM.Marca_ID,\r\n"
				+ "IR.Valor_envio,IR.ID IDPETICION,IC.Serial,IC.NombreConcentrador,IC.version\r\n"
				+ "FROM\r\n"
				+ "Inpetel_Cloud.Corte_Reconeccion IR,Inpetel_Cloud.Concentrador IC,Inpetel_Cloud.Medidor IM,\r\n"
				+ "Inpetel_Cloud.Asoc_concen_medidor ACM  WHERE\r\n"
				+ "IR.ID_Met=IM.ID AND IR.Estado_Peticion=1 AND ACM.Concentrador_ID=IC.ID AND ACM.Medidor_ID=IM.ID;");
		return view;
	}

	@Override
	public List<Map<String, Object>> Transformadores() {
		List<Map<String, Object>> view = template.queryForList("select tf.ID, tf.Address, tf.Codigo, tf.Capacidad, tf.Nodo, tf.CargaAforada,\r\n"
				+ "(SELECT tp.NombreTrafo FROM Inpetel_Cloud.TipoTrafo tp WHERE tp.ID = tf.TipoTrafo)TipoTrafo,\r\n"
				+ "tf.Concentrador_ID,\r\n"
				+ "(SELECT c.Serial FROM Inpetel_Cloud.Concentrador c WHERE c.ID = tf.Concentrador_ID)cnc,\r\n"
				+ "tf.States_ID,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = tf.States_ID)Estado,\r\n"
				+ "tf.Observacion\r\n"
				+ "from Inpetel_Cloud.Transformador tf;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> verTransformadorIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList("select tf.ID, tf.Address, tf.Codigo, tf.Capacidad, tf.Nodo, tf.CargaAforada,\r\n"
				+ "(SELECT tp.NombreTrafo FROM Inpetel_Cloud.TipoTrafo tp WHERE tp.ID = tf.TipoTrafo)TipoTrafo,\r\n"
				+ "tf.Concentrador_ID,\r\n"
				+ "(SELECT c.Serial FROM Inpetel_Cloud.Concentrador c WHERE c.ID = tf.Concentrador_ID)cnc,\r\n"
				+ "tf.States_ID,\r\n"
				+ "(SELECT es.Nombre_Est FROM Inpetel_Cloud.Estados es WHERE es.ID = tf.States_ID)Estado,\r\n"
				+ "tf.Observacion\r\n"
				+ "from Inpetel_Cloud.Transformador tf where ID="+ id +"\r\n"
				+ "ORDER BY ID ASC;");
		return view;
	}
	

	@Override
	public boolean Transformadores(Transformador tf) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.Transformador WHERE Codigo = '"+tf.getCodigo()+"';").size()>0;
	}
	
	@Override
	public List<Map<String, Object>> tipoTransformadores() {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.TipoTrafo");
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

	@Override
	public List<Map<String, Object>> cncSerial(String cnsS) {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador WHERE Serial='"+ cnsS +"';");
		return view;
	}

	@Override
	public List<Map<String, Object>> metSerial(String metS) {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Medidor WHERE Serial='"+metS+"';");
		return view;
	}

	@Override
	public boolean login(Usuarios u) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.Usuarios where States_ID = 1 and Login='"+u.getLogin()+"'and Password_salt='"+u.getPassword()+"';").size()>0;
	}

	@Override

	public List<Map<String, Object>> medidoresNoAsociados() {
		List<Map<String,Object>>view = template.queryForList("SELECT ID, Serial FROM Inpetel_Cloud.Medidor where ID NOT IN \r\n"
				+ "( SELECT Medidor_ID FROM Inpetel_Cloud.Asoc_concen_medidor);");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> ModemsNoAsociados() {
		List<Map<String,Object>>view = template.queryForList("SELECT ID, Imei FROM Inpetel_Cloud.Modem where ID NOT IN \r\n"
				+ "( SELECT Modem_ID FROM Inpetel_Cloud.Concentrador);");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> Macros() {
		List<Map<String,Object>>macros = template.queryForList("SELECT ma.ID AS ID, tr.Codigo AS Transformador, cnc.Serial AS Concentrador, me.Serial AS MacroMedidor \n"
				+ "FROM Inpetel_Cloud.Macro ma,\n"
				+ "Inpetel_Cloud.Medidor me,\n"
				+ "Inpetel_Cloud.Transformador tr,\n"
				+ "Inpetel_Cloud.Concentrador cnc\n"
				+ "where\n"
				+ "ma.Concentrador_ID = cnc.ID and\n"
				+ "ma.Medidor_ID = me.ID and\n"
				+ "ma.Transformador_ID = tr.ID\n"
				+ ";");
		return macros;
	}
	
	@Override
	public List<Map<String, Object>> macros() {
		List<Map<String,Object>>macros = template.queryForList("SELECT ma.ID, tr.Codigo AS Codigo_Trafo, me.Serial AS Serial_MET, me.ID AS IdMedidor\n"
				+ "FROM Inpetel_Cloud.Macro ma,\n"
				+ "Inpetel_Cloud.Transformador tr,\n"
				+ "Inpetel_Cloud.Medidor me\n"
				+ "where\n"
				+ "ma.Medidor_ID = me.ID and\n"
				+ "ma.Transformador_ID = tr.ID;");
		return macros;
	}
	
	
	@Override
	public List<Map<String, Object>> trafosCnc() {
		List<Map<String,Object>>view = template.queryForList("SELECT TF.Codigo as CodigoTF, CNC.Serial, CNC.ID AS IdCnc FROM Inpetel_Cloud.Transformador TF,\r\n"
				+ " Inpetel_Cloud.Concentrador CNC WHERE TF.Concentrador_ID = CNC.ID;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> medidoresCnc() {
		List<Map<String,Object>>view = template.queryForList("SELECT MET.ID AS IdMEt, CNC.ID AS IdCnc, CNC.Ip_real, CNC.Serial AS CNC_Serial,\r\n"
				+ "CNC.user, CNC.pass,\r\n"
				+ "MET.Serial AS MET_Serial,\r\n"
				+ "MET.logicalName\r\n"
				+ " FROM \r\n"
				+ "Inpetel_Cloud.Concentrador CNC,\r\n"
				+ "Inpetel_Cloud.Medidor MET,\r\n"
				+ "Inpetel_Cloud.Asoc_concen_medidor ACM where ACM.Concentrador_ID = CNC.ID\r\n"
				+ "AND ACM.Medidor_ID = MET.ID;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> medidoresDeUnCnc(String serialCnc) {
		List<Map<String,Object>>view = template.queryForList("SELECT MET.ID AS IdMEt, CNC.ID AS IdCnc, CNC.Ip_real, CNC.Serial AS CNC_Serial,\r\n"
				+ "CNC.user, CNC.pass,\r\n"
				+ "MET.Serial AS MET_Serial,\r\n"
				+ "MET.logicalName\r\n"
				+ " FROM \r\n"
				+ "Inpetel_Cloud.Concentrador CNC,\r\n"
				+ "Inpetel_Cloud.Medidor MET,\r\n"
				+ "Inpetel_Cloud.Asoc_concen_medidor ACM where ACM.Concentrador_ID = CNC.ID\r\n"
				+ "AND ACM.Medidor_ID = MET.ID\r\n"
				+ "AND CNC.Serial = '"+ serialCnc + "';");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> concentradoresDeUnTrafo(String codigo) {
		List<Map<String,Object>>view = template.queryForList("SELECT cnc.Serial AS Serial_CNC, cnc.ID  \n"
				+ "FROM Inpetel_Cloud.Transformador tr,\n"
				+ "Inpetel_Cloud.Concentrador cnc\n"
				+ "where\n"
				+ "tr.Concentrador_ID = cnc.ID and\n"
				+ "tr.Codigo = '"+ codigo + "';");
		return view;
	}




	public boolean MUnRepeat(Modem m) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.Modem WHERE Serial = '"+m.getSerial()+"'  OR Imei = '"+m.getImei()+"';").size()> 0;
	}

	@Override
	public List<Map<String, Object>> verMacroIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList (" SELECT ma.ID AS ID, tr.Codigo AS Transformador, cnc.Serial AS Concentrador, me.Serial AS MacroMedidor \n"
				+ "FROM Inpetel_Cloud.Macro ma,\n"
				+ "Inpetel_Cloud.Medidor me,\n"
				+ "Inpetel_Cloud.Transformador tr,\n"
				+ "Inpetel_Cloud.Concentrador cnc\n"
				+ "where\n"
				+ "ma.Concentrador_ID = cnc.ID and\n"
				+ "ma.Medidor_ID = me.ID and\n"
				+ "ma.Transformador_ID = tr.ID and\n"
				+ "ma.ID = '"+id+"';" );
		return view;
	}
	
//	public ArrayList<String> idTransformadorPorCodigo(String serialMacromedidor) {
//		ArrayList<String> resultado = new ArrayList<String>();
//		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Macro WHERE Codigo='"+ codigo +"';");
//		if(view.size() == 1) {
//			for (int i = 0; i < view.size(); i++) {
//				resultado.add(view.get(i).get("ID").toString());
//			}
//		}
//		return resultado;
//	}

	@Override
	public List<Map<String, Object>> valoresMacromedidor(Macro macro) {
		
		String fechaI = macro.getFechaInicio() + " "+ macro.getHoraInicio();
		String fechaF = macro.getFechaFin() + " "+ macro.getHoraFin();

		List<Map<String,Object>>view = template.queryForList (" Select Co.NombreConcentrador CNC, M.Serial Serial_MET, Me.Num_val AI, T.Codigo codigo_TRAFO, T.CargaAforada, (SUBSTRING(Me.Fecha, 1, 10)) Fecha\n"
				+ "from Inpetel_Cloud.Medidor M, Inpetel_Cloud.Medidas Me, Inpetel_Cloud.Transformador T, Inpetel_Cloud.Concentrador Co, Inpetel_Cloud.Asoc_concen_medidor C where\n"
				+ "M.ID IN ((Select M.ID from Inpetel_Cloud.Medidor M, Inpetel_Cloud.Asoc_concen_medidor A,\n"
				+ "Inpetel_Cloud.Macro Ma Where\n"
				+ "A.Concentrador_ID = '"+ macro.getIdConcentrador()+"' and M.ID = A.Medidor_ID and M.ID = Ma.Medidor_ID\n"
				+ "and Ma.Concentrador_ID = A.Concentrador_ID)) and Co.ID = C.Concentrador_ID\n"
				+ "and M.ID = Me.Medidor_ID and C.Medidor_ID = M.ID and C.Concentrador_ID = T.Concentrador_ID\n"
				+ "and Me.Fecha >=('"+ fechaI +"') AND Me.Fecha <=('"+ fechaF +"')\n"
				+ "and Me.HoraIncio is null and Me.InfoMedidas_ID = '2' group by Me.Fecha Order By Fecha;\n"
				+ " ");
		return view;
	}

	@Override
	public List<Map<String, Object>> valoresMetAsociadoTrafo(Macro macro) {

		String fechaI = macro.getFechaInicio() + " "+ macro.getHoraInicio();
		String fechaF = macro.getFechaFin() + " "+ macro.getHoraFin();

		List<Map<String,Object>>view = template.queryForList ("Select C.Concentrador_ID Cnc, M.Serial Serial_MET, Me.Num_val AI, T.Codigo codigo_TRAFO, T.CargaAforada, (SUBSTRING(Me.Fecha, 1, 10)) Fecha, Me.Num_val+T.CargaAforada medidoresMasCargaAforada\n"
				+ " from Inpetel_Cloud.Medidor M, Inpetel_Cloud.Medidas Me, Inpetel_Cloud.Transformador T, Inpetel_Cloud.Asoc_concen_medidor C where\n"
				+ " M.ID IN (  Select M.ID from Inpetel_Cloud.Medidor M, Inpetel_Cloud.Asoc_concen_medidor A,\n"
				+ " Inpetel_Cloud.Macro Ma Where\n"
				+ " A.Concentrador_ID = '"+ macro.getIdConcentrador()+"' and M.ID = A.Medidor_ID and M.ID != Ma.Medidor_ID\n"
				+ " and Ma.Concentrador_ID = A.Concentrador_ID) and M.ID = Me.Medidor_ID and C.Medidor_ID = M.ID and C.Concentrador_ID = T.Concentrador_ID\n"
				+ " and Me.Fecha >=('"+ fechaI +"') AND Me.Fecha <('"+ fechaF +"') and Me.InfoMedidas_ID = '2' and Me.HoraIncio is null group by Me.Fecha Order By Fecha ;\n"
				+ " ");
		return view;
	}

	@Override
	public ArrayList<Double> balanceDiarioPorcentaje(Macro macro) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Double> balanceDiarioPerdidaTecnica(Macro macro) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
