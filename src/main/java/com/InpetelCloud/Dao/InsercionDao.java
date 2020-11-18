package com.InpetelCloud.Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.InpetelCloud.Interfaces.InsercionInterface;
import com.InpetelCloud.Model.Concentrador;
import com.InpetelCloud.Model.Medidor;
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

	@Override
	public int createSchema(String nameSchema) {

	 String SQL = "CREATE SCHEMA `"+nameSchema+"`" ;
	int x = 0;
	try{
	x = template.update(SQL);
	}catch(Exception ex){
	System.out.println(ex);
	}
	return x;
	}

	@Override
	public void schemaCreate(String name) {
	  
		try {
			template.execute("CREATE SCHEMA IF NOT EXISTS `"+ name +"`");
			template.execute("CREATE TABLE `"+ name +"`.`Estados` (\r\n"
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
					+ "AUTO_INCREMENT = 6");
		}catch(Exception ex) {
			System.out.println(ex);
		}
		
	}
	

}
