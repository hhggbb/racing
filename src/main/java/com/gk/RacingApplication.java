package com.gk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.gk.mapper")
@ComponentScan(basePackages = {"com.gk.**"})
public class RacingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RacingApplication.class, args);
	}
}
