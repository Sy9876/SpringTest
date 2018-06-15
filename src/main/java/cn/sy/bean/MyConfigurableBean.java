package cn.sy.bean;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

/**
 * 参见spring手册【11.8.1 Using AspectJ to dependency inject domain objects with Spring】
 * 
 * 1 使用@Configurable标注bean
 * 2 然后在带有@Configuration的类中声明@EnableSpringConfigured和@EnableLoadTimeWeaving
 * 3 pom中添加依赖： org.springframework.spring-aspects org.springframework-spring-instrument
 * 4 最重要的一点是，要启用LoadTimeWeaving（LTW），需要在jvm启动参数中追加：
 *   -javaagent:/path/to/spring-instrument-x.x.x.RELEASE.jar
 *
 */
@Configurable(autowire=Autowire.BY_TYPE,dependencyCheck=true)
public class MyConfigurableBean {

	private static int instanceCount = 0;
	
	@Autowired
	private MyCMBean myCMBean;

	public MyConfigurableBean() {
		instanceCount++;
		System.out.println("MyConfigurableBean constructor. instanceCount=" + instanceCount);
	}
	
	public static int getInstanceCount() {
		return instanceCount;
	}

	public static void setInstanceCount(int instanceCount) {
		MyConfigurableBean.instanceCount = instanceCount;
	}

	public String showCMBean() {
		String n = myCMBean.getBeanName();
		return n;
	}
	
}
