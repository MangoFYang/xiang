package com.yangfan.xiang.persist.repository.demo.authority;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.yangfan.xiang.core.persist.repository.CoreRepository;
import com.yangfan.xiang.domain.demo.authority.Menu;

public interface MenuRepository extends CoreRepository<Menu, String> {
	
	@Query("select m from Menu m where m.parent is null")
	List<Menu> findRootNode();
	
}
