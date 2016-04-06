package com.webstore.console;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.webstore.common.BaseSpringConfig;
import com.webstore.common.SpringJPAConfig;


@Import(value = { SpringJPAConfig.class, BaseSpringConfig.class })
@EnableWebMvc
@ComponentScan(basePackages = {"com.webstore.console.controller", "com.webstore.service.impl"})
@Configuration
public class SpringMVCConfig extends WebMvcConfigurerAdapter {

	@Autowired
	ServletContext servletContext;
	
	//Add bean for InternalResourceViewResolver
	@Bean(name = "internalResourceViewResolver")
	public InternalResourceViewResolver getInternalResourceViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
}
