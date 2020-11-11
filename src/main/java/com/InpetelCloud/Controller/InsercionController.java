package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Service.InsercionService;

@RestController
@RequestMapping(path= "/insercion")
public class InsercionController {
	
	@Autowired
	InsercionService service;

}
