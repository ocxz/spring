package com.cxz.springboot;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

	// 日志记录器
	Logger logger = LoggerFactory.getLogger(getClass());
	
	@Test
	void contextLoads() {
		
		// 日志的级别，由低到高
		// 可以调整输出的日志级别，级别高点，就不会输出低级别日志
		logger.trace("这是跟踪日志……");
		logger.debug("这是调试日志……");
		logger.info("这是信息日志……");
		logger.warn("这是警告日志……");
		logger.error("这是错误日志……");
	}

}
