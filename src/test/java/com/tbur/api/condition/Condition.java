package com.tbur.api.condition;

import io.restassured.response.Response;

public interface Condition {
    void check(Response response);
}
