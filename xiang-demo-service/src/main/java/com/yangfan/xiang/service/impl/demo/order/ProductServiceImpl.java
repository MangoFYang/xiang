package com.yangfan.xiang.service.impl.demo.order;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.order.Product;
import com.yangfan.xiang.persist.repository.demo.order.ProductRepository;
import com.yangfan.xiang.service.iface.demo.order.ProductService;

@Service
public class ProductServiceImpl extends CoreServiceSupport<Product, String> implements ProductService {

	@Resource
	private ProductRepository productRepository;
	
	@Override
	protected CoreRepository<Product, String> getRepository() {
		return productRepository;
	}

}
