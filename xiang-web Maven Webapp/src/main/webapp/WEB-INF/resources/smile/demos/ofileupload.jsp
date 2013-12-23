<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="ofileupload" />
<h:body>
<d:demo/>
<s:script><%-- 此处放置JS标签 --%>
	<s:ofileupload renderTo="ofileupload" url="/servlet/UploadServlet"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.ofileupload.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>ofileupload</h2>
	<h:div>
		<h:p>
			<h:file id="ofileupload"/>
			<h:pre>
	
	<strong>Script标签: </strong>

	&lt;s:ofileupload renderTo="ofileupload" url="/servlet/UploadServlet" /&gt;

	<strong>Html标签: </strong>

	&lt;h:file id="ofileupload"/&gt;

			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>