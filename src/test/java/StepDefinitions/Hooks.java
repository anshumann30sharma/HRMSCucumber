package StepDefinitions;

import org.junit.BeforeClass;


import com.hrms.testbase.*;
import com.hrms.utils.*;
import io.cucumber.java.*;
import io.cucumber.java.Before;

public class Hooks {
	
	@Before
	public void start() {
		BaseClass.setUp();

	}
	
//	@Before
//	public void DBconnection() {
//		JDBCUtil.DBConnection();
//	}
	
	@After
	public void closeDB() {
		JDBCUtil.closeDB();
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
