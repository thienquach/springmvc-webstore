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
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

import com.webstore.common.SpringDataConfig;
import com.webstore.common.SpringJPAConfig;


@Import(value = { SpringJPAConfig.class, SpringDataConfig.class })
@EnableWebMvc
@ComponentScan(basePackages = {"com.webstore.console.controller", "com.webstore.service.impl", "com.webstore.console.editor"})
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
	
	@Bean(name = "tilesViewResolver")
	public TilesViewResolver getTilesViewResolver(){
		TilesViewResolver resolver = new TilesViewResolver();
		resolver.setOrder(-2);
		resolver.setViewClass(TilesView.class);
		
		return resolver;
	}
	
	@Bean(name="tilesConfigurer")
	public TilesConfigurer getTilesConfigurer(){
		TilesConfigurer configurer = new TilesConfigurer();
		configurer.setDefinitions("/WEB-INF/tiles/definitions/tile-definition.xml");
		
		return configurer;
	}
}
