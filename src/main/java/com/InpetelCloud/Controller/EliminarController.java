package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Service.EliminarService;

@RestController
@RequestMapping(path= "/eliminar")
public class EliminarController {
	
	@Autowired
	EliminarService service;
	
	@PutMapping("/eliminarSistemaExterno/{id}")
	@CrossOrigin(origins="*")
	public int eliminarSistemaExterno(@RequestBody SistemExterno se, @PathVariable Long id) {
		return service.eliminarSistemaExterno(se,id);
	}
	
	@DeleteMapping("/eliminarRol/{id}")
	@CrossOrigin(origins="*")
	public int eliminarRol(@PathVariable Long id) {
		return service.eliminarRol(id);
	}
	
	@DeleteMapping("/eliminarMarca/{id}/{nombre}")
	@CrossOrigin(origins="*")
	public int eliminarMarca(@PathVariable Long id, @PathVariable String nombre) {
		return service.eliminarMarca(id, nombre);
	}
	
	@DeleteMapping("/eliminarTecnologiaComponente/{id}")
	@CrossOrigin(origins="*")
	public int eliminarTeconologiaComponente(@PathVariable Long id) {
		return service.eliminarTeconologiaComponente(id);
	}
	
	@DeleteMapping("/eliminarModem/{id}")
	@CrossOrigin(origins="*")
	public int eliminarModem(@PathVariable Long id) {
		return service.eliminarModem(id);
	}
	
	@DeleteMapping("/eliminarTipoComunicacion/{id}")
	@CrossOrigin(origins="*")
	public int eliminarTipoComunicacion(@PathVariable Long id) {
		return service.eliminarTipoComunicacion(id);
	}
	
	@DeleteMapping("/eliminarTiempoConectado/{id}")
	@CrossOrigin(origins="*")
	public int eliminarTiempoConectado(@PathVariable Long id) {
		return service.eliminarTiempoConectado(id);
	}
	
	@DeleteMapping("/eliminarTipoMedidor/{id}")
	@CrossOrigin(origins="*")
	public int eliminarTipoMedidor(@PathVariable Long id) {
		return service.eliminarTipoMedidor(id);
	}
	
	@DeleteMapping("/eliminarTipoPuerto/{id}")
	@CrossOrigin(origins="*")
	public int eliminarTipoPuerto(@PathVariable Long id) {
		return service.eliminarTipoPuerto(id);
	}
	
	@DeleteMapping("/eliminarEstado/{id}")
	@CrossOrigin(origins="*")
	public int eliminarEstado(@PathVariable Long id) {
		return service.eliminarEstado(id);
	}

	@PutMapping("/eliminarTransformador/{id}")
	@CrossOrigin(origins="*")
	public int eliminarTransformador(@RequestBody Transformador transformador,@PathVariable Long id) {
		return service.eliminarTransformador(transformador,id);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	@CrossOrigin(origins="*")
	public int eliminarUsuario(@PathVariable Long id) {
		return service.eliminarUsuario(id);
	}
	
	@PutMapping("/eliminarMedidor/{id}")
	@CrossOrigin(origins="*")
	public int eliminarMedidor(@RequestBody modelMeter medidor, @PathVariable Long id) {
		return service.eliminarMedidor(medidor,id);
	}

	@PutMapping("/eliminarConcentrador/{id}")
	@CrossOrigin(origins="*")
	public int eliminarConcentrador(@RequestBody modelConcentrator concentrador, @PathVariable Long id) {
		return service.eliminarConcentrador(concentrador, id);
	}
	
	@DeleteMapping("/eliminarMacro/{id}")
	@CrossOrigin(origins="*")
	public int eliminarMacro(@PathVariable Long id) {
		return service.eliminarMacro(id);
	}

}
