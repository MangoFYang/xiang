package com.yangfan.xiang.service.iface.demo.work;

import com.yangfan.xiang.core.service.CoreService;
import com.yangfan.xiang.model.po.demo.work.Work;

public interface WorkService extends CoreService<Work, String> {
	
	/**
	 * 保存一本书
	 * 
	 * @param authorId 作者
	 * @param work 作品
	 */
	public void saveWork(String authorId, Work work);

}
