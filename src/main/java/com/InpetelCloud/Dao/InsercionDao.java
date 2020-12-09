package com.InpetelCloud.Dao;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.InsercionInterface;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Model.Modem;
import com.InpetelCloud.Model.ObjetoJson;
import com.InpetelCloud.Model.ObjetoJsonS03;
import com.InpetelCloud.Model.Rol;
import com.InpetelCloud.Model.SistemExterno;
import com.InpetelCloud.Model.TecnologiaComponente;
import com.InpetelCloud.Model.TiempoConectado;
import com.InpetelCloud.Model.TipoComunicacion;
import com.InpetelCloud.Model.TipoMedidor;
import com.InpetelCloud.Model.TipoPuerto;
import com.InpetelCloud.Model.Transformador;
import com.InpetelCloud.Model.Usuarios;

@Repository
public class InsercionDao implements InsercionInterface{
	
	@Autowired
	JdbcTemplate template;

	 /*INSERCION DE ESQUEMA A BASE CON DIFERENTE NOMBRE */ 
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
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Asoc_concen_medidor` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Concentrador_ID` INT NOT NULL,\r\n"
					+ "  `Medidor_ID` INT NOT NULL,\r\n"
					+ "  `Fh_create` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_crea` INT NULL DEFAULT NULL,\r\n"
					+ "  `Fh_update` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_update` INT NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Asoc_concen_medidor_Concentrador1_idx` (`Concentrador_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Asoc_concen_medidor_Medidor1_idx` (`Medidor_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Asoc_concen_medidor_Usuariosc_idx` (`Usu_crea` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Asoc_concen_medidor_Usuariosp_idx` (`Usu_update` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Asoc_concen_medidor_Concentrador1`\r\n"
					+ "    FOREIGN KEY (`Concentrador_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Concentrador` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Asoc_concen_medidor_Medidor1`\r\n"
					+ "    FOREIGN KEY (`Medidor_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Medidor` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Asoc_concen_medidor_Usuariosc`\r\n"
					+ "    FOREIGN KEY (`Usu_crea`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Asoc_concen_medidor_Usuariosp`\r\n"
					+ "    FOREIGN KEY (`Usu_update`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 2\r\n"
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
			
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name + "`.`FTP` (\r\n"
					+ "  `ID_FTP` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Descripcion` VARCHAR(200) NULL DEFAULT NULL,\r\n"
					+ "  `EndPoint` VARCHAR(200) NULL DEFAULT NULL,\r\n"
					+ "  `Puerto` INT(11) NULL DEFAULT NULL,\r\n"
					+ "  `Usuario` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Password` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Carpeta_Entrada` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Carpeta_Procesad` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Fh_create` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_create` INT(11) NULL DEFAULT NULL,\r\n"
					+ "  `Fh_update` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_update` INT(11) NULL DEFAULT NULL,\r\n"
					+ "  `IDFTP` INT(11) NULL DEFAULT NULL,\r\n"
					+ "  `Carpeta_Errores` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID_FTP`),\r\n"
					+ "  INDEX `ff_idx` (`Usu_create` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_ftp_fk_usuariop_idx` (`Usu_update` ASC) VISIBLE,\r\n"
					+ "  INDEX `FK_FTP_FK_IDFTP_idx` (`IDFTP` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `FK_FTP_FK_USUARIOC`\r\n"
					+ "    FOREIGN KEY (`Usu_create`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`)\r\n"
					+ "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION,\r\n"
					+ "  CONSTRAINT `FK_FTP_FK_USUARIOP`\r\n"
					+ "    FOREIGN KEY (`Usu_update`)\r\n"
					+ "    REFERENCES `" + name + "`.`Usuarios` (`ID`)\r\n"
					+ "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION,\r\n"
					+ "  CONSTRAINT `FK_FTP_FK_IDFTP`\r\n"
					+ "    FOREIGN KEY (`IDFTP`)\r\n"
					+ "    REFERENCES `" + name + "`.`FTP` (`ID_FTP`)\r\n"
					+ "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION)\r\n"
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
				+ "VALUES ('"+ se.getNit()+"', '"+ se.getNombre()+"', '"+se.getTelefono()+"', '"+se.getDireccion()+"', 1, "+se.getTipoSistema()+")");
		return value;
	}

	/* CREAR UN ROL */
	@Override
	public int crearRol(Rol rol) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Roles (Nombre_Rol, Descripcion_Rol, States_ID)\r\n"
				+ "VALUES ('" + rol.getNombre() + "', '"+ rol.getDescripcion() +"', " + rol.getEstadoId() + ")");
		return value;
	}

	/* CREAR UNA MARCA */
	@Override
	public int crearMarca(Marca marca) {
		int value = template.update("INSERT IGNORE INTO Inpetel_Cloud.Marca (Nombre_Marca, TecnologiaComponente_ID)\r\n"
				+ "VALUES ('"+ marca.getNombre() + "',  " + marca.getTecnologiaComponenteId() + ")");
		return value;
	}

	/* CREAR UNA TECNOLOGIA DEL COMPONENTE */
	@Override
	public int crearTecnologiaComponente(TecnologiaComponente tecnologiaComponente) {
		int value = template.update( "INSERT INTO Inpetel_Cloud.TecnologiaComponente (Nombre_Tecnologia)\r\n"
				+ " VALUES ('" + tecnologiaComponente.getNombre() + "')");
		return value;
	}

	/* CREAR UN MODEM */
	@Override
	public int crearModem(Modem modem) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Modem (Serial, Nombre, Imei, Marca)\r\n"
				+ "VALUES ('" + modem.getSerial() + "', '" + modem.getNombre() + "', '" + modem.getImei() + "', " + modem.getMarca() + ")");
		return value;
	}

	/* CREAR UN TIPO DE COMUNICACION */
	@Override
	public int crearTipoComunicacion(TipoComunicacion tipoComunicacion) {
		int value = template.update("INSERT INTO Inpetel_Cloud.TipoComunicacion (Nombre)\r\n"
				+ " VALUES ('" + tipoComunicacion.getNombre() + "')");
		return value;
	}

	@Override
	public int crearTiempoConectado(TiempoConectado tiempoConectado) {
		int value = template.update("INSERT INTO Inpetel_Cloud.TiempoConectado (ComStatus, Descripcion)\r\n"
				+ " VALUES ('" + tiempoConectado.getComStatus() + "', " + tiempoConectado.getDescripcion() + ")");
		return value;
	}
	
	@Override
	public int crearTipoMedidor(TipoMedidor tipoMedidor) {
		int value = template.update("INSERT INTO Inpetel_Cloud.TipoMedidor (NombreMedidor)\r\n "
				+ "VALUES ('" + tipoMedidor.getNombre() + "');");
		return value;
	}

	@Override
	public int crearTipoPuerto(TipoPuerto tipoPuerto) {
		int value = template.update("INSERT INTO Inpetel_Cloud.TipoPuerto (Nombre_Puerto)\r\n "
				+ "VALUES ('" + tipoPuerto.getNombre() +  "');");
		return value;
	}

	@Override
	public int crearEstado(Estados estado) {
		int value = template.update(" INSERT INTO Inpetel_Cloud.Estados (Nombre_Est)\r\n "
				+ "VALUES ('" + estado.getNombre() + "');");
		return value;
	}
	
	@Override
	public int crearTransformador(Transformador transformador) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Transformador (Nombre, Ip_real, Capacidad, Nodo, CargaAforada, Tipo_Trafo, Concentrador_ID )\r\n"
				+ " VALUES ('" + transformador.getNombre() + "', '"+ transformador.getIpReal() + "', " + transformador.getCapacidad() +", " + transformador.getNodo() + ", " + transformador.getCargaAforada() + ", '" + transformador.getTipoTrafo() + "', " + transformador.getConcentradorId() + ");");
		return value;
	}
	
	@Override
	public int crearUsuario(Usuarios usuario) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Usuarios ( Nombres, Login, Password, Password_salt, Correo, Fecha_crea, Usu_crea, Fecha_modifica, Usu_modifica, SistemaExteno_ID, States_ID)\r\n"
				+ " VALUES ('"+ usuario.getNombres()+ "', '"+ usuario.getLogin()+ "', '"+ usuario.getPassword()+"', '" + usuario.getPassword_salt()+  "', '"+ usuario.getCorreo() +"', '"+ usuario.getFechaCreate() +"', 56, '"+ usuario.getFechaModifica()+"', 56, '" + usuario.getSistemaExternoId()+"', '" + usuario.getEstadoId()+"' );");
		return value;
	}
	
	/*
	 * Descripcion: Metodo que crea un concentrador dentro del metodo que crea una medida
	 */
	@Override
	public int crearConcentradorMedida(String concentrador) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Concentrador (Ip_real, NombreConcentrador, TipoComunicacion_ID, Imei,  Serial , TiempoConectado_ID, Modem_Embedido, IOmodule,  Modem_ID,  Marca_ID )\r\n"
				+ " VALUES ('"+ 1 + "', '"+ 1 + "',  '" + 1 + "' , '" + 1 + "','" + concentrador + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 56 + "', '" + 1 + "');");
		return value;
	}
	
	/*
	 * Descripcion: Metodo que crea un medidor dentro del metodo que crea una medida
	 */
	@Override
	public int crearMedidorMedida(String medidor) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, Medidorcol,  TipoPuerto_ID , Prepago, Saldo_prepago, Recarga_prepago,  Sync_reloj,  Modelo, Serial, Marca_ID )\r\n"
				+ " VALUES ('"+ 1 + "', '" + 1 + "',  '" + 1 + "' , '" + 1 + "','" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + medidor + "', '" + 1+ "');");
		return value;
	}
	
	/*
	 * Descripcion: Metodo para crear un medidor a través de un crud. ( por aparte  de la medida)
	 */
	@Override
	public int crearMedidor(modelMeter medidor) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, Medidorcol,  TipoPuerto_ID , Prepago, Saldo_prepago, Recarga_prepago,  Sync_reloj,  Modelo, Serial, Marca_ID )\r\n"
				+ " VALUES ('"+ medidor.getTypeMeter() + "', '" + medidor.getMang() + "',  '" + medidor.getNumberQuadrants() + "' , '" + 1 + "','" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + medidor.getModel() + "', '" + medidor.getMeter() + "', '" + medidor.getBrand()+ "');");
		return value;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorMedida(modelMeter medidor) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ medidor.getConcentrator() +"';");
		return idConcentrador;
	}
	
	public List<Map<String,Object>> obtenerIdMedidorMedida(modelMeter medidor) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ medidor.getMeter() +"';");
		return idMedidor;
	}

	/*
	 * Descripcion: Metodo para crear un concentrador a través de un crud. ( por aparte de la medida)
	 */
	@Override
	public int crearConcentrador(modelConcentrator concentrador) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Concentrador (Ip_real, NombreConcentrador, TipoComunicacion_ID, Imei,  Serial , TiempoConectado_ID, Modem_Embedido, IOmodule,  Modem_ID,  Marca_ID )\r\n"
				+ " VALUES ('"+ 1 + "', '"+ concentrador.getConcentrator() + "',  '" + 1 + "' , '" + 1 + "','" + concentrador.getSerial() + "', '" + 1 + "', '" + 1 + "', '" + 1+ "', '" + 56 + "', '" + concentrador.getMarca() + "');");
		return value;
	}
	

	@Override
	public int crearFtp(Ftp f) {
		 int val =  template.update("INSERT INTO Inpetel_Cloud.FTP (Descripcion, EndPoint, Puerto, Usuario, Password, Carpeta_Entrada, Carpeta_Procesad, Fh_create, Usu_create,  IDFTP, Carpeta_Errores)\r\n"
		 		+ "VALUES ('"+f.getDescripcion()+"', '"+f.getEndPoint()+"', '"+f.getPuerto()+"', '"+f.getUsuario()+"', '"+f.getPassword()+"', '"+f.getCarpeta_En()+"', '"+f.getCarpeta_Pr()+"', now(), '"+f.getUsu_crea()+"', 1, '"+f.getCarpeta_Er()+"');");
		 System.out.println(val);
		 return val;
		
	}

	/*
	 * Descripcion: Metodo que viene de la interfaz de insercion y es el que llama al metodo que crea la medida
	 * Return: Entero el cual si su valor es 1, retorna que se creo, si es 0 quiere decir que no se creo.
	 */
	@Override
	public int crearMedida(ObjetoJson json) {
		int value=crearMedidaPrueba(null,null, null,null);
		return value;
	}
	
	/*
	 * Descripcion: Metodo que hace la creacion de la medida con todos los valores que necesita, se hace este
	 * proceso 7 veces porque son 7 medidas que vienen en el arreglo de infomedidas, se pone que i <7 porque no
	 * tomaba la ultima posicion del arreglo de Q.
	 */
	public int crearMedidaPrueba(List<String> resultado,List<String> valorInfoMedida,List<String> fechas,List<String> idInfoMedidas) {
		int value=0;
		for (int i = 0; i < 7; i++) {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidas ( Medidor_ID, Num_val, Fecha, HoraIncio, HoraFin, Trazabilidad_ID, Usu_create, InfoMedidas_ID, Usu_update)\r\n "
					+ "VALUES ('" +  resultado.get(0) + "', '" + valorInfoMedida.get(i) + "', '" + fechas.get(0) + "', '" + fechas.get(1) + "', '" + fechas.get(2) + "', '" + resultado.get(1) + "', '" + 60 + "','" + idInfoMedidas.get(i)+ "', '" + 60 + "');");
		}
		return value;
	}

	public List<Map<String,Object>> serialMedidores(){
		List<Map<String,Object>>medidores = template.queryForList("SELECT Serial FROM Inpetel_Cloud.Medidor");
		return medidores;
	}
	
