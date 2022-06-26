package com.distribuidos.deptoapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;

@SpringBootApplication
public class DeptoapiApplication {

	public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException {

		SpringApplication.run(DeptoapiApplication.class, args);



	}

}
