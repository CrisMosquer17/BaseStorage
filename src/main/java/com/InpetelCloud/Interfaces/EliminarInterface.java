package com.InpetelCloud.Interfaces;

import com.InpetelCloud.Model.SistemExterno;

public interface EliminarInterface {
	
	public boolean deleteUsuario(Long id);
	
	public boolean deleteMedidor(Long id);
	
	public boolean deleteConcentrador(Long id);
	
	public boolean deleteTransformador(Long id);
	
	public boolean deleteMedidas(Long id);
	
	public int eliminarSistemaExterno(Long id);



}
