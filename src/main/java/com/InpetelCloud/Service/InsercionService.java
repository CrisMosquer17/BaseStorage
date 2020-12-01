package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import com.InpetelCloud.Dao.InsercionDao;
import com.InpetelCloud.Interfaces.InsercionInterface;
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
	public int crearTipoMedidor(TipoMedidor tipoMedidor) {
		return dao.crearTipoMedidor(tipoMedidor);
	}

	@Override
	public int crearTipoPuerto(TipoPuerto tipoPuerto) {
		 return dao.crearTipoPuerto(tipoPuerto);
	}

	@Override
	public int crearEstado(Estados estado) {
		return dao.crearEstado(estado);
	}


	@Override
	public int crearFtp(Ftp f) {
		String passOrigin = DigestUtils.md5Hex(f.getPassword());
		f.setPassword(passOrigin);
		return dao.crearFtp(f);
	}

	/*@Override
	public int crearMedida(ObjetoJson objetoJson) {
		return dao.crearMedida(objetoJson);
	}*/

	@Override
	public int crearTransformador(Transformador transformador) {
		return dao.crearTransformador(transformador);
	}

	@Override
	public int crearUsuario(Usuarios usuario) {
		String passOrigin = DigestUtils.md5Hex(usuario.getPassword());
		String passSalt = DigestUtils.md5Hex(usuario.getPassword_salt());
		usuario.setPassword(passOrigin);
		usuario.setPassword_salt(passSalt);
		return dao.crearUsuario(usuario);
	}

}
