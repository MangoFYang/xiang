package com.yangfan.xiang.core.task.execution;

import org.springframework.scheduling.annotation.Async;

// @Component
public class TaskExecutorDemo {

	@Async
	public void printMessages(String message) {
		System.out.println(message);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
	}
	
}