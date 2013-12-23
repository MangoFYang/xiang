<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="oajaxinput" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<%--<s:script src="/smile/demos/scripts/xxx.js"></s:script>--%>
<s:script><%-- 此处放置JS标签 --%>
	<s:oajaxinput url="/servlet/SmileServlet" renderTo="oajaxinput" label="ajax输入域" allowBlank="false"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.oajaxinput.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>oajaxinput</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:input id="oajaxinput"/>
			</h:div>
			<h:p>
				<h:span>1001、1002为合法数据，其他不合法，欢迎尝试。</h:span>
			</h:p>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:oajaxinput url="/servlet/SmileServlet" renderTo="oajaxinput" label="ajax输入域"/&gt;

	<strong>Html标签: </strong>

	&lt;h:input id="oajaxinput"/&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			继承自父类...
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>