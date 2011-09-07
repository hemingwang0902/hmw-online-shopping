package com.baizhi.commons;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;

public class SpringContext {
	
	private static ApplicationContext applicationContext; // Spring应用上下文环境

	private SpringContext(){}
	
	public static void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		SpringContext.applicationContext = applicationContext;
	}

	/**
	 * @return ApplicationContext
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static Object getBean(String name) throws BeansException {
		return applicationContext.getBean(name);
	}

}
