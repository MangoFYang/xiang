package smile.views.model.treegrid;


public interface IdPIdCreator<T> {
	
	/**
	 * 
	 * 需要填充id、pid、expanded属性。
	 * 根节点不用填充pid。
	 * 
	 * @param data
	 * @return
	 */
	public IdPId createIdPId(T data);

}
