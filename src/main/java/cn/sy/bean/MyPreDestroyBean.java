package cn.sy.bean;

import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyPreDestroyBean {

	private final static Logger logger = LoggerFactory.getLogger(MyPreDestroyBean.class);
	
	private static int instanceCount = 0;

	public MyPreDestroyBean() {
		instanceCount++;
		logger.info("MyPreDestroyBean constructor. instanceCount=" + instanceCount);
	}

	@PreDestroy
	public void myMethod() throws Exception {
		instanceCount--;
		logger.info("MyPreDestroyBean destroy. instanceCount=" + instanceCount);
		
	}

	

}
