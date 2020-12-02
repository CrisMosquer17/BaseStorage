package com.InpetelCloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

	@Override
	public int crearMedida(ObjetoJson objetoJson) {
		List<Object> resultado = validarCreacionMedidas(objetoJson);
		return dao.crearMedidaPrueba(resultado);
	}
	
	public List<Object> validarCreacionMedidas(ObjetoJson objetoJson) {
		List<Object> resultado=new ArrayList<Object>();
		boolean validarSerialMedidor = validarSerialMedidor(objetoJson);
		List<Map<String,Object>>idMedidor = dao.obtenerIdMedidor(objetoJson);
		if(validarSerialMedidor == true) {
			for (Map<String, Object> map : idMedidor) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                    resultado.add(value);
                    }
            }
			}
		boolean validarSerialConcentrador = validarSerialConcentrador(objetoJson);
		List<Map<String,Object>>idConcentrador = dao.obtenerIdConcentrador(objetoJson);
		if(validarSerialConcentrador == true) {
			for (Map<String, Object> map : idConcentrador) {
	            for (Map.Entry<String, Object> entry : map.entrySet()) {
	                Object value = entry.getValue();
	                    resultado.add(value);
	                    }
	            }
		}
		
		//crea el registro en la tabla asociacion de medidor con concentrador
		dao.crearAsociacionCncMet(resultado);
		
		
		//ingreso el valor de la medida al arreglo
		resultado.add(objetoJson.getNumValor());
		
		//ingresar la fecha
		resultado.add(objetoJson.getFecha().substring(0,10));
		
		String horaInicio = (objetoJson.getFecha()).substring(11, 16);
		resultado.add(horaInicio);
		
		String horaFin = "";
		resultado.add(horaFin);
		
		//creo tabla de trazabilidad
		dao.crearTrazabilidad(objetoJson);
		
		List<Map<String,Object>>idTrazabilidad = dao.obtenerIdTrazabilidad(objetoJson);
		for (Map<String, Object> map : idTrazabilidad) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                    resultado.add(value);
                    }
            }
		
		List<Map<String,Object>>nombreMedida = dao.obtenerIdInfoMedida(objetoJson);
		for (Map<String, Object> map : nombreMedida) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                Object value = entry.getValue();
                    resultado.add(value);
                    }
            }
		System.out.println(resultado.get(0) + " Medidor_ID");
		System.out.println(resultado.get(1) + "numconcentrador");
		System.out.println(resultado.get(2) + "numvalor");
		System.out.println(resultado.get(3) + "fecha");
		System.out.println(resultado.get(4) + "horainicio");
		System.out.println(resultado.get(5) + "horafin");
		System.out.println(resultado.get(6) + "idtrazabilidad");
		System.out.println(resultado.get(7) + "infomedida");
		return resultado;
	}
	
	
	
	public boolean validarSerialMedidor(ObjetoJson objetoJson) {
		String serialMet = objetoJson.getSerialmet();
		boolean resultado = false;
			List<String> serialesMedidores=new ArrayList<String>();
			List<Map<String,Object>>medidores = dao.serialMedidores();
			for (Map<String, Object> map : medidores) {
	            for (Map.Entry<String, Object> entry : map.entrySet()) {
	                //String key = entry.getKey();
	                Object value = entry.getValue();
	                    serialesMedidores.add((String) value);
	                    }
	            }
			for (int i = 0; i < serialesMedidores.size(); i++) {
				if(serialesMedidores.get(i).equals(serialMet)) {
					resultado = true;
				}
			}
		if(resultado == false) {
			dao.crearMedidor(objetoJson);
			resultado = true;
		}
			
		return resultado;
	}
	
	public boolean validarSerialConcentrador(ObjetoJson objetoJson) {
		String serialCnc = objetoJson.getSerialcnc();
		boolean resultado = false;
		List<String> serialesConcentradores=new ArrayList<String>();
		List<Map<String,Object>>concentradores=dao.serialConcentradores();
		for (Map<String, Object> map : concentradores) {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                //String key = entry.getKey();
                Object value = entry.getValue();
                    serialesConcentradores.add((String) value);
                    }
            }
		for (int i = 0; i < serialesConcentradores.size(); i++) {
			if(serialesConcentradores.get(i).equals(serialCnc)) {
				resultado = true;
			}
		}
		
		if(resultado == false) {
			dao.crearConcentrador(objetoJson);
			resultado = true;
		}
			
		return resultado;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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
