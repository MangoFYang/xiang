package com.yangfan.xiang.core.mybatis.dialect;

public abstract class Dialect {
	
	public abstract String getLimitString(String sql, int offset, int limit);
	
}
