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
}
