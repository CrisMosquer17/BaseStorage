package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.InsercionDao;
import com.InpetelCloud.Interfaces.InsercionInterface;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Service
public class InsercionService implements InsercionInterface {
	
	@Autowired
	InsercionDao dao;

	/*@Override
	public Medidor saveMedidor(Medidor medidor) {
		// TODO Auto-generated method stub
		return null;
	}*/

	/*@Override
	public Concentrador saveConcentrador(Concentrador concentrador) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public Transformador saveTransformador(Transformador transformador) {
		return null;
	}

	@Override
	public Usuarios saveUsuario(Usuarios usuario) {
		return null;
	}

	@Override
	public void schemaCreate(String name) {
		dao.schemaCreate(name);
	}

	@Override
	public int crearSistemaExterno(SistemExterno se) {
		dao.schemaCreate(se.getNombre());
		return dao.crearSistemaExterno(se);
	}

	@Override
	public int crearRol(Rol rol) {
		return	dao.crearRol(rol);
	}

	@Override
	public int crearMarca(Marca marca) {
		return dao.crearMarca(marca);
	}

	@Override
	public int crearTecnologiaComponente(TecnologiaComponente tecnologiaComponente) {
		return dao.crearTecnologiaComponente(tecnologiaComponente);
	}

	@Override
	public int crearModem(Modem modem) {
		return dao.crearModem(modem);
	}

	@Override
	public int crearTipoComunicacion(TipoComunicacion tipoComunicacion) {
		return dao.crearTipoComunicacion(tipoComunicacion);
	}

	@Override
	public int crearTiempoConectado(TiempoConectado tiempoConectado) {
		return dao.crearTiempoConectado(tiempoConectado);
	}

	@Override
	public int crearFtp(Ftp f) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
	

}
