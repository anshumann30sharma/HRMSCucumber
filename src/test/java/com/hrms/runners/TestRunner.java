package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", 

			glue = "StepDefinitions", 
			monochrome = true, 
			dryRun = false, 
			strict = true, // checks for implementation og Gherkin Steps
																														
			tags = " @smoke", 
			plugin = { "pretty", 
					"html:target/CcDefaultReport",
					"json:target/cucumber.json",
					"rerun:target/failed.txt"
			}

		
		
		)

public class TestRunner {

}
