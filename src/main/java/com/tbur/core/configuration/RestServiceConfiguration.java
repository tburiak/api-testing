package com.tbur.core.configuration;

import com.tbur.core.service.BaseRestService;
import com.tbur.core.service.RestService;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({PropertiesConfiguration.class})
public class RestServiceConfiguration {

    @Bean
    RestService restService(PropertiesConfiguration propertiesConfiguration) {
        return new BaseRestService(propertiesConfiguration);
    }

}
