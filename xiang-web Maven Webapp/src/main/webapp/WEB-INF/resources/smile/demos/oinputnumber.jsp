<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="oinputnumber" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/oinputnumber.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>

	function start() {
		if(!!window.console) {
			console.info("start");
		}
	}
	function stop() {
		if(!!window.console) {
			console.info("stop");
		}
	}
	function spin() {
		if(!!window.console) {
			console.info("spin");
		}
	}
	function change() {
		if(!!window.console) {
			console.info("change");
		}
	}

	<s:oinputnumber renderTo="oinputnumber" label="数字输入域" value="1150.1" decimal="4" 
		step="0.0001" start="start" stop="stop" change="change" spin="spin"/>
		
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.oinputnumber.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
	
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>oinputnumber</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:input id="oinputnumber"/>
			</h:div>
			<h:pre>
	
	<strong>Script标签: </strong>

	&lt;s:oinputnumber renderTo="oinputnumber" value="1150.1" decimal="4" 
		step="0.0001" start="start" stop="stop" change="change" spin="spin"/ &gt;

	<strong>Html标签: </strong>

	&lt;h:input id="oinputnumber" /&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="setValue">设置值</h:button>
			<h:pre>
	$("#oinputnumber").oinputnumber("setValue", "123456789.1234");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="getValue">获取值</h:button><h:span id="getValueSpan"></h:span>
			<h:pre>
	var val = $("#oinputnumber").oinputnumber("getValue");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="disable">失效</h:button>
			<h:pre>
	$("#oinputnumber").oinputnumber("disable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enable">启用</h:button>
			<h:pre>
	$("#oinputnumber").oinputnumber("enable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="readOnly">只读</h:button>
			<h:pre>
	$("#oinputnumber").oinputnumber("readOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="nonreadOnly">取消只读</h:button>
			<h:pre>
	$("#oinputnumber").oinputnumber("nonreadOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="reset">重置</h:button>
			<h:pre>
	$("#oinputnumber").oinputnumber("reset");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="clear">清空</h:button>
			<h:pre>
	$("#oinputnumber").oinputnumber("clear");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="validate">校验</h:button><h:span id="validateSpan"></h:span>
			<h:pre>
	var ret = $("#oinputnumber").oinputnumber("validate");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>