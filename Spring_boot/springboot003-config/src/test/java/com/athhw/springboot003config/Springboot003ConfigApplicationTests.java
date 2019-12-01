package com.athhw.springboot003config;

import com.athhw.springboot003config.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
/*
	Spring boot 单元测试:
	可以在测试期间很方便的类似编码一样自动注入等容器的功能
 */

@SpringBootTest
class Springboot003ConfigApplicationTests {

	@Autowired
	Person person;

	@Test
	void contextLoads() {
		System.out.println(person);
	}

}
