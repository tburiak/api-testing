package com.tbur.core.configuration;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
@Data
public class PropertiesConfiguration {
    @Value("${logging.enabled}")
    private boolean isLoggingEnabled;

    @Value("${base.url}")
    private String baseUrl;

}
