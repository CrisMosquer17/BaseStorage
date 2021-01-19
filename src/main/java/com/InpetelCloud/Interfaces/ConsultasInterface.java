package com.InpetelCloud.Interfaces;

import java.util.List;
import java.util.Map;

import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
public interface ConsultasInterface {

	public List<Map<String,Object>>Usuarios();
	
	public List<Map<String,Object>>Concentradores();
	
	public List<Map<String, Object>> verConcentradorIndividual(Long id);
	
	public boolean Concentradores(modelConcentrator cnc);
	
	public List<Map<String,Object>>Transformadores();
	
	public boolean Transformadores(Transformador tf);
	
	public List<Map<String, Object>> verTransformadorIndividual(Long id);

	public List<Map<String,Object>>Medidores();
	
	public boolean Medidores(modelMeter met);
	
	public List<Map<String, Object>> verMedidorIndividual(Long id);
	
	public List<Map<String,Object>>Medidas();
	
	public List<Map<String,Object>>SistemasExternos();
	
	public List<Map<String, Object>> Roles();
	
	public List<Map<String, Object>> Marcas();
	
	public List<Map<String, Object>> Marcas(String id);
	
	public List<Map<String, Object>> TecnologiasComponentes();
	
	public List<Map<String, Object>> TecnologiasComponentes(String id);
	
	public List<Map<String, Object>> Modems();
	
	public boolean MUnRepeat(Modem m);
	
	public List<Map<String, Object>> verModemIndividual(Long id);

	public List<Map<String, Object>> TiposComunicacion();
	
	public List<Map<String, Object>> TiemposConectado();
	
	public List<Map<String, Object>> TiposMedidor();
	
	public List<Map<String, Object>> TiposPuerto();
	
	public List<Map<String, Object>> Estados();
	
	public List<Map<String, Object>> Ftps();
	
	public List<Map<String, Object>> medidoresNoAsociados();
	
	public boolean validarSerialConcentrador(String cnc);
	
	public boolean validarSerialMedidor(String met);
	
	

	/*CNC Y MET SERIAL */
	
	public List<Map<String,Object>> cncSerial(String cnsS);
	
	public List<Map<String,Object>>metSerial(String metS);
	
	/* USUARIOS */
	public boolean login(Usuarios u);
	





}
