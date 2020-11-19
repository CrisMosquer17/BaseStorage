package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.SistemExterno;
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
}
