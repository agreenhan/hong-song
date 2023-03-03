package com.hongsong;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@SpringBootApplication
@EnableSwagger2WebMvc
@MapperScan(basePackages = {"com.hongsong.dao"})
public class HongSongApplication {

	public static void main(String[] args) {
		SpringApplication.run(HongSongApplication.class, args);
	}

}
