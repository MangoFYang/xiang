package com.yangfan.xiang.service.impl.demo.order;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.core.service.support.CoreServiceSupport;
import com.yangfan.xiang.model.po.demo.order.Customer;
import com.yangfan.xiang.persist.repository.demo.order.CustomerRepository;
import com.yangfan.xiang.service.iface.demo.order.CustomerService;

@Service
public class CustomerServiceImpl extends CoreServiceSupport<Customer, String> implements CustomerService {
	
	@Resource
	private CustomerRepository customerRepository;

	@Override
	protected CoreRepository<Customer, String> getRepository() {
		return customerRepository;
	}

}
