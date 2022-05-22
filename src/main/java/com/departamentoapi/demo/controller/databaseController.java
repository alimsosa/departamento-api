package com.departamentoapi.demo.controller;


import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;
import org.springframework.stereotype.Repository;
import com.departamentoapi.demo.domain.*;

public class databaseController extends JpaRepositoryFactory{

	public databaseController(EntityManager entityManager) {
		super(entityManager);
		// TODO Auto-generated constructor stub
	}

}
