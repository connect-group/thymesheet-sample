package com.connect_group.thymesheet.sample.dialect;

import javax.servlet.ServletContext;

import org.thymeleaf.Arguments;
import org.thymeleaf.dom.Element;
import org.thymeleaf.dom.Node;
import org.thymeleaf.processor.AbstractProcessor;
import org.thymeleaf.processor.AttributeNameProcessorMatcher;
import org.thymeleaf.processor.IAttributeNameProcessorMatcher;
import org.thymeleaf.processor.IProcessorMatcher;
import org.thymeleaf.processor.ProcessorMatchingContext;
import org.thymeleaf.processor.ProcessorResult;
import org.thymeleaf.spring3.context.SpringWebContext;
import org.thymeleaf.standard.expression.StandardExpressionProcessor;

/**
 * A processor base class that can handle both attribute and DOM manipulation.
 * @author adam
 *
 */
public abstract class BaseAttributeProcessor extends AbstractProcessor {
	
	private final IAttributeNameProcessorMatcher matcher;
	
	public BaseAttributeProcessor(String attributeNameWithoutNamespace) {
		matcher = new AttributeNameProcessorMatcher(attributeNameWithoutNamespace);
	}
	
	@Override
	protected final ProcessorResult doProcess(final Arguments arguments, final ProcessorMatchingContext processorMatchingContext, final Node node) {
		Element element = (Element)node;
		String attributeName = getAttributeName(processorMatchingContext, element);
		ServletContext ctx = getServletContext(arguments);
		Object evaluated = StandardExpressionProcessor.processExpression(arguments, element.getAttributeValue(attributeName));
		String contextRoot = getContextRoot(arguments);
		
		AttributeData attrData = new AttributeData(attributeName, element, ctx, evaluated, contextRoot);
		
		ProcessorResult result = doProcess(arguments, attrData);
		attrData.element.removeAttribute(attrData.attributeName);
		return result;
	}
	

	public final IProcessorMatcher<? extends Node> getMatcher() {
		return matcher;
	}
	

    protected final String defaultToEmpty(final String str) {
        return (str == null? "" : str);
    }
    
    protected final String defaultToNull(final String str) {
        return ((str != null && str.length() == 0)? null : str);
    }
	
	protected abstract ProcessorResult doProcess(final Arguments arguments, AttributeData data);
	
	protected String getAttributeName(final ProcessorMatchingContext processorMatchingContext, Element element) {
		String result = "";
		String[] attributeNames = this.matcher.getAttributeNames(processorMatchingContext);
		if(attributeNames!=null && attributeNames.length>0) {
	        for (final String attributeName : attributeNames) {
	            if (element.hasNormalizedAttribute(attributeName)) {
	                result = attributeName;
	                break;
	            }
	        }
		}
		return result;
	}
	
	private ServletContext getServletContext(Arguments arguments) {
        SpringWebContext ctx = (SpringWebContext)arguments.getContext();
        ServletContext application = ctx.getServletContext();
        return application;
	}
	
	private String getContextRoot(Arguments arguments) {
		String root=(String) StandardExpressionProcessor.processExpression(arguments, "@{'/'}");
		return root;
	}

}

