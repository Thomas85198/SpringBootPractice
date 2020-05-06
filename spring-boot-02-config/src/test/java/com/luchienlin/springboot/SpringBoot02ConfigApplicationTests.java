package com.luchienlin.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.luchienlin.springboot.bean.Person;

/**
 * SpringBoot單元測試 可以在測試期間很方便的類似編碼依樣進行自動注入等容器功能
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot02ConfigApplicationTests {

	@Autowired
	Person person;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}

}
