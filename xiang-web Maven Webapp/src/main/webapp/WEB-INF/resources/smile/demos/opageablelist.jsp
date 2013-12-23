<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="opageablelist" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/opageablelist.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:opageablelist renderTo="opageablelist" data="fivehundredarhats" displayField="label" valueField="value"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.opageablelist.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>olist</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:ul id="opageablelist"></h:ul>
			</h:div>
			<h:pre>
	
	<strong>Script标签: </strong>

	&lt;s:opageablelist renderTo="opageablelist" data="fivehundredarhats" displayField="label" valueField="value" /&gt;

	<strong>Html标签: </strong>

	&lt;h:ul id="opageablelist"&gt;&lt;/h:ul&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="search">查询</h:button>
			<h:pre>
	$("#opageablelist").opageablelist("search", "阿");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>