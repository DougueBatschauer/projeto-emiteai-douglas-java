package com.project.emiteai.cadastro_pessoas;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableRabbit
@SpringBootApplication
public class CadastroPessoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroPessoasApplication.class, args);
	}
}
