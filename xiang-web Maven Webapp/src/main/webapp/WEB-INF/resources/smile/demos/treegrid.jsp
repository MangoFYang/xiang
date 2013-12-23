<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%><%@include file="/WEB-INF/smile-taglib.jsp" %>
<%@include file="smile-demo.jsp" %>
<!DOCTYPE HTML>
<h:html overflowX="hidden" overflowY="hidden">
<h:head title="TreeGrid" />
<h:body>
<d:demo/>
<s:script><%-- 此处放置JS标签 --%>

</s:script>
<%-- 此处放置HTML标签 --%>
	<h2>TreeGrid</h2>
	<h:div>
		<h:p>
			TreeGrid和普通Grid的除了数据格式稍有不同外无其他区别。
		</h:p>
		<h:p>
			<strong>标签</strong>：设置treeGrid属性为true，指示grid按照树的形式展示数据。
			下面主要构造树型数据格式，Grid是如何解析树型数据的看看下面的代码：
		</h:p>
		<pre>
	treeReader: {
		// 此域决定元素在层级中的水平。
		// 通常root元素被设置为0，root的第一个孩子是1，等等。
		// grid需要此信息设置每个元素的缩进。
		level_field: "level",
		// 指示父节点的id，如果父id设置为null，则元素为root节点。
		parent_id_field: "pid",
		// 指示是否为叶子，可取true或者false。
		// 是否为叶子节点关系到元素的图片和是否能被展开。
		leaf_field: "leaf",
		// 指示grid元素在加载时是否应该被展开，可取true或者false。
		// 如果没有值，则设置为false。
		// 注意：数据可以为null，但是不应该被移除。
		expanded_field: "expanded",
		// 指示数据是否已加载是否。
		loaded: "loaded"
  	}
		</pre>
		<h:p>
		从上面的配置中可以发现提供的数据需要有level、pid、leaf、expanded、loaded字段。
		</h:p>
		<h:p>
		<strong>说明</strong>：此接口为原生API，未经过任何封装，可看出需要提供的数据过多，有些数据是需要经过计算得到，使用不便。
		</h:p>
		<h:p>
		组件推荐使用这种方式，Java代码如下：
		</h:p>
		<pre>
	
	List&lt;TreeGridNode&gt; buildTreeGridData = TreeGridSupport.buildTreeGridData(treeNodeList, new IdPIdCreator&lt;Node&gt;() {
		@Override
		public IdPId createIdPId(Node node) {
			IdPId idPId = new IdPId();
			idPId.setId(node.getTreeNodeId());
			idPId.setPid(node.getTreeNodeParentId());
			return idPId;
		}
	});
	
		</pre>
		<h:p>
		Node: 用户的树节点类，Node对象中必须包含节点标识和父节点标识信息。
		</h:p>
		<h:p>
		treeNodeList: Node对象的List。
		</h:p>
		<h:p>
		IdPIdCreator: 回调中的createIdPId方法意为：将用户的树节点类（Node）中的节点标识和父节点标识信息构造成IdPId对象返回，
		提供给组件用于计算其余信息，比如level、leaf。
		</h:p>
		<h:p>
		完成后得到的buildTreeGridData就是Grid数据格式中的数据部分。
		</h:p>
		<strong style="color: red;">注意</strong>: 使用这种方式之后，在列定义的name属性上必须添加"nodeDate."前缀，
		这是因为TreeGridSupport将用户的所有数据都放在了nodeDate&lt;Object&gt;对象中。
	</h:div>
</h:body>
</h:html>