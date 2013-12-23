<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="StandardJSPTemplate" />
<h:body>
<%-- JS代码, 例如： --%>
<%-- <s:script src="/xxx.js"></s:script> --%>
<s:script><%-- 此处放置JS标签 --%>
	<s:olocation location="['Smile', 'StandardJSPTemplate']" renderTo="location"/>

</s:script>
<%-- 此处放置HTML标签 --%>
<h:div id="location"></h:div>

</h:body>
</h:html>