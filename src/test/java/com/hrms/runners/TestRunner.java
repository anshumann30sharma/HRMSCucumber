package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", 
<<<<<<< HEAD
				glue = "StepDefinitions",
				monochrome = true , 
		dryRun = true, 
		strict = true, // checks for for implementation of all Gherkin Steps.
		tags= "@homework",
		plugin= {
				"pretty",
				"html:target/defaultReport"
		}
=======
			glue = "StepDefinitions", 
			monochrome = true, 
			dryRun = false, 
			strict = true, // checks for implementation og Gherkin Steps
																														
			tags = "@homework", 
			plugin = { "pretty", 
					"html:target/CcDefaultReport",
					"json:target/cucumber.json"
			}
>>>>>>> 80c8efae0ad278098a36cba3738a121d1f7b7c90
		
		
		)

public class TestRunner {

}
