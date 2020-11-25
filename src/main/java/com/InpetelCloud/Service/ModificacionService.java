package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.ModificacionDao;
import com.InpetelCloud.Interfaces.ModificacionInterface;
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
public class ModificacionService implements ModificacionInterface{
	
	@Autowired
	ModificacionDao dao;

	@Override
	public Usuarios updateUser(Long id, Usuarios usuario) {
		return null;
	}

	/*@Override
	public Medidor updateMedidor(Long id, Medidor medidor) {
		return null;
	}*/

	/*@Override
	public Concentrador updateConcentrador(Long id, Concentrador concentrador) {
		return null;
	}*/

	@Override
	public Transformador updateTransformador(Long id, Transformador transformador) {
		return null;
	}

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


}