//	public void crearMedidor(Medida medida) {
//		//String serialMet = medidor.getSerial();
//		template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, TipoPuerto_ID, Serial , Marca_ID )\r\n"
//				+ " VALUES ('" + 1 + "', '" + 1 + "', '" + medida.getSerialmet() + "' , '" + 1 + "');");
//	}
	
	
	public List<Map<String,Object>> serialConcentradores(){
		List<Map<String,Object>>concentradores = template.queryForList("SELECT Serial FROM Inpetel_Cloud.Concentrador");
		return concentradores;
	}
	
//	public void crearConcentrador(Medida medida) {
//		//String serialCnc = concentrador.getSerial();
//		template.update("INSERT INTO Inpetel_Cloud.Concentrador (TipoComunicacion_ID, Serial , TiempoConectado_ID, Modem_ID,  Marca_ID )\r\n"
//				+ " VALUES ('"+ 1 + "', '" + medida.getSerialcnc() + "', '" + 1 + "' , '" + 56 + "', '" + 1 + "');");
//
//	}
	
	public List<Map<String,Object>> obtenerIdMedidor(ObjetoJson json, int j) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ json.getHours().get(j).getMeter() +"';");
		return idMedidor;
	}
//	
	public List<Map<String,Object>> obtenerIdConcentrador(ObjetoJson json, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ json.getHours().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	public void crearAsociacionCncMet(List<Object> resultado) {
		template.update("INSERT INTO Inpetel_Cloud.Asoc_concen_medidor (Concentrador_ID, Medidor_ID) VALUES\r\n"
				+ "('" + resultado.get(1) + "', '" + resultado.get(0)+ "');");
		
	}
	
	public void crearTrazabilidad(ObjetoJson json, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + json.getHours().get(j).getNameFile() + "');");
		}
	
	public List<Map<String,Object>> obtenerIdTrazabilidad(ObjetoJson json, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ json.getHours().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}

	public List<Map<String,Object>> obtenerIdInfoMedida(ObjetoJson json) {
		List<Map<String,Object>> nombreMedida=null;
		for (int i = 0; i < json.getInfoMeasure().size(); i++) {
			nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ json.getInfoMeasure().get(i) +"';");			
		}
		return nombreMedida;
	}
	
	public List<Map<String,Object>> obtenerIdInfoMedidaActivaImportada() {
		List<Map<String,Object>> nombreMedida=null;
		String medida ="AI";
		nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ medida+"';");			
		return nombreMedida;
	}
	public List<Map<String,Object>> obtenerIdInfoMedidaActivaExportada() {
		List<Map<String,Object>> nombreMedida=null;
		String medida ="AE";
		nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ medida+"';");			
		return nombreMedida;
	}
	public List<Map<String,Object>> obtenerIdInfoMedidaBitCalidad() {
		List<Map<String,Object>> nombreMedida=null;
		String medida ="BC";
		nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ medida+"';");			
		return nombreMedida;
	}
	public List<Map<String,Object>> obtenerIdInfoMedidaQ0() {
		List<Map<String,Object>> nombreMedida=null;
		String medida ="R1";
		nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ medida+"';");			
		return nombreMedida;
	}
	public List<Map<String,Object>> obtenerIdInfoMedidaQ1() {
		List<Map<String,Object>> nombreMedida=null;
		String medida ="R2";
		nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ medida+"';");			
		return nombreMedida;
	}
	public List<Map<String,Object>> obtenerIdInfoMedidaQ2() {
		List<Map<String,Object>> nombreMedida=null;
		String medida ="R3";
		nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ medida+"';");			
		return nombreMedida;
	}
	public List<Map<String,Object>> obtenerIdInfoMedidaQ3() {
		List<Map<String,Object>> nombreMedida=null;
		String medida ="R4";
		nombreMedida = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Nombre='"+ medida+"';");			
		return nombreMedida;
	}

	@Override
	public int crearMedidaS03(ObjetoJsonS03 jsons03) {
		int value=crearMedidaPrueba(null,null, null,null);
		return value;
	}
	
	public List<Map<String,Object>> obtenerIdMedidorS03(ObjetoJsonS03 jsons03, int j) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ jsons03.getDays().get(j).getMeter() +"';");
		return idMedidor;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorS03(ObjetoJsonS03 jsons03, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ jsons03.getDays().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	public void crearTrazabilidadS03(ObjetoJsonS03 jsons03, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + jsons03.getDays().get(j).getNameFile() + "');");
		}
	
	public List<Map<String,Object>> obtenerIdTrazabilidadS03(ObjetoJsonS03 jsons03, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ jsons03.getDays().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}



}
