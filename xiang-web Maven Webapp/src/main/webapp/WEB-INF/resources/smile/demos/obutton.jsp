<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="obutton" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/obutton.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>

	function clk() {
		Smile.box.alert({content: "Clicked me"});
	} 

	<s:obutton renderTo="demoBtn" click="clk"/>

	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.obutton.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>obutton</h2>
	<h:div>
		<h:p>
			<h:button id="demoBtn">Click Me!</h:button>
			<h:pre>

	<strong>Script标签: </strong>

	&lts:obutton renderTo="demoBtn" click="clk"/&gt;

	function clk() {
		Smile.box.alert({content: "Clicked me"});
	} 

	<strong>Html标签: </strong>

	&lt;h:button id="demoBtn"&gt;Click Me!&lt;/h:button&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="disable">失效</h:button>
			<h:pre>
	$("#demoBtn").obutton("disable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enable">启用</h:button>
			<h:pre>
	$("#demoBtn").obutton("enable");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>