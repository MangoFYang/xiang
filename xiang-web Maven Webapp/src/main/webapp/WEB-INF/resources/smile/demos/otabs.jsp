<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="otabs" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/otabs.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="otabs" tabsDirection="bottom">
		<s:otab caption="t1" renderTo="t1"/>
		<s:otab caption="t2" renderTo="t2"/>
		<s:otab caption="t3" renderTo="t3"/>
		<s:otab caption="t4" renderTo="t4"/>
	</s:otabs>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.otabs.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>otabs</h2>
	<h:div>
		<h:p>
			<h:tabs id="otabs">
				<h:tab id="t1" height="100">
				t1的内容
				</h:tab>
				<h:tab id="t2" height="100">
				t2的内容
				</h:tab>
				<h:tab id="t3" height="100">
				t3的内容
				</h:tab>
				<h:tab id="t4" height="100">
				t4的内容
				</h:tab>
			</h:tabs>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:otabs renderTo="otabs" tabsDirection="bottom" &gt;
		&lt;s:otab caption="t1" renderTo="t1"/&gt;
		&lt;s:otab caption="t2" renderTo="t2"/&gt;
		&lt;s:otab caption="t3" renderTo="t3"/&gt;
		&lt;s:otab caption="t4" renderTo="t4"/&gt;
	&lt;/s:otabs&gt;

	<strong>Html标签: </strong>

	&lt;h:tabs id="otabs"&gt;
		&lt;h:tab id="t1" height="100"&gt;&lt;/h:tab&gt;
		&lt;h:tab id="t2" height="100"&gt;&lt;/h:tab&gt;
		&lt;h:tab id="t3" height="100"&gt;&lt;/h:tab&gt;
		&lt;h:tab id="t4" height="100"&gt;&lt;/h:tab&gt;
	&lt;/h:tabs&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="select">select(选择t2)</h:button>
			<h:pre>
	$("#otabs").otabs("select", "1");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="length">length</h:button><h:span id="lengthSpan"></h:span>
			<h:pre>
	var ret = $("#otabs").otabs("length");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="disableT3">disable(禁用t3)</h:button>
			<h:pre>
	$("#otabs").otabs("disable", "t3");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enableT3">enable(启用t3)</h:button>
			<h:pre>
	$("#otabs").otabs("enable", "t3");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>