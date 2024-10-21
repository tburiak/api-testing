package com.tbur.api.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        glue = {"com.tbur.api.step"},
        features = {"src/test/resources/feature"}
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
