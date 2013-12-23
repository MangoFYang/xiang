<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="组件方法的调用" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>

</s:script>
<%-- 此处放置HTML标签 --%>
		<h2>组件方法的调用</h2>
		<p>
		通常情况下组件初始化后，需要对组件做后续操作，比如获取值，用户选择或者输入完成后需要将值提交到服务器端，这时就必须调用组件的方法获取用户输入值。
		在上面的例子中otreeselect组件获取值的方法叫getValue，下面就是调用getValue的代码：
		</p>
		<pre>
	$("#otreeselect1").otreeselect("getValue");
		</pre>
		<p>
		方法的名字作为otreeselect实例的第一个参数，方法的参数作为otreeselect实例后续参数依次按顺序传入，各个参数使用","分隔。getValue无参数，故调用时不用传入。
		如要设置值，代码如下：
		</p>
		<pre>
	$("#otreeselect1").otreeselect("setValue", "新值");
		</pre>
		<p>
		setValue方法的参数列表从第二个参数开始往后排。
		</p>
		<p>
		<strong>方法调用通用格式如下</strong>：<span style="color: red;">$("#组件标识").组件名("方法名", 方法参数列表...);</span>
		</p>
</h:body>
</h:html>