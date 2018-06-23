package cn.sy.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;

public class MyDisposableBean implements DisposableBean {

	private final static Logger logger = LoggerFactory.getLogger(MyDisposableBean.class);
	
	private static int instanceCount = 0;

	public MyDisposableBean() {
		instanceCount++;
		logger.info("MyDisposableBean constructor. instanceCount=" + instanceCount);
	}

	@Override
	public void destroy() throws Exception {
		instanceCount--;
		logger.info("MyDisposableBean destroy. instanceCount=" + instanceCount);
		
	}

	

}
