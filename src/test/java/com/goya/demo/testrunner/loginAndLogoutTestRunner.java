package com.goya.demo.testrunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "./src/test/resources/features/login.feature",
        glue = {"com/goya/demo/stepdefs"},
        plugin = {"pretty", "html:target/cucumber-reports/goya.html","json:target/cucumber-reports/goya.json", "junit:target/cucumber-reports/goya.xml" },
        tags="@Goya_Login",
        monochrome = true)

public class loginAndLogoutTestRunner {
}
