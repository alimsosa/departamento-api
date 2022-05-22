package com.departamentoapi.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication{
//private JdbcTemplate jdbcTemplate;
	/*
	 * spring.datasource.url=jdbc:mysql://127.0.0.2:3306/departamentosdb
spring.datasource.username=root
spring.datasource.password=admin*/
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	

		
}
