package cn.sy.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.Lifecycle;
import org.springframework.context.LifecycleProcessor;

/**
 * LifecycleProcessor extends Lifecycle
 * @author sy
 *
 */
public class MyLifecycleBean implements LifecycleProcessor {

	private final static Logger logger = LoggerFactory.getLogger(MyLifecycleBean.class);
	
	private static int instanceCount = 0;

	public MyLifecycleBean() {
		instanceCount++;
		logger.info("MyLifecycleBean constructor. instanceCount=" + instanceCount);
	}

	@Override
	public void start() {
		logger.info("MyLifecycleBean start");
		
	}

	@Override
	public void stop() {
		logger.info("MyLifecycleBean stop");
		
	}

	@Override
	public boolean isRunning() {
		logger.info("MyLifecycleBean isRunning");
		return false;
	}

	@Override
	public void onRefresh() {
		logger.info("MyLifecycleBean onRefresh");
		
	}

	@Override
	public void onClose() {
		logger.info("MyLifecycleBean onClose");
		
	}

	

}
