package com.yangfan.xiang.schema;

import java.util.UUID;

/**
 * 主键生成器，一般用于使用SQL初始化数据时主键的生成。
 * 
 * @author 杨帆
 *
 */
public class UUIDGenerator {
	
	public static UUID generate() {
		return UUID.randomUUID();
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			UUID uuid = UUIDGenerator.generate();
			System.out.println(uuid);
		}
	}

}
