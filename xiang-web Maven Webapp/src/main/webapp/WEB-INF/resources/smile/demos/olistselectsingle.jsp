<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="olistselectsingle" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/olistselectsingle.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:olistselectsingle renderTo="olistselectsingle" 
		label="五百罗汉" title="五百罗汉" data="fivehundredarhats" value="0009"/>
		
var aaa = [ {
	label : "12312312312313",
	value : "0001"
}, {
	label : "asdfgdsa",
	value : "0002"
}, {
	label : "765432",
	value : "0003"
} ]
		
	<s:olistselectsingle renderTo="aaa" 
		label="五百罗汉" title="五百罗汉" data="aaa" value="0003"/>
		
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.olistselectsingle.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>olistselectsingle</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:input id="olistselectsingle"/>
				<h:input id="aaa"/>
			</h:div>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:olistselectsingle renderTo="olistselectsingle" 
		label="五百罗汉" title="五百罗汉" data="fivehundredarhats" value="0009" /&gt;

	<strong>Html标签: </strong>

	&lt;h:input id="olistselectsingle"/&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="setValue">设置值</h:button>
			<h:pre>
	$("#olistselectsingle").olistselectsingle("setValue", "0002");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="getValue">获取值</h:button><h:span id="getValueSpan"></h:span>
			<h:pre>
	var val = $("#olistselectsingle").olistselectsingle("getValue");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="disable">失效</h:button>
			<h:pre>
	$("#olistselectsingle").olistselectsingle("disable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enable">启用</h:button>
			<h:pre>
	$("#olistselectsingle").olistselectsingle("enable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="readOnly">只读</h:button>
			<h:pre>
	$("#olistselectsingle").olistselectsingle("readOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="nonreadOnly">取消只读</h:button>
			<h:pre>
	$("#olistselectsingle").olistselectsingle("nonreadOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="reset">重置</h:button>
			<h:pre>
	$("#olistselectsingle").olistselectsingle("reset");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="clear">清空</h:button>
			<h:pre>
	$("#olistselectsingle").olistselectsingle("clear");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="validate">校验</h:button><h:span id="validateSpan"></h:span>
			<h:pre>
	var ret = $("#olistselectsingle").olistselectsingle("validate");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>