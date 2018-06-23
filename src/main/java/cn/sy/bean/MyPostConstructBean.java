package cn.sy.bean;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPostConstructBean {

	private final static Logger logger = LoggerFactory.getLogger(MyPostConstructBean.class);
	
	private static int instanceCount = 0;

	public MyPostConstructBean() {
		instanceCount++;
		logger.info("MyPostConstructBean constructor. instanceCount=" + instanceCount);
	}

	@PostConstruct
	public void myMethod() {
		logger.info("@PostConstruct myMethod");
		
	}
	

}
