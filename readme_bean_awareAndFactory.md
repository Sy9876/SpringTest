# spring bean
----


## 容器的配置

- 基于XML：传统的xml中定义<bean>的方式
- 基于注解： 在class上使用@Controller, @Service, @Repository, @Component等注解的方式
- 基于java：在@Configuration注解的class中使用@Bean, @Import, @DependsOn等注解把POJO声明为Bean的方式

## 初始化容器

基于XML

```
	ApplicationContext context =
		new ClassPathXmlApplicationContext(new String[] {"services.xml", "daos.xml"});
```


基于java

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

## bean

- class, name, scope
- DI: 基于constructor, 基于properties
- lazy-initialization
- callbacks: initialization, destruction

## bean 生命周期及回调

### BeanFactory

操作spring容器的顶层接口。有getBean等方法。

ApplicationContext是它的子接口。


### FactoryBean

使用getBean("factoryBeanName")能够得到getObject返回的bean。

使用getBean("&factoryBeanName")得到的才是factory bean的实例。

可以把FactoryBean的name定义为bean的name，这样就可以自动注入。



### Aware

- ApplicationContextAware

实现了此接口的spring bean，可用得到ApplicationContext，进而可用getBean获得其它bean。




### InitializingBean

spring bean，实现InitializingBean接口的afterPropertiesSet后，会得到回调

### @PostConstruct

spring bean，使用@PostConstruct注解一个方法，则会得到回调。

与afterPropertiesSet相似，不过此注解不是spring注解，而是JSR-250的，更具通用性


### DisposableBean

spring bean，实现DisposableBean接口的destroy后，会得到回调。

但是要注意，需要使用AbstractApplicationContext.registerShutdownHook()注册才可以

```
    	ApplicationContext ctx = new AnnotationConfigApplicationContext(
    			AppConfig.class);
    	
    	((AbstractApplicationContext) ctx).registerShutdownHook();
```

### Lifecycle

实现了LifecycleProcessor，但只有isRunning被回调。。。


### BeanPostProcessor


## properties引用



