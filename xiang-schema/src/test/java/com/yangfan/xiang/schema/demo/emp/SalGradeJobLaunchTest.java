package com.yangfan.xiang.schema.demo.emp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;

import com.yangfan.xiang.schema.BaseSchemaTest;

public class SalGradeJobLaunchTest extends BaseSchemaTest {
	
	@Resource
	private JobLauncher launcher;
	
	@Resource(name="SalGradeJob")
	private Job job;
	
	@Test
	public void testSalGradeJob() {
		try {
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("SalGradeJob", new JobParameter(new Date()));
			// 运行Job
			JobExecution result = launcher.run(job, new JobParameters(params));
			// 处理结束， 控制台打印处理结果
			System.out.println(result.toString());
			
			// 批处理为异步执行
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
