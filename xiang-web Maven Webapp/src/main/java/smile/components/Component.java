package smile.components;

import java.io.IOException;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import smile.SmileException;

public class Component {
	
	// 将所有的属性都拷贝到此Map中，用于ftl的赋值。
	private Map<String, Object> parameters;
	
	/**
	 * 构造方法
	 * 实例化Component的parameters为LinkedHashMap类型
	 */
    public Component() {
        this.parameters = new LinkedHashMap<String, Object>();
    }

    /**
     * 将传入的所有参数添加到Component的parameters中。
     * @param params 被添加的参数。
     */
    protected void addAllParameters(Map<String, Object> params) {
        parameters.putAll(params);
    }

    /**
     * 
     * 添加key和value到这个Component的parameters中。
     * 如果key为null，则什么都不做。
     * 如果value为null，则从parameter中移除对应key的参数。
     * 
     * @param key  参数的key。
     * @param value key关联的value。
     */
    protected void addParameter(String key, Object value) {
        if (key != null) {
            if (value == null) {
            	parameters.remove(key);
            } else {
            	parameters.put(key, value);
            }
        }
    }

    /**
     * 回调，结束标签的回调。
     * 需要在一次处理标签体吗?
     * 
     * @param writer  输出流。
     * @param body    被渲染的标签体。
     * @return 如果需要再次处理标签体返回true。
     */
    public boolean end(Writer writer, String body) {
		try {
			writer.write(body);
		} catch (IOException e) {
			throw new SmileException(e);
		}
        return false;
    }
    
    /**
     * 获取Component的parameters
     * @return 返回Component的parameters
     */
	public Map<String, Object> getParameters() {
		return parameters;
	}
    
    /**
     * 
     * 回调，开始标签的回调。
     * 需要处理标签体吗?
     * 处理标签体有两种方式
     * 1.直接原样输出。
     * 2.读到Tag中，由程序解析。
     * 
     * 选择那种处理方式可使用usesBody方法。
     *
     * @param writer  输出流。
     * @return 如果需要处理标签体返回true，返回false表示不处理标签体，跳过标签体。
     */
    public boolean start(Writer writer) {
        return true;
    }

    /**
     * 如果Component需要使用body，可重写此方法。
     * 处理标签体有两种方式
     * 1.直接原样输出。
     * 2.读到Tag中，由程序解析。
     * 
     * 
     * @return 永远返回false，返回false表示直接原样输出，返回true表示读到Tag中，由程序解析。
     */
    public boolean usesBody() {
        return false;
    }
    
}
