package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.InpetelCloud.Dao.ModificacionDao;
import com.InpetelCloud.Interfaces.ModificacionInterface;
import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
import com.InpetelCloud.Model.SistemExterno;
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

	@Override
	public Medidor updateMedidor(Long id, Medidor medidor) {
		return null;
	}

	@Override
	public Concentrador updateConcentrador(Long id, Concentrador concentrador) {
		return null;
	}

	@Override
	public Transformador updateTransformador(Long id, Transformador transformador) {
		return null;
	}

	@Override
	public int modificarSistemaExterno(Long id ,SistemExterno se) {
		return dao.modificarSistemaExterno(id, se);
	}


}
