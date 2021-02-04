package com.InpetelCloud.Interfaces;

import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;

public interface EliminarInterface {
				
	//Metodo para eliminar un sistema externo( en realidad, pasa su estado a inhabilitado)
	public int eliminarSistemaExterno(SistemExterno se, Long id);
	
	//Metodo para eliminar un rol
	public int eliminarRol(Long id);
	
	//Metodo para eliminar una marca
	public int eliminarMarca(Long id, String nombre);
		
	//Metodo para eliminar una tecnologia de componente
	public int eliminarTeconologiaComponente(Long id);
		
	//Metodo para eliminar un modem
	public int eliminarModem(Long id);
		
	//Metodo para eliminar un tipo de comunicacion
	public int eliminarTipoComunicacion(Long id);
		
	//Metodo para eliminar un tiempo conectado
	public int eliminarTiempoConectado(Long id);
		
	//Metodo para eliminar un tipo de medidor
	public int eliminarTipoMedidor(Long id);
		
	//Metodo para eliminar un tipo de puerto
	public int eliminarTipoPuerto(Long id);
		
	//Metodo para eliminar un estado
	public int eliminarEstado(Long id);
	
	//Metodo para eliminar un transformador
	public int eliminarTransformador(Transformador transformador, Long id);
	
	//Metodo para eliminar un usuario
	public int eliminarUsuario(Long id);

	public int eliminarMedidor(modelMeter medidor,Long id);
	
	public int eliminarConcentrador(modelConcentrator concentrador, Long id);





}
