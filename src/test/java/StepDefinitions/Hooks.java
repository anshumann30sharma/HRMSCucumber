package StepDefinitions;

import com.hrms.testbase.*;
import com.hrms.utils.*;
import io.cucumber.java.*;

public class Hooks {
	
//	@Before
//	@ParameterType
	public void start() {
		BaseClass.setUp();
	}
	
	@After
	public void end(Scenario scenario) {
		
		byte[] pic;
		if (scenario.isFailed()) {
			pic=CommonMethod.takeScreenShotCucumber("Failed/"+scenario.getName());
		}else {
			pic=CommonMethod.takeScreenShotCucumber("passed/"+scenario.getName());
		}
		
		scenario.attach(pic, "image/png", scenario.getName());
		
		CommonMethod.wait(2);
		BaseClass.tearDown();
	}

}
