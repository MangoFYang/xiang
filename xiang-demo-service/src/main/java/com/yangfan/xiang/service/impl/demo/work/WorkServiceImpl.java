package com.yangfan.xiang.service.impl.demo.work;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.work.Author;
import com.yangfan.xiang.model.po.demo.work.Work;
import com.yangfan.xiang.persist.repository.demo.work.WorkRepository;
import com.yangfan.xiang.service.iface.demo.work.AuthorService;
import com.yangfan.xiang.service.iface.demo.work.WorkService;

@Service
public class WorkServiceImpl extends CoreServiceSupport<Work, String> implements WorkService {
	
	@Resource
	private WorkRepository workRepository;
	
	@Resource
	private AuthorService authorService;

	@Override
	protected CoreRepository<Work, String> getRepository() {
		return workRepository;
	}
	
	public void saveWork(String authorId, Work work) {
		Author author = authorService.findOne(authorId);
		Assert.notNull(author, "作者不存在，authorId: " + authorId);
		work.getAuthors().add(author);
		this.saveAndFlush(work);
	}

}
