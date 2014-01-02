package com.yangfan.xiang.service.impl.demo.job;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.explore.JobExplorer;

import com.yangfan.xiang.service.BaseServiceTest;

public class JobExplorerTest extends BaseServiceTest {
	
	@Resource
	private JobExplorer jobExplorer;
	
	@Test
	public void testGetJobNames() {
		List<String> jobNames = jobExplorer.getJobNames();
		for (String jobName : jobNames) {
			System.out.println(jobName);
		}
	}
	
	@Test
	public void testGetJobInstances() {
		List<JobInstance> jobInstances = jobExplorer.getJobInstances("DeptJob", 0, 2);
		for (JobInstance jobInstance : jobInstances) {
			System.out.println(jobInstance);
		}
	}
	
	@Test
	public void testFindRunningJobExecutions() {
		Set<JobExecution> findRunningJobExecutions = jobExplorer.findRunningJobExecutions("EmpJob");
		for (JobExecution jobExecution : findRunningJobExecutions) {
			System.out.println(jobExecution);
		}
	}
	
	@Test
	public void testGetJobExecutions() {
		JobInstance jobInstance = jobExplorer.getJobInstance(17L);
		if(jobInstance != null) {
			List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobInstance);
			for (JobExecution jobExecution : jobExecutions) {
				System.out.println(jobExecution);
			}
		}
	}
	
}
