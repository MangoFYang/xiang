package smile.views.freemarker;

import java.io.Writer;
import java.util.Map;

public class TemplateRenderingContext {
	
	private Map<String, Object> parameters;
	
	private String templateName;
	
	private Writer writer;

	public TemplateRenderingContext(String templateName,
			Map<String, Object> parameters, Writer writer) {
		this.templateName = templateName;
		this.parameters = parameters;
		this.writer = writer;
	}

	public Map<String, Object> getParameters() {
		return parameters;
	}

	public String getTemplateName() {
		return templateName;
	}

	public Writer getWriter() {
		return writer;
	}
	
}
