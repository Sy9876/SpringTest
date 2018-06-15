package cn.sy;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

    	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    	ctx.register(AppConfig.class, KafkaConfig.class);
    			
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        
    }


}
