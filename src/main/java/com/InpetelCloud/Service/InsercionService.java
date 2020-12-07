package com.InpetelCloud.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

		System.out.println(agregarHora("14:00"));
		System.out.println(nombreMedidas());

		return dao.crearRol(rol);
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
	public int crearConcentrador(String concentrador) {
		return dao.crearConcentrador(concentrador);
	}

	@Override
	public int crearMedidor(String medidor) {
		return dao.crearMedidor(medidor);
	}

	@Override
	public int crearFtp(Ftp f) {
		String passOrigin = DigestUtils.md5Hex(f.getPassword());
		f.setPassword(passOrigin);
		return dao.crearFtp(f);
	}

	@Override
	public int crearMedida(ObjetoJson json) {
		// array que va a contener el id de las medidas, el id de AI, AE etc.
		List<String> idInfomedidas = new ArrayList<>();
		// array que va a contener el id del medidor y el id de la trazabilidad para
		// crear la medida.
		List<String> resultado = new ArrayList<>();
		
		// -- - - - - - - -- - - - - - - - -- - - - -- - - - - -- - - - valores medidas parciales

		// esta parte realiza el guardado por arreglo de infomedidas del json, es decir
		// toma cada valor del arreglo de infomedida del json y es para cada arreglo,
		// para cuando se vaya a recorrer
		// no tome los valores del ultimo arreglo y con eso arme la medida, sino que
		// tome cada valor de cada arreglo
		List<String> valorInfomedida = new ArrayList<>();
		String numValorActiveImport = "";
		String numValorActiveExport = "";
		String numValorBitOfQuality = "";
		String numValorQ1 = "";
		String numValorQ2 = "";
		String numValorQ3 = "";
		String numValorQ4 = "";
		// -- - - - - - - -- - - - - - - - -- - - - -- - - - - -- - - - valores medidas parciales

		// -- - - - - - - -- - - - - - - - -- - - - -- - - - - -- - - - fechas
		// Lo mismo de los valores de las medidas aplica para las fechas
		List<String> fechas = new ArrayList<>();
		String fecha = "";
		String horaInicio = "";
		String horaFin = "";
		// -- - - - - - - -- - - - - - - - -- - - - -- - - - - -- - - - fechas

		int medidaCreada = 0;
		// se recorre el arreglo de objetoJson (objetoJson tiene un arreglo de tipo
		// objetoJson)
		for (int j = 0; j < json.getArreglo().size(); j++) {

			// recorro los arreglos de infomedida que contenga un objeto json y le saco sus
			// valores, es decir recorro lo siguiente
			// "infoMeasure": [
			// {
			// "activeImport":"0", "activeExpor":"0", "bitOfQuality":"00",
			// "date":"20201202190000000W", "Q":[0, 0, 0, 0]
			// }
			resultado = validarCreacionMedidas(json, j);
			for (int i = 0; i < json.getArreglo().get(j).getInfoMeasure().size(); i++) {
				numValorActiveImport = json.getArreglo().get(j).getInfoMeasure().get(i).getActiveImport();
				numValorActiveExport = json.getArreglo().get(j).getInfoMeasure().get(i).getActiveExpor();
				numValorBitOfQuality = json.getArreglo().get(j).getInfoMeasure().get(i).getBitOfQuality();
				numValorQ1 = json.getArreglo().get(j).getInfoMeasure().get(i).Q.get(0);
				numValorQ2 = json.getArreglo().get(j).getInfoMeasure().get(i).Q.get(1);
				numValorQ3 = json.getArreglo().get(j).getInfoMeasure().get(i).Q.get(2);
				numValorQ4 = json.getArreglo().get(j).getInfoMeasure().get(i).Q.get(3);
				// obtengo valores de infomedida y lo guardo en el arreglo valorInfomedida que
				// luego se mandara al dao para crear la medida
				valorInfomedida.add(numValorActiveImport);
				valorInfomedida.add(numValorActiveExport);
				valorInfomedida.add(numValorBitOfQuality);
				valorInfomedida.add(numValorQ1);
				valorInfomedida.add(numValorQ2);
				valorInfomedida.add(numValorQ3);
				valorInfomedida.add(numValorQ4);
				// obtengo la fecha del arreglo infomedida y la parseo con el metodo de
				// parseFecha y obtengo de igual manera
				// la hora inicio y la hora fin y se guarda en el arreglo de fechas para
				// enviarse al dao en el cual se crea la medida
				fecha = parserFecha(json.getArreglo().get(j).getInfoMeasure().get(i).getDate());
				horaInicio = fecha.substring(11, 16);
				horaFin = agregarHora(horaInicio);
				fechas.add(fecha);
				fechas.add(horaInicio);
				fechas.add(horaFin);
				try {
					// obtengo tanto el id del medidor y el id de la trazabilidad en la lista
					// resultado y se envia al dao
					// para la creacion de la medida
					// obtengo los id de los nombres de las medidas de la tabla infomedida
					// tomandolos directamente de la base de datos
					// ir a ver el metodo para entender
					idInfomedidas = nombreMedidas();
					medidaCreada = dao.crearMedidaPrueba(resultado, valorInfomedida, fechas, idInfomedidas);
					valorInfomedida.remove(0);
					valorInfomedida.remove(0);
					valorInfomedida.remove(0);
					valorInfomedida.remove(0);
					valorInfomedida.remove(0);
					valorInfomedida.remove(0);
					valorInfomedida.remove(0);
					fechas.remove(0);
					fechas.remove(0);
					fechas.remove(0);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return medidaCreada;
	}

	/*
	 * Parametros:Objeto json y un entero j, que es la posicion del arreglo que
	 * tiene el json, es decir json.getArreglo.get(j) para poder tener la referencia
	 * a que objeto del arreglo json estoy apuntando. Descripcion: Metodo que
	 * obtiene el id del medidor y el id de la trazabilidad para la creacion de la
	 * medida Return: Lista con el id del medidor y el id de la trazabilidad.
	 */
	public List<String> validarCreacionMedidas(ObjetoJson json, int j) {
		List<Object> resultado = new ArrayList<Object>();
		List<String> medidaResultado = new ArrayList<>();

		boolean validarSerialMedidor = validarSerialMedidor(json, j);
		List<Map<String, Object>> idMedidor = dao.obtenerIdMedidor(json, j);
		if (validarSerialMedidor == true) {
			for (Map<String, Object> map : idMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
		}

		medidaResultado.add(resultado.get(0).toString());

		boolean validarSerialConcentrador = validarSerialConcentrador(json, j);
		List<Map<String, Object>> idConcentrador = dao.obtenerIdConcentrador(json, j);
		if (validarSerialConcentrador == true) {
			for (Map<String, Object> map : idConcentrador) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
		}

		// crea el registro en la tabla asociacion de medidor con concentrador

		dao.crearAsociacionCncMet(resultado);

		// creo tabla de trazabilidad con el nameFile
		dao.crearTrazabilidad(json, j);

		List<Map<String, Object>> idTrazabilidad = dao.obtenerIdTrazabilidad(json, j);
		for (Map<String, Object> map : idTrazabilidad) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				resultado.add(value);
			}
		}
		medidaResultado.add(resultado.get(2).toString());

		return medidaResultado;
	}

	/*
	 * Descripcion: Metodo que sirve para hacer match del nombre que viene del json,
	 * al nombre de la medida que esta guardada en la base de datos. Por ejemplo, si
	 * en el json viene el nombre activeImport lo que hago es traerme el id de esa
	 * medida que en la base de datos se llama AI. Asi para cada caso en cuestion.
	 * 
	 * Return: arreglo con todos los ids de los nombres de las medidas de la tabla
	 * infomedida en la base de datos.
	 */
	public List<String> nombreMedidas() {
		List<Map<String, Object>> nombreMedida = new ArrayList<>();
		List<String> ids = new ArrayList<String>();
		List<Object> resultado = new ArrayList<Object>();
		List<String> arreglo = new ArrayList<>();
		arreglo.add("activeImport");
		arreglo.add("activeExpor");
		arreglo.add("bitOfQuality");
		arreglo.add("Q[0]");
		arreglo.add("Q[1]");
		arreglo.add("Q[2]");
		arreglo.add("Q[3]");

		for (int i = 0; i < arreglo.size(); i++) {

			switch (arreglo.get(i)) {
			case "activeImport":
				nombreMedida = dao.obtenerIdInfoMedidaActivaImportada();
				for (Map<String, Object> map : nombreMedida) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				break;
			case "activeExpor":
				nombreMedida = dao.obtenerIdInfoMedidaActivaExportada();
				for (Map<String, Object> map : nombreMedida) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				break;
			case "bitOfQuality":
				nombreMedida = dao.obtenerIdInfoMedidaBitCalidad();
				for (Map<String, Object> map : nombreMedida) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}

				break;
			case "Q[0]":
				nombreMedida = dao.obtenerIdInfoMedidaQ0();
				for (Map<String, Object> map : nombreMedida) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				break;
			case "Q[1]":
				nombreMedida = dao.obtenerIdInfoMedidaQ1();
				for (Map<String, Object> map : nombreMedida) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				break;
			case "Q[2]":
				nombreMedida = dao.obtenerIdInfoMedidaQ2();
				for (Map<String, Object> map : nombreMedida) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				break;
			case "Q[3]":
				nombreMedida = dao.obtenerIdInfoMedidaQ3();
				for (Map<String, Object> map : nombreMedida) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				break;
			default:
				break;
			}

		}
		ids.add(resultado.get(0).toString());
		ids.add(resultado.get(1).toString());
		ids.add(resultado.get(2).toString());
		ids.add(resultado.get(3).toString());
		ids.add(resultado.get(4).toString());
		ids.add(resultado.get(5).toString());
		ids.add(resultado.get(6).toString());

		return ids;
	}

	/*
	 * Metodo que parsea la fecha que viene en el json al formato de yyyy/MM/dd
	 * HH:mm Return: fecha parseada.
	 */
	public String parserFecha(String fecha) {
		String fechaHora = "";
		try {
			SimpleDateFormat date = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			SimpleDateFormat ndate = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			Date fechan = date.parse(fecha.trim());
			fechaHora = ndate.format(fechan);
		} catch (Exception e) {
			fechaHora = null;
		}
		return fechaHora;
	}

	/*
	 * Descripcion: Metodo que agrega una hora de mas a la hora inicio que se
	 * obtiene de la fecha que viene en el json
	 */
	public String agregarHora(String horaInicio) {
		String horaFormateada = "";
		try {

			SimpleDateFormat hora = new SimpleDateFormat("HH:mm");
			Date horaI = hora.parse(horaInicio);
			java.util.Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(horaI);
			cal.add(GregorianCalendar.HOUR, 1);
			horaFormateada = hora.format(cal.getTime());
		} catch (Exception e) {
			horaFormateada = null;
		}

		return horaFormateada;
	}

	/*
	 * Parametros: Objeto json y un entero j, que es la posicion del arreglo que
	 * tiene el json, es decir json.getArreglo.get(j) para poder tener la referencia
	 * a que objeto del arreglo json estoy apuntando. Descripcion: Metodo que valida
	 * el serial del medidor que viene en el json. En caso de que no se encuentre el
	 * medidor en la base de datos, se crea este con su serial. Return: True si
	 * encuentra el medidor en la base de datos, false en caso contrario.
	 */
	public boolean validarSerialMedidor(ObjetoJson json, int j) {
		boolean resultado = false;
		List<String> serialesMedidores = new ArrayList<String>();
		// dao.serialMedidores: se trae todos los seriales de los medidores que estan en
		// la base de datos
		List<Map<String, Object>> medidores = dao.serialMedidores();
		for (Map<String, Object> map : medidores) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				serialesMedidores.add((String) value);
			}
		}
		for (int i = 0; i < serialesMedidores.size(); i++) {
			if (serialesMedidores.size() == 0) {

			} else {
				if (serialesMedidores.get(i).equals(json.getArreglo().get(j).getMeter())) {
					resultado = true;
				}

			}
		}
		if (resultado == false) {
			dao.crearMedidor(json.getArreglo().get(j).getMeter());
			resultado = true;
		}

		return resultado;
	}

	/*
	 * Parametros: Objeto json y un entero j, que es la posicion del arreglo que
	 * tiene el json, es decir json.getArreglo.get(j) para poder tener la referencia
	 * a que objeto del arreglo json estoy apuntando. Descripcion: Metodo que valida
	 * el serial del concentrador que viene en json. En caso en que el concentrador
	 * no se encuentre en la base de datos, se crea con su serial. Return: True si
	 * el serial del concentrador se encuentra en la base de datos, false en caso
	 * contrario.
	 */
	public boolean validarSerialConcentrador(ObjetoJson json, int j) {
		boolean resultado = false;
		List<String> serialesConcentradores = new ArrayList<String>();
		// dao.serialConcentradores: se trae todos los seriales de los concentradores
		// que estan en la base de datos.
		List<Map<String, Object>> concentradores = dao.serialConcentradores();
		for (Map<String, Object> map : concentradores) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				serialesConcentradores.add((String) value);
			}
		}
		for (int i = 0; i < serialesConcentradores.size(); i++) {
			if (serialesConcentradores.size() == 0) {

			} else {

				if (serialesConcentradores.get(i).equals(json.getArreglo().get(j).getConcentrator())) {
					resultado = true;
				}
			}
		}

		if (resultado == false) {
			dao.crearConcentrador(json.getArreglo().get(j).getConcentrator());
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
