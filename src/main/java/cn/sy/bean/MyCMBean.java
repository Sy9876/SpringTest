package cn.sy.bean;

public class MyCMBean {

	private static int instanceCount = 0;
	
	private String beanName;

	public MyCMBean() {
		instanceCount++;
		System.out.println("MyCMBean constructor. instanceCount=" + instanceCount);
	}
	
	public MyCMBean(String beanName) {
		instanceCount++;
		this.beanName = beanName;
		System.out.println("MyCMBean constructor2. beanName=" + beanName + "  instanceCount=" + instanceCount);
	}
	
	public static int getInstanceCount() {
		return instanceCount;
	}

	public static void setInstanceCount(int instanceCount) {
		MyCMBean.instanceCount = instanceCount;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}
	
	
}
