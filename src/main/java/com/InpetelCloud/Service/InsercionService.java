package com.InpetelCloud.Service;

import java.text.ParseException;
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
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Model.objetoJsonG3;
import com.InpetelCloud.Model.objetoJsonG3S03;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.ObjetoJson;
import com.InpetelCloud.Model.ObjetoJsonEventos;
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
		int crea=0;
		
		List<Map<String,Object>> validacion=dao.validarModem(modem);
		if(validacion.size() >= 1) {
			//ya existe ese modem en la base de datos
			crea = 2;
		}
		else {
			crea = dao.crearModem(modem);
			}
		
		return crea;
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
	public int crearConcentradorMedida(String concentrador) {
		return dao.crearConcentradorMedida(concentrador);
	}

	@Override
	public int crearMedidorMedida(String medidor) {
		return dao.crearMedidorMedida(medidor);
	}
	
	@Override
	public int crearMedidor(modelMeter medidor) {
		int validate=0;
		
		List<Map<String, Object>> existeCnc= new ArrayList<Map<String,Object>>();
		ArrayList<String> idMet = dao.serialesMedidor(medidor);
		//validaciones para el medidor
		if(idMet.size() == 1) {
			validate= dao.updateMedidor(medidor, idMet.get(0));
		}
		else {
			validate = dao.crearMedidor(medidor);

		}	
		
		existeCnc = dao.cncSerial(medidor.getConcentrator().toString());
		if(existeCnc.size() == 0) {
			dao.crearConcentradorMedida(medidor.getConcentrator().toString());
		}
		else {
			
			//validar si ese concentrador existe en la tabla asociacion
			ArrayList<String> idAsoCncMet = dao.validarSerialCncTablaAsociacion(medidor);

			List<Object> resultado = new ArrayList<Object>();
			if(idAsoCncMet.size() ==1) {
				dao.updateAsoCncMet(medidor, idAsoCncMet.get(0));
			}
			else {

				List<Map<String, Object>> idMedidor = dao.obtenerIdMedidorMedida(medidor);
				for (Map<String, Object> map : idMedidor) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				List<Map<String, Object>> idConcentrador = dao.obtenerIdConcentradorMedida(medidor);
				for (Map<String, Object> map : idConcentrador) {
					for (Map.Entry<String, Object> entry : map.entrySet()) {
						Object value = entry.getValue();
						resultado.add(value);
					}
				}
				
				dao.crearAsociacionCncMet(resultado);
				
				
			}
			
		}
		
		
		
	
		return validate;
	}

	@Override
	public int crearConcentrador(modelConcentrator concentrador) {
		int validate=0;
		ArrayList<String> idcnc= dao.serialesCnc(concentrador);
		if(idcnc.size() == 1) {
			validate = dao.updateConcentrador(concentrador, idcnc.get(0));
		}
		else {
			validate= dao.crearConcentrador(concentrador);
		}
		
		return validate;
	}

	@Override
	public int crearFtp(Ftp f) {
		String passOrigin = DigestUtils.md5Hex(f.getPassword());
		f.setPassword(passOrigin);
		return dao.crearFtp(f);
	}
	
	@Override
	public int crearTransformador(Transformador transformador) {
		int crea=0;
		List<Map<String,Object>> validacionAsociacion=dao.validarAsoTransformadorCnc(transformador);
		ArrayList<String> id = new ArrayList<String>();
		
		if(validacionAsociacion.size() == 1) {
			for (int i = 0; i < validacionAsociacion.size(); i++) {
				id.add(validacionAsociacion.get(i).get("ID").toString());
			}
			crea=dao.updateTransformador(transformador, id.get(0));
		}
		
		else {
			crea= dao.crearTransformador(transformador);
			
		}

		return crea;
	}

	@Override
	public int crearUsuario(Usuarios usuario) {
		int crea=0;
		String passOrigin = DigestUtils.md5Hex(usuario.getPassword());
		String passSalt = DigestUtils.md5Hex(usuario.getPassword_salt());
		usuario.setPassword(passOrigin);
		usuario.setPassword_salt(passSalt);
		List<Map<String,Object>> validacion=dao.validarUsuario(usuario);
		if(validacion.size() >= 1) {
			//ya existe ese usuario en la base de datos
			crea = 2;
		}
		else {
			crea = dao.crearUsuario(usuario);
			}
		
		return crea;
	}
	
	
