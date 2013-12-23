<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="osinglebox" />
<d:demo/>
<h:body>
<%-- JS代码 --%>
<%--<s:script src="/smile/demos/scripts/xxx.js"></s:script>--%>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="tabs">
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.osinglebox.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>