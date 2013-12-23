<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="odialog" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/odialog.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:odialog renderTo="odialog" title="odialog" modal="false" autoOpen="false"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.odialog.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>odialog</h2>
	<h:div>
		<h:p>
			<h:div id="odialog"></h:div>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:odialog renderTo="odialog" title="odialog"/&gt;

	<strong>Html标签: </strong>

	&lt;h:div id="odialog"&gt;&lt;/h:div&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="toggleShow">toggleShow</h:button>
			<h:pre>
	$("#odialog").odialog("toggleShow");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="show">show</h:button>
			<h:pre>
	$("#odialog").odialog("show");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="hide">hide</h:button>
			<h:pre>
	$("#odialog").odialog("hide");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="isShow">isShow</h:button><h:span id="isShowSpan"></h:span>
			<h:pre>
	$("#odialog").odialog("isShow");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="open">open</h:button>
			<h:pre>
	$("#odialog").odialog("open");
			</h:pre>
		</h:p>
		<h:p>
			<h:button id="close">close</h:button>
			<h:pre>
	$("#odialog").odialog("close");
			</h:pre>
		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>