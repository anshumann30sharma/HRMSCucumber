package StepDefinitions;

import com.hrms.testbase.BaseClass;

import io.cucumber.java.*;

public class Hooks {
	
	@Before
	public void start() {
		BaseClass.setUp();
	}
	
	@After
	public void end() {
		BaseClass.tearDown();;
	}

}
