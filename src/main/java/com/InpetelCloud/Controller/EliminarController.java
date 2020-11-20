package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.SistemExterno;
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

}
