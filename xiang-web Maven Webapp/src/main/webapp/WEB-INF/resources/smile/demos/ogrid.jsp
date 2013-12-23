<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="ogrid" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<%--<s:script src="/smile/demos/scripts/xxx.js"></s:script>--%>
<s:script><%-- 此处放置JS标签 --%>
	<s:ogrid url="/servlet/TreeGridServlet" renderTo="ogrid" treeGrid="true" toppager="true" bottomPager="false">
		<s:ogrid.column name="nodeDate.label" label="cell1"/>
		<s:ogrid.column name="nodeDate.value" label="cell2" formatterAlias="detail" width="1000"/>
		<s:ogrid.column name="dy.dy2" label="cell3" formatterAlias="a" width="1000"/>
	</s:ogrid>
	<s:ogrid.button renderTo="ogrid" label="小按钮" />
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.ogrid.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
		<s:otab caption="TreeGrid" renderTo="treegrid" embedType="page" url="/smile/demos/treegrid.jsp"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>ogrid</h2>
	<h:div>
		<h:p>
			<h:table id="ogrid"></h:table>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:ogrid url="/smile/demos/data/grid/tree.data.adjacency.js" renderTo="ogrid" treeGrid="true"&gt;
		&lt;s:ogrid.column name="cell1" label="cell1"/&gt;
		&lt;s:ogrid.column name="dy.dy1" label="cell2" formatterAlias="num3" /&gt;
		&lt;s:ogrid.column name="dy.dy2" label="cell3" formatterAlias="a" /&gt;
	&lt;/s:ogrid&gt;
	
	&lt;s:ogrid.button renderTo="ogrid" label="小按钮" /&gt;

	<strong>Html标签: </strong>

	&lt;h:table id="ogrid"&gt;&lt;/h:table&gt;

			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
<h:tab id="treegrid" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>