package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
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
	
	@PostMapping("/cuatro/")
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
	
}
