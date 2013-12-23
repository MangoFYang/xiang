<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %><%@include file="../smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="提问的智慧" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="otabs">
		<s:otab caption="译文" renderTo="smartquestions" embedType="page" url="/smile/demos/smartquestions/smart-questions.html"/>
		<s:otab caption="图解1" renderTo="picture1"/>
		<s:otab caption="图解2" renderTo="picture2"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="otabs" class="demo-tabs">
	<h:tab id="smartquestions" height="95%"></h:tab>
	<h:tab id="picture1" height="95%">
		<img alt="图1" src="question.jpeg"></img>
	</h:tab>
	<h:tab id="picture2" height="95%">
		<img alt="图2" src="questions4mind.png"></img>
	</h:tab>
</h:tabs>
</h:body>
</h:html>