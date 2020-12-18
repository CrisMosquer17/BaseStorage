package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Model.objetoJsonG3;
import com.InpetelCloud.Model.objetoJsonG3S03;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.ObjetoJson;
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
import com.InpetelCloud.Service.InsercionService;

@RestController
@RequestMapping(path ="/client")
public class InsercionController {
	
	@Autowired
	InsercionService service;
	

	@GetMapping("/tres/{name}")
	@CrossOrigin(origins="*")
	public void schemaCreate(@PathVariable String name) {
		service.schemaCreate(name);
	}
	
	@PostMapping("/crearSistemaExterno/")
	@CrossOrigin(origins="*")
	public int crearSistemaExterno(@RequestBody SistemExterno se) {
		return service.crearSistemaExterno(se);
	}
	
	@PostMapping("/crearRol/")
	@CrossOrigin(origins="*")
	public int crearRol(@RequestBody Rol rol) {
		return service.crearRol(rol);
	}
	
	@PostMapping("/crearMarca/")
	@CrossOrigin(origins="*")
	public int crearMarca(@RequestBody Marca marca) {
		return service.crearMarca(marca);
	}
	
	@PostMapping("/crearTecnologiaComponente/")
	@CrossOrigin(origins = "*")
	public int crearTecnologiaComponente(@RequestBody TecnologiaComponente tecnologiaComponente) {
		return service.crearTecnologiaComponente(tecnologiaComponente);
	}
	
	@PostMapping("/crearModem/")
	@CrossOrigin(origins = "*")
	public int crearModem(@RequestBody Modem modem) {
		return service.crearModem(modem);
	}
	
	@PostMapping("/crearTipoComunicacion/")
	@CrossOrigin(origins = "*")
	public int crearTipoComunicacion(@RequestBody TipoComunicacion tipoComunicacion) {
		return service.crearTipoComunicacion(tipoComunicacion);
	}
	
	@PostMapping("/crearTiempoConectado/")
	@CrossOrigin(origins = "*")
	public int crearTiempoConectado(@RequestBody TiempoConectado tiempoConectado) {
		return service.crearTiempoConectado(tiempoConectado);
	}
	
	@PostMapping("/crearTipoMedidor/")
	@CrossOrigin(origins = "*")
	public int crearTipoMedidor(@RequestBody TipoMedidor tipoMedidor) {
		return service.crearTipoMedidor(tipoMedidor);
	}
	
	
	@PostMapping("/crearTipoPuerto/")
	@CrossOrigin(origins = "*")
	public int crearTipoMedidor(@RequestBody TipoPuerto tipoPuerto) {
		return service.crearTipoPuerto(tipoPuerto);
	}
	
	@PostMapping("/crearEstado/")
	@CrossOrigin(origins = "*")
	public int crearEstado(@RequestBody Estados estado) {
		return service.crearEstado(estado);
	}
	
	@PostMapping("/crearTransformador/")
	@CrossOrigin(origins = "*")
	public int crearTransformador(@RequestBody Transformador transformador) {
		return service.crearTransformador(transformador);
	}
	
	@PostMapping("/crearUsuario/")
	@CrossOrigin(origins = "*")
	public int crearUsuario(@RequestBody Usuarios usuario) {
		return service.crearUsuario(usuario);
	}
	
	@PostMapping("/crearFtp/")
	@CrossOrigin(origins = "*")
	public int crearFtp(@RequestBody Ftp f) {
		return service.crearFtp(f);
	}

	@PostMapping("/crearMedida/")
	@CrossOrigin(origins = "*")
	public int crearMedida(@RequestBody ObjetoJson json) {
		return service.crearMedida(json);
	}
	
	@PostMapping("/crearMedidaS03/")
	@CrossOrigin(origins = "*")
	public int crearMedidaS03(@RequestBody ObjetoJsonS03 jsons03) {
		return service.crearMedidaS03(jsons03);
	}
	
	@PostMapping("/crearMedidor/")
	@CrossOrigin(origins = "*")
	public int crearMedidor(@RequestBody modelMeter medidor) {
		return service.crearMedidor(medidor);
	}
	
	@PostMapping("/crearConcentrador/")
	@CrossOrigin(origins = "*")
	public int crearConcentrador(@RequestBody modelConcentrator concentrador) {
		return service.crearConcentrador(concentrador);
	}
	
	@PostMapping("/crearMedidaG3/")
	@CrossOrigin(origins = "*")
	public int crearMedidaG3Horaria(@RequestBody objetoJsonG3 jsons03) {
		return service.crearMedidaG3Horaria(jsons03);
	}
	
	@PostMapping("/crearMedidaG3Diaria/")
	@CrossOrigin(origins = "*")
	public int crearMedidaG3Diaria(@RequestBody objetoJsonG3S03 jsong3s03) {
		return service.crearMedidaG3Diaria(jsong3s03);
	}	
	
}
