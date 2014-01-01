package com.yangfan.xiang.service.impl.demo.work;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.work.Author;
import com.yangfan.xiang.persist.repository.demo.work.AuthorRepository;
import com.yangfan.xiang.service.iface.demo.work.AuthorService;

@Service
public class AuthorServiceImpl extends CoreServiceSupport<Author, String> implements AuthorService {
	
	@Resource
	private AuthorRepository authorRepository;

	@Override
	protected CoreRepository<Author, String> getRepository() {
		return authorRepository;
	}

}
