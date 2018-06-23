package cn.sy.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sy.ApplicationAware;

public class MyInitializingBean implements InitializingBean {

	private final static Logger logger = LoggerFactory.getLogger(MyInitializingBean.class);
	
	private static int instanceCount = 0;

	public MyInitializingBean() {
		instanceCount++;
		logger.info("MyInitializingBean constructor. instanceCount=" + instanceCount);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		logger.info("MyInitializingBean afterPropertiesSet");
		
	}
	

}
