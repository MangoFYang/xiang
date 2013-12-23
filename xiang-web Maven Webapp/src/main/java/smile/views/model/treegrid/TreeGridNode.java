package smile.views.model.treegrid;

public class TreeGridNode {
	
	// 节点标识
	private String id;
	
	// 父节点标识
	private String pid;
	
	// 节点层级, 根节点为第0级
	private int level;
	
	// 是否为叶子
	private boolean leaf;
	
	// 默认是否展开
	private boolean expanded = true;
	
	// 默认数据是否已加载
	private boolean loaded = true;
	
	// 节点数据
	private Object nodeDate;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public boolean isLeaf() {
		return leaf;
	}

	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}

	public boolean isExpanded() {
		return expanded;
	}

	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

	public boolean isLoaded() {
		return loaded;
	}

	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}

	public Object getNodeDate() {
		return nodeDate;
	}

	public void setNodeDate(Object nodeDate) {
		this.nodeDate = nodeDate;
	}

}