/**
 * INICIO DE METODOS PARA CREAR UNA MEDIDA PARA EL REPORTE S02
 */
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
		for (int j = 0; j < json.getHours().size(); j++) {

			// recorro los arreglos de infomedida que contenga un objeto json y le saco sus
			// valores, es decir recorro lo siguiente
			// "infoMeasure": [
			// {
			// "activeImport":"0", "activeExpor":"0", "bitOfQuality":"00",
			// "date":"20201202190000000W", "Q":[0, 0, 0, 0]
			// }
			resultado = validarCreacionMedidas(json, j);
			for (int i = 0; i < json.getHours().get(j).getInfoMeasure().size(); i++) {
				numValorActiveImport = json.getHours().get(j).getInfoMeasure().get(i).getActiveImport();
				numValorActiveExport = json.getHours().get(j).getInfoMeasure().get(i).getActiveExpor();
				numValorBitOfQuality = json.getHours().get(j).getInfoMeasure().get(i).getBitOfQuality();
				numValorQ1 = json.getHours().get(j).getInfoMeasure().get(i).Q.get(0);
				numValorQ2 = json.getHours().get(j).getInfoMeasure().get(i).Q.get(1);
				numValorQ3 = json.getHours().get(j).getInfoMeasure().get(i).Q.get(2);
				numValorQ4 = json.getHours().get(j).getInfoMeasure().get(i).Q.get(3);
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
				fecha = parserFecha(json.getHours().get(j).getInfoMeasure().get(i).getDate());
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
					medidaCreada = dao.crearMedidaPrime(resultado, valorInfomedida, fechas, idInfomedidas);
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
	//2020-12-16T00:00:00-05:00
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
	
	public String parserFechaUtc(String fecha) {
		String fechaHora = "";
		try {
			SimpleDateFormat date = new SimpleDateFormat("yyyyMMddTHHmmssSSS");
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
	
	public String restarCinco(String horaInicio) {
		String horaFormateada = "";
		horaInicio = horaInicio.substring(0,19);
		try {

			SimpleDateFormat hora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
			Date horaI = hora.parse(horaInicio);
			java.util.Calendar cal = GregorianCalendar.getInstance();
			cal.setTime(horaI);
			cal.add(GregorianCalendar.HOUR, -5);
			horaFormateada = hora.format(cal.getTime());
						
		} catch (Exception e) {
			horaFormateada = null;
		}

		return horaFormateada;
	}
	
	public String formatFecha(String horaFormateada) {
		String fechaFin = "";
		SimpleDateFormat hora = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date fecha = hora.parse(horaFormateada);
			 fechaFin = outputFormat.format(fecha);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fechaFin;
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
				if (serialesMedidores.get(i).equals(json.getHours().get(j).getMeter())) {
					resultado = true;
				}

			}
		}
		if (resultado == false) {
			dao.crearMedidorMedida(json.getHours().get(j).getMeter());
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

				if (serialesConcentradores.get(i).equals(json.getHours().get(j).getConcentrator())) {
					resultado = true;
				}
			}
		}

		if (resultado == false) {
			dao.crearConcentradorMedida(json.getHours().get(j).getConcentrator());
			resultado = true;
		}
		return resultado;
	}
	
	public int recibej(int j) {
		return j;
	}
	
	/**
	 * FIN DE METODOS PARA CREAR UNA MEDIDA PARA EL REPORTE S02
	 */



	/**
	 * INICIO DE METODOS PARA CREAR UNA MEDIDA PARA EL REPORTE S03
	 */
	@Override
	public int crearMedidaS03(ObjetoJsonS03 jsons03) {
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
				for (int j = 0; j < jsons03.getDays().size(); j++) {

					// recorro los arreglos de infomedida que contenga un objeto json y le saco sus
					// valores, es decir recorro lo siguiente
					// "infoMeasure": [
					// {
					// "activeImport":"0", "activeExpor":"0", "bitOfQuality":"00",
					// "date":"20201202190000000W", "Q":[0, 0, 0, 0]
					// }
					resultado = validarCreacionMedidasS03(jsons03, j);
					for (int i = 0; i < jsons03.getDays().get(j).getInfoMeasure().size(); i++) {
						numValorActiveImport = jsons03.getDays().get(j).getInfoMeasure().get(i).getActiveImport();
						numValorActiveExport = jsons03.getDays().get(j).getInfoMeasure().get(i).getActiveExpor();
						numValorBitOfQuality = jsons03.getDays().get(j).getInfoMeasure().get(i).getBitOfQuality();
						numValorQ1 = jsons03.getDays().get(j).getInfoMeasure().get(i).Q.get(0);
						numValorQ2 = jsons03.getDays().get(j).getInfoMeasure().get(i).Q.get(1);
						numValorQ3 = jsons03.getDays().get(j).getInfoMeasure().get(i).Q.get(2);
						numValorQ4 = jsons03.getDays().get(j).getInfoMeasure().get(i).Q.get(3);
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
						fecha = parserFecha(jsons03.getDays().get(j).getInfoMeasure().get(i).getDate());
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
							medidaCreada = dao.crearMedidaPrime(resultado, valorInfomedida, fechas, idInfomedidas);
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
	public List<String> validarCreacionMedidasS03(ObjetoJsonS03 jsons03, int j) {
		List<Object> resultado = new ArrayList<Object>();
		List<String> medidaResultado = new ArrayList<>();

		boolean validarSerialMedidor = validarSerialMedidorS03(jsons03, j);
		List<Map<String, Object>> idMedidor = dao.obtenerIdMedidorS03(jsons03, j);
		if (validarSerialMedidor == true) {
			for (Map<String, Object> map : idMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
		}

		medidaResultado.add(resultado.get(0).toString());

		boolean validarSerialConcentrador = validarSerialConcentradorS03(jsons03, j);
		List<Map<String, Object>> idConcentrador = dao.obtenerIdConcentradorS03(jsons03, j);
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
		dao.crearTrazabilidadS03(jsons03, j);

		List<Map<String, Object>> idTrazabilidad = dao.obtenerIdTrazabilidadS03(jsons03, j);
		for (Map<String, Object> map : idTrazabilidad) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				resultado.add(value);
			}
		}
		medidaResultado.add(resultado.get(2).toString());

		return medidaResultado;
	}
	
	public boolean validarSerialMedidorS03(ObjetoJsonS03 jsons03, int j) {
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
				if (serialesMedidores.get(i).equals(jsons03.getDays().get(j).getMeter())) {
					resultado = true;
				}

			}
		}
		if (resultado == false) {
			dao.crearMedidorMedida(jsons03.getDays().get(j).getMeter());
			resultado = true;
		}

		return resultado;
	}
	
	public boolean validarSerialConcentradorS03(ObjetoJsonS03 jsons03, int j) {
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

				if (serialesConcentradores.get(i).equals(jsons03.getDays().get(j).getConcentrator())) {
					resultado = true;
				}
			}
		}

		if (resultado == false) {
			dao.crearConcentradorMedida(jsons03.getDays().get(j).getConcentrator());
			resultado = true;
		}
		return resultado;
	}

	
	/**
	 * FIN DE METODOS PARA CREAR UNA MEDIDA PARA EL REPORTE S03
	 */
	
	
	
	/**
	 * COMIENZO DE METODOS PARA CREAR UN EVENTO PARA EL CONCENTRADOR
	 */
