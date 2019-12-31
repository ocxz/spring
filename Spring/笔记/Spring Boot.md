# 四、Web开发

## 1、简介

## 2、SpringBoot对静态资源文件的映射

## 3、模板引擎

## 4、SpringMVC自动配置

[自动配置文档](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-features-developing-web-applications)

### 1、 Spring MVC Auto-configuration

Spring Boot已经自动配置好了SpringMVC

​	自动装配类：WebMvcAutoConfiguration

以下是SpringBoot对SpringMVC的默认配置：

- Inclusion of `ContentNegotiatingViewResolver` and `BeanNameViewResolver` beans.
  - 自动配置了ViewResolver（视图解析器：根据方法的返回值获得视图对象（View），视图对象决定如何渲染（包括：转发、重定向……））
  - ContentNegotiatingViewResolver ：组合获取所有的视图解析器（从ioc容器中获取，后组合）
  - 定制视图解析器：只需要将视图解析器放入到IOC容器中，Spring Boot就会自动将其组合进来
- Support for serving static resources, including support for WebJars (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-static-content))). 静态资源文件夹路径和webjars
- Static `index.html` support. 静态首页访问
- Custom `Favicon` support (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-favicon)).
- Automatic registration of `Converter`, `GenericConverter`, and `Formatter` beans.（自动注册）
  -  `Converter`：转换器，将网页字符数据转成Java类数据
  - `Formatter`：格式化器；2017-12-12  --> Date类型
- Support for `HttpMessageConverters` (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-message-converters)).
  - `HttpMessageConverters` ：消息转换器，SpringMVC中用来转换Http请求和响应的，如：对象 --> Json格式数据，**是从容器获取的**
- Automatic registration of `MessageCodesResolver` (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-features-spring-message-codes)).
  - `MessageCodesResolver` ：消息解析器，定义错误代码生成规则
- Automatic use of a `ConfigurableWebBindingInitializer` bean (covered [later in this document](https://docs.spring.io/spring-boot/docs/2.1.3.RELEASE/reference/htmlsingle/#boot-features-spring-mvc-web-binding-initializer)).
  - ​

If you want to keep Spring Boot MVC features and you want to add additional [MVC configuration](https://docs.spring.io/spring/docs/5.1.5.RELEASE/spring-framework-reference/web.html#mvc) (interceptors, formatters, view controllers, and other features), you can add your own `@Configuration` class of type `WebMvcConfigurer` but **without** `@EnableWebMvc`. If you wish to provide custom instances of `RequestMappingHandlerMapping`, `RequestMappingHandlerAdapter`, or `ExceptionHandlerExceptionResolver`, you can declare a `WebMvcRegistrationsAdapter` instance to provide such components.

If you want to take complete control of Spring MVC, you can add your own `@Configuration` annotated with `@EnableWebMvc`.

### 2、扩展SpringMVC的功能

```xml
	<mvc:view-controller path="/helloworld" view-name="success"/>
	<mvc:interceptors>
		<mvc:interceptor>
			<mvc:mapping path="/hello"/>
			<bean></bean>
		</mvc:interceptor>
	</mvc:interceptors>
```

**做法：编写一个配置类（`@Configuration` )，此类是`WebMvcConfigurer` （接口）类型，不能标注 `@EnableWebMvc`，要什么功能，重写什么方法即可**

```java
/**
 * 实现WebMvcConfigurer接口，扩展SpringMVC的功能
 * 需要扩展什么功能，就重写实现WebMvcConfigurer中的哪个方法
 * @author 22527
 *
 */
@Configuration
public class WebMvcConf implements WebMvcConfigurer {
	
	/**
	 * 	实现addViewControllers的功能，相当于：
	 * 		<mvc:view-controller path="/helloworld" view-name="success"/>
	 */
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
//		WebMvcConfigurer.super.addViewControllers(registry);
		registry.addViewController("/helloworld2").setViewName("success");
	}
}

```

原理：

​	1）、WebMvcAutoConfiguration是SpringMVC的自动配置类

​	2）、WebMvcAutoConfigurationAdapter 也是继承了 WebMvcConfigurer，重写WebMvcConfigurer中的方法

```java
public static class EnableWebMvcConfiguration extends DelegatingWebMvcConfiguration{
  private final WebMvcConfigurerComposite configurers = new WebMvcConfigurerComposite();
  
  // 从容器中获取所有的WebMvcConfigurer
  	@Autowired(required = false)
	public void setConfigurers(List<WebMvcConfigurer> configurers) {
		if (!CollectionUtils.isEmpty(configurers)) {
			this.configurers.addWebMvcConfigurers(configurers);
          // 一个参考实现，将所有WebMvcConfigurer相关的配置都一起作用
          	@Override
              public void addViewControllers(ViewControllerRegistry registry) {
                   // 将所有WebMvcConfigurer相关的配置都一起作用
                  for (WebMvcConfigurer delegate : this.delegates) {
                      delegate.addViewControllers(registry);
                  }
              }
		}
	}
}
```

​	3）、容器中所有的WebMvcConfigurer都会一起作用，即我们配置的类也会被调用

   	4）、效果SpringMVC的自动配置和我们的扩展配置都会起作用

### 3、全面接管SpringMVC

意思：SpringBoot对SpringMVC的自动配置不需要了，所有配置都是我们自己来配

做法：我们需要在配置类行添加`@EnableWebMvc`即可

效果：只有我们有一个配置类，添加了`@EnableWebMvc`注解，那么WebMvcAutoConfiguration自动配置类就会失效，就只会按照我们写的配置类来配置SpringMVC

原理：

​	1）EnableWebMvc的核心

```java
// 导入DelegatingWebMvcConfiguration组件（即WebMvcConfigurationSupport类型组件）
@Import(DelegatingWebMvcConfiguration.class)
public @interface EnableWebMvc {}
```

​	2）DelegatingWebMvcConfiguration

```java
public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport {}
```

​	3）WebMvcAutoConfiguration

```java
@Configuration(proxyBeanMethods = false)
@ConditionalOnWebApplication(type = Type.SERVLET)
@ConditionalOnClass({ Servlet.class, DispatcherServlet.class, WebMvcConfigurer.class })
// 容器中没有WebMvcConfigurationSupport组件时，WebMvcAutoConfiguration自动配置类才生效
@ConditionalOnMissingBean(WebMvcConfigurationSupport.class)
@AutoConfigureOrder(Ordered.HIGHEST_PRECEDENCE + 10)
@AutoConfigureAfter({ DispatcherServletAutoConfiguration.class, TaskExecutionAutoConfiguration.class,
		ValidationAutoConfiguration.class })
public class WebMvcAutoConfiguration {……}
```

​	4）总结：`@EnableWebMvc`将WebMvcConfigurationSupport类型组件导入到了IOC容器中，而使得WebMvcAutoConfiguration基本配置类失效

​	5）而导入的WebMvcConfigurationSupport就只是SpringMVC的一些最基本的功能

## 5、如何修改SpringBoot默认配置

#### SpringBoot注册组件模式：

1、先看容器中有没有用户自己配置的，有就是要用户配置的、没有自动配置，如果可以有多个（如ViewResolver)则会将用户配置和自定义配置组合起来

2、在SpringBoot中会有非常多的xxxConfigure，帮助我们进行扩展配置