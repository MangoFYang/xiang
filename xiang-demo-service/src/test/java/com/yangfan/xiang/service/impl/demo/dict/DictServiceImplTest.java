package com.yangfan.xiang.service.impl.demo.dict;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.model.po.demo.dict.Dict;
import com.yangfan.xiang.service.iface.demo.dict.DictService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-service.xml")
public class DictServiceImplTest {
	
	@Resource
	private DictService dictService;

	@Test
	public void testFindOneString() {
		Dict findOne = dictService.findOne("ab45d4b3-0363-47d2-a845-d750f420a5dc");
		System.out.println(findOne);
		System.out.println(findOne.getDictType());
	}
	
	@Test
	public void testFindByDictType() {
		List<Dict> findByDictType = dictService.findByDictTypeFromCache("FourAccId");
		for (Dict dict : findByDictType) {
			System.out.println(dict);
			System.out.println(dict.getDictType());
		}
	}
	
	@Test
	public void testFindByDictTypeAndCode() {
		Dict dict = dictService.findByDictTypeAndCodeFromCache("FourAccId", "0001");
		System.out.println(dict);
		System.out.println(dict.getDictType());
	}
	
	@Test
	public void testFindByDictTypeFromCache() {
		List<Dict> dictList = dictService.findByDictTypeAndCodeFromCache("FourAccId", 
				new String[] {"0001", "0002", "0003"});
		for (Dict dict : dictList) {
			System.out.println(dict);
			System.out.println(dict.getDictType());
		}
	}

}
