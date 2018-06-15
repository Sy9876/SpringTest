# spring test
----

基于注解配置的spring环境。开启了webMVC。可以打成war包放到tomcat中运行。

## spring configure （无webMVC时的配置）

Application.java的main函数中，创建AnnotationConfigApplicationContext。

传入带有@Configuration注解的类。

``` java
    public static void main(String[] args) {
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(
    			AppConfig.class, xxx.class);
```

AppConfig.java中，使用@Configuration注解，并使用@Bean配置bean。

``` java
@Configuration
@ComponentScan(basePackages = "cn.sy")
@PropertySource("classpath:/application.properties")
public class AppConfig {
	@Bean
	......
}
```

## webMVC

需要使用@EnableWebMvc注解开启webMVC。

继承WebApplicationInitializer，创建AnnotationConfigWebApplicationContext，
并注册dispatcher servlet。

``` java
public class MyWebApplicationInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {

    	AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
    	ctx.register(AppConfig.class, xxx.class);
    			
        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(ctx));
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        
    }


}
```

maven依赖增加

```
        <dependency>
           <groupId>javax.servlet</groupId>
           <artifactId>javax.servlet-api</artifactId>
           <scope>provided</scope>
        </dependency>
 		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-web</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework</groupId>
			<artifactId>spring-webmvc</artifactId>
		</dependency>
```

在maven-war-plugin中配置不需要web.xml。

```
	        <plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-war-plugin</artifactId>
				<configuration>
					<failOnMissingWebXml>false</failOnMissingWebXml>
				</configuration>
	        </plugin>
```



## spring kafka

（参考spring kafka分支）

@EnableKafka开启kafka，

配置KafkaListenerContainerFactory用于consumer

配置kafkaTemplate用于producer

## 测试

- http://localhost:8080/SpringTest/public/sendKafkaMsgStr.do
- http://localhost:8080/SpringTest/public/sendKafkaMsgInt.do
- http://localhost:8080/SpringTest/public/sendKafkaMsg.do
- http://localhost:8080/SpringTest/public/sendKafkaMsg2.do
