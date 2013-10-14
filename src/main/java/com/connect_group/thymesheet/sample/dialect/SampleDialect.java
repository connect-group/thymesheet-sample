package com.connect_group.thymesheet.sample.dialect;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.processor.IProcessor;


public class SampleDialect extends AbstractDialect {

	public String getPrefix() {
		return "sample";
	}
	
	@Override
	public boolean isLenient() {
		return false;
	}

	@Override
    public Set<IProcessor> getProcessors() {
		final Set<IProcessor> processors = new HashSet<IProcessor>();
		processors.add(new RemoveTagUnlessProcessor());
		return processors;
	}


}
