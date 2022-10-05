package org.mule.extension.html.template.parser.internal;

import java.util.Optional;

import org.mule.runtime.extension.api.error.ErrorTypeDefinition;

public enum TemplateParserError implements ErrorTypeDefinition<TemplateParserError> {
	INVALID_EXPRESSION;
	
    private ErrorTypeDefinition<? extends Enum<?>> parent;

	TemplateParserError(ErrorTypeDefinition<? extends Enum<?>> parent) {
        this.parent = parent;
    }

	TemplateParserError() {
    }

    @Override
    public Optional<ErrorTypeDefinition<? extends Enum<?>>> getParent() {
        return Optional.ofNullable(parent);
    }
    
}
