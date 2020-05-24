package com.example.StarterDemo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebMvc
public class WebConfig extends WebMvcConfigurationSupport  {

  public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**").allowedOrigins("*");
  }
} 
