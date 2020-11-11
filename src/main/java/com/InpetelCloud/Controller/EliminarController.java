package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Service.EliminarService;

@RestController
@RequestMapping(path= "/eliminar")
public class EliminarController {
	
	@Autowired
	EliminarService service;

}
