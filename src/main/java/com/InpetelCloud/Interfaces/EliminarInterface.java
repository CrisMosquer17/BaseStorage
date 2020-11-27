package com.InpetelCloud.Interfaces;

import com.InpetelCloud.Model.SistemExterno;

public interface EliminarInterface {
	
	public boolean deleteUsuario(Long id);
	
	public boolean deleteMedidor(Long id);
	
	public boolean deleteConcentrador(Long id);
	
	public boolean deleteTransformador(Long id);
	
	public boolean deleteMedidas(Long id);
	
	//Metodo para eliminar un sistema externo( en realidad, pasa su estado a inhabilitado)
	public int eliminarSistemaExterno(Long id);
	
	//Metodo para eliminar un rol
		public int eliminarRol(Long id);
		
		//Metodo para eliminar una marca
		public int eliminarMarca(Long id);
		
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




}
