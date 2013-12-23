<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="select" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="tabs" tabsDirection="bottom">
		<s:otab caption="普通单选框" renderTo="oselect" embedType="page" url="/smile/demos/oselect.jsp"/>
		<s:otab caption="搜索单选框" renderTo="olistselectsingle" embedType="page" url="/smile/demos/olistselectsingle.jsp"/>
		<s:otab caption="树型单选框" renderTo="otreeselectsingle" embedType="page" url="/smile/demos/otreeselectsingle.jsp"/>
		<s:otab caption="搜索多选框" renderTo="olistselect" embedType="page" url="/smile/demos/olistselect.jsp"/>
		<s:otab caption="树型多选框" renderTo="otreeselect" embedType="page" url="/smile/demos/otreeselect.jsp"/>
		<s:otab caption="OSinglebox" renderTo="osinglebox" embedType="page" url="/smile/demos/osinglebox.jsp"/>
		<s:otab caption="OTwobox" renderTo="otwobox" embedType="page" url="/smile/demos/otwobox.jsp"/>
		<s:otab caption="OList4input" renderTo="olist4input" embedType="page" url="/smile/demos/olist4input.jsp"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="oselect" height="95%"></h:tab>
<h:tab id="olistselectsingle" height="95%"></h:tab>
<h:tab id="otreeselectsingle" height="95%"></h:tab>
<h:tab id="olistselect" height="95%"></h:tab>
<h:tab id="otreeselect" height="95%"></h:tab>
<h:tab id="osinglebox" height="95%"></h:tab>
<h:tab id="otwobox" height="95%"></h:tab>
<h:tab id="olist4input" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>