package com.yangfan.xiang.test.databinder;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.ObjectError;

public class DataBinderTest {
	
	@Test
	public void testDataBinder() {
		
		MutablePropertyValues pvs = new MutablePropertyValues();
		pvs.add("stringField", "stringField111");
		pvs.add("dateField", new Date());
		pvs.add("bar.sss", "sss111");
		
		Foo foo = new Foo();
		DataBinder binder = new DataBinder(foo, "aaa");
		
		binder.setRequiredFields("dateField");
		
		binder.bind(pvs);
		
		BindingResult bindingResult = binder.getBindingResult();
		
		List<ObjectError> allErrors = bindingResult.getAllErrors();
		System.out.println(allErrors);
		
	}

}
