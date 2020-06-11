package com.hrms.runners;

import org.junit.runner.*;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "/src/test/resources/features/", 
		glue = "StepDefinitions", 
		dryRun = true, 
		monochrome = true, 
		strict = true, 
		plugin = {
		"pretty", "html:target/Cucumber-Default-Report", "json:target/Cucumber.json" }

)

public class SmokeRunner {

}
