package com.InpetelCloud.Interfaces;


import com.InpetelCloud.Model.AsociacionConcentradorMedidor;
import com.InpetelCloud.Model.Macro;
import com.InpetelCloud.Model.CyR;
import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.ObjetoJson;
import com.InpetelCloud.Model.ObjetoJsonS03;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.TipoMedidor;
import com.InpetelCloud.Model.TipoPuerto;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Model.objetoJsonEventoConcentrador;
import com.InpetelCloud.Model.objetoJsonEventoMedidor;
import com.InpetelCloud.Model.objetoJsonEventoMedidorG3;
import com.InpetelCloud.Model.objetoJsonG3;
import com.InpetelCloud.Model.objetoJsonG3S03;

public interface InsercionInterface {

	/*MEDIDORES */ 
	
	public void schemaCreate(String name);
	
	
	//Metodo para crear un sistema externo
	public int crearSistemaExterno(SistemExterno se);
	
	public int crearAsociacionMetCnc(AsociacionConcentradorMedidor asociacion);
	
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
	
	public int crearCyR(CyR cyr);
	
	//Metodo para crear un transformador
	public int crearTransformador(Transformador transformador); 
	
	//Metodo para crear usuarios
	public int crearUsuario(Usuarios usuario); 

	//Metodo para crear un ftp
	public int crearFtp(Ftp f);
		
	//Metodo para crear una medida
	public int crearMedida(ObjetoJson json);
	
	public int crearMedidaS03(ObjetoJsonS03 jsons03);
	
	//Metodo para crear un medidor
	public int crearMedidorMedida(String medidor); 
	
	//Metodo para crear un concentrador
	public int crearConcentradorMedida(String concentrador);
	
	public int crearMedidor(modelMeter medidor);
	
	public int crearConcentrador(modelConcentrator concentrador);
	
	public int crearMedidorVista(modelMeter medidor);
	
	public int crearConcentradorVista(modelConcentrator concentrador);
	
	public int crearMedidaG3Horaria(objetoJsonG3 jsong3);
	
	public int crearMedidaG3Diaria(objetoJsonG3S03 jsong3);
	
	public int crearEventoConcentrador(objetoJsonEventoConcentrador evento);
	
	public int crearEventoMedidor(objetoJsonEventoMedidor evento);

	
	public int crearEventoMedidorG3(objetoJsonEventoMedidorG3 evento);
	
	public int crearMacro(Macro macro);


	
//	public int crearEventoConcentrador(ObjetoJsonEventos evento);

	


	
}