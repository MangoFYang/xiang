package com.yangfan.xiang.core.task.scheduler;

import org.springframework.scheduling.annotation.Scheduled;

// @Component
public class TaskSchedulerDemo {
	
	@Scheduled(fixedDelay=5000) // 最后一次调用和下次调用间隔5秒
	public void doSomething1() {
		System.out.println("TaskSchedulerDemo.doSomething1被调用，暂停5秒。");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("TaskSchedulerDemo.doSomething1被调用，注解配置：@Scheduled(fixedDelay=5000)，最后一次调用和下次调用间隔5秒。");
	}
	
	@Scheduled(fixedRate=5000) // 每隔5秒调用一次
	public void doSomething2() {
		System.out.println("TaskSchedulerDemo.doSomething2被调用，暂停5秒。");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
		}
		System.out.println("TaskSchedulerDemo.doSomething2被调用，注解配置：@Scheduled(fixedRate=5000)，每隔5秒调用一次。");
	}

}
