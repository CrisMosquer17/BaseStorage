package com.InpetelCloud.Interfaces;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.InpetelCloud.Model.Macro;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
public interface ConsultasInterface {

	public List<Map<String,Object>>Usuarios();
	
	public boolean Usuarios(Usuarios usu);
	
	public List<Map<String, Object>> verUsuarioIndividual(Long id);

	public List<Map<String,Object>>Concentradores();
	
	public List<Map<String, Object>> verConcentradorIndividual(Long id);
	
	public boolean Concentradores(modelConcentrator cnc);
	
	public List<Map<String,Object>>Transformadores();
	
	public List<Map<String,Object>>tipoTransformadores();

	
	public boolean Transformadores(Transformador tf);
	
	public List<Map<String, Object>> verTransformadorIndividual(Long id);

	public List<Map<String,Object>>Medidores();
	
	public boolean Medidores(modelMeter met);
	
	public List<Map<String, Object>> verMedidorIndividual(Long id);
	
	public List<Map<String,Object>>Medidas();
	
	public List<Map<String,Object>>SistemasExternos();
	
	public List<Map<String,Object>>verSistemaExternoIndividual(Long id);
	
	public boolean SistemasExternos(SistemExterno se);

	
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
	
	public List<Map<String, Object>> CortesReconeccion();
	
	public List<Map<String, Object>> medidoresNoAsociados();
	
	public List<Map<String, Object>> ModemsNoAsociados();
	
	public List<Map<String, Object>> Macros();

	
	//TRANSFORMADORES ASOCIADOS A UN CNC
	public List<Map<String, Object>> trafosCnc();
	
	//TODOS LOS MEDIDORES ASOCIADOS A CONCENTRADORES
	public List<Map<String, Object>> medidoresCnc();
	
	//TODOS LOS MEDIDORES DE UN SOLO CONCENTRADOR
	public List<Map<String, Object>> medidoresDeUnCnc(String serialCnc);
	

	public boolean validarSerialConcentrador(String cnc);
	
	public boolean validarSerialMedidor(String met);
	
	public List<Map<String, Object>> verMacroIndividual(Long id);

	/*CNC Y MET SERIAL */
	
	public List<Map<String,Object>> cncSerial(String cnsS);
	
	public List<Map<String,Object>>metSerial(String metS);
	
	/*DEVUELVE LOS CONCENTRADORES(POR EL MOMENTO 1) ASOCIADOS A UN TRANSFORMADOR*/
	public List<Map<String, Object>> concentradoresDeUnTrafo(String codigo);
	
	/*MUESTRA EL TRAFO Y EL MEDIDOR DE LA TABLA MACRO*/
	public List<Map<String, Object>> macros();
	
	//BALANCE diario de la macro, se envía solo el macromedidor
	public List<Map<String, Object>> valoresMacromedidor(Macro macro);
	
	//BALANCE Consulta para traer los datos de los medidores asociados al trafo, sin macromedidor 
	public List<Map<String, Object>> valoresMetAsociadoTrafo(Macro macro);

	//BALANCE diario en porcentaje 
	public ArrayList<Double> balanceDiarioPorcentaje(Macro macro);
	
	//BALANCE diario perdida tecnica 
	public ArrayList<Double> balanceDiarioPerdidaTecnica(Macro macro);


	
	/* USUARIOS */
	public boolean login(Usuarios u);
	





}
