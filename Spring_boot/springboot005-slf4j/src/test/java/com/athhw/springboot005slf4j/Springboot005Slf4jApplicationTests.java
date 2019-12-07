package com.athhw.springboot005slf4j;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class Springboot005Slf4jApplicationTests {

	//日志记录器 必须是logger4j旗下的 注意选对
	Logger logger = LoggerFactory.getLogger(getClass());

	@Test
	void contextLoads() {

		//日志级别
		//由低到高 trace<debug.....
		//可以调整需要输出的日志级别 这个日志就只会在这个级别以后的高级别生效
		logger.trace("这是trace日志 跟踪轨迹");
		logger.debug("这是debug日志");
		//springboot默认给我们使用得到是info级别的日志 所以默认输出info级别及以后的内容
		//在配置文件调整基本
		logger.info("这是info日志");
		logger.warn("这是warn日志");
		logger.error("这是error日志");
	}

}
