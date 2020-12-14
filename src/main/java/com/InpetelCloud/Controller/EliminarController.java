package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Service.EliminarService;

@RestController
@RequestMapping(path= "/eliminar")
public class EliminarController {
	
	@Autowired
	EliminarService service;
	
	@PutMapping("/{id}")
	@CrossOrigin(origins="*")
	public void eliminarSistemaExterno(@PathVariable Long id) {
		service.eliminarSistemaExterno(id);
	}
	
	@DeleteMapping("/eliminarRol/{id}")
	@CrossOrigin(origins="*")
	public void eliminarRol(@PathVariable Long id) {
		service.eliminarRol(id);
	}
	
	@DeleteMapping("/eliminarMarca/{id}/{nombre}")
	@CrossOrigin(origins="*")
	public void eliminarMarca(@PathVariable Long id, @PathVariable String nombre) {
		service.eliminarMarca(id, nombre);
	}
	
	@DeleteMapping("/eliminarTecnologiaComponente/{id}")
	@CrossOrigin(origins="*")
	public void eliminarTeconologiaComponente(@PathVariable Long id) {
		service.eliminarTeconologiaComponente(id);
	}
	
	@DeleteMapping("/eliminarModem/{id}")
	@CrossOrigin(origins="*")
	public void eliminarModem(@PathVariable Long id) {
		service.eliminarModem(id);
	}
	
	@DeleteMapping("/eliminarTipoComunicacion/{id}")
	@CrossOrigin(origins="*")
	public void eliminarTipoComunicacion(@PathVariable Long id) {
		service.eliminarTipoComunicacion(id);
	}
	
	@DeleteMapping("/eliminarTiempoConectado/{id}")
	@CrossOrigin(origins="*")
	public void eliminarTiempoConectado(@PathVariable Long id) {
		service.eliminarTiempoConectado(id);
	}
	
	@DeleteMapping("/eliminarTipoMedidor/{id}")
	@CrossOrigin(origins="*")
	public void eliminarTipoMedidor(@PathVariable Long id) {
		service.eliminarTipoMedidor(id);
	}
	
	@DeleteMapping("/eliminarTipoPuerto/{id}")
	@CrossOrigin(origins="*")
	public void eliminarTipoPuerto(@PathVariable Long id) {
		service.eliminarTipoPuerto(id);
	}
	
	@DeleteMapping("/eliminarEstado/{id}")
	@CrossOrigin(origins="*")
	public void eliminarEstado(@PathVariable Long id) {
		service.eliminarEstado(id);
	}

	@DeleteMapping("/eliminarTransformador/{id}")
	@CrossOrigin(origins="*")
	public void eliminarTransformador(@RequestBody Transformador transformador,@PathVariable Long id) {
		service.eliminarTransformador(transformador,id);
	}
	
	@DeleteMapping("/eliminarUsuario/{id}")
	@CrossOrigin(origins="*")
	public void eliminarUsuario(@PathVariable Long id) {
		service.eliminarUsuario(id);
	}
	
	@DeleteMapping("/eliminarMedidor/{id}")
	@CrossOrigin(origins="*")
	public void eliminarMedidor(@RequestBody modelMeter medidor, @PathVariable Long id) {
		service.eliminarMedidor(medidor,id);
	}

	@DeleteMapping("/eliminarConcentrador/{id}")
	@CrossOrigin(origins="*")
	public void eliminarConcentrador(@RequestBody modelConcentrator concentrador, @PathVariable Long id) {
		service.eliminarConcentrador(concentrador, id);
	}

}
