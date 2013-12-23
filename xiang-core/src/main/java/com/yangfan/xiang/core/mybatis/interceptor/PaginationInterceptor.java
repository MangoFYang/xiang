package com.yangfan.xiang.core.mybatis.interceptor;

import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yangfan.xiang.core.mybatis.dialect.Dialect;


@Intercepts({ @Signature(type=StatementHandler.class, method="prepare", args={ Connection.class }) })
public class PaginationInterceptor implements Interceptor {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	public static final String DELEGATE_ROWBOUNDS = "delegate.rowBounds";
	
	private Dialect dialect;
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		BoundSql boundSql = statementHandler.getBoundSql();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler);
		RowBounds rowBounds = (RowBounds) metaStatementHandler.getValue(DELEGATE_ROWBOUNDS);

		// 判断是否有分页信息，无分页则跳过。
		if (rowBounds == null || rowBounds == RowBounds.DEFAULT) {
			return invocation.proceed();
		}
		String originalSql = boundSql.getSql();

		// 初始化方言
		if(dialect == null) {
			Configuration configuration = (Configuration) metaStatementHandler.getValue("delegate.configuration");
			String dialectName = configuration.getVariables().getProperty("dialect");
			dialect = (Dialect) Class.forName(dialectName).newInstance();
			logger.debug("初始化方言 : {}", dialectName);
		}

		// 生成分页SQL
		metaStatementHandler.setValue("delegate.boundSql.sql", dialect.getLimitString(originalSql, rowBounds.getOffset(), rowBounds.getLimit()));
		// 重置分页数据，跳过mybatis对分页的处理。
		metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
		metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		logger.debug("生成分页SQL: {}", statementHandler.getBoundSql().getSql());

		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}
	
}
