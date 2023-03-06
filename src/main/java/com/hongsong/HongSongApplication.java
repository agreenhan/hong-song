package com.hongsong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
@MapperScan("com.hongsong.dao")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class HongSongApplication {

	public static void main(String[] args) {
		SpringApplication.run(HongSongApplication.class, args);
	}

}

