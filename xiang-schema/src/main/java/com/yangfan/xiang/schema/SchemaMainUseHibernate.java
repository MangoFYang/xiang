package com.yangfan.xiang.schema;

import java.util.Properties;

import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.MultipleLinesSqlCommandExtractor;
import org.hibernate.tool.hbm2ddl.SchemaExport;


/**
 * 使用Hibernate初始化数据库。
 * 
 * @author 杨帆
 *
 */
public class SchemaMainUseHibernate {
	
	public static void main(String[] args) {
		Properties extraProperties = new Properties();
		extraProperties.setProperty(AvailableSettings.HBM2DDL_IMPORT_FILES, 
				"com/yangfan/xiang/schema/batch/schema-drop-oracle10g.sql");
		
		Configuration configure = new Configuration().configure();
		configure.addProperties(extraProperties);
		SchemaExport export = new SchemaExport(configure);
		export.setImportSqlCommandExtractor(new MultipleLinesSqlCommandExtractor());
		export.create(true, false);
	}

}
