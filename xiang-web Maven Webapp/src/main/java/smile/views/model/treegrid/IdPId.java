package smile.views.model.treegrid;

public class IdPId {
	
	// 节点标识
	private String id;
	
	// 父节点标识
	private String pid;
	
	// 默认是否展开
	private boolean expanded = true;

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

	public boolean isExpanded() {
		return expanded;
	}

	/**
	 * 设置默认是否展开
	 * @param expanded
	 */
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}

}
