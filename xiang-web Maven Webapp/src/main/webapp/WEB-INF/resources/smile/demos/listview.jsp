<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="listview" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="tabs" tabsDirection="bottom">
		<s:otab caption="树型框" renderTo="otree" embedType="page" url="/smile/demos/otree.jsp"/>
		<s:otab caption="列表框" renderTo="olist" embedType="page" url="/smile/demos/olist.jsp"/>
		<s:otab caption="分页列表" renderTo="opageablelist" embedType="page" url="/smile/demos/opageablelist.jsp"/>
		<s:otab caption="obaselist" renderTo="obaselist" embedType="page" url="/smile/demos/obaselist.jsp"/>
		<s:otab caption="OList4excludeinput" renderTo="olist4excludeinput" embedType="page" url="/smile/demos/olist4excludeinput.jsp"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
	<h:tab id="olist" height="95%"></h:tab>
	<h:tab id="otree" height="95%"></h:tab>
	<h:tab id="opageablelist" height="95%"></h:tab>
	<h:tab id="obaselist" height="95%"></h:tab>
	<h:tab id="olist4excludeinput" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>