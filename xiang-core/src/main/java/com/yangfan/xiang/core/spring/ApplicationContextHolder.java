package com.yangfan.xiang.core.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * 
 * 获取ApplicationContext以及Spring管理的Bean, 神器啊!
 * 
 * @author 杨帆
 *
 */
@SuppressWarnings("unchecked")
public final class ApplicationContextHolder implements ApplicationContextAware, InitializingBean, DisposableBean {
	
	private static final Logger logger = LoggerFactory.getLogger(ApplicationContextHolder.class);
	
	private static ApplicationContext applicationContext;

	private static void checkApplicationContext() {
		if (applicationContext == null) {
			throw new IllegalStateException(
					"applicaitonContext未注入,请在Spring配置文件中定义ApplicationContextHolder");
		}
	}

	/**
	 * 取得存储在静态变量中的ApplicationContext.
	 */
	public static ApplicationContext getApplicationContext() {
		checkApplicationContext();
		return applicationContext;
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean, 自动转型为所赋值对象的类型.
	 */
	public static <T> T getBean(Class<T> clazz) {
		checkApplicationContext();
		return applicationContext.getBean(clazz);
	}

	/**
	 * 从静态变量ApplicationContext中取得Bean.
	 */
	public static <T> T getBean(String name) {
		checkApplicationContext();
		return (T) applicationContext.getBean(name);
	}

	/**
	 * 实现ApplicationContextAware接口的context注入函数, 将其存入静态变量.
	 */
	public void setApplicationContext(ApplicationContext applicationContext) {
		ApplicationContextHolder.applicationContext = applicationContext; // NOSONAR
	}

	@Override
	public void destroy() throws Exception {
		applicationContext = null;
		logger.info("清除 ApplicationContextHolder 中持有的Spring容器.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("小提示: 任何类中都可以使用 ApplicationContextHolder.getBean() 获取Spring管理的Bean, 神器啊!");
	}

}
