package com.ninos.apigatewaymicroservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableFeignClients
@SpringBootApplication
public class ApiGatewayMicroservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayMicroservice3Application.class, args);
	}

}
