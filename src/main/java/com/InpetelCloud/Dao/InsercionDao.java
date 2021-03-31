package com.InpetelCloud.Dao;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.InsercionInterface;
import com.InpetelCloud.Model.modelConcentrator;
import com.InpetelCloud.Model.AsociacionConcentradorMedidor;
import com.InpetelCloud.Model.Macro;
import com.InpetelCloud.Model.CyR;
import com.InpetelCloud.Model.Estados;
import com.InpetelCloud.Model.Ftp;
import com.InpetelCloud.Model.Marca;
import com.InpetelCloud.Model.modelMeter;
import com.InpetelCloud.Model.objetoJsonEventoConcentrador;
import com.InpetelCloud.Model.objetoJsonEventoMedidor;
import com.InpetelCloud.Model.objetoJsonEventoMedidorG3;
import com.InpetelCloud.Model.objetoJsonG3;
import com.InpetelCloud.Model.objetoJsonG3S03;
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
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`TiempoConectado` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `ComStatus` VARCHAR(25) NULL DEFAULT NULL,\r\n"
					+ "  `Descripcion` VARCHAR(150) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`TecnologiaComponente` (\r\n"
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
					+ "  UNIQUE INDEX `Nombre_Marca` (`Nombre_Marca` ASC) VISIBLE,\r\n"
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
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Estados` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre_Est` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
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
					+ "  `Modem_ID` INT NULL DEFAULT NULL,\r\n"
					+ "  `Marca_ID` INT NOT NULL,\r\n"
					+ "  `pass` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `user` VARCHAR(45) NULL DEFAULT NULL,\r\n"
					+ "  `Version` VARCHAR(20) NULL,\r\n"
					+ "  `States_ID` INT NOT NULL,\r\n"
					+ "  `Observacion` VARCHAR(200) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Concetrador_TipoComunicacion1_idx` (`TipoComunicacion_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Concetrador_TiempoConectado1_idx` (`TiempoConectado_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Concentrador_Modem1_idx` (`Modem_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Concentrador_Marca1_idx` (`Marca_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Concentrador_StatesID_idx` (`States_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Conccentrador_TiempoConectado`\r\n"
					+ "    FOREIGN KEY (`TiempoConectado_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TiempoConectado` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Concentrador_Marca1`\r\n"
					+ "    FOREIGN KEY (`Marca_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Marca` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Concentrador_Modem1`\r\n"
					+ "    FOREIGN KEY (`Modem_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Modem` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Concentrador_StatesID`\r\n"
					+ "    FOREIGN KEY (`States_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Estados` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Concetrador_TipoComunicacion1`\r\n"
					+ "    FOREIGN KEY (`TipoComunicacion_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TipoComunicacion` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 150\r\n"
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
					+ "  `Sync_reloj` TINYINT NULL DEFAULT NULL,\r\n"
					+ "  `Modelo` VARCHAR(60) NULL DEFAULT NULL,\r\n"
					+ "  `Serial` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  `Marca_ID` INT NOT NULL,\r\n"
					+ "  `logicalName` VARCHAR(120) NULL,\r\n"
					+ "  `States_ID` INT NOT NULL,\r\n"
					+ "  `Observacion` VARCHAR(200) NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Medidor_TipoMedidor1_idx` (`TipoMedidor_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Medidor_TipoPuerto1_idx` (`TipoPuerto_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Medidor_Marca1_idx` (`Marca_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Medidor_States_idx` (`States_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Medidor_Marca1`\r\n"
					+ "    FOREIGN KEY (`Marca_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Marca` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Medidor_TipoMedidor1`\r\n"
					+ "    FOREIGN KEY (`TipoMedidor_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TipoMedidor` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Medidor_TipoPuerto1`\r\n"
					+ "    FOREIGN KEY (`TipoPuerto_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TipoPuerto` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Medidor_States`\r\n"
					+ "    FOREIGN KEY (`States_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Estados` (`ID`)\r\n"
					+ "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION)\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Usuarios` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombres` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  `Login` VARCHAR(45) NULL DEFAULT NULL,\r\n"
					+ "  `Password` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Password_salt` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Correo` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  `Fecha_crea` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_crea` INT NULL DEFAULT NULL,\r\n"
					+ "  `Fecha_modifica` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Usu_modifica` INT NULL DEFAULT NULL,\r\n"
					+ "  `SistemaExteno_ID` INT NULL DEFAULT NULL,\r\n"
					+ "  `States_ID` INT NOT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `usuario_modifica_idx` (`Usu_modifica` ASC) VISIBLE,\r\n"
					+ "  INDEX `usuario_crea_idx` (`Usu_crea` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Usuarios_States_idx` (`States_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Usuarios_States`\r\n"
					+ "    FOREIGN KEY (`States_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Estados` (`ID`),\r\n"
					+ "  CONSTRAINT `usuario_crea`\r\n"
					+ "    FOREIGN KEY (`Usu_crea`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `usuario_modifica`\r\n"
					+ "    FOREIGN KEY (`Usu_modifica`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Asoc_concen_medidor` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Concentrador_ID` INT NOT NULL,\r\n"
					+ "  `Medidor_ID` INT NOT NULL,\r\n"
					+ "  `Fh_create` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_crea` INT NULL DEFAULT NULL,\r\n"
					+ "  `Fh_update` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_update` INT NULL DEFAULT NULL,\r\n"
					+ "  `Observacion` VARCHAR(200) NULL DEFAULT NULL,\r\n"
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
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
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
					+ "AUTO_INCREMENT = 1\r\n"
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
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`TipoTrafo` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `NombreTrafo` VARCHAR(150) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Transformador` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Address` VARCHAR(30) NULL DEFAULT NULL,\r\n"
					+ "  `Codigo` VARCHAR(120) NULL DEFAULT NULL,\r\n"
					+ "  `Capacidad` INT NULL DEFAULT NULL,\r\n"
					+ "  `Nodo` INT NULL DEFAULT NULL,\r\n"
					+ "  `CargaAforada` INT NULL DEFAULT NULL,\r\n"
					+ "  `TipoTrafo` INT NOT NULL,\r\n"
					+ "  `Concentrador_ID` INT NOT NULL,\r\n"
					+ "  `States_ID` INT NOT NULL,\r\n"
					+ "  `Observacion` VARCHAR(200) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Transformador_Concentrador1_idx` (`Concentrador_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Transformador_States_idx` (`States_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Transformador_TipoTrafo1_idx` (`TipoTrafo` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Transformador_Concentrador1`\r\n"
					+ "    FOREIGN KEY (`Concentrador_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Concentrador` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Transformador_States`\r\n"
					+ "    FOREIGN KEY (`States_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Estados` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Transformador_TipoTrafo1`\r\n"
					+ "    FOREIGN KEY (`TipoTrafo`)\r\n"
					+ "    REFERENCES `"+ name +"`.`TipoTrafo` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Macro` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Concentrador_ID` INT NOT NULL,\r\n"
					+ "  `Medidor_ID` INT NOT NULL,\r\n"
					+ "  `Transformador_ID` INT NOT NULL,\r\n"
					+ "  `Usuarios_ID` INT NOT NULL,\r\n"
					+ "  `Fh_create` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Fh_update` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Macro_Transformador1_idx` (`Transformador_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Macro_Medidor1_idx` (`Medidor_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Macro_Usuarios1_idx` (`Usuarios_ID` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Macro_Concentrador1_idx` (`Concentrador_ID` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Macro_Concentrador1`\r\n"
					+ "    FOREIGN KEY (`Concentrador_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Concentrador` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Macro_Medidor1`\r\n"
					+ "    FOREIGN KEY (`Medidor_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Medidor` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Macro_Transformador1`\r\n"
					+ "    FOREIGN KEY (`Transformador_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Transformador` (`ID`),\r\n"
					+ "  CONSTRAINT `fk_Macro_Usuarios1`\r\n"
					+ "    FOREIGN KEY (`Usuarios_ID`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`EstadoPeticion` (\r\n"
					+ "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre` VARCHAR(150) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`Corte_Reconeccion` (\r\n"
					+ "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `ID_Met` INT(11) NOT NULL,\r\n"
					+ "  `Valor_envio` INT(11) NULL DEFAULT NULL,\r\n"
					+ "  `Estado_Final` INT(11) NULL DEFAULT NULL,\r\n"
					+ "  `Estado_Peticion` INT(11) NOT NULL,\r\n"
					+ "  `Usu_crea` INT(11) NOT NULL,\r\n"
					+ "  `Fecha_inicio` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Fecha_fin` DATETIME NULL DEFAULT NULL,\r\n"
					+ "  `Descripcion` VARCHAR(200) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`),\r\n"
					+ "  INDEX `fk_Corte_Reconeccion_Medidor1_idx` (`ID_Met` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Corte_Reconeccion_Usuarios_idx` (`Usu_crea` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_Corte_Reconeccion_EstadoPeticion_idx` (`Estado_Peticion` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `fk_Corte_Reconeccion_Medidor1`\r\n"
					+ "    FOREIGN KEY (`ID_Met`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Medidor` (`ID`)\r\n"
					+ "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION,\r\n"
					+ "  CONSTRAINT `fk_Corte_Reconeccion_Usuarios`\r\n"
					+ "    FOREIGN KEY (`Usu_crea`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`)\r\n"
					+ "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION,\r\n"
					+ "  CONSTRAINT `fk_Corte_Reconeccion_EstadoPeticion`\r\n"
					+ "    FOREIGN KEY (`Estado_Peticion`)\r\n"
					+ "    REFERENCES `"+ name +"`.`EstadoPeticion` (`ID`)\r\n"
					+ "    ON DELETE NO ACTION\r\n"
					+ "    ON UPDATE NO ACTION)\r\n"
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
					+ "AUTO_INCREMENT = 1\r\n"
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
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`FTP` (\r\n"
					+ "  `ID_FTP` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Descripcion` VARCHAR(200) NULL DEFAULT NULL,\r\n"
					+ "  `EndPoint` VARCHAR(200) NULL DEFAULT NULL,\r\n"
					+ "  `Puerto` INT NULL DEFAULT NULL,\r\n"
					+ "  `Usuario` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Password` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Carpeta_Entrada` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Carpeta_Procesad` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `Fh_create` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_create` INT NULL DEFAULT NULL,\r\n"
					+ "  `Fh_update` TIMESTAMP NULL DEFAULT NULL,\r\n"
					+ "  `Usu_update` INT NULL DEFAULT NULL,\r\n"
					+ "  `IDFTP` INT NULL DEFAULT NULL,\r\n"
					+ "  `Carpeta_Errores` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID_FTP`),\r\n"
					+ "  INDEX `ff_idx` (`Usu_create` ASC) VISIBLE,\r\n"
					+ "  INDEX `fk_ftp_fk_usuariop_idx` (`Usu_update` ASC) VISIBLE,\r\n"
					+ "  INDEX `FK_FTP_FK_IDFTP_idx` (`IDFTP` ASC) VISIBLE,\r\n"
					+ "  CONSTRAINT `FK_FTP_FK_IDFTP`\r\n"
					+ "    FOREIGN KEY (`IDFTP`)\r\n"
					+ "    REFERENCES `"+ name +"`.`FTP` (`ID_FTP`),\r\n"
					+ "  CONSTRAINT `FK_FTP_FK_USUARIOC`\r\n"
					+ "    FOREIGN KEY (`Usu_create`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`),\r\n"
					+ "  CONSTRAINT `FK_FTP_FK_USUARIOP`\r\n"
					+ "    FOREIGN KEY (`Usu_update`)\r\n"
					+ "    REFERENCES `"+ name +"`.`Usuarios` (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
					+ "DEFAULT CHARACTER SET = utf8;");
			
			template.execute("CREATE TABLE IF NOT EXISTS `"+ name +"`.`InfoMedidas` (\r\n"
					+ "  `ID` INT NOT NULL AUTO_INCREMENT,\r\n"
					+ "  `Nombre` VARCHAR(50) NULL DEFAULT NULL,\r\n"
					+ "  `Codigo` VARCHAR(100) NULL DEFAULT NULL,\r\n"
					+ "  `UnidadMedidad` VARCHAR(15) NULL DEFAULT NULL,\r\n"
					+ "  `Descipcion` VARCHAR(155) NULL DEFAULT NULL,\r\n"
					+ "  PRIMARY KEY (`ID`))\r\n"
					+ "ENGINE = InnoDB\r\n"
					+ "AUTO_INCREMENT = 1\r\n"
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
					+ "  `IdProfile` INT NULL,"
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
					+ "AUTO_INCREMENT = 1\r\n"
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
				+ "VALUES ('" + modem.getSerial() + "', '" + modem.getNombre() + "', '" + modem.getImei() + "', '" + modem.getMarca() + "')");
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
	public int crearCyR(CyR cyr) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Corte_Reconeccion (ID_Met,Valor_envio,Estado_Peticion, Usu_crea, Fecha_inicio, Descripcion )\r\n"
				+ "VALUES ('"+ cyr.getIdMet() +"', '"+ cyr.getValorEnvio() +"', '1', '"+ cyr.getUsuCrea() +"', now(), '"+ cyr.getDescripcion() +"');");
		return value;
	}
	
	@Override
	public int crearTransformador(Transformador transformador) {
		
		int value = template.update("INSERT INTO Inpetel_Cloud.Transformador (Address, Codigo, Capacidad, Nodo, CargaAforada, TipoTrafo, Concentrador_ID, States_ID)\r\n"
				+ " VALUES ('"+ transformador.getAddress() + "', '"+ transformador.getCodigo() + "', " + transformador.getCapacidad() +", " + transformador.getNodo() + ", " + transformador.getCargaAforada() + ", '" + transformador.getTipoTrafo() + "', " + transformador.getConcentradorId() + ", 1);");
		return value;
	}
	
	
	@Override
	public int crearUsuario(Usuarios usuario) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Usuarios ( Nombres, Login, Password, Password_salt, Correo, Fecha_crea, Usu_crea, SistemaExteno_ID, States_ID)\r\n"
				+ " VALUES ('"+ usuario.getNombres()+ "', '"+ usuario.getLogin()+ "', '"+ usuario.getPassword()+"', '" + usuario.getPassword_salt()+  "', '"+ usuario.getCorreo() +"', now() , '" + usuario.getUsuCrea() +"','" + usuario.getSistemaExternoId()+"', '" + 2+"' );");
		return value;
	}
	
	@Override
	public int crearMedidorVista(modelMeter medidor) {
		int value=0;
		List<String> tipoMet = tipoMedidor(medidor);
		List<String> marcaId = marcaMedidor(medidor);
		if(marcaId.get(0).equals("1")) {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, TipoPuerto_ID , Prepago, Sync_reloj,  Modelo, Serial, Marca_ID, States_ID )\r\n"
					+ " VALUES ('"+ tipoMet.get(0) + "', '" + medidor.getMagnitud() + "',  '" + medidor.getNumberQuadrants() + "' , '" + medidor.getTipoPuertoId() + "', '" + medidor.getPrepago() + "', '" + medidor.getSyncReloj() + "', '" + medidor.getModel() + "', '" + medidor.getMeter() + "', '" + marcaId.get(0)+ "', '1');");
			
			 }
		else {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, TipoPuerto_ID , Prepago,  Sync_reloj,  Modelo, Serial, Marca_ID , States_ID)\r\n"
					+ " VALUES ('"+ tipoMet.get(0) + "', '" + medidor.getMagnitud() + "',  '" + medidor.getNumberQuadrants() + "' , '" + medidor.getTipoPuertoId() + "', '" + medidor.getPrepago() + "', '" + medidor.getSyncReloj() + "', '" + medidor.getModel() + "', '" + medidor.getMeter() + "', '" + marcaId.get(0)+ "', '1');");	 
		}
		return value;
		
	}
	
	@Override
	public int crearConcentradorVista(modelConcentrator concentrador) {
		int value=0;
		List<String> marcaId = marcaConcentrador(concentrador);
		if(marcaId.get(0).equals("1") ) {
			
			 value = template.update("INSERT INTO Inpetel_Cloud.Concentrador (Ip_real, NombreConcentrador, TipoComunicacion_ID, Imei,  Serial , TiempoConectado_ID, Modem_Embedido, IOmodule,  Modem_ID,  Marca_ID, pass, user, States_ID )\r\n"
						+ " VALUES ('"+ concentrador.getIpReal() + "', '"+ concentrador.getConcentrator() + "',  '" + concentrador.getTipoComunicacionId() + "' , '" + concentrador.getImei() + "','" + concentrador.getConcentrator() + "', '" + concentrador.getTiempoConectadoId() + "', '" + concentrador.getModemEmbebidoId() + "', '" + concentrador.getIoModule()+ "', '" + concentrador.getModemId() + "', '" + marcaId.get(0) + "', 'NA', 'NA', '1' );");
		}
		else {
			value = template.update("INSERT INTO Inpetel_Cloud.Concentrador (Ip_real, NombreConcentrador, TipoComunicacion_ID, Imei,  Serial , TiempoConectado_ID, Modem_Embedido, IOmodule,  Modem_ID,  Marca_ID, pass, user, States_ID )\r\n"
					+ " VALUES ('"+ concentrador.getIpReal() + "', '"+ concentrador.getConcentrator() + "',  '" + concentrador.getTipoComunicacionId() + "' , '" + concentrador.getImei() + "','" + concentrador.getConcentrator() + "', '" + concentrador.getTiempoConectadoId() + "', '" + concentrador.getModemEmbebidoId() + "', '" + concentrador.getIoModule()+ "', '" + concentrador.getModemId() + "', '" + marcaId.get(0) + "', '"+ concentrador.getPass()+"', '"+concentrador.getUser()+"', '1' );");
			
		}

		return value;
	}
	
	/**
	 * Retorno: si es 2, el idCnc  no esta en la bd. Si es 3 el idMet no está en la bd, Si es 3 el idTrafo no está en la bd
	 * Comentario: El id del usuario se entiende que viene el numero.
	 */
	@Override
	public int crearMacro(Macro macro) {
		int value = 0;
		List<String> idCnc = idConcentrador(macro.getIdConcentrador());
		List<String> idMet = idMedidor(macro.getIdMedidor());
		List<String> idTrafo =idTransformadorPorCodigo(macro.getIdTrafo());
		
		if(idCnc.size() < 1) {
			System.out.println("El id del cnc que esta tratando de mandar no existe en la base de datos");
			value = 2;
		}
		
		else if(idMet.size() < 1) {
			System.out.println("El id del medidor que esta tratando de mandar no existe en la base de datos");
			value = 3;
		}
		else if(idTrafo.size() < 1) {
			System.out.println("El id del trafo que esta tratando de mandar no existe en la base de datos");
			value = 4;
		}
		
		else {
			value = template.update("INSERT INTO Inpetel_Cloud.Macro (Concentrador_ID, Medidor_ID, Usuarios_ID, Transformador_ID, Fh_create)\r\n"
					+ " VALUES ('"+ idCnc.get(0) + "', '"+ idMet.get(0) + "', '"+ macro.getIdUsuario() + "',  '" + idTrafo.get(0) + "' , now());");
			}

		return value;
	}

	
	public List<Map<String,Object>> validarUsuario(Usuarios usuario) {
		List<Map<String,Object>>validacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Usuarios where Login='"+ usuario.getLogin() +"';");
		return validacion;
	}
	
	public List<Map<String,Object>> validarModem(Modem modem) {
		List<Map<String,Object>>validacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Modem where Imei='"+ modem.getImei() +"';");
		return validacion;
	}
	
	public List<Map<String,Object>> validarAsoTransformadorCnc(Transformador transformador) {
		List<Map<String,Object>>validacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Transformador where Concentrador_ID='"+transformador.getConcentradorId() +"';");
		return validacion;
	}
	
	/**
	 * Valida que el concentrador que viene del transformador exista en la tabla concentrador
	 * @param transformador
	 * @return
	 */
	public List<Map<String,Object>> validarConcentradorTransformador(Transformador transformador) {
		List<Map<String,Object>>validacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador where ID='"+ transformador.getConcentradorId() +"';");
		return validacion;
	}
	
	
	/*
	 * Descripcion: Metodo que crea un concentrador dentro del metodo que crea una medida
	 */
	@Override
	public int crearConcentradorMedida(String concentrador) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Concentrador (Ip_real, NombreConcentrador, TipoComunicacion_ID, Imei,  Serial , TiempoConectado_ID, Modem_Embedido, IOmodule,  Modem_ID,  Marca_ID, States_ID)\r\n"
				+ " VALUES ('"+ 1 + "', '"+ 1 + "',  '" + 1 + "' , '" + 1 + "','" + concentrador + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 56 + "', '" + 1 + "', '" + 1 + "');");
		return value;
	}
	
	/*
	 * Descripcion: Metodo que crea un medidor dentro del metodo que crea una medida
	 */
	@Override
	public int crearMedidorMedida(String medidor) {
		int value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, TipoPuerto_ID , Prepago, Sync_reloj,  Modelo, Serial, Marca_ID, States_ID )\r\n"
				+ " VALUES ('"+ 1 + "', '" + 1 + "',  '" + 1 + "' ,'" + 1 + "', '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + medidor + "', '" + 1+ "', '" + 1+ "');");
		return value;
	}
	
	public ArrayList<String> serialesConcentrador(modelMeter medidor) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>serialConcentrador = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador where Serial='"+ medidor.getConcentrator() +"';");
		if(serialConcentrador.size() == 1) {
			for (int i = 0; i < serialConcentrador.size(); i++) {
				resultado.add(serialConcentrador.get(i).get("ID").toString());
			}
			}
		return resultado;
	}
	
	public ArrayList<String> serialesConcentradoresMedidores(modelMeter medidor, int j) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>serialConcentrador = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador where Serial='"+ medidor.getConcentrator() +"';");
		if(serialConcentrador.size() == 1) {
			for (int i = 0; i < serialConcentrador.size(); i++) {
				resultado.add(serialConcentrador.get(i).get("ID").toString());
			}
			}
		return resultado;
	}
	
	public List<Map<String, Object>> cncSerial(String cnsS) {
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador WHERE Serial='"+ cnsS +"';");
		return view;
	}
	
	
	
	public ArrayList<String> idConcentrador(String cncS) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador WHERE Serial='"+ cncS +"';");
		if(view.size() == 1) {
			for (int i = 0; i < view.size(); i++) {
				resultado.add(view.get(i).get("ID").toString());
			}
		}
		return resultado;
	}
	
	public ArrayList<String> idTransformadorPorCodigo(String codigo) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Transformador WHERE Codigo='"+ codigo +"';");
		if(view.size() == 1) {
			for (int i = 0; i < view.size(); i++) {
				resultado.add(view.get(i).get("ID").toString());
			}
		}
		return resultado;
	}
	
	public ArrayList<String> idMedidor(String metS) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>view = template.queryForList("SELECT * FROM Inpetel_Cloud.Medidor WHERE Serial='"+ metS +"';");
		if(view.size() == 1) {
			for (int i = 0; i < view.size(); i++) {
				resultado.add(view.get(i).get("ID").toString());
			}
		}
		return resultado;
	}
	
	public ArrayList<String> serialesMedidor(modelMeter medidor) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>serialMedidor = template.queryForList("SELECT * FROM Inpetel_Cloud.Medidor where Serial='"+ medidor.getMeter() +"';");
		if(serialMedidor.size() == 1) {
			for (int i = 0; i < serialMedidor.size(); i++) {
				resultado.add(serialMedidor.get(i).get("ID").toString());
				}
			}
		return resultado;
	}
	
	public ArrayList<String> idTransformador(Transformador transformador) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>idTransformador = template.queryForList("SELECT * FROM Inpetel_Cloud.Transformador where ID='"+ transformador.getConcentradorId() +"';");
		if(idTransformador.size() == 1) {
			for (int i = 0; i < idTransformador.size(); i++) {
				resultado.add(idTransformador.get(i).get("ID").toString());
			}
			}
		
		return resultado;
	}
	
	
	
	public ArrayList<String> validarSerialCncTablaAsociacion(modelMeter medidor) {
		ArrayList<String> idAsociacionmed = new ArrayList<String>();
		ArrayList<String> concentrador = serialesConcentrador(medidor);
		ArrayList<String> medidorS = serialesMedidor(medidor);

		List<Map<String,Object>>asociacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Asoc_concen_medidor where Concentrador_ID='"+ concentrador.get(0) +"' and Medidor_ID='"+ medidorS.get(0) +"' ;");
		if(asociacion.size() == 1) {
			for (int i = 0; i < asociacion.size(); i++) {
				idAsociacionmed.add(asociacion.get(i).get("ID").toString());
			}
		}
		return idAsociacionmed;
	}
	
	public ArrayList<String> validarSerialCncTablaAsociacion(String idMet, String idCnc) {
		ArrayList<String> idAsociacionmed = new ArrayList<String>();

		List<Map<String,Object>>asociacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Asoc_concen_medidor where Concentrador_ID='"+ idCnc +"' and Medidor_ID='"+ idMet +"' ;");
		if(asociacion.size() == 1) {
			for (int i = 0; i < asociacion.size(); i++) {
				idAsociacionmed.add(asociacion.get(i).get("ID").toString());
			}
		}
		return idAsociacionmed;
	}
	
	/**
	 * 
	 * @param idConcentrador id del concentrador
	 * @param idMedidor id del medidor
	 * @return booleano indicando si la asociacion entre ese concentrador y ese medidor ya existe, true si existe, false del caso contrario.
	 */
	public boolean validarAsociacionCncMet(String idConcentrador, String idMedidor ) {
		boolean existe = false;
		//valida que ya exista la asociacion de ese concentrador con ese medidor
		List<Map<String,Object>>asociacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Asoc_concen_medidor where Concentrador_ID='"+ idConcentrador +"' and Medidor_ID='"+ idMedidor +"' ;");
		if(asociacion.size() >= 1) {
			existe = true;
		}
		return existe;
	}
	
	
	
	
		
	public ArrayList<String> serialesCnc(modelConcentrator concentrador) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>serialConcentrador = template.queryForList("SELECT * FROM Inpetel_Cloud.Concentrador where Serial='"+ concentrador.getConcentrator() +"';");
		if(serialConcentrador.size() == 1) {
			for (int i = 0; i < serialConcentrador.size(); i++) {
				resultado.add(serialConcentrador.get(i).get("ID").toString());
			}
			}
		
		return resultado;
	}
	
	
	
	
	
	
	/*
	 * Descripcion: Metodo para crear un medidor a través de un crud. ( por aparte  de la medida)
	 */
	@Override
	public int crearMedidor(modelMeter medidor) {
		int value=0;
		List<String> tipoMet = tipoMedidor(medidor);
		List<String> marcaId = marcaMedidor(medidor);
		if(marcaId.get(0).equals("1")) {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, TipoPuerto_ID , Prepago, Sync_reloj,  Modelo, Serial, Marca_ID, logicalName, States_ID )\r\n"
					+ " VALUES ('"+ tipoMet.get(0) + "', '" + 1 + "',  '" + 1+ "' , '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + medidor.getModel() + "', '" + medidor.getMeter() + "', '" + marcaId.get(0)+ "', 'NA', '1');");
			
			 }
		else {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, TipoPuerto_ID , Prepago,  Sync_reloj,  Modelo, Serial, Marca_ID, logicalName , States_ID)\r\n"
					+ " VALUES ('"+ tipoMet.get(0) + "', '" + 1 + "',  '" + 1+ "' , '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + medidor.getModel() + "', '" + medidor.getMeter() + "', '" + marcaId.get(0)+ "', '" + medidor.getLogicalName()+ "', '1');");	 
		}
		return value;
	}
	
	public int crearMedidores(modelMeter medidor, int j) {
		int value=0;
		List<String> tipoMet = tipoMedidor(medidor);
		List<String> marcaId = marcaMedidor(medidor);
		if(marcaId.get(0).equals("1")) {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, TipoPuerto_ID , Prepago, Sync_reloj,  Modelo, Serial, Marca_ID, logicalName, States_ID )\r\n"
					+ " VALUES ('"+ tipoMet.get(0) + "', '" + 1 + "',  '" + 1+ "' , '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + medidor.getModel() + "', '" + medidor.getMeter() + "', '" + marcaId.get(0)+ "', 'NA', '1');");
			
			 }
		else {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidor (TipoMedidor_ID, Magnitud, NumCuadrantes, TipoPuerto_ID , Prepago,  Sync_reloj,  Modelo, Serial, Marca_ID, logicalName , States_ID)\r\n"
					+ " VALUES ('"+ tipoMet.get(0) + "', '" + 1 + "',  '" + 1+ "' , '" + 1 + "', '" + 1 + "', '" + 1 + "', '" + medidor.getModel() + "', '" + medidor.getMeter() + "', '" + marcaId.get(0)+ "', '" + medidor.getLogicalName()+ "', '1');");	 
		}
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
		int value=0;
		List<String> marcaId = marcaConcentrador(concentrador);
		if(marcaId.get(0).equals("1")) {
			 value = template.update("INSERT INTO Inpetel_Cloud.Concentrador (Ip_real, NombreConcentrador, TipoComunicacion_ID, Imei,  Serial , TiempoConectado_ID, Modem_Embedido, IOmodule,  Modem_ID,  Marca_ID, pass, user, Version, States_ID )\r\n"
						+ " VALUES ('"+ 1 + "', '"+ concentrador.getConcentrator() + "',  '" + 1 + "' , '" + concentrador.getImei() + "','" + concentrador.getConcentrator() + "', '" + 1 + "', '" + 1 + "', '" + 1+ "', '" + 56 + "', '" + marcaId.get(0) + "', 'NA', 'NA', '"+concentrador.getVersion()+"', '1' );");
		}
		else {
			value = template.update("INSERT INTO Inpetel_Cloud.Concentrador (Ip_real, NombreConcentrador, TipoComunicacion_ID, Imei,  Serial , TiempoConectado_ID, Modem_Embedido, IOmodule,  Modem_ID,  Marca_ID, pass, user, Version, States_ID )\r\n"
					+ " VALUES ('"+ 1 + "', '"+ concentrador.getConcentrator() + "',  '" + 1 + "' , '" + concentrador.getImei() + "','" + concentrador.getConcentrator() + "', '" + 1 + "', '" + 1 + "', '" + 1+ "', '" + 56 + "', '" + marcaId.get(0) + "', '" + concentrador.getPass() + "', '" + concentrador.getUser() + "', '"+concentrador.getVersion()+"', '1');");
			
		}

		return value;
	}
	
	
	
	public int updateConcentrador(modelConcentrator concentrador, String id) {
		List<String> marca = marcaConcentrador(concentrador);
		int value=0;
		if(marca.get(0).equals("1")) {
			value= template.update("UPDATE Inpetel_Cloud.Concentrador set NombreConcentrador='"+concentrador.getConcentrator()+"', Imei='"+concentrador.getImei()+"', Serial='"+concentrador.getConcentrator()+"', Marca_ID='"+marca.get(0)+"', pass='Na', user='Na', Version='"+concentrador.getVersion()+"'  where ID="+ id +";");
			}
		else {
			value= template.update("UPDATE Inpetel_Cloud.Concentrador set NombreConcentrador='"+concentrador.getConcentrator()+"', Imei='"+concentrador.getImei()+"', Serial='"+concentrador.getConcentrator()+"', Marca_ID='"+marca.get(0)+"', pass='"+concentrador.getPass()+"', user='"+concentrador.getUser()+"', Version='"+concentrador.getVersion()+"'  where ID="+ id +";");

		}

		return value;
	}
	
	public int updateMedidor(modelMeter medidor, String id) {
		List<String> marca = marcaMedidor(medidor);
		List<String> tipoMedidor = tipoMedidor(medidor);
		int value= template.update("UPDATE Inpetel_Cloud.Medidor set TipoMedidor_ID='"+ tipoMedidor.get(0) +"',  Modelo='"+medidor.getModel()+"', Serial='"+medidor.getMeter()+"', Marca_ID='"+marca.get(0)+"', logicalName='"+medidor.getLogicalName()+"'  where ID="+ id +";");
		return value;
	}
	
	public int updateAsoCncMet(modelMeter medidor, String id) {
		ArrayList<String> concentrador = serialesConcentrador(medidor);
		ArrayList<String> medidorS = serialesMedidor(medidor);
		int value= template.update("UPDATE Inpetel_Cloud.Asoc_concen_medidor set Concentrador_ID='"+concentrador.get(0)+"', Medidor_ID='"+medidorS.get(0)+"', Fh_update=now(), Usu_update='"+56+"'   where ID="+ id +";");

		return value;
	}
	
	public int updateAsoCncMet(String idMet, String idCnc, String id) {
		int value= template.update("UPDATE Inpetel_Cloud.Asoc_concen_medidor set Concentrador_ID='"+idCnc+"', Medidor_ID='"+idMet+"', Fh_update=now(), Usu_update='"+56+"'   where ID="+ id +";");

		return value;
	}
	
	public int updateTransformador(Transformador transformador, String id) {
	int value = template.update("UPDATE Inpetel_Cloud.Transformador set Address='"+ transformador.getAddress() + "', Codigo='"+ transformador.getCodigo()+ "', Capacidad='"+ transformador.getCapacidad() + "', Nodo='"+ transformador.getNodo() + "', CargaAforada='"+ transformador.getCargaAforada() + "', TipoTrafo='"+ transformador.getTipoTrafo() + "', Concentrador_ID='"+ transformador.getConcentradorId() + "' where ID="+ id +";");
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
		int value=crearMedidaPrime(null,null, null,null);
		return value;
	}
	
	/*
	 * Descripcion: Metodo que hace la creacion de la medida con todos los valores que necesita, se hace este
	 * proceso 7 veces porque son 7 medidas que vienen en el arreglo de infomedidas, se pone que i <7 porque no
	 * tomaba la ultima posicion del arreglo de Q.
	 */
	public int crearMedidaPrime(List<String> resultado,List<String> valorInfoMedida,List<String> fechas,List<String> idInfoMedidas) {
		int value=0;

		if(valorInfoMedida.size() == 3) {
			for (int i = 0; i < 3; i++) {
				value = template.update("INSERT INTO Inpetel_Cloud.Medidas ( Medidor_ID, Num_val, Fecha , HoraIncio, HoraFin, Trazabilidad_ID, Usu_create, InfoMedidas_ID, Usu_update)\r\n "
						+ "VALUES ('" +  resultado.get(0) + "', '" + valorInfoMedida.get(i) + "', '" + fechas.get(0) + "', '" + fechas.get(1) + "', '" + fechas.get(2) + "', '" + resultado.get(1) + "', '" + 60 + "','" + idInfoMedidas.get(i)+ "', '" + 60 + "');");
			}
		}
		else {
			for (int i = 0; i < 7; i++) {
				value = template.update("INSERT INTO Inpetel_Cloud.Medidas ( Medidor_ID, Num_val, Fecha, HoraIncio, HoraFin, Trazabilidad_ID, Usu_create, InfoMedidas_ID, Usu_update)\r\n "
						+ "VALUES ('" +  resultado.get(0) + "', '" + valorInfoMedida.get(i) + "', '" + fechas.get(0) + "', '" + fechas.get(1) + "', '" + fechas.get(2) + "', '" + resultado.get(1) + "', '" + 60 + "','" + idInfoMedidas.get(i)+ "', '" + 60 + "');");
			}
		}
		return value;
	}
	
	public int crearMedidaPrimeDiaria(List<String> resultado,List<String> valorInfoMedida,List<String> fechas,List<String> idInfoMedidas) {
		int value=0;
		if(valorInfoMedida.size() == 3) {
			for (int i = 0; i < 3; i++) {
				value = template.update("INSERT INTO Inpetel_Cloud.Medidas ( Medidor_ID, Num_val, Fecha , HoraFin, Trazabilidad_ID, Usu_create, InfoMedidas_ID, Usu_update)\r\n "
						+ "VALUES ('" +  resultado.get(0) + "', '" + valorInfoMedida.get(i) + "', '" + fechas.get(0) + "', '" + fechas.get(2) + "', '" + resultado.get(1) + "', '" + 60 + "','" + idInfoMedidas.get(i)+ "', '" + 60 + "');");
			}
		}
		else {
			for (int i = 0; i < 7; i++) {
				value = template.update("INSERT INTO Inpetel_Cloud.Medidas ( Medidor_ID, Num_val, Fecha, HoraFin, Trazabilidad_ID, Usu_create, InfoMedidas_ID, Usu_update)\r\n "
						+ "VALUES ('" +  resultado.get(0) + "', '" + valorInfoMedida.get(i) + "', '" + fechas.get(0) + "', '" + fechas.get(2) + "', '" + resultado.get(1) + "', '" + 60 + "','" + idInfoMedidas.get(i)+ "', '" + 60 + "');");
			}
		}
		return value;
	}
	
	/*
	 * Se omite ingresar el status para un futuro, porque el status hace referencia a un bit de calidad, por este motivo en este momento no se tiene en cuenta
	 * para ingresar una medida de g3, porque repite los registros a la hora de insertar
	 */
	public int crearMedidaG3(List<String> resultado,List<String> idRegister,List<String> fechas,List<String> valorRegister) {
		int value=0;		
		//for (int i = 0; i < 2; i++) {
			value = template.update("INSERT INTO Inpetel_Cloud.Medidas ( Medidor_ID, Num_val, Fecha, HoraIncio, HoraFin, Trazabilidad_ID, Usu_create, InfoMedidas_ID, Usu_update, IdProfile)\r\n "
					+ "VALUES ('" +  resultado.get(0) + "', '" + valorRegister.get(0) + "', '" + fechas.get(0) + "', '" + fechas.get(1) + "', '" + fechas.get(2) + "', '" + resultado.get(1) + "', '" + 60 + "','" + idRegister.get(0)+ "', '" + 60 + "', '"+ resultado.get(2)+"');");
		//}
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
		template.update("INSERT INTO Inpetel_Cloud.Asoc_concen_medidor (Concentrador_ID, Medidor_ID, Fh_create, Usu_crea) VALUES\r\n"
				+ "('" + resultado.get(1) + "', '" + resultado.get(0)+ "', now(), '" + 56 + "');");
		
	}
	
	
	public void crearTrazabilidad(ObjetoJson json, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + json.getHours().get(j).getNameFile() + "');");
		}
	
	public List<Map<String,Object>> obtenerIdTrazabilidad(ObjetoJson json, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ json.getHours().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}
	
	public List<Map<String,Object>> obtenerIdTrazabilidadMedidaG3(objetoJsonG3 jsons03, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ jsons03.getG3().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}
	
	public List<Map<String,Object>> obtenerIdTrazabilidadMedidaG3Diaria(objetoJsonG3S03 jsong3s03, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ jsong3s03.getDaysg3().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}
	
	public List<Map<String,Object>> obtenerIdTrazabilidadEventoMedidor(objetoJsonEventoMedidor evento, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ evento.getEventoMedidor().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}
	
	public List<Map<String,Object>> obtenerIdTrazabilidadEventoMedidorG3(objetoJsonEventoMedidorG3 evento, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ evento.getG3EventoMedidor().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}
	
	public List<Map<String,Object>> obtenerIdTrazabilidadEventoConcentrador(objetoJsonEventoConcentrador evento, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ evento.getEventoConcentrador().get(j).getNameFile() +"';");
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
		int value=crearMedidaPrime(null,null, null,null);
		return value;
	}
	
	public List<Map<String,Object>> obtenerIdMedidorS03(ObjetoJsonS03 jsons03, int j) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ jsons03.getDays().get(j).getMeter() +"';");
		return idMedidor;
	}
	
	public List<Map<String,Object>> obtenerIdMedidorG3(objetoJsonG3 jsons03, int j) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ jsons03.getG3().get(j).getMeter() +"';");
		return idMedidor;
	}
	
	public List<Map<String,Object>> obtenerIdEventoMedidorG3(objetoJsonEventoMedidorG3 evento, int j) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ evento.getG3EventoMedidor().get(j).getMeter() +"';");
		return idMedidor;
	}
	
	public List<Map<String,Object>> obtenerIdMedidorG3Diaria(objetoJsonG3S03 jsong3s03, int j) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ jsong3s03.getDaysg3().get(j).getMeter() +"';");
		return idMedidor;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorS03(ObjetoJsonS03 jsons03, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ jsons03.getDays().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorG3(objetoJsonG3 jsong3, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ jsong3.getG3().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorG3S03(objetoJsonG3S03 jsong3s03, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ jsong3s03.getDaysg3().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorEvento(objetoJsonEventoConcentrador evento, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ evento.getEventoConcentrador().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	public List<Map<String,Object>> obtenerIdMedidorEvento(objetoJsonEventoMedidor evento, int j) {
		List<Map<String,Object>>idMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Medidor where Serial='"+ evento.getEventoMedidor().get(j).getMeter() +"';");
		return idMedidor;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorEventoMedidor(objetoJsonEventoMedidor evento, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ evento.getEventoMedidor().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	public List<Map<String,Object>> obtenerIdConcentradorEventoMedidorG3(objetoJsonEventoMedidorG3 evento, int j) {
		List<Map<String,Object>>idConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Concentrador where Serial='"+ evento.getG3EventoMedidor().get(j).getConcentrator() +"';");
		return idConcentrador;
	}
	
	
	
	public void crearTrazabilidadS03(ObjetoJsonS03 jsons03, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + jsons03.getDays().get(j).getNameFile() + "');");
		}
	
	public void crearTrazabilidadG3(objetoJsonG3 jsong3, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + jsong3.getG3().get(j).getNameFile() + "');");
		}
	
	public void crearTrazabilidadG3Diaria(objetoJsonG3S03 jsong3s03, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + jsong3s03.getDaysg3().get(j).getNameFile() + "');");
		}
	
	public void crearTrazabilidadEventoMedidor(objetoJsonEventoMedidor evento, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + evento.getEventoMedidor().get(j).getNameFile() + "');");
		}
	
	public void crearTrazabilidadEventoMedidorG3(objetoJsonEventoMedidorG3 evento, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + evento.getG3EventoMedidor().get(j).getNameFile() + "');");
		}
	
	public void crearTrazabilidadEventoConcentrador(objetoJsonEventoConcentrador evento, int j) {
		template.update("INSERT INTO Inpetel_Cloud.Trazabilidad (Nombre_reporte) VALUES\r\n"
				+ "('" + evento.getEventoConcentrador().get(j).getNameFile() + "');");
		}
	
	public List<Map<String,Object>> obtenerIdTrazabilidadS03(ObjetoJsonS03 jsons03, int j) {
		List<Map<String,Object>>idTrazabilidad = template.queryForList("SELECT ID FROM Inpetel_Cloud.Trazabilidad where Nombre_reporte='"+ jsons03.getDays().get(j).getNameFile() +"';");
		return idTrazabilidad;
	}
	
	public List<Map<String,Object>> obtenerIdProfile(objetoJsonG3 jsons03, int j) {
		List<Map<String,Object>>idProfile = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Codigo='"+ jsons03.getG3().get(j).getIdProfile() +"';");
		return idProfile;
	}
	
	public List<Map<String,Object>> obtenerIdProfileEventoMedidorG3(objetoJsonEventoMedidorG3 evento, int j) {
		List<Map<String,Object>>idProfile = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoEventos where Codigo='"+ evento.getG3EventoMedidor().get(j).getIdProfile() +"';");
		return idProfile;
	}
	
	public List<Map<String,Object>> obtenerIdProfileG3Diaria(objetoJsonG3S03 jsong3s03, int j) {
		List<Map<String,Object>>idProfile = template.queryForList("SELECT ID FROM Inpetel_Cloud.InfoMedidas where Codigo='"+ jsong3s03.getDaysg3().get(j).getIdProfile() +"';");
		return idProfile;
	}
	
	public ArrayList<String> obtenerIdRegister(String obi) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>idRegister = template.queryForList("SELECT * FROM Inpetel_Cloud.InfoMedidas where Codigo='"+ obi +"';");
		
		if(idRegister.size() > 0) {
			resultado.add(idRegister.get(0).get("ID").toString());
			}
		else {
			
		}
		
		return resultado;
	}
	
	public ArrayList<String> obtenerIdRegisterEventoMedidorG3(String obi) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>idRegister = template.queryForList("SELECT * FROM Inpetel_Cloud.InfoEventos where Codigo='"+ obi +"';");
		
		if(idRegister.size() > 0) {
			resultado.add(idRegister.get(0).get("ID").toString());
			}
		else {
			
		}
		
		return resultado;
	}
	
	public ArrayList<String> obtenerGrupoEvento(String grupoEvento) {
		ArrayList<String> resultado = new ArrayList<String>();
		List<Map<String,Object>>idGrupoEvento = template.queryForList("SELECT * FROM Inpetel_Cloud.InfoEventos where GrupoEvento='"+ grupoEvento +"';");
		
			//for (int k = 0; k < idRegister.size(); k++) {
		if(idGrupoEvento.size() > 0) {
			resultado.add(idGrupoEvento.get(0).get("ID").toString());
			}
		else {
			
		}
			//}
		
		return resultado;
	}
	
	public List<String> tipoMedidor(modelMeter medidor){
		List<Map<String, Object>> tipoMedidor = new ArrayList<>();
		List<Object> resultado = new ArrayList<Object>();
		List<String> tipo = new ArrayList<String>();

		String monofasico="Monofasico";
		String trifasico="Trifasico";
		String monofasicoTrifilar="Monofasico Trifilar";
		String trifasicoSemidirecta = "Trifasico Semidirecta";
		String bifasico = "Bifasico";
		String polifasico ="Polifasico";

		
		
		switch (medidor.getTypeMeter()) {
		case "Monofasico":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ monofasico +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Trifasico":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ trifasico +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Monofasico Trifilar":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ monofasicoTrifilar +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Trifasico Semidirecta":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ trifasicoSemidirecta +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Bifasico":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ bifasico +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "Polifasico":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.TipoMedidor where NombreMedidor='"+ polifasico +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		default:
			break;
		}
		tipo.add(resultado.get(0).toString());
		return tipo;
	}
	
	public List<String> marcaMedidor(modelMeter medidor){
		List<Map<String, Object>> tipoMedidor = new ArrayList<>();
		List<Object> resultado = new ArrayList<Object>();
		List<String> tipoMarca = new ArrayList<String>();

		String circutor="CIRCUTOR";
		String meter="METER AND CONTROL";
		String add="ADD";
		
		switch (medidor.getBrand().toUpperCase()) {
		case "CIRCUTOR":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ circutor +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "METER AND CONTROL":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ meter +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "ADD":
			tipoMedidor = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ add +"';");			
			for (Map<String, Object> map : tipoMedidor) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		default:
			break;
		}
		tipoMarca.add(resultado.get(0).toString());

		return tipoMarca;
	}
	
	
	public List<String> marcaConcentrador(modelConcentrator concentrador){
		List<Map<String, Object>> tipoConcentrador = new ArrayList<>();
		List<Object> resultado = new ArrayList<Object>();
		List<String> tipoMarca = new ArrayList<String>();

		String circutor="CIRCUTOR";
		String meter="METER AND CONTROL";
		String add="ADD";
		
		
		switch (concentrador.getBrand().toUpperCase()) {
		case "CIRCUTOR":
			tipoConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ circutor +"';");			
			for (Map<String, Object> map : tipoConcentrador) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "METER AND CONTROL":
			tipoConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ meter +"';");			
			for (Map<String, Object> map : tipoConcentrador) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		case "ADD":
			tipoConcentrador = template.queryForList("SELECT ID FROM Inpetel_Cloud.Marca where Nombre_Marca='"+ add +"';");			
			for (Map<String, Object> map : tipoConcentrador) {
				for (Map.Entry<String, Object> entry : map.entrySet()) {
					Object value = entry.getValue();
					resultado.add(value);
				}
			}
			break;
		default:
			break;
		}
		tipoMarca.add(resultado.get(0).toString());

		return tipoMarca;
	}

	@Override
	public int crearMedidaG3Horaria(objetoJsonG3 jsong3) {
		int value=crearMedidaG3(null,null, null,null);
		return value;
	}

	@Override
	public int crearMedidaG3Diaria(objetoJsonG3S03 jsong3) {
		int value=crearMedidaG3(null,null, null,null);
		return value;
	}

	@Override
	public int crearEventoConcentrador(objetoJsonEventoConcentrador evento) {
		int value = crearEventoC(null, null, null,  null, "", evento, 0);
		return value;
	}


	@Override
	public int crearEventoMedidorG3(objetoJsonEventoMedidorG3 evento) {
		int value=crearEventoMedidorG3Prueba(null,null, null,null);
		return value;
	}
	
	
	/**
	 * 
	 * @param resultado parametro con el id del medidor y el id de la trazabilidad
	 * @param eventoC codigo del evento
	 * @param fechas fecha
	 * @param eventGroup grupo del evento
	 * @param observacion D1, D2 etc.
	 * @param evento objeto eventoMedidor
	 * @param j referencia a cada archivo
	 * @return si retorna 1, se crea el evento con exito, si retorna 4 es porque el medidor no se encuentra
	 * en la base de datos.
	 */
	public int crearEventoMedidorG3Prueba(List<String> resultado,List<String> idRegister,List<String> fechas,List<String> valorRegister) {
		int value=0;
		//if(resultado.size() == 2) {
			value = template.update("INSERT INTO Inpetel_Cloud.EventoMedidor ( Medidor_ID, Fecha, Trazabilidad_ID, Usu_create, InfoEventos_ID, CodigoEvento)\r\n "
					+ "VALUES ('" +  resultado.get(0) + "', '" + fechas.get(0) + "', '" + resultado.get(1) + "','" + 60 + "', '" + idRegister.get(0)+ "', '" + valorRegister.get(0) + "');");
//			}
//		else {
//			System.out.println("no agrega");
//			value = 4;
		//}
		return value;
	}

	@Override
	public int crearEventoMedidor(objetoJsonEventoMedidor evento) {
		int value = crearEventoM(null, null, null,  null, "", evento, 0);
		return value;
	}
	
	/**
	 * 
	 * @param resultado parametro con el id del medidor y el id de la trazabilidad
	 * @param eventoC codigo del evento
	 * @param fechas fecha
	 * @param eventGroup grupo del evento
	 * @param observacion D1, D2 etc.
	 * @param evento objeto eventoMedidor
	 * @param j referencia a cada archivo
	 * @return si retorna 1, se crea el evento con exito, si retorna 4 es porque el medidor no se encuentra
	 * en la base de datos.
	 */
	public int crearEventoM(List<String> resultado,List<String> eventoC,List<String> fechas,List<String> eventGroup, String observacion, objetoJsonEventoMedidor evento, int j) {
		int value=0;
		//if(resultado.size() == 2) {
			value = template.update("INSERT INTO Inpetel_Cloud.EventoMedidor ( Medidor_ID, Fecha, Trazabilidad_ID, Usu_create, InfoEventos_ID, CodigoEvento, Observaciones)\r\n "
					+ "VALUES ('" +  resultado.get(0) + "', '" + fechas.get(0) + "', '" + resultado.get(1) + "', '" + 56 + "', '" + eventGroup.get(0) + "',  '" + eventoC.get(0) + "', '" + observacion + "');");
//			}
//		else {
//			value = 4;
//		}
	
		return value;
	}
	
	/**
	 * 
	 * @param resultado parametro con el id del medidor y el id de la trazabilidad
	 * @param eventoC codigo del evento
	 * @param fechas fecha
	 * @param eventGroup grupo del evento
	 * @param observacion D1, D2 etc.
	 * @param evento objeto eventoMedidor
	 * @param j referencia a cada archivo
	 * @return si retorna 1, se crea el evento con exito, si retorna 4 es porque el medidor no se encuentra
	 * en la base de datos.
	 */
	public int crearEventoMedidorSinObservacion(List<String> resultado,List<String> eventoC,List<String> fechas,List<String> eventGroup, String observacion, objetoJsonEventoMedidor evento, int j) {
		int value=0;
		//if(resultado.size() == 3) {
			value = template.update("INSERT INTO Inpetel_Cloud.EventoMedidor ( Medidor_ID, Fecha, Trazabilidad_ID, Usu_create, InfoEventos_ID, CodigoEvento, Observaciones)\r\n "
					+ "VALUES ('" +  resultado.get(0) + "', '" + fechas.get(0) + "', '" + resultado.get(1) + "', '" + 56 + "', '" + eventGroup.get(0) + "',  '" + eventoC.get(0) + "', '" + "-" + "');");
			//}
		//else {
		//	value = 4;
		//}

		return value;
	}
	
	 /** 
	 * @param resultado parametro con el id del concentrador y el id de la trazabilidad
	 * @param eventoC codigo del evento
	 * @param fechas fecha
	 * @param eventGroup grupo del evento
	 * @param observacion D1, D2 etc.
	 * @param evento objeto eventoMedidor
	 * @param j referencia a cada archivo
	 * @return si retorna 1, se crea el evento con exito, si retorna 4 es porque el medidor no se encuentra
	 * en la base de datos.
	 */
	public int crearEventoC(List<String> resultado,List<String> eventoC,List<String> fechas,List<String> eventGroup, String observacion, objetoJsonEventoConcentrador evento, int j) {
		int value=0;
		//if(resultado.size() == 3) {
			value = template.update("INSERT INTO Inpetel_Cloud.EventoConcentrador ( Concentrador_ID, Fecha, Trazabilidad_ID, Usu_create, InfoEventos_ID, CodigoEvento, Observaciones)\r\n "
					+ "VALUES ('" +  resultado.get(0) + "', '" + fechas.get(0) + "', '" + resultado.get(1) + "', '" + 56 + "', '" + eventGroup.get(0) + "',  '" + eventoC.get(0) + "', '" + observacion + "');");
			//}
		//else {
			//value = 4;
		//}
	
		return value;
	}

	
	 /** 
	 * @param resultado parametro con el id del concentrador y el id de la trazabilidad
	 * @param eventoC codigo del evento
	 * @param fechas fecha
	 * @param eventGroup grupo del evento
	 * @param observacion D1, D2 etc.
	 * @param evento objeto eventoMedidor
	 * @param j referencia a cada archivo
	 * @return si retorna 1, se crea el evento con exito, si retorna 4 es porque el medidor no se encuentra
	 * en la base de datos.
	 */
	public int crearEventoConcentradorSinObservacion(List<String> resultado,List<String> eventoC,List<String> fechas,List<String> eventGroup, String observacion, objetoJsonEventoConcentrador evento, int j) {
		int value=0;
		//if(resultado.size() == 2) {
			value = template.update("INSERT INTO Inpetel_Cloud.EventoConcentrador ( Concentrador_ID, Fecha, Trazabilidad_ID, Usu_create, InfoEventos_ID, CodigoEvento, Observaciones)\r\n "
					+ "VALUES ('" +  resultado.get(0) + "', '" + fechas.get(0) + "', '" + resultado.get(1) + "', '" + 56 + "', '" + eventGroup.get(0) + "',  '" + eventoC.get(0) + "', '" + "-" + "');");
			//}
//		else {
//			value = 4;
//		}
	
		return value;
	}


	@Override
	public int crearAsociacionMetCnc(AsociacionConcentradorMedidor asociacion) {
		int value=0;
		ArrayList<String> idConcentrador= idConcentrador(asociacion.getSerialConcentrador());
		ArrayList<String> idMedidor= idMedidor(asociacion.getSerialMedidor());
		
		value = template.update("INSERT INTO Inpetel_Cloud.Asoc_concen_medidor (Concentrador_ID, Medidor_ID, Fh_create, Usu_crea) VALUES\r\n"
					+ "('" + idConcentrador.get(0) + "', '" + idMedidor.get(0) + "', now(), '" + 56 + "');");
		
		return value;
	}
	
	public boolean validarAsociacionMetConCualquierCnc(String idMedidor) {
		boolean existe = false;
		List<Map<String,Object>>asociacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Asoc_concen_medidor where Medidor_ID='"+ idMedidor +"' ;");
		
		if(asociacion.size() == 1) {
			existe = true;
		}
		return existe;
	}
	
	/**
	 * Description: Validar que el registro con el medidor y el trafo que llegan no se encuentre en la bd
	 * @param idMedidor
	 * @param idTrafo
	 * @return
	 */
	public boolean validarRegistroBalance(String idMedidor, String idTrafo ) {
		boolean existe = false;
		//valida que ya exista el registro de ese medidor con ese trafo
		List<Map<String,Object>>asociacion = template.queryForList("SELECT * FROM Inpetel_Cloud.Macro where Medidor_ID='"+ idMedidor +"' and Transformador_ID='"+ idTrafo +"' ;");
		if(asociacion.size() >= 1) {
			existe = true;
		}
		return existe;
	}
	

	
	
}