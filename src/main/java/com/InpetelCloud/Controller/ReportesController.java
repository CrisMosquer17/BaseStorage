package com.InpetelCloud.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Service.ReportesService;

@RestController
@RequestMapping(path="/reporte/")
public class ReportesController {
	
	@Autowired
	ReportesService service;
	
//	@GetMapping("/curvaHoraria")
//	@CrossOrigin(origins="*")
//	public List<Map<String, Object>> curvaHoraria(@RequestParam("reporte") String reporte,@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin, @RequestParam("medidores")String medidores ) {
//		return service.curvaHoraria(reporte, fechaInicio, fechaFin, medidores);
//	}
//	@GetMapping("/curvaDiaria")
//	@CrossOrigin(origins="*")
//	public List<Map<String, Object>> curvaDiaria(@RequestParam("reporte") String reporte,@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin, @RequestParam("medidores")String medidores ) {
//		return service.curvaDiaria(reporte, fechaInicio, fechaFin, medidores);
//	}
//	
//	@GetMapping("/eventoMedidor")
//	@CrossOrigin(origins="*")
//	public List<Map<String, Object>> eventoMedidor(@RequestParam("reporte") String reporte,@RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin, @RequestParam("medidores")String medidores) {
//		return service.eventoMedidor(reporte, fechaInicio, fechaFin, medidores);
//	}
	
	@GetMapping("/reportes")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> eventoMedidor(@RequestParam("reporte") String reporte, @RequestParam("reporte") String serialCnc, @RequestParam("fechaInicio") String fechaInicio, @RequestParam("fechaFin") String fechaFin, @RequestParam("medidores")String medidores) {
		return service.reporte(reporte, serialCnc, fechaInicio, fechaFin, medidores);
	}

}
