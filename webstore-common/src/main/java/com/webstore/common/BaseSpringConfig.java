package com.webstore.common;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.webstore.common.repository.impl"})
public class BaseSpringConfig {

}
