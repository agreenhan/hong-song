package com.hongsong;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hongsong.pojo.po.Log;
import com.hongsong.service.LogService;
import com.hongsong.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;


@SpringBootTest(classes = {HongSongApplication.class})
class HongSongApplicationTests {
	@Autowired
	private LogService logService;

	@Test
	void contextLoads() {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		// 加密
		String encode = passwordEncoder.encode("123456");
		// 解密
		System.out.println(passwordEncoder.matches("12345", encode));
		System.out.println(passwordEncoder.matches("123456", encode));
	}

	@Test
	void testJwt() throws Exception {
		String jwt = JwtUtil.createJWT("17634409136");
		Claims claims = JwtUtil.parseJWT(jwt);
		String subject = claims.getSubject();
		System.out.println(subject);
	}

	@Test
	void testInsert() {
		logService.save(new Log());
	}
}
