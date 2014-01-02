package com.yangfan.xiang.schema.demo.emp;

import java.util.Set;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobInstanceAlreadyExistsException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;

import com.yangfan.xiang.schema.BaseSchemaTest;

public class JobOperatorTest extends BaseSchemaTest {
	
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
