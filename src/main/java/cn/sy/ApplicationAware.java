package cn.sy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

public class ApplicationAware implements ApplicationContextAware,
	ApplicationListener<ContextRefreshedEvent> {

	private final static Logger logger = LoggerFactory.getLogger(ApplicationAware.class);
	
	private static ApplicationContext applicationContext = null;
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		ApplicationAware.applicationContext = applicationContext;
		logger.info("ApplicationAware setApplicationContext start");

	}
	
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String name) throws BeansException {
		return (T) applicationContext.getBean(name);
	}

	public static <T> T getBean(Class<T> requiredType) throws BeansException {
		return applicationContext.getBean(requiredType);
	}


	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		logger.info("ApplicationAware onApplicationEvent start. event: " + event);
		
	}
}
