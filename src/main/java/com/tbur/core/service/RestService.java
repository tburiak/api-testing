package com.tbur.core.service;

import io.restassured.specification.RequestSpecification;

public interface RestService {
    RequestSpecification setUp();
}
