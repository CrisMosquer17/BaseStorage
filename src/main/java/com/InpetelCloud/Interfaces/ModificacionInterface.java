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

public interface ModificacionInterface {
	
	public Usuarios updateUser(Long id, Usuarios usuario);
	
	//public Medidor updateMedidor(Long id, Medidor medidor);
	
	//public Concentrador updateConcentrador(Long id, Concentrador concentrador);
	
	public Transformador updateTransformador(Long id, Transformador transformador);

	//public Medidas updateMedidas(Long id, Medidas medidas);
	
	
	//Metodo para modificar un sistema externo
	public int modificarSistemaExterno(Long id, SistemExterno se);
	
	//Metodo para modificar un rol
	public int modificarRol(Long id, Rol rol);
	
	//Metodo para modificar una marca
	public int modificarMarca(Long id, Marca marca);
	
	//Metodo para modificar una tecnologia del componente
	public int modificarTecnologiaComponente(Long id, TecnologiaComponente tecnologiaComponente);
	
	//Metodo para modificar un modem
	public int modificarModem(Long id, Modem modem);
	
	//Metodo para modificar un tipo de comunicacion
	public int modificarTipoComunicacion(Long id, TipoComunicacion tipoComunicacion);
	
	//Metodo para modificar un tiempo conectado
	public int modificarTiempoConectado(Long id, TiempoConectado tiempoConectado);



}
