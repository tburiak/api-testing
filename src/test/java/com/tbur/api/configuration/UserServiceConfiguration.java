package com.tbur.api.configuration;

import com.tbur.api.service.UserService;
import com.tbur.core.service.RestService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserServiceConfiguration {

    @Bean
    public UserService userService(RestService restService) {
        return new UserService(restService);
    }

}
