package com.xywei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
public class RabbitMqSpringBoot12306ServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RabbitMqSpringBoot12306ServerApplication.class, args);
	}

}
