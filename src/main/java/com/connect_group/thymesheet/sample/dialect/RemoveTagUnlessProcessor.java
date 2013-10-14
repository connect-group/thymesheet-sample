package com.connect_group.thymesheet.sample.dialect;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.NestableNode;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.standard.expression.StandardExpressionProcessor;

public class RemoveTagUnlessProcessor extends BaseAttributeProcessor {

	public RemoveTagUnlessProcessor() {
		super("removetagunless");
	}

	@Override
	protected final ProcessorResult doProcess(final Arguments arguments, AttributeData data) {

        if(!isWrapRequired(arguments, data.attributeValue)) {
        	doNotWrap(data.element);
        }
		
		return ProcessorResult.OK;
	}
	
	private void doNotWrap(Element element) {
		NestableNode parent = element.getParent();
		parent.extractChild(element);
	}
	
	private boolean isWrapRequired(Arguments arguments, String attributeValue) {
		Object result=StandardExpressionProcessor.processExpression(arguments, attributeValue);
		
		if(result==null) return false;
		
		if(result instanceof Boolean) {
			Boolean bool = (Boolean)result;
			return bool;
		}
		
		if(result instanceof Integer) {
			Integer intg = (Integer)result;
			return intg != 0;
		}
		
		if(result instanceof String) {
			return !"off".equalsIgnoreCase((String)result) && !"false".equalsIgnoreCase((String)result) && !"no".equalsIgnoreCase((String)result);
		}
		
		return true;
	}

	@Override
	public int getPrecedence() {
		return 1000;
	}
	
}
