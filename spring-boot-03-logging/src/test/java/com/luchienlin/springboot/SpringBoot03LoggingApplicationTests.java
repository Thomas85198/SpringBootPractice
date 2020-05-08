package com.luchienlin.springboot;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBoot03LoggingApplicationTests {

	// 紀錄器
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	public void contextLoads() {
		
		// 日誌的級別
		// 由低到高 trace<debug<info<warn<error
		// 可以調整輸出的日誌級別：日誌就只會在這個級別以後的高級別生效
		logger.trace("這是trace日誌");
		logger.debug("這是debug日誌");
		// springboot默認給我們的是info級別，沒有指定級別就用SpringBoot默認規定級別：root級別
		logger.info("這是info日誌");
		logger.warn("這是warn日誌");
		logger.error("這是error日誌");
	
	}

}
