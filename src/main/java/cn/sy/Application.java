package cn.sy;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import cn.sy.controller.KafkaMsgController;

public class Application {

//	public static void test(ApplicationContext ctx) {
//		KafkaMsgController kafkaMsgController = ctx.getBean(KafkaMsgController.class);
//    	try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//
//		}
//    	kafkaMsgController.sendKafkaMsgStr();
//    	try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//
//		}
//    	kafkaMsgController.sendKafkaMsg2();
//	}
//	
//    public static void main(String[] args) {
//    	ApplicationContext ctx = new AnnotationConfigApplicationContext(
//    			AppConfig.class, KafkaConfig.class);
//    	
//    	Application.test(ctx);
//    	
//    	for(;;) {
//    		try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//				break;
//			}
//    	}
//    }

}
