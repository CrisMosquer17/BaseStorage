package com.InpetelCloud.Interfaces;

import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

public interface InsercionInterface {

	/*MEDIDORES */ 
	
	public Medidor saveMedidor(Medidor medidor); 
	
	/* CONCENTRADORES */
	public Concentrador saveConcentrador(Concentrador concentrador); 

	
	/* TRANSFORMADOR */
	public Transformador saveTransformador(Transformador transformador); 

	
	/* MEDIDAS VALUES */
	//public Medidas createMedidas(Medidas medidas);
	
	/* VALUES */
	
	/*USUARIOS */
	public Usuarios saveUsuario(Usuarios usuario); 

	
}
