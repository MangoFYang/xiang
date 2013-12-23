package com.yangfan.xiang.core.tools.twodbSyncrecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Oracle数据库之间的同步数据
 * 
 * 将一个数据库中表的数据同步到另一数据库的同名表中，表结构必须一样。
 * 
 * @author 杨帆
 *
 */
public class TwoDBSyncRecord {
	
	/**
	 * 数据库驱动类
	 */
	private static final String DRIVER_NAME = "oracle.jdbc.OracleDriver";
	
	/**
	 * 源数据库连接信息
	 */
	private static final String SOURCE_URL = "jdbc:oracle:thin:@localhost:1521:omega";
	private static final String SOURCE_USERNAME = "xiang";
	private static final String SOURCE_PASSWORLD = "xiang123";
	
	/**
	 * 目标数据库连接信息
	 */
	private static final String TARGET_URL = "jdbc:oracle:thin:@localhost:1521:omega";
	private static final String TARGET_USERNAME = "omega";
	private static final String TARGET_PASSWORLD = "omega123";
	
	/**
	 * 每次同步数据条数
	 */
	private static final int PAGE_SIZE = 10000;
	
	/**
	 * 配置文件名
	 * 
	 * 配置需要同步数据的表名，以#号开头为注释。
	 * 
	 */
	private static final String TABLE_NAMES = "tableNames";
	
	public static void main(String[] args) {
		execute();
	}
	
	/**
	 * 开始执行同步数据
	 */
	public static void execute() {
		System.out.println("(start)开始同步数据...");
		long start = System.currentTimeMillis();
		for (String tableName : readTableNames()) {
			try {
				copy(tableName);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		System.out.println("(end)同步完成，共耗时：" + (System.currentTimeMillis() - start) + "毫秒");
	}
	
	/**
	 * 拷贝数据
	 * 
	 * @param tableName 表名
	 */
	public static int copy(String tableName) {
		long start = System.currentTimeMillis();
		
		Connection sourceConnection = null;
		Connection targetConnection = null;
		
		System.out.println(">start正在同步表[" + tableName + "]的数据...");
		int tatalCount = -1;
		int pageNum = 0;
		int pageSize = PAGE_SIZE;
		int count = 0;
		
		Statement countStatement = null;
		ResultSet countRS = null;
		
		try {
			sourceConnection = getConnection(SOURCE_URL, SOURCE_USERNAME, SOURCE_PASSWORLD);
			targetConnection = getConnection(TARGET_URL, TARGET_USERNAME, TARGET_PASSWORLD);
			
			countStatement = sourceConnection.createStatement();
			countRS = countStatement.executeQuery("select count(1) from " + tableName);
			countRS.next();
			tatalCount = countRS.getInt(1);
			System.out.println("表["+tableName+"]共有"+tatalCount+"条记录");
			for (int i = 0; i < (tatalCount / pageSize + 1); i++) {
				int once = doCopy(sourceConnection, targetConnection, tableName, pageNum * pageSize, pageSize);
				pageNum ++;
				count = count + once;
			}
			System.out.println(">end同步表[" + tableName + "]数据完成，" + "共同步" + count +"条数据，耗时：" + (System.currentTimeMillis() - start) + "毫秒");
			return count;
		} catch(Exception e) {
			System.out.println(">end同步表[" + tableName + "]数据异常中断，" + "已同步" + count +"条数据，未同步"+(tatalCount - count)+"条数据，耗时：" + (System.currentTimeMillis() - start) + "毫秒");
			throw new RuntimeException(e);
		} finally {
			if(countRS != null) {
				try {
					countRS.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(countStatement != null) {
				try {
					countStatement.close();
				} catch (SQLException e) {
					throw new RuntimeException(e);
				}
			}
			if(sourceConnection != null) {
				try {
					sourceConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(targetConnection != null) {
				try {
					targetConnection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	/**
	 * 分页复制数据
	 * 
	 * @param sourceConnection
	 * @param targetConnection
	 * @param tableName
	 * @param offset
	 * @param limit
	 * @return
	 */
	public static int doCopy(Connection sourceConnection, Connection targetConnection, String tableName, int offset, int limit) {
		int count = 0;
		Statement statement = null;
		ResultSet rs = null;
		PreparedStatement pStatement = null;
		try {
			List<Integer> targetSqlTypeList = new ArrayList<Integer>();
			
			statement = sourceConnection.createStatement();
			rs = statement.executeQuery(getLimitString("select * from " + tableName, offset, limit));
			ResultSetMetaData metaData = rs.getMetaData();
			
			// 列数
			int columnCount = metaData.getColumnCount() - 1;
			for (int i = 1; i <= columnCount; i++) {
				int columnType = metaData.getColumnType(i);
				targetSqlTypeList.add(columnType);
			}
			
			// 拼 insert SQL语句
			StringBuilder sb = new StringBuilder();
			sb.append("insert into ").append(tableName).append(" values ( ");
			for (int i = 1; i <= columnCount; i++) {
				if(i == columnCount) {
					sb.append("? ");
				} else {
					sb.append("?, ");
				}
			}
			sb.append(")");

			targetConnection.setAutoCommit(false);
			pStatement = targetConnection.prepareStatement(sb.toString());
			while(rs.next()) {
				for (int i = 1; i <= columnCount; i++) {
					Object object = rs.getObject(i);
					Integer targetSqlType = targetSqlTypeList.get(i - 1);
					pStatement.setObject(i, object, targetSqlType);
				}
				pStatement.addBatch();
				count ++;
			}
			
			if(pStatement != null) {
				pStatement.executeBatch();
				targetConnection.commit();
				pStatement.close();
			}
			System.out.println("已同步" + count + "条数据");
			return count;
		} catch (Exception e) {
			try {
				if(targetConnection != null) {
					targetConnection.rollback();
				}
			} catch (SQLException e1) {
				throw new RuntimeException(e1);
			}
			throw new RuntimeException(e);
		} finally {
			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(statement != null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pStatement != null) {
				try {
					pStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 获取需要同步数据的表名
	 * @return
	 */
	public static List<String> readTableNames() {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(TwoDBSyncRecord.class.getResourceAsStream(TABLE_NAMES)));
		List<String> tableNameList = new ArrayList<String>();
		try {
			String tableName = null;
			while( (tableName = br.readLine()) != null ) {
				if(!"".equals(tableName.trim()) && !tableName.trim().startsWith("#")) {
					tableNameList.add(tableName);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if( br != null ) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return tableNameList;
	}
	
	/**
	 * Oracle分页
	 * 
	 * @param sql
	 * @param offset
	 * @param limit
	 * @return
	 */
	public static String getLimitString(String sql, int offset, int limit) {
		sql = sql.trim();
        StringBuffer pagingSelect = new StringBuffer(sql.length() + 100);    
        pagingSelect.append("select * from ( select row_.*, rownum rownum_ from ( ");    
        pagingSelect.append(sql);
        pagingSelect.append(" ) row_ where rownum <= ").append(offset + limit)
        	.append(") where rownum_ > ").append(offset);
        return pagingSelect.toString();
	}
	
	static {
		try {
			Class.forName(DRIVER_NAME);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 数据库连接
	 * @return
	 */
	public static Connection getConnection(String url, String username, String password) {
		try {
			Connection sourceConnection = DriverManager.getConnection(url, username, password);
			return sourceConnection;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
