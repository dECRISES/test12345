package org.dfm.test.12345.cucumber;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", strict = true, plugin = {"json:target/cucumber/test12345.json", "json:target/cucumber/test12345.xml"}, tags = {
    "@Test12345"}, glue = "classpath:org.dfm.test.12345.cucumber")
public class RunCucumberTest12345Test {

}
