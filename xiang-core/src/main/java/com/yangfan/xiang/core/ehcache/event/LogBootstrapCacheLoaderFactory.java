package com.yangfan.xiang.core.ehcache.event;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.ehcache.bootstrap.BootstrapCacheLoaderFactory;

public class LogBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactory<LogBootstrapCacheLoader> {

	private final Logger log = LoggerFactory.getLogger(LogBootstrapCacheLoaderFactory.class);
	
	@Override
	public LogBootstrapCacheLoader createBootstrapCacheLoader(Properties properties) {
		log.debug("创建LogBootstrapCacheLoader使用配置: {}", properties);
		return new LogBootstrapCacheLoader();
	}

}
