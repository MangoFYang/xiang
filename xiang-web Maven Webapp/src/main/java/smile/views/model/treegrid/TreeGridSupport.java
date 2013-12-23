package smile.views.model.treegrid;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * id
 * pid
 * 
 * 
 * @author fange
 *
 */
public class TreeGridSupport<T> {
	
	/**
	 * 
	 * 建立treegrid数据。
	 * 
	 * @param nodes
	 * @return
	 */
	public static <T> List<TreeGridNode> buildTreeGridData(List<T> datas, IdPIdCreator<T> nodeCallback) {
		// 预填充节点, 此时节点id、pid、nodeDate、expanded已填充。
		List<TreeGridNode> nodeList = new ArrayList<TreeGridNode>();
		for (T data : datas) {
			IdPId idPId = nodeCallback.createIdPId(data);
			TreeGridNode node = new TreeGridNode();
			node.setId(idPId.getId());
			node.setPid(idPId.getPid());
			node.setExpanded(idPId.isExpanded());
			node.setNodeDate(data);
			nodeList.add(node);
		}
		// 必须重建 Node List，防止数据顺序错误。
		List<TreeGridNode> tree = new ArrayList<TreeGridNode>();
		if(nodeList != null) {
			List<TreeGridNode> roots = findRoots(nodeList);
			for (TreeGridNode node : roots) {
				tree.add(node);
				fillNode(tree, node, nodeList, 0);
			}
		}
		return tree;
	}
	
	/**
	 * 
	 * 填充当前节点的子节点
	 * 
	 * @param tree 树节点的列表
	 * @param currentNode 当前节点
	 * @param nodeList 所有节点的列表
	 */
	private static void fillNode(List<TreeGridNode> tree, TreeGridNode currentNode, List<TreeGridNode> nodeList, int level) {
		// 填充根节点的level属性为0。
		currentNode.setLevel(level);
		boolean hasChildren = false;
		for (TreeGridNode node : nodeList) {
			if(currentNode.getId().equals(node.getPid())) {
				hasChildren = true;
				tree.add(node);
				fillNode(tree, node, nodeList, level + 1);
			}
		}
		currentNode.setLeaf(!hasChildren);
	}
	
	/**
	 * 
	 * 查找树根节点
	 * 
	 * @param nodeList
	 * @return
	 */
	private static List<TreeGridNode> findRoots(List<TreeGridNode> nodeList) {
		List<TreeGridNode> roots = new ArrayList<TreeGridNode>();
		for (TreeGridNode node : nodeList) {
			if(node.getPid() == null) {
				node.setLevel(0);
				roots.add(node);
			}
		}
		return roots;
	}
	
}
