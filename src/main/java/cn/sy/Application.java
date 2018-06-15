package cn.sy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.sy.bean.MyBean;
import cn.sy.bean.MyCMBean;
import cn.sy.bean.MyConfigurableBean;

public class Application {

	public static void test(ApplicationContext ctx) {
		MyCMBean myCMBean = ctx.getBean(MyCMBean.class);
		System.out.println("Application test myCMBean name=" + myCMBean.getBeanName());
	}
	
	public static void test2(ApplicationContext ctx) {
		MyBean myBean=null;
		try {
			myBean = MyBean.class.newInstance();
			String s=myBean.showCMBean();
			System.out.println("Application test2 myBean.showCMBean=" + s);
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
		System.out.println("Application test3 ctx.getBean myBean.showCMBean=" + s);
		
	}
	
	public static void test4(ApplicationContext ctx) {
		MyConfigurableBean myBean=null;
		try {
			myBean = MyConfigurableBean.class.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		String s=myBean.showCMBean();
		System.out.println("Application test4 MyConfigurableBean.class.newInstance.showCMBean=" + s);
		
	}
	
    public static void main(String[] args) {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(
    			AppConfig.class);
    	
    	System.out.println("Application ApplicationContext initialized");
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    	Application.test2(ctx);

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
