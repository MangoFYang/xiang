<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/smile-taglib.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="工作日历查询" />
<h:body>
<%-- JS代码, 例如： --%>
<%-- <s:script src="/xxx.js"></s:script> --%>
<s:script><%-- 此处放置JS标签 --%>
	<s:olocation location="['工作日历查询']" renderTo="location"/>

	$.smile.ogrid.createFormatterAlias("yesOrNo", function(cellvalue, options, row) {
		return cellvalue;
	});
	
	var dayOfWeekArr = ['星期一', '星期二', '星期三', '星期四', '星期五', '星期六', '星期日'];
	$.smile.ogrid.createFormatterAlias("dayOfWeek", function(cellvalue, options, row) {
		return dayOfWeekArr[cellvalue - 1];
	});
	
	function addWorkingCalendar() {
		$("#newWorkingCalendarDlg").odialog("show");
	}
	
	function addWorkingCalendar_do() {
		Smile.ajax({
			url: "/demo/WorkingCalendarController/buildWorkingDateFromStartDateAndEndDate",
			data: {
				"workingCalendarTypeId": $("#wcType").oselect("getValue"),
				"startDateStr": $("#startDate1").odatepicker("getValue"),
				"endDateStr": $("#endDate1").odatepicker("getValue")
			},
			onComplete: function(data, textStatus) {
				if(data.success) {
					$("#newWorkingCalendarDlg").odialog("close");
					Smile.box.success({
						content: "工作日已生成!"
					});
				} else {
					Smile.box.error({
						content: data.message
					});
				}
			}
		});
		
	}
	
	function searchWorkingCalendar_do() {
		$("#workingCalendarGrid").ogrid("setPostParam", {
			"workingCalendarType.id": $("#wcType4s").oselect("getValue")
		});
		$("#workingCalendarGrid").ogrid("research");
	}

	<s:ogrid caption="工作日历列表" url="/demo/WorkingCalendarController/list" renderTo="workingCalendarGrid" 
		shrinkToFit="true" toppager="true" datatype="local">
		<s:ogrid.column name="id" label="标识" hidden="true"/>
		<s:ogrid.column name="workDate" label="工作日期" align="center"/>
<!-- 		<s:ogrid.column name="startTime" label="开始时间" align="center"/> -->
<!-- 		<s:ogrid.column name="endTime" label="结束时间" align="center"/> -->
		<s:ogrid.column name="dayOfWeek" label="星期" align="center" formatterAlias="dayOfWeek"/>
		<s:ogrid.column name="dateType" label="是否工作日" formatterAlias="yesOrNo" align="center" sortable="true" />
		<s:ogrid.column name="workingCalendarType_id" label="工作日历类型标识" hidden="true"/>
		<s:ogrid.column name="workingCalendarType_typeName" label="工作日历类型" align="center"/>
	</s:ogrid>
	<s:ogrid.button renderTo="workingCalendarGrid" label="添加工作日" click="addWorkingCalendar"/>
	
	<s:odialog renderTo="newWorkingCalendarDlg" 
		title="添加工作日历" autoOpen="false" width="680" height="100" closeOnEscape="true"/>
	
	<s:otextfield renderTo="genReg" label="工作日生成规则" value="非周六日" readOnly="true"/>
	
	<s:output var="workingCalendarType" value="${workingCalendarType }"/>
	<s:oselect renderTo="wcType" label="工作日类型" data="workingCalendarType" displayField="typeName" valueField="id" allowBlank="false"/>
	<s:odatepicker renderTo="startDate1" label="开始时间" allowBlank="false" value="+1"/>
	<s:odatepicker renderTo="endDate1"  label="结束时间" allowBlank="false" value="+10"/>
	
	$("#add").click(function() {
		addWorkingCalendar_do();
	});
	
	$("#search").click(function() {
		searchWorkingCalendar_do();
	});
	
	<s:oselect renderTo="wcType4s" label="工作日类型" data="workingCalendarType" displayField="typeName" valueField="id"/>
	
</s:script>
<%-- 此处放置HTML标签 --%>
<h:div id="location"></h:div>
	<h:table id="workingCalendarSearchTable" width="100%">
		<h:tr>
			<h:td width="30%">
				<h:input id="wcType4s"/>
			</h:td>
			<h:td>
				<h:button id="search">查找</h:button>
			</h:td>
		</h:tr>
	</h:table>
<h:table id="workingCalendarGrid"></h:table>
<h:div id="newWorkingCalendarDlg">
	<h:table id="newWorkingCalendarDlg_layout1" layout="true" width="100%">
		<h:tr>
			<h:td width="40%">
				<h:input id="genReg"/>
			</h:td>
			<h:td width="60%">
				<h:input id="wcType"/>
			</h:td>
		</h:tr>
	</h:table>
	<h:table id="newWorkingCalendarDlg_layout2" layout="true" width="100%">
		<h:tr>
			<h:td width="40%">
				<h:input id="startDate1"/>
			</h:td>
			<h:td width="40%">
				<h:input id="endDate1"/>
			</h:td>
			<h:td width="20%">
				<h:button id="add">生成</h:button>
			</h:td>
		</h:tr>
	</h:table>
	<h:table id="selectedParams" width="100%"></h:table>
</h:div>
</h:body>
</h:html>