package com.yangfan.xiang.core.logger;

/**
 * Logger工厂类
 * @author 杨帆
 *
 */
public class LoggerFactory {
	
	public static Logger getLogger(Class<?> clazz) {
		return new Logger(clazz);
	}

}
