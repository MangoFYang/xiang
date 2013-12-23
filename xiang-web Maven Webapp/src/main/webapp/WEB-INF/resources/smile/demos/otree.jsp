<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="otree" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/otree.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:otree renderTo="otree" data="nationalpeoplescongressofthecommunistpartyofchina"
		parent4Root="999999" parentIdField="pid" displayField="name" valueField="id"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.otree.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>otree</h2>
	<h:div>
		<h:p>
			<h:div class="fixed">
				<h:div id="otree"></h:div>
			</h:div>
			<h:pre>
	
	<strong>Script标签: </strong>

	&lt;s:otree renderTo="otree" data="nationalpeoplescongressofthecommunistpartyofchina"
		parent4Root="999999" parentIdField="pid" displayField="name" valueField="id" /&gt;

	<strong>Html标签: </strong>

	&lt;h:div id="otree"&gt;&lt;/h:div&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="selectNode">selectNode</h:button>
			<h:pre>
	$("#otree").otree("selectNode", $("#18"));
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="deselectNode">deselectNode</h:button>
			<h:pre>
	$("#otree").otree("deselectNode", $("#18"));
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="toggleSelect">toggleSelect</h:button>
			<h:pre>
	$("#otree").otree("toggleSelect", $("#17"));
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="deselectAll">deselectAll</h:button>
			<h:pre>
	$("#otree").otree("deselectAll");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="isSelected">isSelected</h:button><h:span id="isSelectedSpan"></h:span>
			<h:pre>
	$("#otree").otree("isSelected", $("#18"));
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="getSelected">getSelected</h:button><h:span id="getSelectedSpan"></h:span>
			<h:pre>
	var ret = $("#otree").otree("getSelected");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>