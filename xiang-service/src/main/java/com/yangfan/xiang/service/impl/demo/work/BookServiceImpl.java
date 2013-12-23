package com.yangfan.xiang.service.impl.demo.work;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.domain.demo.work.Book;
import com.yangfan.xiang.persist.repository.demo.work.BookRepository;
import com.yangfan.xiang.service.iface.demo.work.BookService;

@Service
public class BookServiceImpl extends CoreServiceSupport<Book, String> implements BookService {
	
	@Resource
	private BookRepository bookRepository;
	
	@Override
	protected CoreRepository<Book, String> getRepository() {
		return bookRepository;
	}
	
}
