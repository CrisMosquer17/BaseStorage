package com.InpetelCloud.Interfaces;


import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

public interface InsercionInterface {

	/*MEDIDORES */ 
	
	//public Medidor saveMedidor(Medidor medidor); 
	
	/* CONCENTRADOR */
	//public Concentrador saveConcentrador(Concentrador concentrador); 

	
	/* TRANSFORMADOR */
	public Transformador saveTransformador(Transformador transformador); 

	
	/* MEDIDAS VALUES */
	//public Medidas createMedidas(Medidas medidas);
	

	
	/*USUARIOS */
	public Usuarios saveUsuario(Usuarios usuario); 

	public void schemaCreate(String name);
	
	//Metodo para crear un sistema externo
	public int crearSistemaExterno(SistemExterno se);
	
	// Metodo para crear un rol 
	public int crearRol(Rol rol);
	
	// Metodo para crear una marca 
	public int crearMarca(Marca marca);
	
	// Metodo para crear una tecnologia del componente
	public int crearTecnologiaComponente(TecnologiaComponente tecnologiaComponente);
	
	// Metodo para crear un modem
	public int crearModem(Modem modem);
	
	// Metodo para crear un tipo de comunicacion
	public int crearTipoComunicacion(TipoComunicacion tipoComunicacion);
	
	// Metodo para crear una categoria en la que un medidor se puede encontrar conectado, es decir
	// puede estar activo, temporalmente por fuera, por fuera o una nueva que se crea a través de este metodo
	public int crearTiempoConectado(TiempoConectado tiempoConectado);
	
	
	
	
}
