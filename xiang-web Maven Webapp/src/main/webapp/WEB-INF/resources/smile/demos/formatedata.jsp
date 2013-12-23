<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html>
<h:head title="组件的数据格式" />
<d:demo/>
<h:body>
<s:script><%-- 此处放置JS标签 --%>

</s:script>
<%-- 此处放置HTML标签 --%>
		<h2>组件数据的格式</h2>
		<p>
		当组件初始化时，可能需要填充一些可供用户选择的记录，比如选择框，这就涉及到组件数据的格式，在讲解数据格式之前先来了解下JSON。
		JSON(JavaScript Object Notation) 是一种轻量级的数据交换格式，采用完全独立于语言的文本格式，是理想的数据交换格式。
		同时，JSON是JavaScript原生格式，这意味着在JavaScript中处理 JSON数据不须要任何特殊的API或工具包。 
		</p>
		<p>
		在JSON中，有两种结构：对象和数组。
		</p>
		<p>
		<strong>1、对象</strong>：一个key/value对的集合。在各种语言中，这个叫做对象、记录、结构体、字体、哈希表、有键列表、关联数组（好多名字呀，都是一回事）。
		</p>
		<p>
		一个对象以"{"（左括号）开始，"}"（右括号）结束。每个"名称"后跟一个":"（冒号）; "'名称/值' 对"之间运用 ","（逗号）分隔。
		 名称用引号引起来；值如果是字符串则必须用引号引起来，数值型则不须要。例如：
		</p>
		<pre>
	var o = {
		"xlid":"cxh",
		"xldigitid":123456,
		"topscore":2000,
		"topplaytime":"2009-08-20"
	};
		</pre>
		<p>
		<strong>2、数组</strong>：值的有序列表，在很多语言中，这个叫做数组、向量、序列等。
		</p>
		<p>
		数组是值（value）的有序集合。一个数组以"["（左中括号）开始，"]"（右中括号）结束。值之间运用 ","（逗号）分隔。例如：
		</p>
		<pre>
	var a = [
		{"xlid":"cxh","xldigitid":123456,"topscore":2000,"topplaytime":"2009-08-20"},
		{"xlid":"zd","xldigitid":123456,"topscore":1500,"topplaytime":"2009-11-20"}
	];
		</pre>
		<p>
		此数组中有两个元素，每个元素为一对象。
		</p>
		<p>
		组件需要的数据格式就是JSON格式: <strong>数组中是对象</strong>，格式和变量a完全一致，所有选择框都有data属性，指定数据源（需要事先定义，像 a 那样）；
		displayField属性，指定显示字段（来自数据源中元素的key）；valueField属性，指定值字段（来自数据源中元素的key）。
		值得注意的是，在树型选择框中有parentIdField属性，指定父节点字段（使用邻接表存储树时必须有），parent4Root属性，指定父节点为指定值时作为根节点。
		</p>
		<p>
		通常情况数据是从服务器端获取的，存放在List中，list中的每个元素为对象，记为：List&lt;XXXVO&gt;，而不是像静态数据 a 变量那样。
		</p>
		<p>
		<strong>如何将Java对象List&lt;XXXVO&gt;转化成组件能够识别的格式呢 ?</strong>
		</p>
		<p>
		<strong>数据标签</strong>：&lt;s:output var="foo" value="\${ foo }"/&gt;，
		通过EL表达式获取page、request、session或者application（四种范围）中的java对象序列化成组件可以使用的JSON格式的数据。
		在组件中引用var的值即可。
		</p>
		
</h:body>
</h:html>