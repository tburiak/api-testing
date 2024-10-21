package com.tbur.api.step;

import com.tbur.api.configuration.TestContextConfiguration;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = {TestContextConfiguration.class})
@CucumberContextConfiguration
public class AbstractStepDefinition {
}
