package com.yangfan.xiang.schema;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-schema.xml")
public class JobOperatorTest {
	
	@Resource
	private JobOperator jobOperator;
	
	@Test
	public void testJobNames() {
		Set<String> jobNames = jobOperator.getJobNames();
		for (String jobName : jobNames) {
			System.out.println(jobName);
		}
	}
	
	@Test
	public void testStart() {
		try {
			jobOperator.start("DeptJob", "");
		} catch (NoSuchJobException e) {
			e.printStackTrace();
		} catch (JobInstanceAlreadyExistsException e) {
			e.printStackTrace();
		} catch (JobParametersInvalidException e) {
			e.printStackTrace();
		}
	}

}
