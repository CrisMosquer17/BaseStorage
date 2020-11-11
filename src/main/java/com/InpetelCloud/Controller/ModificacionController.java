package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Service.ModificacionService;

@RestController
@RequestMapping(path= "/modificacion")
public class ModificacionController {
	
	@Autowired
	ModificacionService service;

}
