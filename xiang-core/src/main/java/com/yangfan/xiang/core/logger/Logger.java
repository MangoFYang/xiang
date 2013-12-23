package com.yangfan.xiang.core.logger;

/**
 * 
 * 对slf4j Logger的封装，支持3种日志输出级别，debug、info、error
 * @author 杨帆
 *
 */
public class Logger {
	
	private org.slf4j.Logger logger;
	
	public Logger(Class<?> clazz) {
		logger = org.slf4j.LoggerFactory.getLogger(clazz);
	}
	
	public void debug(String msg) {
		logger.debug(msg);
	}
	
	public void debug(String msg, Object... params) {
		logger.debug(msg, params);
	}
	
	public void debug(String msg , Throwable throwable) {
		logger.debug(msg);
		logger.debug("异常堆栈信息", throwable);
	}
	
	public void debug(String msg , Throwable throwable, Object... params) {
		logger.debug(msg, params);
		logger.debug("异常堆栈信息", throwable);
	}
	
	public void error(String msg) {
		logger.error(msg);
	}
	
	public void error(String msg, Object... params) {
		logger.error(msg, params);
	}
	
	public void error(String msg, Throwable throwable) {
		logger.error(msg);
		logger.error("异常堆栈信息", throwable);
	}
	
	public void error(String msg, Throwable throwable, Object... params) {
		logger.error(msg, params);
		logger.error("异常堆栈信息", throwable);
	}
	
	public void info(String msg) {
		logger.info(msg);
	}
	
	public void info(String msg, Object... params) {
		logger.info(msg, params);
	}
	
	public void info(String msg, Throwable throwable) {
		logger.info(msg);
		logger.info("异常堆栈信息", throwable);
	}
	
	public void info(String msg, Throwable throwable, Object... params) {
		logger.info(msg, params);
		logger.info("异常堆栈信息", throwable);
	}
	
}
