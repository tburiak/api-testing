package com.tbur.api.step;

import com.tbur.api.assertion.AssertableResponse;
import com.tbur.api.condition.ConditionUtils;
import com.tbur.api.payload.CreateUserPayload;
import com.tbur.api.response.CreateUserResponse;
import com.tbur.api.service.UserService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static java.lang.String.format;
import static java.net.HttpURLConnection.HTTP_CREATED;
import static java.net.HttpURLConnection.HTTP_OK;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.notNullValue;

public class UserStepDefinitions {

    @Autowired
    private UserService userService;

    private AssertableResponse users;

    @When("The user has requested all users")
    public void user_has_requested_all_users() {
        users = userService.getUsers();
        users.shouldHave(ConditionUtils.statusCode(HTTP_OK));
    }

    @Then("The user {}, {} should be returned")
    public void user_should_be_returned(String lastName, String firstName) {
        String jsonPath = format("data.find { it.first_name=='%s' && it.last_name=='%s'}", firstName, lastName);
        users.shouldHave(ConditionUtils.bodyField(jsonPath, notNullValue()));
    }

    @Given("The user can create new users")
    public void user_can_create_new_user(List<CreateUserPayload> createUserPayloads) {
        createUserPayloads.forEach(it -> {
            CreateUserResponse createUserResponse = userService.createUser(it)
                    .shouldHave(ConditionUtils.statusCode(HTTP_CREATED))
                    .asPojo(CreateUserResponse.class);
            assertThat(createUserResponse.getId()).isPositive();
        });
    }



}
