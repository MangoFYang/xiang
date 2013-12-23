<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="button" />
<h:body>
<d:demo/>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="tabs" tabsDirection="bottom">
		<s:otab caption="普通按钮" renderTo="obutton" embedType="page" url="/smile/demos/obutton.jsp"/>
		<s:otab caption="CheckboxRadio" renderTo="ocheckboxradio" embedType="page" url="/smile/demos/ocheckboxradio.jsp"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
	<h:tab id="obutton" height="95%"></h:tab>
	<h:tab id="ocheckboxradio" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>