//	
//	@Override
//	public int crearEventoConcentrador(ObjetoJsonEventos evento) {
//		return 0;
//	}
	
	
	
	
//	public boolean validarSerialConcentradorEvento(ObjetoJsonEventos evento, int j) {
//		boolean resultado = false;
//		List<String> serialesConcentradores = new ArrayList<String>();
//		// dao.serialConcentradores: se trae todos los seriales de los concentradores
//		// que estan en la base de datos.
//		List<Map<String, Object>> concentradores = dao.serialConcentradores();
//		for (Map<String, Object> map : concentradores) {
//			for (Map.Entry<String, Object> entry : map.entrySet()) {
//				Object value = entry.getValue();
//				serialesConcentradores.add((String) value);
//			}
//		}
//		for (int i = 0; i < serialesConcentradores.size(); i++) {
//			if (serialesConcentradores.size() == 0) {
//
//			} else {
//
//				if (serialesConcentradores.get(i).equals(evento.getEventos().get(j).getConcentrator())) {
//					resultado = true;
//				}
//			}
//		}
//
//		if (resultado == false) {
//			dao.crearConcentradorMedida(evento.getEventos().get(j).getConcentrator());
//			resultado = true;
//		}
//		return resultado;
//	}
	

	/**
	 * INICIO DE CREACION DE MEDIDAS PARA G3 HORARIA -------------------------------------------------------------------------------------------------------
	 */
	@Override
	public int crearMedidaG3Horaria(objetoJsonG3 jsong3) {
		int medidaCreada = 0;
		List<String> resultado = new ArrayList<>();
		
		List<String> valorRegister = new ArrayList<>();
		List<String> idRegister = new ArrayList<>();
		ArrayList<String> idRegisterValidado = new ArrayList<>();

		String value="";
		String status="";
		
		List<String> fechas = new ArrayList<>();
		String fecha = "";
		String horaInicio = "";
		String horaFin = "";
		
		for (int j = 0; j < jsong3.getG3().size(); j++) {
			resultado=validarCreacionMedidasG3(jsong3, j);
			for (int i = 0; i < jsong3.getG3().get(j).getRegister().size(); i++) {
				idRegisterValidado= dao.obtenerIdRegister(jsong3.getG3().get(j).getRegister().get(i).getIdRegister().toString());
				if(idRegisterValidado.size() > 0) {
					value=jsong3.getG3().get(j).getRegister().get(i).getValue();
					status=jsong3.getG3().get(j).getRegister().get(i).getStatus();
					idRegister.add(idRegisterValidado.get(0));
					valorRegister.add(value);
					valorRegister.add(status);
					//valorRegister.add(unit);
					fecha = formatFecha(restarCinco(jsong3.getG3().get(j).getRegister().get(i).getDate()));
					horaInicio = fecha.substring(11,15);
					horaFin = agregarHora(horaInicio);
					fechas.add(fecha);
					fechas.add(horaInicio);
					fechas.add(horaFin);
					medidaCreada = dao.crearMedidaG3(resultado, idRegister, fechas, valorRegister);
					
					idRegister.remove(0);
					valorRegister.remove(0);
					valorRegister.remove(0);
					fechas.remove(0);
					fechas.remove(0);
					fechas.remove(0);
					
				}
				else {
					medidaCreada=0;
				}
				}
			}

		
		


		return medidaCreada;
	}
	
	public List<String> validarCreacionMedidasG3(objetoJsonG3 jsong3, int j) {
		List<Object> resultado = new ArrayList<Object>();
		List<String> medidaResultado = new ArrayList<>();

		boolean validarSerialMedidor = validarSerialMedidorG3(jsong3, j);
		List<Map<String, Object>> idMedidor = dao.obtenerIdMedidorG3(jsong3, j);
		if (validarSerialMedidor == true) {
			for (Map<String, Object> map : idMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
		}
		//serial medidor
		medidaResultado.add(resultado.get(0).toString());

		List<Map<String, Object>> idProfile = dao.obtenerIdProfile(jsong3, j);
		for (Map<String, Object> map : idProfile) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				resultado.add(value);
			}
		}
		

		

		return medidaResultado;
	}
	
	
	public boolean validarSerialMedidorG3(objetoJsonG3 jsons03, int j) {
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
				if (serialesMedidores.get(i).equals(jsons03.getG3().get(j).getMeter())) {
					resultado = true;
				}

			}
		}
		if (resultado == false) {
			dao.crearMedidorMedida(jsons03.getG3().get(j).getMeter());
			resultado = true;
		}

		return resultado;
	}
	
	/**
	 * FIN DE CREACION DE MEDIDAS PARA G3 HORARIA -------------------------------------------------------------------------------------------------------
	 */

	@Override
	public int crearMedidaG3Diaria(objetoJsonG3S03 jsong3s03) {
		int medidaCreada = 0;
		List<String> resultado = new ArrayList<>();
		
		List<String> valorRegister = new ArrayList<>();
		List<String> idRegister = new ArrayList<>();
		ArrayList<String> idRegisterValidado = new ArrayList<>();

		String value="";
		String status="";
		
		List<String> fechas = new ArrayList<>();
		String fecha = "";
		String horaInicio = "";
		String horaFin = "";
		
		for (int j = 0; j < jsong3s03.getDaysg3().size(); j++) {
			resultado=validarCreacionMedidasG3Diaria(jsong3s03, j);
			for (int i = 0; i < jsong3s03.getDaysg3().get(j).getRegister().size(); i++) {
				idRegisterValidado= dao.obtenerIdRegister(jsong3s03.getDaysg3().get(j).getRegister().get(i).getIdRegister().toString());
				if(idRegisterValidado.size() > 0) {
					value=jsong3s03.getDaysg3().get(j).getRegister().get(i).getValue();
					status=jsong3s03.getDaysg3().get(j).getRegister().get(i).getStatus();
					idRegister.add(idRegisterValidado.get(0));
					valorRegister.add(value);
					valorRegister.add(status);
					//valorRegister.add(unit);
					fecha = formatFecha(restarCinco(jsong3s03.getDaysg3().get(j).getRegister().get(i).getDate()));
					horaInicio = fecha.substring(11,15);
					horaFin = agregarHora(horaInicio);
					fechas.add(fecha);
					fechas.add(horaInicio);
					fechas.add(horaFin);
					medidaCreada = dao.crearMedidaG3(resultado, idRegister, fechas, valorRegister);
					
					idRegister.remove(0);
					valorRegister.remove(0);
					valorRegister.remove(0);
					fechas.remove(0);
					fechas.remove(0);
					fechas.remove(0);
					
				}
				else {
					medidaCreada=0;
				}
				}
			}

		
		


		return medidaCreada;
	}
	
	
	
	public List<String> validarCreacionMedidasG3Diaria(objetoJsonG3S03 jsong3s03, int j) {
		List<Object> resultado = new ArrayList<Object>();
		List<String> medidaResultado = new ArrayList<>();

		boolean validarSerialMedidor = validarSerialMedidorG3Diaria(jsong3s03, j);
		List<Map<String, Object>> idMedidor = dao.obtenerIdMedidorG3Diaria(jsong3s03, j);
		if (validarSerialMedidor == true) {
			for (Map<String, Object> map : idMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
		}
		//serial medidor
		medidaResultado.add(resultado.get(0).toString());

		List<Map<String, Object>> idProfile = dao.obtenerIdProfileG3Diaria(jsong3s03, j);
		for (Map<String, Object> map : idProfile) {
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				Object value = entry.getValue();
				resultado.add(value);
			}
		}
		

		

		return medidaResultado;
	}
	
	
	
	
	public boolean validarSerialMedidorG3Diaria(objetoJsonG3S03 jsong3s03, int j) {
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
				if (serialesMedidores.get(i).equals(jsong3s03.getDaysg3().get(j).getMeter())) {
					resultado = true;
				}

			}
		}
		if (resultado == false) {
			dao.crearMedidorMedida(jsong3s03.getDaysg3().get(j).getMeter());
			resultado = true;
		}

		return resultado;
	}



	

}
