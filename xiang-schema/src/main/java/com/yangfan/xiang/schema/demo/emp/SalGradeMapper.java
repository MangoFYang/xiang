package com.yangfan.xiang.schema.demo.emp;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.yangfan.xiang.domain.demo.emp.SalGrade;

/**
 * 初始化SalGrade数据时，从文本文件中读取的数据转换成Java对象时使用的映射。
 * 
 * @author 杨帆
 *
 */
public class SalGradeMapper implements FieldSetMapper<SalGrade> {

	@Override
	public SalGrade mapFieldSet(FieldSet fieldSet) throws BindException {
		SalGrade sg = new SalGrade();
		sg.setGrade(fieldSet.readInt(0));
		sg.setHisal(fieldSet.readDouble(2));
		sg.setLosal(fieldSet.readDouble(1));
		return sg;
	}

}
