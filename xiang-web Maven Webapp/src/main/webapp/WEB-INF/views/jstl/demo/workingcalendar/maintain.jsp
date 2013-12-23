<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/smile-taglib.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="工作日历参数维护" />
<h:body>
<%-- JS代码, 例如： --%>
<%-- <s:script src="/xxx.js"></s:script> --%>
<s:script><%-- 此处放置JS标签 --%>
	<s:olocation location="['工作日历类型维护']" renderTo="location"/>
	
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
		renderTo="workingCalendarParamTypeGrid" shrinkToFit="true" height="200" 
	    onSelectRow="onSelectRow">
		<s:ogrid.column name="type" label="参数类型"/>
		<s:ogrid.column name="label" label="因素名称"/>
	</s:ogrid>
	
	<s:ogrid caption="工作日历参数列表" url="/demo/WorkingCalendarMaintainController/listParam" datatype="local"
		renderTo="workingCalendarParamGrid" shrinkToFit="true" height="200" >
		<s:ogrid.column name="id" label="标识" align="center" hidden="true"/>
		<s:ogrid.column name="code" label="参数代码" align="center" sortable="true"/>
		<s:ogrid.column name="label" label="参数名称" align="center"/>
	</s:ogrid>
	
	<s:ogrid caption="工作日历类型列表" url="/demo/WorkingCalendarMaintainController/listWorkingCalendarType" 
		renderTo="workingCalendarTypeGrid" shrinkToFit="true"
		onSelectRow="onSelectRow_workingCalendarTypeGrid">
		<s:ogrid.column name="id" label="标识" hidden="true"/>
		<s:ogrid.column name="typeName" label="类型名称"/>
	</s:ogrid>
	<s:ogrid.button renderTo="workingCalendarTypeGrid" label="新建" click="newWorkingCalendarType"/>

	<s:ogrid caption="工作日类型定义列表" url="/demo/WorkingCalendarMaintainController/listWorkingCalendarDefinition" 
		renderTo="workingCalendarDefinitionGrid" shrinkToFit="true" datatype="local">
		<s:ogrid.column name="id" label="标识" align="center" hidden="true"/>
		<s:ogrid.column name="paramType_label" label="工作日历类型参数" align="center"/>
		<s:ogrid.column name="param_label" label="工作日历参数" align="center"/>
	</s:ogrid>
	
	<s:odialog renderTo="newWorkingCalendarTypeDlg" 
		title="新建工作日历类型" autoOpen="false" width="680" height="300" closeOnEscape="true"/>
		
	<s:otextfield renderTo="workingCalendarTypeName" label="日历名称" allowBlank="false"/>
	
	<s:output var="paramType" value="${paramType }"/>
	
	function select(e, d) {
		var defFieldEle = $(e.target).oselect("widget").parent().next().find(".SmileField")
		Smile.ajax({
			url: "/demo/WorkingCalendarMaintainController/findParamListByParamType",
			data: {
				"paramType": d.item.type
			},
			onComplete: function(data, textStatus) {
				defFieldEle.oselect("setData", data);
			}
		});
	}
	
	function saveWorkingCalendarType() {
	
		var serialize = $("#selectedParams").orepeatablerowtable("serialize");
		serialize = $.extend(serialize, {
			"typeName": $("#workingCalendarTypeName").val()
		})
		console.info(serialize);
		Smile.ajax({
			url: "/demo/WorkingCalendarMaintainController/addWorkingCalendarType",
			data: serialize,
			onComplete: function(data, textStatus) {
				if(data.success) {
					$("#newWorkingCalendarTypeDlg").odialog("close");
					$("#workingCalendarTypeGrid").ogrid("research");
				} else {
					Smile.box.error({
						content: data.message
					});
				}
			}
		});
		
	}
	
	<s:orepeatablerowtable renderTo="selectedParams" toolbarAlign="center" collapsible="false" hideCaption="true">
		<s:orepeatablerowtable.column label="参数类型" name="_[?]._" type="oselect" 
			options="{displayField: 'label', valueField: 'type', data: paramType, select: select}"/>
		<s:orepeatablerowtable.column label="参数名称" name="workingCalendarDefinitionList[?].param.id" 
			type="oselect" options="{displayField: 'label', valueField: 'id'}"/>
	</s:orepeatablerowtable>
	<s:orepeatablerowtable.button renderTo="selectedParams" label="保存" click="saveWorkingCalendarType"/>

</s:script>
<%-- 此处放置HTML标签 --%>
<h:div id="location"></h:div>
<h:table id="layout" width="100%" layout="true">
	<h:tr>
		<h:td  width="40%" valign="top">
			<h:table id="workingCalendarTypeGrid"></h:table>
		</h:td>
		<h:td  width="60%" valign="top">
			<h:table id="workingCalendarDefinitionGrid"></h:table>
		</h:td>
	</h:tr>
</h:table>
<h:div id="newWorkingCalendarTypeDlg">
	<h:table id="newWorkingCalendarTypeDlg_layout" layout="true" width="100%">
		<h:tr>
			<h:td>
				<h:input id="workingCalendarTypeName"/>
			</h:td>
		</h:tr>
	</h:table>
	<h:table id="selectedParams" width="100%"></h:table>
</h:div>
</h:body>
</h:html>