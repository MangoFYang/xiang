<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="olistselectsingle" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/oselect.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>

	function select() {
		Smile.box.info({
			content: $("#oselect").val()
		})
	}

	<s:oselect renderTo="oselect" 
		label="十大元帅" title="十大元帅" data="d" value="1009" select="select"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.oselect.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>oselect</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:input id="oselect"/>
			</h:div>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:oselect renderTo="oselect" 
		label="十大元帅" title="十大元帅" data="d" value="1009" select="select"/&gt;

	function select() {
		Smile.box.info({
			content: $("#oselect").val()
		})
	}

	<strong>Html标签: </strong>

	&lt;h:input id="oselect"/&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="setValue">设置值</h:button>
			<h:pre>
	$("#oselect").oselect("setValue", "1002");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="getValue">获取值</h:button><h:span id="getValueSpan"></h:span>
			<h:pre>
	var val = $("#oselect").oselect("getValue");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="disable">失效</h:button>
			<h:pre>
	$("#oselect").oselect("disable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enable">启用</h:button>
			<h:pre>
	$("#oselect").oselect("enable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="readOnly">只读</h:button>
			<h:pre>
	$("#oselect").oselect("readOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="nonreadOnly">取消只读</h:button>
			<h:pre>
	$("#oselect").oselect("nonreadOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="reset">重置</h:button>
			<h:pre>
	$("#oselect").oselect("reset");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="clear">清空</h:button>
			<h:pre>
	$("#oselect").oselect("clear");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="validate">校验</h:button><h:span id="validateSpan"></h:span>
			<h:pre>
	var ret = $("#oselect").oselect("validate");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>