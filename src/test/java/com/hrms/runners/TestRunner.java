package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/Invalidlogin.feature", 
				glue = "StepDefinitions",
				monochrome = true , 
		dryRun = true, 
		strict = true, // checks for for implementation of all Gherkin Steps.
		tags= "@smoke or @regression"
		
)

public class TestRunner {

}
