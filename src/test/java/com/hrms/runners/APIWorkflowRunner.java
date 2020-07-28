package com.hrms.runners;
import org.junit.runner.*;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = "APIStepDefinitions", 
		dryRun = false, 
		monochrome = true, 
		strict = false, 
		tags = "@workflow",
		plugin = {
		"pretty", 
		"html:target/Cucumber-Default-Report", 
		"json:target/Cucumber.json",
		"rerun:target/failed.txt"
		}

)
public class APIWorkflowRunner {

}
