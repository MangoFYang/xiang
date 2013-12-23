<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="快速入门" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>
	<s:otabs renderTo="otabs">
		<s:otab caption="简介" renderTo="brief"/>
		<s:otab caption="标签的基本用法" renderTo="tagsusage" embedType="page" url="/smile/demos/tagsusage.jsp"/>
		<s:otab caption="组件方法的调用" renderTo="methodinvocation" embedType="page" url="/smile/demos/methodinvocation.jsp"/>
		<s:otab caption="组件数据的格式" renderTo="formatedata" embedType="page" url="/smile/demos/formatedata.jsp"/>
	</s:otabs>
	
	$(".tagsusage").on("click", function() {
		$("#otabs").otabs("select", 1);
	});
	$(".methodinvocation").on("click", function() {
		$("#otabs").otabs("select", 2);
	});
	$(".formatedata").on("click", function() {
		$("#otabs").otabs("select", 3);
	});
	
</s:script>
<%-- 此处放置HTML标签 --%>
<h:tabs id="otabs" class="demo-tabs">
	<h:tab id="brief" height="95%">
		<h2>简介</h2>
		<p>
		Smile 是一种基于JSP自定义标签和jQuery UI，用于构建Java Web 应用程序的框架。
		它提供了一种以组件为中心来开发 Java Web 用户界面的方法，从而简化了开发。
		Smile 为开发人员提供了无与伦比的功能和编程灵活性。
		Smile 还通过将组件和数据分离确保了应用程序具有更高的可维护性。
		</p>
		<p>
		Smile组件主要分为jQuery插件和JSP标签两部分，jQuery插件是组件的核心，也是实现部分，代码全部为JavaScript，所以不易编写和调试，也没有自动提示功能。
		为了编写方便，将组件封装成JSP标签，使用标签输出Javascript代码完成组件的初始化过程，标签只能用于组件的初始化工作，之后对组件的其他操作需要调用组件的方法。
		</p>
		<p>
		您已经大致了解了Smile组件的构成，下面我们会分为三部分讲解组件的使用：
		</p>
		<p>1、<a class="tagsusage" href="javascript:void(0)"><strong style="color: red;">标签的基本用法</strong></a></p>
		<p>2、<a class="methodinvocation" href="javascript:void(0)"><strong style="color: red;">组件方法的调用</strong></a></p>
		<p>3、<a class="formatedata" href="javascript:void(0)"><strong style="color: red;">组件数据的格式</strong></a></p>	
	</h:tab>
	<h:tab id="tagsusage" height="95%"></h:tab>
	<h:tab id="methodinvocation" height="95%"></h:tab>
	<h:tab id="formatedata" height="95%"></h:tab>
</h:tabs>
</h:body>
</h:html>