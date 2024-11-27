package com.gmalheiro.tasks.taskify_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.gmalheiro.tasks.taskify_api.repository")
public class TaskifyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskifyApiApplication.class, args);
	}

}
