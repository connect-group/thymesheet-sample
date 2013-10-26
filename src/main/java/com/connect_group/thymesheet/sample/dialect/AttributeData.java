/*
 * =============================================================================
 *
 *   Copyright (c) 2013, Connect Group (http://www.connect-group.com)
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 * =============================================================================
 */
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
