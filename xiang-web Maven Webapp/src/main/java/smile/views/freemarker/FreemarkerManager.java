package smile.views.freemarker;

import smile.SmileException;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

public class FreemarkerManager {
	
	private static FreemarkerManager instance = new FreemarkerManager();
	
	public static FreemarkerManager getInstance() {
		return instance;
	}

	private Configuration config;

	private FreemarkerManager() {
		try {
			config = new Configuration();
			config.setClassForTemplateLoading(this.getClass(), "/smile/template");
			config.setObjectWrapper(new DefaultObjectWrapper());
			// 取消ftl模板缓存，生产环境可进行优化。
			config.setTemplateUpdateDelay(0);
			config.setDefaultEncoding("UTF-8");
		} catch (Exception e) {
			throw new SmileException(e);
		}
	}
	
	private String getSuffix() {
		return "ftl";
	}

	public void renderTemplate(TemplateRenderingContext context) {
		try {
			Template template = config.getTemplate(context.getTemplateName() + "." + getSuffix());
			template.process(context.getParameters(), context.getWriter());
		} catch (Exception e) {
			throw new SmileException(e);
		}
	}
	
}
