package com.tbur.api.service;

import com.tbur.api.assertion.AssertableResponse;
import com.tbur.api.payload.CreateUserPayload;
import com.tbur.core.service.RestService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UserService {

    private final RestService restService;

    public AssertableResponse getUsers() {
        return new AssertableResponse(restService.setUp()
                .when().get("users"));
    }

    public AssertableResponse createUser(CreateUserPayload userPayload) {
        return new AssertableResponse(restService.setUp()
                .when()
                .body(userPayload)
                .post("users"));
    }



}
