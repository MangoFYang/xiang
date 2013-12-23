<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="SmileWidget模板" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/xxx.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/xxx.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs">
<h:tab id="demo" height="600">
	<h2>组件名</h2>
	<h:div>
		<h:p>
			示例
			<h:pre>代码 ...</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="a1">动作1</h:button>
			<h:pre>代码 ...</h:pre>
		</h:p>
		<h:p>
			<h:button id="a2">动作2</h:button>
			<h:pre>代码 ...</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="600"></h:tab>
<h:tab id="faq" height="600"></h:tab>
</h:tabs>
</h:body>
</h:html>