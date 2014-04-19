package com.yangfan.xiang.core.support;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;

/**
 * 
 * 为Bean的定义产生Bean的名称
 * 
 * @author 杨帆
 *
 */
public final class BeanNameGeneratorImpl implements BeanNameGenerator {

	/**
	 * 使用Bean的全限定名作为Bean的名称
	 */
	@Override
	public String generateBeanName(BeanDefinition definition,
			BeanDefinitionRegistry registry) {
		return definition.getBeanClassName();
	}

}
