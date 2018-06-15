package cn.sy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableLoadTimeWeaving;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.aspectj.EnableSpringConfigured;

import cn.sy.bean.MyCMBean;

@Configuration
//@EnableLoadTimeWeaving
//@EnableSpringConfigured
@ComponentScan(basePackages = "cn.sy")
@PropertySource("classpath:/application.properties")
public class AppConfig {

	@Value("${cn.sy.bean-name}")
	private String myCMBeanName;
	
	@Bean
	public MyCMBean myCMBean() {
		return new MyCMBean(myCMBeanName);
	}
	
	@Bean
	public ApplicationAware applicationAware() {
		return new ApplicationAware();
	}
}
