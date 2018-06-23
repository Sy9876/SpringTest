package cn.sy.bean.factoryBean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class MyComplexBeanHolder {

	private final static Logger logger = LoggerFactory.getLogger(MyComplexBeanHolder.class);
			
	@Autowired
	@Qualifier("myComplex")
	private MyComplexBean myComplexBean;

	private static int instanceCount = 0;

	public MyComplexBeanHolder() {
		instanceCount++;
		logger.info("MyComplexBeanHolder constructor. instanceCount=" + instanceCount);
	}
	
	public String showMyComplexBean() {
		return myComplexBean.showProps();
	}
	
}
