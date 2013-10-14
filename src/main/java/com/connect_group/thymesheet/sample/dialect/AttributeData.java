package com.connect_group.thymesheet.sample.dialect;

import javax.servlet.ServletContext;

import org.thymeleaf.dom.Element;

public class AttributeData {
	public final String attributeName;
	public final Element element;
	public final String attributeValue;
	public final ServletContext servletContext;
	public final Object evaluatedAttributeValue;
	public final String evaluatedAttributeValueString;
	public final String contextRoot;
	
	public AttributeData(String attributeName, Element element, ServletContext ctx, Object evaluatedAttributeValue, String contextRoot) {
		this.attributeName = attributeName;
		this.element = element;
		this.attributeValue = element.getAttributeValue(attributeName);
		this.servletContext = ctx;
		this.evaluatedAttributeValue = evaluatedAttributeValue;
		this.contextRoot = contextRoot;
		if(evaluatedAttributeValue!=null) evaluatedAttributeValueString = evaluatedAttributeValue.toString();
		else evaluatedAttributeValueString="";
		
		
	}
	
}
