package cn.sy.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sy.ApplicationAware;

public class MyBean {

	private static int instanceCount = 0;
	
//	@Autowired
//	private static MyCMBean myCMBean;
	private MyCMBean myCMBean;

	public MyBean() {
		instanceCount++;
		System.out.println("MyBean constructor. instanceCount=" + instanceCount);
//		myCMBean = ApplicationAware.getApplicationContext().getBean(MyCMBean.class);
		myCMBean = ApplicationAware.getBean(MyCMBean.class);
	}
	
	public static int getInstanceCount() {
		return instanceCount;
	}

	public static void setInstanceCount(int instanceCount) {
		MyBean.instanceCount = instanceCount;
	}

	public String showCMBean() {
		String n = myCMBean.getBeanName();
		return n;
	}
	
}
