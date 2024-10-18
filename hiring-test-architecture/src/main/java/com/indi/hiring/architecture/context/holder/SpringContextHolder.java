package com.indi.hiring.architecture.context.holder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.indi.hiring.architecture.context.ServiceLocator;

@Service
public class SpringContextHolder implements ContextHolder {

	private final ApplicationContext context;

	@Autowired
	SpringContextHolder(ApplicationContext applicationContext) {
		context = applicationContext;
		if (!ServiceLocator.isInitialized()) ServiceLocator.setContextHolder(this);
	}

	@Override
	public <T> T locate(Class<T> clazz) {
		return context.getBean(clazz);
	}
}
