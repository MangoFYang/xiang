package com.yangfan.xiang.core.jdbc.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;

import com.yangfan.xiang.test.CoreTest;

public class DatabaseMetaDataTest extends CoreTest {
	
	@Resource
	private DataSource dataSource;
	
	@Test
	public void testDatabaseMetaData() {
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			
			DatabaseMetaData metaData = connection.getMetaData();
			
			ResultSet catalogs = metaData.getCatalogs();
			while(catalogs.next()) {
				String catalog = catalogs.getString(1);
				System.out.println("TABLE_CAT: " + catalog);
			}
			
			ResultSet tableTypes = metaData.getTableTypes();
			while(tableTypes.next()) {
				String tableType = tableTypes.getString(1);
				System.out.println("TABLE_TYPE: " + tableType);
			}
			
			ResultSet schemas = metaData.getSchemas();
			while(schemas.next()) {
				String tableSchema = schemas.getString(1);
				String tableCatalog = schemas.getString(2);
				System.out.print("TABLE_SCHEMA: " + tableSchema);
				System.out.print(", ");
				System.out.print("TABLE_CATALOG: " + tableCatalog);
				System.out.println();
			}
			
			ResultSet tables = metaData.getTables(null, "XIANG", "DEMO%", null);
			int columnCount = tables.getMetaData().getColumnCount();
			while(tables.next()) {
				for (int i = 0; i < columnCount; i++) {
					String tableType = tables.getString(i + 1);
					System.out.print(tableType + ", ");
				}
				System.out.println();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
