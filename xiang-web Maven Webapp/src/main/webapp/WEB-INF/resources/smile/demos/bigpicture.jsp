<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="bigpicture" />
<h:body>
<d:demo/>
<%-- 引用的JS文件, 必须以"/"开头, 例如： --%>
<%-- <s:script src="/xxx.js"></s:script> --%>
<s:script><%-- 此处放置JS标签 --%>

</s:script>
<%-- 此处放置HTML标签 --%>
<img alt="大图" src="images/widget.png"></img>
</h:body>
</h:html>