package cn.sy.bean.factoryBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;

public class MyComplexBeanFactoryBean implements FactoryBean<MyComplexBean> {

	private final static Logger logger = LoggerFactory.getLogger(MyComplexBeanFactoryBean.class);
	
	private static int instanceCount = 0;

	public MyComplexBeanFactoryBean() {
		instanceCount++;
		logger.info("MyComplexBeanFactoryBean constructor. instanceCount=" + instanceCount);
	}

	@Override
	public MyComplexBean getObject() throws Exception {
		
		logger.info("MyComplexBeanFactoryBean getObject.");
		MyComplexBean myComplexBean = new MyComplexBean();
		
		myComplexBean.setProp(System.getProperties());
		
		return myComplexBean;
	}

	@Override
	public Class<?> getObjectType() {
		logger.info("MyComplexBeanFactoryBean getObjectType.");
		return MyComplexBean.class;
	}

	@Override
	public boolean isSingleton() {
		logger.info("MyComplexBeanFactoryBean isSingleton.");
		return true;
	}

	

}
