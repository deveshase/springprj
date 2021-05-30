package com.app.dkc.wclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.app.dkc.wclient"})
@SpringBootApplication
public class WebClientApplication {

	public static void main(String[] args) {

		SpringApplication.run(WebClientApplication.class, args);

	}

}
