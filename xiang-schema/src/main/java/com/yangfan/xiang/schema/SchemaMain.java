package com.yangfan.xiang.schema;

import java.util.Date;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * 使用Spring初始化数据库。
 * 
 * @author 杨帆
 *
 */
public class SchemaMain {
	
	public static void main(String[] args) {
		// 初始化容器，创建数据库表。
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-schema.xml");
		
		/*
		// 初始化数据。
		JobOperator jobOperator = context.getBean(JobOperator.class);
		Set<String> jobNames = jobOperator.getJobNames();
		for (String jobName : jobNames) {
			try {
				jobOperator.start(jobName, "");
			} catch (NoSuchJobException e) {
				e.printStackTrace();
			} catch (JobInstanceAlreadyExistsException e) {
				e.printStackTrace();
			} catch (JobParametersInvalidException e) {
				e.printStackTrace();
			}
		}
		*/
		
		long startupDate = context.getStartupDate();
		System.out.println(new Date(startupDate));
		context.close();
	}

}
