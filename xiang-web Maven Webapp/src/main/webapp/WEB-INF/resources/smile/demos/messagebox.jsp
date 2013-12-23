<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="messagebox" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/messagebox.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>Smile.box</h2>
	<h:div>
		<h:p>
			<h:button id="alert">alert</h:button><h:span id="alertSpan"></h:span>
			<h:pre>
	Smile.box.alert({
		content: "这里是提示信息!",
		ok: function() {
			$("#alertSpan").html("OK!");
		}
	});
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="success">success</h:button>
			<h:pre>
	Smile.box.success({
		content: "这里是提示信息!"
	});
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="info">info</h:button>
			<h:pre>
	Smile.box.info({
		content: "这里是提示信息!"
	});
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="confirm">confirm</h:button><h:span id="confirmSpan"></h:span>
			<h:pre>
	Smile.box.confirm({
		content: "这里是提示信息!",
		ok: function() {
			$("#confirmSpan").html("OK!");
		},
		cancel: function() {
			$("#confirmSpan").html("CANCEL!");
		}
	});
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="error">error</h:button>
			<h:pre>
	Smile.box.error({
		content: "这里是提示信息!"
	});
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>