package com.prototype;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.apachecommons.CommonsLog;

@CommonsLog
@Configuration
@EnableWebMvc
public class WebMvcConfig implements WebMvcConfigurer {

	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		log.info("----- WebMvcConfig | addResourceHandlers -----");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}