package com.yangfan.xiang.core.spring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-core.xml")
public class ApplicationContextHolderTest {
	
	@Test
	public void testGetBeanString() {
		net.sf.ehcache.CacheManager cacheManager1 = ApplicationContextHolder.getBean("ehcache");
		System.out.println(cacheManager1);
		
		org.springframework.cache.CacheManager cacheManager2 = ApplicationContextHolder.getBean("cacheManager");
		System.out.println(cacheManager2);
	}

}
