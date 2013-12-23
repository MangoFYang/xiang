package com.yangfan.xiang.service.impl.demo.job;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class JobExplorerTest {
	
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
		List<JobExecution> jobExecutions = jobExplorer.getJobExecutions(jobExplorer.getJobInstance(17L));
		for (JobExecution jobExecution : jobExecutions) {
			System.out.println(jobExecution);
		}
	}
	
}
