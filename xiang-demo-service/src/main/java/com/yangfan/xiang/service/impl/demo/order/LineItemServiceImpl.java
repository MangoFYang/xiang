package com.yangfan.xiang.service.impl.demo.order;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.order.LineItem;
import com.yangfan.xiang.persist.repository.demo.order.LineItemRepository;
import com.yangfan.xiang.service.iface.demo.order.LineItemService;

@Service
public class LineItemServiceImpl extends CoreServiceSupport<LineItem, String> implements LineItemService {
	
	@Resource
	private LineItemRepository lineItemRepository;

	@Override
	protected CoreRepository<LineItem, String> getRepository() {
		return lineItemRepository;
	}

}
