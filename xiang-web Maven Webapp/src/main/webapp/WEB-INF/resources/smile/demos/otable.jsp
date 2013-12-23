<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="otable" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/otable.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:otable renderTo="otable" caption="表格"/>
	<s:otable.button renderTo="otable" label="小按钮"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.otable.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>otable</h2>
	<h:div>
		<h:p>
			<h:table id="otable">
				<h:tr>
					<h:td></h:td>
					<h:td></h:td>
				</h:tr>
				<h:tr>
					<h:td></h:td>
					<h:td></h:td>
				</h:tr>
			</h:table>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:otable renderTo="otable" caption="表格"/&gt;
	&lt;s:otable.button renderTo="otable" label="小按钮"/&gt;

	<strong>Html标签: </strong>

	&lt;h:table id="otable"&gt;
		&lt;h:tr>
			&lt;h:td&gt;&lt;/h:td&gt;
			&lt;h:td&gt;&lt;/h:td&gt;
		&lt;/h:tr&gt;
		&lt;h:tr&gt;
			&lt;h:td&gt;&lt;/h:td&gt;
			&lt;h:td&gt;&lt;/h:td&gt;
		&lt;/h:tr&gt;
	&lt;/h:table&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="addButton">添加按钮</h:button>
			<h:pre>
	$("#otable").otable("addButton", {
		label: "Click Me!",
		click: function() {
			Smile.box.alert({
				content: "你点击了按钮"
			})
		}
	});
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>