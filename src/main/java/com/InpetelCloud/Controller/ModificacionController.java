package com.InpetelCloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.TipoMedidor;
import com.InpetelCloud.Model.TipoPuerto;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;
import com.InpetelCloud.Service.ModificacionService;

@RestController
@RequestMapping(path= "/modificacion")
public class ModificacionController {
	
	@Autowired
	ModificacionService service;
	
	@PutMapping("modificarSistemaExterno/{id}")
	@CrossOrigin(origins="*")
	public void modificarSistemaExterno(@PathVariable Long id, @RequestBody SistemExterno se) {
		service.modificarSistemaExterno(id, se);
	}
	
	@PutMapping("modificarRol/{id}")
	@CrossOrigin(origins="*")
	public void modificarRol(@PathVariable Long id, @RequestBody Rol rol) {
		service.modificarRol(id, rol);
	}
	
	@PutMapping("modificarMarca/{id}")
	@CrossOrigin(origins="*")
	public void modificarMarca(@PathVariable Long id, @RequestBody Marca marca) {
		service.modificarMarca(id, marca);
	}
	
	@PutMapping("modificarTecnologiaComponente/{id}")
	@CrossOrigin(origins="*")
	public void modificarTecnologiaComponente(@PathVariable Long id, @RequestBody TecnologiaComponente tecnologiaComponente) {
		service.modificarTecnologiaComponente(id, tecnologiaComponente);
	}
	
	@PutMapping("modificarModem/{id}")
	@CrossOrigin(origins="*")
	public void modificarModem(@PathVariable Long id, @RequestBody Modem modem) {
		service.modificarModem(id, modem);
	}
	
	@PutMapping("modificarTipoComunicacion/{id}")
	@CrossOrigin(origins="*")
	public void modificarTipoComunicacion(@PathVariable Long id, @RequestBody TipoComunicacion tipoComunicacion) {
		service.modificarTipoComunicacion(id, tipoComunicacion);
	}
	
	@PutMapping("modificarTiempoConectado/{id}")
	@CrossOrigin(origins="*")
	public void modificarTiempoConectado(@PathVariable Long id, @RequestBody TiempoConectado tiempoConectado) {
		service.modificarTiempoConectado(id, tiempoConectado);
	}
	
	@PutMapping("modificarTipoMedidor/{id}")
	@CrossOrigin(origins="*")
	public void modificarTipoMedidor(@PathVariable Long id, @RequestBody TipoMedidor tipoMedidor) {
		service.modificarTipoMedidor(id, tipoMedidor);
	}
	
	@PutMapping("modificarTipoPuerto/{id}")
	@CrossOrigin(origins="*")
	public void modificarTipoPuerto(@PathVariable Long id, @RequestBody TipoPuerto tipoPuerto) {
		service.modificarTipoPuerto(id, tipoPuerto);
	}
	
	@PutMapping("modificarEstado/{id}")
	@CrossOrigin(origins="*")
	public void modificarEstado(@PathVariable Long id, @RequestBody Estados estado) {
		service.modificarEstado(id, estado);
	}

	@PutMapping("modificarTransformador/{id}")
	@CrossOrigin(origins="*")
	public void modificarTransformador(@PathVariable Long id, @RequestBody Transformador transformador) {
		service.modificarTransformador(id, transformador);
	}
	
	@PutMapping("modificarUsuario/{id}")
	@CrossOrigin(origins="*")
	public void modificarUsuario(@PathVariable Long id, @RequestBody Usuarios usuario) {
		service.modificarUsuario(id, usuario);
	}

	@PutMapping("modificarFtp/")
	@CrossOrigin(origins="*")
	public void modificarFtp(@RequestBody Ftp f) {
		service.modificarFtp(f);
	}
}
