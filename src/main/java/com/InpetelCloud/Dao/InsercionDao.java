package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.InsercionInterface;
import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Repository
public class InsercionDao implements InsercionInterface{
	
	@Autowired
	JdbcTemplate template;
	
	@Override
	public Usuarios saveUsuario(Usuarios usuario) {
		return null;
	}

	@Override
	public Medidor saveMedidor(Medidor medidor) {
		return null;
	}

	@Override
	public Concentrador saveConcentrador(Concentrador concentrador) {
		return null;
	}

	@Override
	public Transformador saveTransformador(Transformador transformador) {
		return null;
	}

	 /*INSERCION DE ESQEMA A BASE CON DIFERENTE NOMBRE */ 
	@Override
	public void schemaCreate(String name) {
	  
		try {
			template.execute("CREATE SCHEMA IF NOT EXISTS `"+ name +"`");
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Estados` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre_Est` VARCHAR(120) NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Roles` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre_rol` VARCHAR(80) NULL DEFAULT NULL,\r\n"
					+ "  `Descripcion_rol` VARCHAR(150) NULL DEFAULT NULL,\r\n"
					+ "  `States_ID` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Roles_States1_idx` (`States_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Roles_States1`\r\n"
					+ "    FOREIGN KEY (`States_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Estados` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Usuarios` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombres` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  `Login` VARCHAR(45) NULL DEFAULT NULL,\r\n"
					+ "  `Password` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Password_salt` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Correo` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  `Fecha_crea` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_crea` INT NOT NULL,\r\n"
					+ "  `Fecha_modifica` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_modifica` INT NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `usuario_modifica_idx` (`Usu_modifica` ASC) VISIBLE,\r\n"
					+ "  INDEX `usuario_crea_idx` (`Usu_crea` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `usuario_crea`\r\n"
					+ "    FOREIGN KEY (`Usu_crea`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `usuario_modifica`\r\n"
					+ "    FOREIGN KEY (`Usu_modifica`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Asoc_usu_roles` (\r\n"
					+ "  `Usuarios_ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Roles_ID` INT NOT NULL,\r\n"
					+ "  `Fecha` DATE NULL DEFAULT NULL,\r\n"
					+ "  `Fh_create` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_create` INT NOT NULL,\r\n"
					+ "  `Fh_update` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_update` INT NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`Usuarios_ID`, `Roles_ID`),\r\n"
					+ "  INDEX `fk_Usuarios_has_Roles_Roles1_idx` (`Roles_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Usuarios_has_Roles_Usuarios1_idx` (`Usuarios_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_UsuariosC_Roles_idx` (`Usu_create` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_UsuariosUp_Roles_idx` (`Usu_update` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Usuarios_has_Roles_Roles1`\r\n"
					+ "    FOREIGN KEY (`Roles_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Roles` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Usuarios_has_Roles_Usuarios1`\r\n"
					+ "    FOREIGN KEY (`Usuarios_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_UsuariosC_Roles`\r\n"
					+ "    FOREIGN KEY (`Usu_create`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_UsuariosUp_Roles`\r\n"
					+ "    FOREIGN KEY (`Usu_update`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`TiempoConectado` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `ComStatus` VARCHAR(25) NULL DEFAULT NULL,\r\n"
					+ "  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("\r\n"
					+ "CREATE TABLE IF NOT EXISTS `"+ name +"`.`TecnologiaComponente` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre_Tecnologia` VARCHAR(80) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Marca` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre_Marca` VARCHAR(85) NULL DEFAULT NULL,\r\n"
					+ "  `TecnologiaComponente_ID` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Marca_TecnologiaComponente1_idx` (`TecnologiaComponente_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Marca_TecnologiaComponente1`\r\n"
					+ "    FOREIGN KEY (`TecnologiaComponente_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TecnologiaComponente` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Modem` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Serial` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Nombre` VARCHAR(60) NULL DEFAULT NULL,\r\n"
					+ "  `Imei` VARCHAR(25) NULL DEFAULT NULL,\r\n"
					+ "  `Marca` VARCHAR(60) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`TipoComunicacion` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Concentrador` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Ip_real` VARCHAR(50) NULL DEFAULT NULL,\r\n"
					+ "  `NombreConcentrador` VARCHAR(45) NULL DEFAULT NULL,\r\n"
					+ "  `TipoComunicacion_ID` INT NOT NULL,\r\n"
					+ "  `Imei` VARCHAR(50) NULL DEFAULT NULL,\r\n"
					+ "  `Serial` VARCHAR(80) NULL DEFAULT NULL,\r\n"
					+ "  `TiempoConectado_ID` INT NOT NULL,\r\n"
					+ "  `Modem_Embedido` TINYINT NULL DEFAULT NULL,\r\n"
					+ "  `IOmodule` TINYINT NULL DEFAULT NULL,\r\n"
					+ "  `Modem_ID` INT NOT NULL,\r\n"
					+ "  `Marca_ID` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Concetrador_TipoComunicacion1_idx` (`TipoComunicacion_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Concetrador_TiempoConectado1_idx` (`TiempoConectado_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Concentrador_Modem1_idx` (`Modem_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Concentrador_Marca1_idx` (`Marca_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Conccentrador_TiempoConectado`\r\n"
					+ "    FOREIGN KEY (`TiempoConectado_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TiempoConectado` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Concentrador_Marca1`\r\n"
					+ "    FOREIGN KEY (`Marca_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Marca` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Concentrador_Modem1`\r\n"
					+ "    FOREIGN KEY (`Modem_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Modem` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Concetrador_TipoComunicacion1`\r\n"
					+ "    FOREIGN KEY (`TipoComunicacion_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TipoComunicacion` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`InfoEventos` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre` VARCHAR(50) NULL DEFAULT NULL,\r\n"
					+ "  `Codigo` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Descripcion` VARCHAR(255) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Trazabilidad` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Encabezado` BLOB NULL DEFAULT NULL,\r\n"
					+ "  `Nombre_reporte` VARCHAR(255) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`EventoConcentrador` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Concentrador_ID` INT NOT NULL,\r\n"
					+ "  `Fecha` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Trazabilidad_ID` INT NOT NULL,\r\n"
					+ "  `Hora_Inicio` TIME NULL DEFAULT NULL,\r\n"
					+ "  `Hora_Fin` TIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_create` INT NOT NULL,\r\n"
					+ "  `InfoEventos_ID` INT NOT NULL,\r\n"
					+ "  `Usu_update` INT NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Admon_Evento_Concentrador1_idx` (`Concentrador_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Admon_Evento_Trazabilidad1_idx` (`Trazabilidad_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_EventosConcentrador_InfoEventos1_idx` (`InfoEventos_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Eventos_Usuarioc_idx` (`Usu_create` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Eventos_Usuariod_idx` (`Usu_update` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Admon_Evento_Concentrador1`\r\n"
					+ "    FOREIGN KEY (`Concentrador_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Concentrador` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Evento_InfoEvento`\r\n"
					+ "    FOREIGN KEY (`InfoEventos_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`InfoEventos` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Evento_Trazabilidad1`\r\n"
					+ "    FOREIGN KEY (`Trazabilidad_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Trazabilidad` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Evento_Usuarioc`\r\n"
					+ "    FOREIGN KEY (`Usu_create`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Evento_Usuariop`\r\n"
					+ "    FOREIGN KEY (`Usu_update`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`TipoMedidor` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `NombreMedidor` VARCHAR(60) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`TipoPuerto` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre_Puerto` VARCHAR(80) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Medidor` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `TipoMedidor_ID` INT NOT NULL,\r\n"
					+ "  `Magnitud` INT NULL DEFAULT NULL,\r\n"
					+ "  `NumCuadrantes` INT NULL DEFAULT NULL,\r\n"
					+ "  `Medidorcol` VARCHAR(45) NULL DEFAULT NULL,\r\n"
					+ "  `TipoPuerto_ID` INT NOT NULL,\r\n"
					+ "  `Prepago` TINYINT NULL DEFAULT NULL,\r\n"
					+ "  `Saldo_prepago` INT NULL DEFAULT NULL,\r\n"
					+ "  `Recarga_prepago` INT NULL DEFAULT NULL,\r\n"
					+ "  `Sync_reloj` TINYINT NULL DEFAULT NULL,\r\n"
					+ "  `Modelo` VARCHAR(60) NULL DEFAULT NULL,\r\n"
					+ "  `Serial` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  `Marca_ID` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Medidor_TipoMedidor1_idx` (`TipoMedidor_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Medidor_TipoPuerto1_idx` (`TipoPuerto_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Medidor_Marca1_idx` (`Marca_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Medidor_Marca1`\r\n"
					+ "    FOREIGN KEY (`Marca_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Marca` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Medidor_TipoMedidor1`\r\n"
					+ "    FOREIGN KEY (`TipoMedidor_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TipoMedidor` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Medidor_TipoPuerto1`\r\n"
					+ "    FOREIGN KEY (`TipoPuerto_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TipoPuerto` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`EventoMedidor` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Medidor_ID` INT NOT NULL,\r\n"
					+ "  `Fecha` TIMESTAMP(5) NULL DEFAULT NULL,\r\n"
					+ "  `HoraInicio` TIME NULL DEFAULT NULL,\r\n"
					+ "  `HoraFin` TIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_create` INT NOT NULL,\r\n"
					+ "  `Trazabilidad_ID` INT NOT NULL,\r\n"
					+ "  `Usu_update` INT NULL DEFAULT NULL,\r\n"
					+ "  `InfoEventos_ID` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_EventoMedidor_Trazabilidad2_idx` (`Trazabilidad_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_EventoMedidor_Medidor2_idx` (`Medidor_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_EventoMedidor_Usuarioc_idx` (`Usu_create` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_EventoMedidor_Usuariop_idx` (`Usu_update` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_EventoMedidor_InfoEventos1_idx` (`InfoEventos_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_EventoMedidor_InfoEventos1`\r\n"
					+ "    FOREIGN KEY (`InfoEventos_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`InfoEventos` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_EventoMedidor_Medidor`\r\n"
					+ "    FOREIGN KEY (`Medidor_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Medidor` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_EventoMedidor_Trazabilidad`\r\n"
					+ "    FOREIGN KEY (`Trazabilidad_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Trazabilidad` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_EventoMedidor_Usuarioc`\r\n"
					+ "    FOREIGN KEY (`Usu_create`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_EventoMedidor_Usuariop`\r\n"
					+ "    FOREIGN KEY (`Usu_update`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`InfoMedidas` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre` VARCHAR(50) NULL DEFAULT NULL,\r\n"
					+ "  `Codigo` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `UnidadMedidad` VARCHAR(15) NULL DEFAULT NULL,\r\n"
					+ "  `Descipcion` VARCHAR(155) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Medidas` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Medidor_ID` INT NOT NULL,\r\n"
					+ "  `Num_val` VARCHAR(50) NULL DEFAULT NULL,\r\n"
					+ "  `Fecha` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `HoraIncio` TIME NULL DEFAULT NULL,\r\n"
					+ "  `HoraFin` TIME NULL DEFAULT NULL,\r\n"
					+ "  `Trazabilidad_ID` INT NOT NULL,\r\n"
					+ "  `Usu_create` INT NOT NULL,\r\n"
					+ "  `InfoMedidas_ID` INT NOT NULL,\r\n"
					+ "  `Usu_update` INT NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Admon_Medida_Medidor1_idx` (`Medidor_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Admon_Medida_Trazabilidad1_idx` (`Trazabilidad_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Medidas_InfoMedidas1_idx` (`InfoMedidas_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Eventos_Usuariosc_idx` (`Usu_create` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Eventos_Usuariosp_idx` (`Usu_update` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Admon_Medida_InfoMedida`\r\n"
					+ "    FOREIGN KEY (`InfoMedidas_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`InfoMedidas` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Medida_Medidor1`\r\n"
					+ "    FOREIGN KEY (`Medidor_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Medidor` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Medida_Trazabilidad1`\r\n"
					+ "    FOREIGN KEY (`Trazabilidad_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Trazabilidad` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Medida_Usuarioc`\r\n"
					+ "    FOREIGN KEY (`Usu_create`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Admon_Medida_Usuariop`\r\n"
					+ "    FOREIGN KEY (`Usu_update`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Transformador` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre` VARCHAR(60) NULL DEFAULT NULL,\r\n"
					+ "  `Ip_real` VARCHAR(30) NULL DEFAULT NULL,\r\n"
					+ "  `Capacidad` INT NULL DEFAULT NULL,\r\n"
					+ "  `Nodo` INT NULL DEFAULT NULL,\r\n"
					+ "  `CargaAforada` INT NULL DEFAULT NULL,\r\n"
					+ "  `Tipo_Trafo` VARCHAR(45) NULL DEFAULT NULL,\r\n"
					+ "  `Concentrador_ID` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Transformador_Concentrador1_idx` (`Concentrador_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Transformador_Concentrador1`\r\n"
					+ "    FOREIGN KEY (`Concentrador_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Concentrador` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}

	/* CREAR SISTEMA EXTERNO */ 
	@Override
	public int crearSistemaExterno(SistemExterno se) {
		int value = template.update("INSERT INTO Inpetel_Cloud.SistemaExteno (Nit, Nombre_SE, Telefono_SE, Direccion_SE, States_ID, Tipo_SistemaExterno_ID)\r\n"
				+ "VALUES ('"+ se.getNit()+"', '"+se.getNombre()+"', '"+se.getTelefono()+"', '"+se.getDireccion()+"', 1, "+se.getTipoSistema()+")");
		return value;
	}
	

}
