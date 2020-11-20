package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Service.ModificacionService;

@RestController
@RequestMapping(path= "/modificacion")
public class ModificacionController {
	
	@Autowired
	ModificacionService service;
	
	@PutMapping("/{id}")
	@CrossOrigin(origins="*")
	public void modificarSistemaExterno(@PathVariable Long id, @RequestBody SistemExterno se) {
		service.modificarSistemaExterno(id, se);
	}

}
