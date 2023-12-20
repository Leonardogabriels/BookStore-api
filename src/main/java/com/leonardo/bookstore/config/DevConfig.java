package com.leonardo.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leonardo.bookstore.service.DBservice;

@Configuration
@Profile("dev")
public class DevConfig {
	
	@Autowired
	private DBservice dbService;
	
	@Value("${spring.jpa.hibernate.ddl-auto}")//para subir a base de dados smp que dar deploy 
	private String strategy;

	
	public boolean instanciaBase() {
		if(this.strategy.equals("create")){
			this.dbService.instanciaBaseDeDados();
		}
		return false;
	}
}
