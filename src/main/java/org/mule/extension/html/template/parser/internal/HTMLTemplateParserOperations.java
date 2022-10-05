package org.mule.extension.html.template.parser.internal;

import static org.mule.runtime.extension.api.annotation.param.MediaType.ANY;

import java.util.Map;

import javax.inject.Inject;

import org.mule.runtime.api.el.BindingContext;
import org.mule.runtime.api.el.BindingContext.Builder;
import org.mule.runtime.api.metadata.DataType;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.core.api.el.ExpressionManager;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;

/**
 * This class is a container for operations, every public method in this class
 * will be taken as an extension operation.
 */
public class HTMLTemplateParserOperations {

	@Inject
	ExpressionManager em;
	
	@Throws(ExecuteErrorsProvider.class)
	@MediaType(value = ANY, strict = false)
	public String parseHtmlTemplate(String template,
			@Optional(defaultValue = "#[{}]") @Content(primary = true) Map<String, Object> inputParameters) {
		TemplateParser parser = new TemplateParser(em, getContext(inputParameters));
		return parser.getParsedTemplate(template);
	}

	private BindingContext getContext(Map<String, Object> params) {
		Builder bc = BindingContext.builder();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			// System.out.println(param.getKey() + " : " + param.getValue());
			bc.addBinding(param.getKey(), new TypedValue<>(param.getValue(), DataType.INPUT_STREAM));
		}
		return bc.build();
	}

}
