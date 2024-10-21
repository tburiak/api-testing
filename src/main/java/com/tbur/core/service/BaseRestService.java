package com.tbur.core.service;

import com.tbur.core.configuration.PropertiesConfiguration;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
public class BaseRestService implements RestService{

    private final PropertiesConfiguration properties;

    public RequestSpecification setUp() {
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .baseUri(properties.getBaseUrl())
                .filters(getFilters());
    }


    private List<Filter> getFilters() {
        if (properties.isLoggingEnabled()) {
            return Arrays.asList(
                    new RequestLoggingFilter(),
                    new ResponseLoggingFilter(),
                    new AllureRestAssured());
        }
        return List.of(new AllureRestAssured());
    }
}
