package com.yangfan.xiang.service.impl.demo.work;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.work.Person;
import com.yangfan.xiang.persist.repository.demo.work.PersonRepository;
import com.yangfan.xiang.service.iface.demo.work.PersonService;

@Service
public class PersonServiceImpl extends CoreServiceSupport<Person, String> implements PersonService {
	
	private PersonRepository personRepository;

	@Override
	protected CoreRepository<Person, String> getRepository() {
		return personRepository;
	}

}
