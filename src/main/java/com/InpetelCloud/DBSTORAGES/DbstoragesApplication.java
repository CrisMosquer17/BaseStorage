package com.InpetelCloud.DBSTORAGES;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.InpetelCloud")
public class DbstoragesApplication {

	public static void main(String[] args) {
		SpringApplication.run(DbstoragesApplication.class, args);
	}

}
