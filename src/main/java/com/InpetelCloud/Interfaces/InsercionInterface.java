package com.InpetelCloud.Interfaces;


import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.ObjetoJson;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.TipoMedidor;
import com.InpetelCloud.Model.TipoPuerto;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

public interface InsercionInterface {

	/*MEDIDORES */ 
	
	/* MEDIDAS VALUES */
	//public Medidas createMedidas(Medidas medidas);

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
	
	// Metodo para crear un tipo de medidor
	public int crearTipoMedidor(TipoMedidor tipoMedidor);
		
	// Metodo para crear un tipo de puerto
	public int crearTipoPuerto(TipoPuerto tipoPuerto);
		
	// Metodo para crear un estado
	public int crearEstado(Estados estado);
	
	//Metodo para crear un transformador
	public int crearTransformador(Transformador transformador); 
	
	//Metodo para crear usuarios
	public int crearUsuario(Usuarios usuario); 

	//Metodo para crear un ftp
	public int crearFtp(Ftp f);
		
	//Metodo para crear una medida
	public int crearMedida(ObjetoJson json);
	
	//Metodo para crear un medidor
	public int crearMedidor(String medidor); 
	
	//Metodo para crear un concentrador
	public int crearConcentrador(String concentrador);
	


	
}
