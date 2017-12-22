package com.eBRS2.config;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	    @Autowired
	    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;
	
	    @PostConstruct
	    public void init() {
	       requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
	    }
	
		@Override
		public void addResourceHandlers(ResourceHandlerRegistry registry) {
			   registry.addResourceHandler("/resources/**").addResourceLocations("/WEB-INF/css").setCachePeriod(31556926);
			   registry.addResourceHandler("/image/**").addResourceLocations("/WEB-INF/image").setCachePeriod(31556926);
			   registry.addResourceHandler("/font/**").addResourceLocations("/WEB-INF/font").setCachePeriod(31556926);
		       registry.addResourceHandler("/script/**").addResourceLocations("/WEB-INF/script").setCachePeriod(31556926);
		}
		
		@Override
		public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {		
			configurer.enable();
		}
}
