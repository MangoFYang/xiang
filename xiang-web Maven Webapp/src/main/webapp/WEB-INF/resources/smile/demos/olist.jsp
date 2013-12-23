<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="olist" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/olist.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:olist renderTo="olist" data="fivehundredarhats" displayField="label" valueField="value" multiSelect="true" value="0009"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.olist.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>olist</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:ul id="olist"></h:ul>
			</h:div>
			<h:pre>
	
	<strong>Script标签: </strong>

	&lt;s:olist renderTo="olist" data="d" displayField="label" valueField="value" multiSelect="true" value="0009" /&gt;

	<strong>Html标签: </strong>

	&lt;h:ul id="olist"&gt;&lt;/h:ul&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="setValue">设置值</h:button>
			<h:pre>
	$("#olist").olist("setValue", "0006, 0007");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="getValue">获取值</h:button><h:span id="getValueSpan"></h:span>
			<h:pre>
	var val = $("#olist").olist("getValue");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="disable">失效</h:button>
			<h:pre>
	$("#olist").olist("disable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enable">启用</h:button>
			<h:pre>
	$("#olist").olist("enable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="reset">重置</h:button>
			<h:pre>
	$("#olist").olist("reset");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="clear">清空</h:button>
			<h:pre>
	$("#olist").olist("clear");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="select">选择</h:button>
			<h:pre>
	$("#olist").olist("select", "0001");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="unselect">取消选择</h:button>
			<h:pre>
	$("#olist").olist("unselect", "0001");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="selectAll">全选</h:button>
			<h:pre>
	$("#olist").olist("selectAll");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="unselectAll">取消全选</h:button>
			<h:pre>
	$("#olist").olist("unselectAll");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>