package com.InpetelCloud.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.modelMeter;
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
	
	@PostMapping("/verConcentradores")
	@CrossOrigin(origins="*")
	public boolean Concentradores(@RequestBody modelConcentrator cnc) {
		return service.Concentradores(cnc);
	}
	
	@GetMapping("/verMedidores")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Medidores(){
		return service.Medidores();
	}
	


	@GetMapping("/verMedidoresNoAsociados")
	@CrossOrigin(origins="*")
	public List<Map<String,Object>> MedidoresNoAsociados(){
		return service.medidoresNoAsociados();
	}

	@PostMapping("/verMedidores")
	@CrossOrigin(origins="*")
	public boolean Medidores(@RequestBody modelMeter met) {
		return service.Medidores(met);
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
	@GetMapping("/verMarcas/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Marcas(@PathVariable String id){
		return service.Marcas(id);
	}
	
	@GetMapping("/verTecnologiasComponentes")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> TecnologiasComponentes(){
		return service.TecnologiasComponentes();
	}
	
	@GetMapping("/verTecnologiasComponentes/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> TecnologiasComponentes(String id){
		return service.TecnologiasComponentes(id);
	}
	
	@GetMapping("/verModems")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> Modems(){
		return service.Modems();
	}
	
	@GetMapping("/verModems/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> verModems(@PathVariable Long id){
		return service.verModemIndividual(id);
	}
	
	@PostMapping("/verModemsur")
	@CrossOrigin(origins="*")
	public boolean MUnRepeat(@RequestBody Modem m) {
		return service.MUnRepeat(m);
	}
	
	@GetMapping("/verConcentradores/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> verConcentradores(@PathVariable Long id){
		return service.verConcentradorIndividual(id);
	}
	
	@GetMapping("/verTransformadores/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> verTransformadores(@PathVariable Long id){
		return service.verTransformadorIndividual(id);
	}
	
	@GetMapping("/verMedidores/{id}")
	@CrossOrigin(origins="*")
	public List<Map<String, Object>> verMedidores(@PathVariable Long id){
		return service.verMedidorIndividual(id);
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
	
	@PostMapping("/verTransformadores")
	@CrossOrigin(origins="*")
	public boolean Transformadores(@RequestBody Transformador tf) {
		return service.Transformadores(tf);
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
	
	@GetMapping("/verConcentrador/{cnsS}")
	@CrossOrigin(origins="*")
	public List<Map<String,Object>>cncSerial(@PathVariable String cnsS){
		return service.cncSerial(cnsS);
	}
	
	@GetMapping("/verMedidor/{metS}")
	@CrossOrigin(origins="*")
	public List<Map<String,Object>>metSerial(@PathVariable String metS){
		return service.metSerial(metS);
	}
	@PostMapping("/users/login")
	@CrossOrigin(origins="*")
	public boolean login(@RequestBody Usuarios u) {
		return service.login(u);
	}
}
