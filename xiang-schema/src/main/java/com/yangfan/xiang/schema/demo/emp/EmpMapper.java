package com.yangfan.xiang.schema.demo.emp;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;

import com.yangfan.xiang.model.po.demo.emp.Dept;
import com.yangfan.xiang.model.po.demo.emp.Emp;
import com.yangfan.xiang.schema.SchemaException;

/**
 * 初始化Emp数据时，从文本文件中读取的数据转换成Java对象时使用的映射。
 * 
 * @author 杨帆
 *
 */
public class EmpMapper implements FieldSetMapper<Emp> {

	@Override
	public Emp mapFieldSet(FieldSet fieldSet) throws BindException {
		try {
			Emp e = new Emp();
			e.setEmpNo(fieldSet.readInt(0));
			e.seteName(fieldSet.readRawString(1));
			e.setJob(fieldSet.readRawString(2));
			
			String mgrStr = fieldSet.readRawString(3);
			if(!StringUtils.isEmpty(mgrStr)) {
				Emp mgr = new Emp();
				mgr.setEmpNo(Integer.parseInt(mgrStr));
				e.setMgr(mgr);
			}
			
			e.setHireDate(fieldSet.readDate(4, "yyyy-MM-dd"));
			e.setSal(fieldSet.readDouble(5));
			
			String commStr = fieldSet.readRawString(6);
			if(!StringUtils.isEmpty(commStr)) {
				e.setComm(Double.valueOf(commStr));
			}
			
			Dept d = new Dept();
			d.setDeptNo(fieldSet.readInt(7));
			e.setDept(d);
			
			return e;
		} catch(Exception e) {
			throw new SchemaException(e);
		}

	}

}
