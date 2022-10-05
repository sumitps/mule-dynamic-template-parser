package org.mule.extension.html.template.parser.internal;

import java.util.regex.Pattern;

import org.mule.runtime.api.el.BindingContext;
import org.mule.runtime.core.api.el.ExpressionManager;
import org.mule.runtime.extension.api.exception.ModuleException;

public class TemplateParser {
	static String seq = "#[";
	ExpressionManager expManager;
	BindingContext context;

	public TemplateParser(ExpressionManager em, BindingContext bc) {
		this.expManager = em;
		this.context = bc;
	}

	protected String getParsedTemplate(String template) throws ModuleException {
		int lastI = template.lastIndexOf(seq);
		String code = "";
		ParserUtils util = new ParserUtils();

		while (template.contains(seq)) {
			code = util.getCode(lastI, template);
			if (code != "")	template = evalAndReplaceCode(code, template);
			lastI = template.substring(0, lastI).lastIndexOf(seq);
			if (lastI == -1) break;
		}
		return template;
	}

	private String evalAndReplaceCode(String code, String template) throws ModuleException {
		String evalStr = "";
		try {
			evalStr = this.expManager.evaluate(code, this.context).getValue().toString();
			code = Pattern.quote(code);
		} catch (Exception e) {
			e.printStackTrace();
			String errMsg = "Could not evalue expression: " + code;
			throw new ModuleException(errMsg, TemplateParserError.INVALID_EXPRESSION, e);
		}
		return template.replaceAll(code, evalStr);
	}

}
