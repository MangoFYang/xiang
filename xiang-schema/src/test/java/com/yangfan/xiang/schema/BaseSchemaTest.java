package com.yangfan.xiang.schema;

import javax.annotation.Resource;

import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-core.xml")
public class BaseSchemaTest {
	
	@Resource
	private ApplicationContext applicationContext;

}
