package org.jsp.cda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {//to communicate other technologies
@Bean
WebMvcConfigurer webConfigurer() {
	return new WebMvcConfigurer() {
		@Override
		public void addCorsMappings(CorsRegistry registry) {
			registry
			.addMapping("/**")
			.allowedMethods("GET","POST","DELETE","PATCH")
			.allowedOrigins("*");
		}
	};
}
}
