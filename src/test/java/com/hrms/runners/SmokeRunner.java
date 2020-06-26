package com.hrms.runners;

import org.junit.runner.*;
import io.cucumber.junit.*;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features/", 
		glue = "StepDefinitions", 
		dryRun = false, 
		monochrome = true, 
		strict = true, 
		
		tags="@smoke2",
		plugin = {
		"pretty", 
		"html:target/CcDefaultReport",
		"json:target/cucumber.json",
		"rerun:target/failed.txt"
		}

)

public class SmokeRunner {

}
