package com.InpetelCloud.Dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.ConsultasInterface;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Usuarios;
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
		List<Map<String, Object>> view = template.queryForList("SELECT c.ID,c.Ip_real, NombreConcentrador, \r\n"
				+ "(SELECT tp.Nombre FROM Inpetel_Cloud.TipoComunicacion tp WHERE tp.ID = c.TipoComunicacion_ID)Comunicacion,\r\n"
				+ "c.Imei,\r\n"
				+ "c.Serial,\r\n"
				+ "(SELECT tc.ComStatus FROM Inpetel_Cloud.TiempoConectado tc WHERE tc.ID = c.TiempoConectado_ID)Conectado,\r\n"
				+ "c.Modem_Embedido,\r\n"
				+ "c.IOmodule,\r\n"
				+ "(SELECT m.Serial FROM Inpetel_Cloud.Modem m WHERE m.ID = c.Modem_ID )Modemserial,\r\n"
				+ "(SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = c.Marca_ID)Marca,\r\n"
				+ "(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = c.Marca_ID)Tecnologia,\r\n"
				+ "c.user, c.pass, c.States_ID, c.Observacion \r\n"
				+ " FROM Inpetel_Cloud.Concentrador c;");
		return view;
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
				+ "(SELECT m.Serial FROM Inpetel_Cloud.Modem m WHERE m.ID = c.Modem_ID )Modemserial,\r\n"
				+ "(SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = c.Marca_ID)Marca,\r\n"
				+ "(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = c.Marca_ID)Tecnologia,\r\n"
				+ "c.user, c.pass, c.States_ID, c.Observacion FROM Inpetel_Cloud.Concentrador c where ID="+ id +"\r\n"
				+ "ORDER BY ID ASC;") ;
		return view;
	}

	@Override
	public List<Map<String, Object>> Medidores() {
		List<Map<String, Object>> view = template.queryForList("SELECT m.ID,\r\n"
				+ "(SELECT tm.NombreMedidor FROM Inpetel_Cloud.TipoMedidor tm WHERE tm.ID = m.TipoMedidor_ID)TipoMET,\r\n"
				+ "m.Magnitud, m.NumCuadrantes,\r\n"
				+ "(SELECT tp.Nombre_Puerto FROM Inpetel_Cloud.TipoPuerto tp WHERE tp.ID = m.TipoPuerto_ID)Puerto,\r\n"
				+ "m.Prepago, m.Sync_reloj, m.Modelo, m.Serial,\r\n"
				+ "(SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = m.Marca_ID)Marca,\r\n"
				+ "(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = m.Marca_ID)Tecnologia,\r\n"
				+ "m.logicalName, m.States_ID, m.Observacion\r\n"
				+ " FROM Inpetel_Cloud.Medidor m;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> verMedidorIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList(" SELECT ID,\r\n"
				+ "(SELECT tm.NombreMedidor FROM Inpetel_Cloud.TipoMedidor tm WHERE tm.ID = m.TipoMedidor_ID)TipoMET,\r\n"
				+ " Magnitud, NumCuadrantes,\r\n"
				+ "(SELECT tp.Nombre_Puerto FROM Inpetel_Cloud.TipoPuerto tp WHERE tp.ID = m.TipoPuerto_ID)Puerto,\r\n"
				+ "Prepago,\r\n"
				+ "Sync_reloj, Modelo, Serial,\r\n"
				+ "(SELECT mr.Nombre_Marca FROM Inpetel_Cloud.Marca mr WHERE mr.ID = m.Marca_ID)Marca,\r\n"
				+ "(SELECT tr.Nombre_Tecnologia FROM Inpetel_Cloud.Marca mt, Inpetel_Cloud.TecnologiaComponente tr\r\n"
				+ "WHERE tr.ID = mt.TecnologiaComponente_ID AND mt.ID = m.Marca_ID)Tecnologia,\r\n"
				+ "logicalName, States_ID, Observacion"
				+ " FROM Inpetel_Cloud.Medidor m where ID="+ id +"\r\n"
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
		return null;
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
	public List<Map<String, Object>> Transformadores() {
		List<Map<String, Object>> view = template.queryForList("select tf.ID, tf.Nombre, tf.Address, tf.Codigo, tf.Capacidad, tf.Nodo, tf.CargaAforada, \r\n"
				+ "(SELECT tp.NombreTrafo FROM Inpetel_Cloud.TipoTrafo tp WHERE tp.ID = tf.TipoTrafo)TipoTrafo,\r\n"
				+ "(SELECT c.Serial FROM Inpetel_Cloud.Concentrador c WHERE c.ID = tf.Concentrador_ID)cnc,\r\n"
				+ "tf.States_ID,\r\n"
				+ "tf.Observacion\r\n"
				+ " from Inpetel_Cloud.Transformador tf;");
		return view;
	}
	
	@Override
	public List<Map<String, Object>> verTransformadorIndividual(Long id) {
		List<Map<String,Object>>view = template.queryForList("select tf.ID, tf.Nombre, tf.Address,tf.Codigo, tf.Capacidad, tf.Nodo, tf.CargaAforada,\r\n"
				+ "(SELECT tp.NombreTrafo FROM Inpetel_Cloud.TipoTrafo tp WHERE tp.ID = tf.TipoTrafo)TipoTrafo,\r\n"
				+ "(SELECT c.Serial FROM Inpetel_Cloud.Concentrador c WHERE c.ID = tf.Concentrador_ID)cnc,\r\n"
				+ "tf.States_ID,\r\n"
				+ "tf.Observacion\r\n"
				+ "from Inpetel_Cloud.Transformador tf where ID="+ id +"\r\n"
				+ "ORDER BY ID ASC;");
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
	public boolean MUnRepeat(Modem m) {
		return template.queryForList("SELECT * FROM Inpetel_Cloud.Modem WHERE Serial = '"+m.getSerial()+"'  OR Imei = '"+m.getImei()+"';").size()> 0;
	}





	
}
