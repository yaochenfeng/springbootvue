package com.chenfeng.app.springbootvue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App {


	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(App.class);
	}

	public static void main(String[] args){
		SpringApplication.run(App.class, args);
	}
}
