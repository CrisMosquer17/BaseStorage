package com.InpetelCloud.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Service.ConsultasService;

@RestController
@RequestMapping(path= "/consulta")
public class ConsultasController {

	@Autowired
	ConsultasService service;
	
	@GetMapping("/verUsers")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Usuarios(){
		return service.Usuarios();
	}
	
	@GetMapping("/verConcentradores")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Concentradores(){
		return service.Concentradores();
	}
	
	@GetMapping("/verTransformadores")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Transformadores(){
		return service.Transformadores();
	}
	
	@GetMapping("/verMedidores")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Medidores(){
		return service.Medidores();
	}
	
	@GetMapping("/verMedidas")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Medidas(){
		return service.Medidas();
	}
	
	@GetMapping("/verSistemasExternos")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> SistemasExternos(){
		return service.SistemasExternos();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
