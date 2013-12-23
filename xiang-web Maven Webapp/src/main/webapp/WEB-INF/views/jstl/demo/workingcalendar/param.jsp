<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/smile-taglib.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="工作日历参数维护" />
<h:body>
<%-- JS代码, 例如： --%>
<%-- <s:script src="/xxx.js"></s:script> --%>
<s:script><%-- 此处放置JS标签 --%>
	<s:olocation location="['工作日历参数维护']" renderTo="location"/>
	
	function onSelectRow(rowid, status, e) {
		var type = $("#workingCalendarParamTypeGrid").ogrid("getCell", rowid, "type");
		console.info(type);
		
		$("#workingCalendarParamGrid").ogrid("setPostParam", {
			"paramType.type": type
		});
		
		$("#workingCalendarParamGrid").ogrid("research");
	}
	
	function onSelectRow_workingCalendarTypeGrid(rowid, status, e) {
		
		var id = $("#workingCalendarTypeGrid").ogrid("getCell", rowid, "id");
		console.info(id);
		
		$("#workingCalendarDefinitionGrid").ogrid("setPostParam", {
			"workingCalendarType.id": id
		});
		$("#workingCalendarDefinitionGrid").ogrid("research");
	
	}
	
	function newWorkingCalendarType() {
		$("#newWorkingCalendarTypeDlg").odialog("show");
	}

	<s:ogrid caption="工作日历参数类型列表" url="/demo/WorkingCalendarMaintainController/listParamType" 
		renderTo="workingCalendarParamTypeGrid" shrinkToFit="true"
	    onSelectRow="onSelectRow">
		<s:ogrid.column name="type" label="参数类型"/>
		<s:ogrid.column name="label" label="因素名称"/>
	</s:ogrid>
	
	<s:ogrid caption="工作日历参数列表" url="/demo/WorkingCalendarMaintainController/listParam" datatype="local"
		renderTo="workingCalendarParamGrid" shrinkToFit="true" >
		<s:ogrid.column name="id" label="标识" align="center" hidden="true"/>
		<s:ogrid.column name="code" label="参数代码" align="center" sortable="true"/>
		<s:ogrid.column name="label" label="参数名称" align="center"/>
	</s:ogrid>
	
</s:script>
<%-- 此处放置HTML标签 --%>
<h:div id="location"></h:div>
<h:table id="layout" width="100%" layout="true">
	<h:tr>
		<h:td width="40%" valign="top">
			<h:table id="workingCalendarParamTypeGrid"></h:table>
		</h:td>
		<h:td width="60%" valign="top">
			<h:table id="workingCalendarParamGrid"></h:table>
		</h:td>
	</h:tr>
</h:table>
</h:body>
</h:html>