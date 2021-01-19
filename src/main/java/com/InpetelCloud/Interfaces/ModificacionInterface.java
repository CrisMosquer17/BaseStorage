package com.InpetelCloud.Interfaces;


import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.TipoMedidor;
import com.InpetelCloud.Model.TipoPuerto;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

public interface ModificacionInterface {
		
	//public Medidor updateMedidor(Long id, Medidor medidor);
	
	//public Concentrador updateConcentrador(Long id, Concentrador concentrador);
	
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

	//Metodo para modificar un tipo de medidor
	public int modificarTipoMedidor(Long id, TipoMedidor tipoMedidor);
		
	//Metodo para modificar un tipo de puerto
	public int modificarTipoPuerto(Long id, TipoPuerto tipoPuerto);
		
	//Metodo para modificar un estado
	public int modificarEstado(Long id, Estados estado);
	
	//Metodo para modificar un transformador
	public int modificarTransformador(Long id, Transformador transformador);
	
	//Metodo para modificar un usuario
	public int modificarUsuario(Long id, Usuarios usuario);
	
	//Metodo para modificar un ftp
	public int modificarFtp( Ftp f);
	
	//Metodo para modificar un concentrador
	public int modificarConcentrador(Long id, modelConcentrator concentrador);

	//Metodo para modificar un medidor
	public int modificarMedidor(Long id, modelMeter medidor);
	
	public int modificarMedidorVista(Long id, modelMeter medidor);



}
