package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
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
import com.InpetelCloud.Service.ModificacionService;

@RestController
@RequestMapping(path= "/modificacion")
public class ModificacionController {
	
	@Autowired
	ModificacionService service;
	
	@PutMapping("modificarSistemaExterno/{id}")
	@CrossOrigin(origins="*")
	public void modificarSistemaExterno(@PathVariable Long id, @RequestBody SistemExterno se) {
		service.modificarSistemaExterno(id, se);
	}
	
	@PutMapping("modificarRol/{id}")
	@CrossOrigin(origins="*")
	public void modificarRol(@PathVariable Long id, @RequestBody Rol rol) {
		service.modificarRol(id, rol);
	}
	
	@PutMapping("modificarMarca/{id}")
	@CrossOrigin(origins="*")
	public void modificarMarca(@PathVariable Long id, @RequestBody Marca marca) {
		service.modificarMarca(id, marca);
	}
	
	@PutMapping("modificarTecnologiaComponente/{id}")
	@CrossOrigin(origins="*")
	public void modificarTecnologiaComponente(@PathVariable Long id, @RequestBody TecnologiaComponente tecnologiaComponente) {
		service.modificarTecnologiaComponente(id, tecnologiaComponente);
	}
	
	@PutMapping("modificarModem/{id}")
	@CrossOrigin(origins="*")
	public void modificarModem(@PathVariable Long id, @RequestBody Modem modem) {
		service.modificarModem(id, modem);
	}
	
	@PutMapping("modificarTipoComunicacion/{id}")
	@CrossOrigin(origins="*")
	public void modificarTipoComunicacion(@PathVariable Long id, @RequestBody TipoComunicacion tipoComunicacion) {
		service.modificarTipoComunicacion(id, tipoComunicacion);
	}
	
	@PutMapping("modificarTiempoConectado/{id}")
	@CrossOrigin(origins="*")
	public void modificarTiempoConectado(@PathVariable Long id, @RequestBody TiempoConectado tiempoConectado) {
		service.modificarTiempoConectado(id, tiempoConectado);
	}

}
