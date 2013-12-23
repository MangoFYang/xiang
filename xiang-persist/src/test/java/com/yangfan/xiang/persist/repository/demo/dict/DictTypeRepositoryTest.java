package com.yangfan.xiang.persist.repository.demo.dict;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yangfan.xiang.domain.demo.dict.DictType;
import com.yangfan.xiang.persist.repository.demo.dict.DictTypeRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationContext-persist.xml")
public class DictTypeRepositoryTest {
	
	@Resource
	private DictTypeRepository dictTypeRepository;

	@Test
	public void testFindAll() {
		List<DictType> findAll = dictTypeRepository.findAllJoinFetchDict();
		for (DictType dictType : findAll) {
			System.out.println(dictType);
			System.out.println(dictType.getDicts());
		}
	}

}
