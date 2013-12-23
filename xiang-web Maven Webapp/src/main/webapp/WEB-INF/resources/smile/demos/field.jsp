<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="field" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="tabs" tabsDirection="bottom">
		<s:otab caption="普通输入域" renderTo="otextfield" embedType="page" url="/smile/demos/otextfield.jsp"/>
		<s:otab caption="Ajax输入域" renderTo="oajaxinput" embedType="page" url="/smile/demos/oajaxinput.jsp"/>
		<s:otab caption="日历" renderTo="odatepicker" embedType="page" url="/smile/demos/odatepicker.jsp"/>
		<s:otab caption="数字输入域" renderTo="oinputnumber" embedType="page" url="/smile/demos/oinputnumber.jsp"/>
		<s:otab caption="otriggerinput" renderTo="otriggerinput" embedType="page" url="/smile/demos/otriggerinput.jsp"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
	<h:tab id="otextfield" height="93%"></h:tab>
	<h:tab id="oajaxinput" height="93%"></h:tab>
	<h:tab id="otriggerinput" height="93%"></h:tab>
	<h:tab id="oinputnumber" height="93%"></h:tab>
	<h:tab id="odatepicker" height="93%"></h:tab>
</h:tabs>
</h:body>
</h:html>