package com.leonardo.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.leonardo.bookstore.service.DBservice;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBservice dbService;

  
    public void instanciaBase() {
        this.dbService.instanciaBaseDeDados();
    }
}
