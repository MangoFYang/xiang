<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="ocheckboxradio" />
<h:body>
<d:demo/>
<%-- JS代码 --%>
<s:script src="/smile/demos/scripts/ocheckboxradio.js"></s:script>
<s:script><%-- 此处放置JS标签 --%>
	<s:ocheckbox renderTo="cb1" checked="true" label="CVS" value="1001" check="check" uncheck="uncheck"/>
	<s:ocheckbox renderTo="cb2" label="SVN" check="check" value="1002" uncheck="uncheck"/>
	<s:ocheckbox renderTo="cb3" checked="true" label="GIT" value="1003" check="check" uncheck="uncheck"/>
	<s:oradio renderTo="r1" label="未婚" value="1001" check="check"/>
	<s:oradio renderTo="r2" label="已婚" value="1002" check="check"/>
	<s:oradio renderTo="r3" label="丧偶" value="1003" checked="true" check="check"/>
	<s:otabs renderTo="tabs">
		<s:otab caption="示例" renderTo="demo"/>
		<s:otab caption="编程接口" renderTo="api" embedType="page" url="/smile/docs/smile.ui.ocheckboxradio.html"/>
		<s:otab caption="常见问题" renderTo="faq"/>
	</s:otabs>
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="tabs" class="demo-tabs">
<h:tab id="demo" height="95%">
	<h2>ocheckbox</h2>
	<h:div>
		<h:p>
			<h:checkbox id="cb1" name="cb" />
			<h:checkbox id="cb2" name="cb" />
			<h:checkbox id="cb3" name="cb" />
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:ocheckbox renderTo="cb1" checked="true" label="CVS" check="check" uncheck="uncheck"/&gt;
	&lt;s:ocheckbox renderTo="cb2" label="SVN" check="check" uncheck="uncheck"/&gt;
	&lt;s:ocheckbox renderTo="cb3" checked="true" label="GIT" check="check" uncheck="uncheck"/&gt;

	<strong>Html标签: </strong>

	&lt;h:checkbox id="cb1" name="cb"/&gt;
	&lt;h:checkbox id="cb2" name="cb"/&gt;
	&lt;h:checkbox id="cb3" name="cb"/&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>oradio</h2>
	<h:div>
		<h:p>
			<h:radio id="r1" name="r" value="1001"/>
			<h:radio id="r2" name="r" value="1002"/>
			<h:radio id="r3" name="r" value="1003"/>
			<h:pre>

	<strong>Script标签: </strong>

	&lt;s:oradio renderTo="r1" label="未婚" check="check"/&gt;
	&lt;s:oradio renderTo="r2" label="已婚" check="check"/&gt;
	&lt;s:oradio renderTo="r3" label="丧偶" check="check"/&gt;

	<strong>Html标签: </strong>

	&lt;h:radio id="r1" name="r"/&gt;
	&lt;h:radio id="r2" name="r"/&gt;
	&lt;h:radio id="r3" name="r"/&gt;

			</h:pre>
		</h:p>
	</h:div>
	<h2>动作</h2>
	<h:div>
		<h:p>
			<h:button id="checkbox_checked">checkbox获取选中值(返回值为数组哦)</h:button><h:span id="checkbox_value"></h:span>
			<h:pre>

	$.smile.ocheckbox.getValue("cb");

			</h:pre>
		</h:p>
		<h:p>
			<h:button id="radio_checked">radio获取选中值</h:button><h:span id="radio_value"></h:span>
			<h:pre>

	$.smile.oradio.getValue("r");

			</h:pre>
		</h:p>
	</h:div>
	<h2>回调</h2>
	<h:div>
		<h:p>
			<h:pre>

	function check(event, data) {
		Smile.box.info({
			content: "您选中了: " + $(data.target)[$(data.target).data("xtype")]("option", "label")
		})
	}
	
	function uncheck(event, data) {
		Smile.box.info({
			content: "您取消选中了: " + $(data.target)[$(data.target).data("xtype")]("option", "label")
		})
	}

			</h:pre>

		</h:p>
	</h:div>
</h:tab>
<h:tab id="api" height="95%"></h:tab>
<h:tab id="faq" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>