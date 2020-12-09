package com.InpetelCloud.Service;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.ModificacionDao;
import com.InpetelCloud.Interfaces.ModificacionInterface;
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

@Service
public class ModificacionService implements ModificacionInterface{
	
	@Autowired
	ModificacionDao dao;

	/*@Override
	public Medidor updateMedidor(Long id, Medidor medidor) {
		return null;
	}*/

	/*@Override
	public Concentrador updateConcentrador(Long id, Concentrador concentrador) {
		return null;
	}*/

	@Override
	public int modificarSistemaExterno(Long id ,SistemExterno se) {
		return dao.modificarSistemaExterno(id, se);
	}

	@Override
	public int modificarRol(Long id, Rol rol) {
		return dao.modificarRol(id, rol);
	}

	@Override
	public int modificarMarca(Long id, Marca marca) {
		return dao.modificarMarca(id, marca);
	}

	@Override
	public int modificarTecnologiaComponente(Long id, TecnologiaComponente tecnologiaComponente) {
		return dao.modificarTecnologiaComponente(id, tecnologiaComponente);
	}

	@Override
	public int modificarModem(Long id, Modem modem) {
		return dao.modificarModem(id, modem);
	}

	@Override
	public int modificarTipoComunicacion(Long id, TipoComunicacion tipoComunicacion) {
		return dao.modificarTipoComunicacion(id, tipoComunicacion);
	}

	@Override
	public int modificarTiempoConectado(Long id, TiempoConectado tiempoConectado) {
		return dao.modificarTiempoConectado(id, tiempoConectado);
	}
	
	@Override
	public int modificarTipoMedidor(Long id, TipoMedidor tipoMedidor) {
		return dao.modificarTipoMedidor(id, tipoMedidor);
	}

	@Override
	public int modificarTipoPuerto(Long id, TipoPuerto tipoPuerto) {
		return dao.modificarTipoPuerto(id, tipoPuerto);
	}

	@Override
	public int modificarEstado(Long id, Estados estado) {
		return dao.modificarEstado(id, estado);
	}

	@Override
	public int modificarTransformador(Long id, Transformador transformador) {
		return dao.modificarTransformador(id, transformador);
	}

	@Override
	public int modificarUsuario(Long id, Usuarios usuario) {
		String passOrigin = DigestUtils.md5Hex(usuario.getPassword());
		String passSalt = DigestUtils.md5Hex(usuario.getPassword_salt());
		usuario.setPassword(passOrigin);
		usuario.setPassword_salt(passSalt);
		return dao.modificarUsuario(id, usuario);
	}

	@Override
	public int modificarFtp(Ftp f) {
		String pass = DigestUtils.md5Hex(f.getPassword());
		f.setPassword(pass);
		return dao.modificarFtp(f);
	}

	@Override
	public int modificarConcentrador(Long id, modelConcentrator concentrador) {
		return dao.modificarConcentrador(id, concentrador);
	}

	@Override
	public int modificarMedidor(Long id, modelMeter medidor) {
		return dao.modificarMedidor(id, medidor);
	}



}
