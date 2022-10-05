package org.mule.extension.html.template.parser.internal;

import java.util.HashSet;
import java.util.Set;

import org.mule.runtime.extension.api.annotation.error.ErrorTypeProvider;
import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public class ExecuteErrorsProvider implements ErrorTypeProvider {

	@SuppressWarnings("rawtypes")
	@Override
	public Set<ErrorTypeDefinition> getErrorTypes() {
		HashSet<ErrorTypeDefinition> errors = new HashSet<>();
        errors.add(TemplateParserError.INVALID_EXPRESSION);
        return errors;
	}

}
