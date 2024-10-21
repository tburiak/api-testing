package com.tbur.api.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@Configuration
@ComponentScan(basePackages = {"com.tbur.core", "com.tbur.api"})
public class TestContextConfiguration {

}
