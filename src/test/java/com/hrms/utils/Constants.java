package com.hrms.utils;

public class Constants {
	
	public static final String PROPERITESFILE_PATH= System.getProperty("user.dir")+"/src/test/resources/Configs/Configuration.properties";
	
	public static int IMPLICIT_WAIT_TIME=10;
	public static int EXPLICIT_WAIT_TIME=10;
	
	public static final String TEST_DATA_FILEPATH= System.getProperty("user.dir") + "/src/test/resources/testdata/";
	
	public static final String PROJECT_URL="http://18.232.148.34/humanresources/symfony/web/index.php/admin/employmentStatus";
	public static final String USER_ID="Admin";
	public static final String PASSWORD="Hum@nhrm123";
	public static final String BROWSER="chrome";
	
	public static final String REPORT_FILEPATH=System.getProperty("user.dir")+"/target/html-report/";
	
	public static final String SCREENSHOT_FILEPATH=System.getProperty("user.dir")+"/target/ScreenShots/";
}
