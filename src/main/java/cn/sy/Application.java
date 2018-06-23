package cn.sy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import cn.sy.bean.MyBean;
import cn.sy.bean.MyCMBean;
import cn.sy.bean.factoryBean.MyComplexBean;
import cn.sy.bean.factoryBean.MyComplexBeanHolder;

public class Application {

	private final static Logger logger = LoggerFactory.getLogger(Application.class);
	
	public static void test(ApplicationContext ctx) {
		MyCMBean myCMBean = ctx.getBean(MyCMBean.class);
		logger.info("Application test myCMBean name=" + myCMBean.getBeanName());
	}
	
	public static void test2(ApplicationContext ctx) {
		MyBean myBean=null;
		try {
			myBean = MyBean.class.newInstance();
			String s=myBean.showCMBean();
			logger.info("Application test2 myBean.showCMBean=" + s);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void test3(ApplicationContext ctx) {
		MyBean myBean=null;
		myBean = ctx.getBean(MyBean.class);
		String s=myBean.showCMBean();
		logger.info("Application test3 ctx.getBean myBean.showCMBean=" + s);
		
	}
	
	public static void test4(ApplicationContext ctx) {
		MyComplexBean bean = ctx.getBean("myComplexBeanFactoryBean", MyComplexBean.class);
		String s=bean.showProps();
		logger.info("Application test4 ctx.getBean factory bean. " + s);
		
	}

	public static void test5(ApplicationContext ctx) {
		MyComplexBeanHolder bean = ctx.getBean("myComplexBeanHolder", MyComplexBeanHolder.class);
		String s=bean.showMyComplexBean();
		logger.info("Application test5 ctx.getBean myComplexBeanHolder. " + s);
		
	}

    public static void main(String[] args) {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(
    			AppConfig.class);
    	
    	// 注册shutdown hook，使Disposable bean得到回调
    	((AbstractApplicationContext) ctx).registerShutdownHook();
    	
    	logger.info("Application ApplicationContext initialized");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
//    	Application.test(ctx);
    	Application.test5(ctx);


//    	for(;;) {
//    		try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				break;
//			}
//    	}
    }

}
