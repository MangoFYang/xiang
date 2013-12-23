<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %><%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="Smile Reference" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="otabs" tabsDirection="vertical">
		<s:otab caption="欢迎" renderTo="welcome"/>
		<s:otab caption="提问的智慧" renderTo="smartquestions" embedType="page" url="/smile/demos/smartquestions/index.jsp"/>
		<s:otab caption="快速入门" renderTo="gettingstart" embedType="page" url="/smile/demos/gettingstart.jsp"/>
		<s:otab caption="大图" renderTo="bigpicture" embedType="page" url="/smile/demos/bigpicture.jsp"/>
		<s:otab caption="核心" renderTo="core" embedType="page" url="/smile/demos/core.jsp"/>
		<s:otab caption="基类" renderTo="obase" embedType="page" url="/smile/demos/obase.jsp"/>
		<s:otab caption="输入域" renderTo="field" embedType="page" url="/smile/demos/field.jsp"/>
		<s:otab caption="选择框" renderTo="select" embedType="page" url="/smile/demos/select.jsp"/>
		<s:otab caption="消息框" renderTo="messagebox" embedType="page" url="/smile/demos/messagebox.jsp"/>
		<s:otab caption="按钮" renderTo="button" embedType="page" url="/smile/demos/button.jsp"/>
		<s:otab caption="当前位置" renderTo="olocation" embedType="page" url="/smile/demos/olocation.jsp"/>
		<s:otab caption="标签页" renderTo="otabs1" embedType="page" url="/smile/demos/otabs.jsp"/>
		<s:otab caption="对话框" renderTo="odialog" embedType="page" url="/smile/demos/odialog.jsp"/>
		<s:otab caption="表格" renderTo="otable" embedType="page" url="/smile/demos/otable.jsp"/>
		<s:otab caption="Grid" renderTo="ogrid" embedType="page" url="/smile/demos/ogrid.jsp"/>
		<s:otab caption="展示框" renderTo="listview" embedType="page" url="/smile/demos/listview.jsp"/>
		<s:otab caption="级联菜单" renderTo="cascadingmenu" embedType="page" url="/smile/demos/cascadingmenu.jsp"/>
		<s:otab caption="文件上传" renderTo="ofileupload" embedType="page" url="/smile/demos/ofileupload.jsp"/>
		<s:otab caption="聊天" renderTo="chat" embedType="page" url="/smile/demos/socketio/chat.html"/>
	</s:otabs>
	<s:otable renderTo="news" hideBottomToolbar="true" 
		hideTopToolbar="true" caption="最新动向" collapsible="false"/>
	<s:otable renderTo="tips" hideBottomToolbar="true" 
		hideTopToolbar="true" caption="友情提示" collapsible="false"/>
</s:script><%-- 此处放置HTML标签 --%>
<%--<h:a href="socketio/chat.html">chat</h:a>--%>
<h:tabs id="otabs" class="demo-tabs">
	<h:tab id="welcome" height="99%">
		<h:div style="font-size: 50px; text-align: center; color: red; padding-top: 100px;margin-bottom: 300px;">欢迎来到Smile的世界</h:div>
		<h:table id="newsC" width="100%">
			<h:tr>
				<h:td width="50%" valign="top">
					<h:table id="tips">
						<h:tr>
							<h:td>所有组件都可以使用show/hide方法显示或隐藏组件。</h:td>
						</h:tr>
						<h:tr>
							<h:td>输入域组件已不在自动折行。</h:td>
						</h:tr>
						<h:tr>
							<h:td>OGrid默认将空或空字符串格式化显示为"--"，在使用用户自定义格式化别名时记得处理单元格为空的情况，直接返回"--"即可。</h:td>
						</h:tr>
						<h:tr>
							<h:td>将OGrid的height属性设置为auto时，OGrid会根据数据多少自动调整高度。</h:td>
						</h:tr>
					</h:table>
				</h:td>
				<h:td valign="top">
					<h:table id="news">
						<h:tr>
							<h:td><strong style="color: red;">Grid</strong> 简单的构建出TreeGrid的数据。<strong>文档</strong>：Grid  >> TreeGrid。</h:td>
						</h:tr>
						<h:tr>
							<h:td><strong style="color: red;">快速入门</strong> 5分钟学会使用Smile组件。</h:td>
						</h:tr>
						<h:tr>
							<h:td><strong>CheckboxRadio</strong> 使用ocheckbox或oradio的静态getValue方法获取一组ocheckbox或oradio中被选中的值。<strong>文档</strong>：按钮  >> CheckboxRadio。</h:td>
						</h:tr>
						<h:tr>
							<h:td><strong>提问的智慧</strong> 教会我们如何提出高质量的问题。</h:td>
						</h:tr>
						<h:tr>
							<h:td><strong>数值输入域组件</strong> 已完成，<strong>组件名</strong>：oinputnumber，可处理金额输入。<strong>文档</strong>：输入域  >> 数字输入域。</h:td>
						</h:tr>
					</h:table>
				</h:td>
			</h:tr>
		</h:table>
	</h:tab>
	<h:tab id="smartquestions" height="99%"></h:tab>
	<h:tab id="gettingstart" height="99%"></h:tab>
	<h:tab id="bigpicture" height="99%"></h:tab>
	<h:tab id="core" height="99%"></h:tab>
	<h:tab id="obase" height="99%"></h:tab>
	<h:tab id="messagebox" height="99%"></h:tab>
	<h:tab id="field" height="99%"></h:tab>
	<h:tab id="select" height="99%"></h:tab>
	<h:tab id="button" height="99%"></h:tab>
	<h:tab id="olocation" height="99%"></h:tab>
	<h:tab id="otabs1" height="99%"></h:tab>
	<h:tab id="odialog" height="99%"></h:tab>
	<h:tab id="otable" height="99%"></h:tab>
	<h:tab id="ogrid" height="99%"></h:tab>
	<h:tab id="listview" height="99%"></h:tab>
	<h:tab id="cascadingmenu" height="99%"></h:tab>
	<h:tab id="ofileupload" height="99%"></h:tab>
	<h:tab id="chat" height="99%"></h:tab>
</h:tabs>
</h:body>
</h:html>