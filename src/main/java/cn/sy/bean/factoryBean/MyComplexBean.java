package cn.sy.bean.factoryBean;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyComplexBean {

	private final static Logger logger = LoggerFactory.getLogger(MyComplexBean.class);
			
	private Properties prop;

	private static int instanceCount = 0;

	public MyComplexBean() {
		instanceCount++;
		logger.info("MyComplexBean constructor. instanceCount=" + instanceCount);
	}
	
	public Properties getProp() {
		logger.info("MyComplexBean getProp");
		return prop;
	}

	public void setProp(Properties prop) {
		logger.info("MyComplexBean setProp");
		this.prop = prop;
	}
	
	public String showProps() {
		logger.info("MyComplexBean showProps");
		return prop.toString();
	}
}
