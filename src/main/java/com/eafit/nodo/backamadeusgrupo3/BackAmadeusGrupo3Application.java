package com.eafit.nodo.backamadeusgrupo3;

import com.eafit.nodo.backamadeusgrupo3.configs.DataBaseConfig;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.util.Objects;

@SpringBootApplication
public class BackAmadeusGrupo3Application {

	@Autowired
	private DataSource dataSource;

	public static void main(String[] args) {
		DataBaseConfig.loadDatabaseProperties();
		Dotenv dotenv = Dotenv.load();
		System.setProperty("MAIL_USERNAME", Objects.requireNonNull(dotenv.get("MAIL_USERNAME")));
		System.setProperty("APP_PASSWORD", Objects.requireNonNull(dotenv.get("APP_PASSWORD")));
		SpringApplication.run(BackAmadeusGrupo3Application.class, args);
	}
}