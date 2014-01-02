package com.yangfan.xiang.schema.demo.emp;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.yangfan.xiang.model.po.demo.emp.Dept;

/**
 * 初始化Dept数据时，从文本文件中读取的数据转换成Java对象时使用的映射。
 * 
 * @author 杨帆
 *
 */
public class DeptMapper implements FieldSetMapper<Dept> {

	@Override
	public Dept mapFieldSet(FieldSet fieldSet) throws BindException {
		Dept d = new Dept();
		d.setDeptNo(Integer.parseInt(fieldSet.readRawString(0).trim()));
		d.setDeptName(fieldSet.readRawString(1).trim());
		d.setLoc(fieldSet.readRawString(2).trim());
		return d;
	}

}
