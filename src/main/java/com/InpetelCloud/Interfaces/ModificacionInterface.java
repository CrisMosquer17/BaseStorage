package com.InpetelCloud.Interfaces;

import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

public interface ModificacionInterface {
	
	public Usuarios updateUser(Long id, Usuarios usuario);
	
	public Medidor updateMedidor(Long id, Medidor medidor);
	
	public Concentrador updateConcentrador(Long id, Concentrador concentrador);
	
	public Transformador updateTransformador(Long id, Transformador transformador);

	//public Medidas updateMedidas(Long id, Medidas medidas);
	
	public int modificarSistemaExterno(Long id, SistemExterno se);
	



}
