package com.yangfan.xiang.core.task;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yangfan.xiang.core.task.execution.TaskExecutorDemo;

public class TaskDemo {
	
	public static void main(String[] args) {
		AbstractApplicationContext factory = new ClassPathXmlApplicationContext("classpath:com/yangfan/xiang/core/task/applicationContext-task.xml");
		System.out.println("执行任务异步执行和调度!");
		
		TaskExecutorDemo taskExecutorDemo = factory.getBean(TaskExecutorDemo.class);
		for ( int i = 0; i < 20; i ++ ) {
			taskExecutorDemo.printMessages("TaskExecutorDemo.printMessages()被调用。" + i);
		}
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
		}
		factory.destroy();
		factory.close();
	}


}
