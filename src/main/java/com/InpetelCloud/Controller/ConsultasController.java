package com.InpetelCloud.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Service.ConsultasService;

@RestController
@RequestMapping(path="/consulta/")
public class ConsultasController {

	@Autowired
	ConsultasService service;
	
	@GetMapping("/verConcentradores")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Concentradores(){
		return service.Concentradores();
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
	
	@GetMapping("/verRoles")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Roles(){
		return service.Roles();
	}
	
	@GetMapping("/verMarcas")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Marcas(){
		return service.Marcas();
	}

	@GetMapping("/verTecnologiasComponentes")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> TecnologiasComponentes(){
		return service.TecnologiasComponentes();
	}
	
	@GetMapping("/verModems")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Modems(){
		return service.Modems();
	}
	
	@GetMapping("/verTiposComunicacion")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> TiposComunicacion(){
		return service.TiposComunicacion();
	}
	
	@GetMapping("/verTiemposConectado")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> TiemposConectado(){
		return service.TiemposConectado();
	}
	
	@GetMapping("/verTiposMedidor")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> TiposMedidor(){
		return service.TiposMedidor();
	}

	@GetMapping("/verTiposPuerto")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> TiposPuerto(){
		return service.TiposPuerto();
	}
	
	@GetMapping("/verEstados")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Estados(){
		return service.Estados();
	}
	
	@GetMapping("/verTransformadores")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Transformadores(){
		return service.Transformadores();
	}
	
	@GetMapping("/verUsuarios")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Usuarios(){
		return service.Usuarios();
	}
	
	@GetMapping("/verFtp")
	@CrossOrigin(origins="*")
	public List<Map<String,Object>> Ftps(){
		return service.Ftps();
	}
	
	@GetMapping("/validarSerialCnc/{cnc}")
	@CrossOrigin(origins="*")
	public boolean validarSerialConcentrador(@PathVariable String cnc) {
		return service.validarSerialConcentrador(cnc);
	}
	
	@GetMapping("/validarSerialMet/{met}")
	@CrossOrigin(origins="*")
	public boolean validarSerialMedidor(@PathVariable String met) {
		return service.validarSerialMedidor(met);
	}
	
}
