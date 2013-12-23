package com.yangfan.xiang.core.batch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

import com.yangfan.xiang.core.infrastructure.Infrastructure;

public class LogJobListener extends Infrastructure implements JobExecutionListener {
	
	public void beforeJob(JobExecution jobExecution) {
		logger.debug("批处理Job监听器LogJobListener.beforeJob被调用，参数为：jobExecution[ {} ]", jobExecution);
	}

	public void afterJob(JobExecution jobExecution) {
		logger.debug("批处理Job监听器LogJobListener.afterJob被调用，参数为：jobExecution[ {} ]", jobExecution);
	}

}
