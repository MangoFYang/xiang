<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="标签的基本用法" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>

</s:script>
<%-- 此处放置HTML标签 --%>
		<h2>标签的基本用法</h2>
		<p>
		Smile标签分为三部分，JavaScript标签、HTML标签和数据标签。
		</p>
		<p>
		<strong>JavaScript标签</strong>：s开头，也称s标签，用于输出组件的JavaScript代码，将HTML渲染成Smile组件。
		</p>
		<p>
		<strong>HTML标签</strong>：h开头，也称h标签，用于输出组件的HTML代码，决定组件的基础HTML元素，和组件渲染的位置。
		</p>
		<p>
		<strong>数据标签</strong>：&lt;s:output var="foo" value="\${ foo }"/&gt;，
		通过EL表达式获取page、request、session或者application（四种范围）中的java对象序列化成组件可以使用的JSON格式的数据。
		</p>
		<p>
		看看下面这段代码：
		</p>
		<pre>
	1、&lt;s:script&gt;
	2、	&lt;s:otreeselect renderTo="otreeselect1"/&gt;
	3、&lt;/s:script&gt;
	4、&lt;h:input id="otreeselect1"/&gt;
		</pre>
		<p>
		<strong>&lt;s:script&gt;</strong>标签会输出script元素和 $function：
		</p>
		<pre>
	&lt;script type="text/javascript"&gt;$(function(){
	
	});&lt;/script&gt;
		</pre>
		<p>
		因此，写在&lt;s:script&gt;标签中的JavaScript标签和JavaScript代码不用写script元素和 $function，换句换说就是直接写逻辑代码即可。
		</p>
		<p>
		<strong>&lt;s:otreeselect renderTo="otreeselect1"/&gt;</strong>标签会输出otreeselect组件的初始化代码：
		</p>
		<pre>
	$("#otreeselect1").otreeselect({adjacency:{"a":"a"},checkbox: {"a":"a"},"a":"a"});
		</pre>
		<p>
		otreeselect依赖于第4行代码中的&lt;h:input id="otreeselect1"/&gt;，语义为：将id为otreeselect1的h标签渲染成otreeselect组件，
		说明：输出JavaScript代码中的"a":"a"为简单处理避免有未知选项时最后的选项后面的","需要截取的麻烦，可不必在意。
		</p>
		<p>
		<strong>&lt;h:input id="otreeselect1"/&gt;</strong>标签会输出组件的HTML基本代码：
		</p>
		<pre>
	&lt;input type="text" id="otreeselect1"/&gt;
		</pre>
		<p>
		只输出一个普通的HTML input元素，h标签的位置决定了s标签的渲染位置（组件的生成位置），通常s标签会对应一个h标签，对应关系在具体组件的实例中有描述。
		</p>
		<p>
		以上讲解了标签的分类和基本用法，<strong>注意</strong>：使用标签只能做组件的初始化，若要对组件做后续操作请阅读<strong style="color: red;">组件方法的调用</strong>
		</p>
</h:body>
</h:html>