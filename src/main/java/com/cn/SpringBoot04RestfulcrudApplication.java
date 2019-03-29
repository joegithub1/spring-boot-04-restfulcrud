package com.cn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.Nullable;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class SpringBoot04RestfulcrudApplication {
	/**
	 * 静态资源那可以放在以下路径
	 *
	 * private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
	 "classpath:/META-INF/resources/", "classpath:/resources/",
	 "classpath:/static/", "classpath:/public/" };
	 *
	 *favicon.ico  标题图标
	 * xxx.index.html 默认首页
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot04RestfulcrudApplication.class, args);
	}
	@Bean
	public MyViewResolver myViewResolver(){
		return new MyViewResolver();
	}
	private static class MyViewResolver implements ViewResolver{
		@Nullable
		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			return null;
		}
	}
}

