package com.hrms.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/", 
				glue = "StepDefinitions",
				monochrome = true , 
		dryRun = true, 
		strict = true, // checks for for implementation of all Gherkin Steps.
		tags= "@homework",
		plugin= {
				"pretty",
				"html:target/defaultReport"
		}
		
)

public class TestRunner {

}
