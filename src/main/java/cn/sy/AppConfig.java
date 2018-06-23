package cn.sy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import cn.sy.bean.MyCMBean;
import cn.sy.bean.MyDisposableBean;
import cn.sy.bean.MyInitializingBean;
import cn.sy.bean.MyLifecycleBean;
import cn.sy.bean.MyPostConstructBean;
import cn.sy.bean.MyPreDestroyBean;
import cn.sy.bean.factoryBean.MyComplexBeanFactoryBean;
import cn.sy.bean.factoryBean.MyComplexBeanHolder;

@Configuration
@ComponentScan(basePackages = "cn.sy")
@PropertySource("classpath:/application.properties")
public class AppConfig {

	@Value("${cn.sy.bean-name}")
	private String myCMBeanName;
	
//	@Bean
	public MyCMBean myCMBean() {
		return new MyCMBean(myCMBeanName);
	}

//	@Bean
	public MyInitializingBean myInitializingBean() {
		return new MyInitializingBean();
	}
	
//	@Bean
	public MyPostConstructBean myPostConstructBean() {
		return new MyPostConstructBean();
	}
	
//	@Bean
	public MyDisposableBean myDisposableBean() {
		return new MyDisposableBean();
	}	
	
//	@Bean
	public MyPreDestroyBean myPreDestroyBean() {
		return new MyPreDestroyBean();
	}

//	@Bean
	public MyLifecycleBean myLifecycleBean() {
		return new MyLifecycleBean();
	}
	
	@Bean(name="myComplex")
	public MyComplexBeanFactoryBean myComplexBean() {
		return new MyComplexBeanFactoryBean();
	}
	
	@Bean
	public MyComplexBeanHolder myComplexBeanHolder() {
		return new MyComplexBeanHolder();
	}
	
	@Bean
	public ApplicationAware applicationAware() {
		return new ApplicationAware();
	}
}
