package com.InpetelCloud.Interfaces;

import java.util.List;
import java.util.Map;

import com.InpetelCloud.Model.Usuarios;
public interface ConsultasInterface {

	public List<Map<String,Object>>Usuarios();
	
	public List<Map<String,Object>>Concentradores();
	
	public List<Map<String,Object>>Transformadores();

	public List<Map<String,Object>>Medidores();
	
	public List<Map<String,Object>>Medidas();
	
	public List<Map<String,Object>>SistemasExternos();
	
	public List<Map<String, Object>> Roles();
	
	public List<Map<String, Object>> Marcas();

	public List<Map<String, Object>> TecnologiasComponentes();

	public List<Map<String, Object>> Modems();

	public List<Map<String, Object>> TiposComunicacion();
	
	public List<Map<String, Object>> TiemposConectado();
	
	public List<Map<String, Object>> TiposMedidor();
	
	public List<Map<String, Object>> TiposPuerto();
	
	public List<Map<String, Object>> Estados();
	
	public List<Map<String, Object>> Ftps();
	
	public boolean validarSerialConcentrador(String cnc);
	
	public boolean validarSerialMedidor(String met);

	/*CNC Y MET SERIAL */
	
	public List<Map<String,Object>> cncSerial(String cnsS);
	
	public List<Map<String,Object>>metSerial(String metS);
	
	/* USUARIOS */
	public boolean login(Usuarios u);
	





}
