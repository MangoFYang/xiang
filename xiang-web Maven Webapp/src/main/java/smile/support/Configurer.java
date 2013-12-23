package smile.support;

import java.io.IOException;
import java.util.Properties;

public class Configurer {
	
	private static Properties properties;
	
	public static final String STATIC_PATH = "staticPath";
	
	static {
		properties = new Properties();
		try {
			properties.load(Configurer.class.getClassLoader().getResourceAsStream("smile.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String propertyName) {
		return properties.getProperty(propertyName);
	}
	
	public static String getStaticPath() {
		String contextPath = properties.getProperty(STATIC_PATH);
		return (contextPath != null && !"".equals(contextPath.trim())) ? contextPath : null;
	}
	
}
