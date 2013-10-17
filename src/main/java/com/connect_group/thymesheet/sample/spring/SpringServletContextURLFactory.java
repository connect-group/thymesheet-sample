package com.connect_group.thymesheet.sample.spring;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;

import com.connect_group.thymesheet.ServletContextURLFactory;

public class SpringServletContextURLFactory implements ServletContextURLFactory, ServletContextAware {

	private ServletContext servletContext;
	
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public URL getURL(String filePath) throws MalformedURLException {
		return servletContext.getResource(filePath);
	}

}
