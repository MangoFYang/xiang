package com.yangfan.xiang.core.spring;

import org.junit.Test;

import com.yangfan.xiang.test.CoreTest;

public class ApplicationContextHolderTest extends CoreTest {
	
	@Test
	public void testGetBeanString() {
		net.sf.ehcache.CacheManager cacheManager1 = ApplicationContextHolder.getBean("ehcache");
		System.out.println(cacheManager1);
		
		org.springframework.cache.CacheManager cacheManager2 = ApplicationContextHolder.getBean("cacheManager");
		System.out.println(cacheManager2);
	}

}
