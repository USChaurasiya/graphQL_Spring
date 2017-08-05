package com.uma.graphql.demo.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;


public class SampleAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	 @Override
	    protected Class<?>[] getRootConfigClasses() {
	        return new Class[] { SampleAppConfiguration.class };
	    }
	  
	    @Override
	    protected Class<?>[] getServletConfigClasses() {
	        return new Class[] { MVCAppContext.class };
	    }

	    @Override
	    protected String[] getServletMappings() {
	        return new String[] { "/" };
	    }

	    @Configuration
	    @EnableWebMvc
	    @ComponentScan("com.uma.graphql.demo.controller")
	    public static class MVCAppContext extends WebMvcConfigurerAdapter {

	        @Override
	        public void addResourceHandlers(final ResourceHandlerRegistry registry) {
	            registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	        }

	        @Bean
	        public ViewResolver setupViewResolver() {
	            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
	            viewResolver.setViewClass(JstlView.class);
	            viewResolver.setPrefix("/resources/graphiql");
	            viewResolver.setSuffix(".html");
	            return viewResolver;
	        }
	    }
}
