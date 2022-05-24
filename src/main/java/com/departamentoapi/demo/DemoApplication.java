package com.departamentoapi.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication(scanBasePackages={"com.departamentoapi.demo.Repository","com.departamentoapi.demo.controller","com.departamentoapi.demo.services","com.departamentoapi.demo.domain"})

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
