<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="otextfield" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/otextfield.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:otextfield renderTo="otextfield" label="输入域" value="输入值" allowBlank="false" vtypeAlias="v1"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.otextfield.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>otextfield</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:input id="otextfield"/>
			</h:div>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:otextfield renderTo="otextfield" label="输入域" value="输入值" vtype="v1"/&gt;

	<strong>Html标签: </strong>

	&lt;h:input id="otextfield"/&gt;

	<strong>JS定义校验别名: </strong>

	Smile.util.createVtypeAlias("v1", {
		rangeLength: [3, 8]
	});

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="setValue">设置值</h:button>
			<h:pre>
	$("#otextfield").otextfield("setValue", "新值");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="getValue">获取值</h:button><h:span id="getValueSpan"></h:span>
			<h:pre>
	var val = $("#otextfield").otextfield("getValue");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="disable">失效</h:button>
			<h:pre>
	$("#otextfield").otextfield("disable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="enable">启用</h:button>
			<h:pre>
	$("#otextfield").otextfield("enable");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="readOnly">只读</h:button>
			<h:pre>
	$("#otextfield").otextfield("readOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="nonreadOnly">取消只读</h:button>
			<h:pre>
	$("#otextfield").otextfield("nonreadOnly");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="reset">重置</h:button>
			<h:pre>
	$("#otextfield").otextfield("reset");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="clear">清空</h:button>
			<h:pre>
	$("#otextfield").otextfield("clear");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="validate">校验</h:button><h:span id="validateSpan"></h:span>
			<h:pre>
	var ret = $("#otextfield").otextfield("validate");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>