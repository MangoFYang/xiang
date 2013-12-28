package com.yangfan.xiang.persist.repository.demo.dict;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.yangfan.xiang.domain.demo.dict.Dict;
import com.yangfan.xiang.domain.demo.dict.DictType;
import com.yangfan.xiang.vo.demo.LabelValue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-persist.xml")
public class DictRepositoryTest {
	
	@Resource
	private DictRepository dictRepository;
	
	@Resource
	private DictTypeRepository dictTypeRepository;

	@Test
	@Transactional
	public void testFindByDictType() {
		List<Dict> findByDictType = dictRepository.findByDictType_type("FourAccId");
		for (Dict dict : findByDictType) {
			System.out.println(dict);
		}
	}
	
	@Test
	@Transactional
	@Rollback(true)
	public void testSave() {
		DictType fourAccId = dictTypeRepository.findOne("FourAccId");
		Dict d = new Dict();
		d.setCode("test");
		d.setLabel("测试保存字典");
		d.setDictType(fourAccId);
		dictRepository.save(d);
	}
	
	@Test
	public void testFindAll() {
		List<Dict> findAll = dictRepository.findAll();
		for (Dict dict : findAll) {
			System.out.println(dict);
		}
	}
	
	@Test
	@Transactional
	public void testFindAllJoinDictType() {
		List<Dict> findAll = dictRepository.findAllJoinFetchDictType();
		for (Dict dict : findAll) {
			System.out.println(dict);
			System.out.println(dict.getDictType().getType());
		}
	}
	
	@Test
	public void testFindCodeAndLabel() {
		List<Object[]> test = dictRepository.findCodeAndLabel();
		for (Object[] os : test) {
			Dict d = new Dict();
			d.setCode((String)os[0]);
			d.setLabel((String)os[1]);
			System.out.println(d);
		}
	}
	
	@Test
	public void testFindCodeAndLabelNew() {
		List<LabelValue> findCodeAndLabelNew = dictRepository.findCodeAndLabelNew();
		for (LabelValue labelValue : findCodeAndLabelNew) {
			System.out.println(labelValue);
		}
	}

}
