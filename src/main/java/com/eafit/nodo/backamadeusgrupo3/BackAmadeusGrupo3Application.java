package com.eafit.nodo.backamadeusgrupo3;

import com.eafit.nodo.backamadeusgrupo3.configs.DataBaseConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class BackAmadeusGrupo3Application {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		DataBaseConfig.loadDatabaseProperties();
		SpringApplication.run(BackAmadeusGrupo3Application.class, args);
	}
}