package com.herring.faubook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class FaubookApplication {

	public static void main(String[] args) {
		SpringApplication.run(FaubookApplication.class, args);
	}

}
