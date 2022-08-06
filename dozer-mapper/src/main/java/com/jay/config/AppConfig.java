package com.jay.config;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

  @Bean
  public DozerBeanMapper dozerBeanMapper() {
    return new DozerBeanMapper();
  }
}
