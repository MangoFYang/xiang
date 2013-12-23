<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="otreeselect" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/otreeselect.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:otreeselect renderTo="otreeselect" data="nationalpeoplescongressofthecommunistpartyofchina" 
		value="21, 22" label="中国共产党全国代表大会" title="中国共产党全国代表大会" parent4Root="999999" 
		displayField="name" valueField="id" parentIdField="pid" selectableField="selectable" />
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.otreeselect.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>otreeselect</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:input id="otreeselect"/>
			</h:div>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:otreeselect renderTo="otreeselect" data="nationalpeoplescongressofthecommunistpartyofchina" 
		value="21, 22" label="中国共产党全国代表大会" title="中国共产党全国代表大会" parent4Root="999999" 
		displayField="name" valueField="id" parentIdField="pid" selectableField="selectable" /&gt;

	<strong>Html标签: </strong>

	&lt;h:input id="otreeselect"/&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="setValue">设置值</h:button>
			<h:pre>
	$("#otreeselect").otreeselect("setValue", "16, 17, 18");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="getValue">获取值</h:button><h:span id="getValueSpan"></h:span>
			<h:pre>
	var val = $("#otreeselect").otreeselect("getValue");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="disable">失效</h:button>
			<h:pre>
	$("#otreeselect").otreeselect("disable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enable">启用</h:button>
			<h:pre>
	$("#otreeselect").otreeselect("enable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="readOnly">只读</h:button>
			<h:pre>
	$("#otreeselect").otreeselect("readOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="nonreadOnly">取消只读</h:button>
			<h:pre>
	$("#otreeselect").otreeselect("nonreadOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="reset">重置</h:button>
			<h:pre>
	$("#otreeselect").otreeselect("reset");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="clear">清空</h:button>
			<h:pre>
	$("#otreeselect").otreeselect("clear");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="validate">校验</h:button><h:span id="validateSpan"></h:span>
			<h:pre>
	var ret = $("#otreeselect").otreeselect("validate");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>