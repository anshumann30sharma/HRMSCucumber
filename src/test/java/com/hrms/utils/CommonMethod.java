package com.hrms.utils;

import java.io.*;
import java.text.*;
import java.util.*;
import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import com.hrms.testbase.PageInitializer;

public class CommonMethod extends PageInitializer {

	public static String destinationfile = "";

	/**
	 * Method that clears and send keys
	 * 
	 * @param element
	 * @param text
	 * @param space
	 */

	public static void sendText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);

	}

	public static void sendTextWithSpace(WebElement element, String text, Keys space) {
		element.clear();
		element.sendKeys(text);
		element.sendKeys(space);
	}

	/**
	 * This Method checks if radio/checkbox is enabled and clicks it.
	 * 
	 * @param radioOrcheckbox
	 * @param value
	 */

	public static void clickRadioOrCheckBox(List<WebElement> radioOrcheckbox, String value) {
		String actualValue;
		for (WebElement element : radioOrcheckbox) {
			actualValue = element.getAttribute("value").trim();
			if (element.isEnabled() && actualValue.equals(value)) {
				element.click();
				break;
			}
		}
	}

	/**
	 * Method to Select dropdown list by Visible Text
	 * 
	 * @param element
	 * @param textToSelect
	 */

	public static void selectDdValue(WebElement element, String textToSelect) {

		try {
			Select select = new Select(element);
			select.selectByVisibleText(textToSelect);

			List<WebElement> option = select.getOptions();

			for (WebElement ele : option) {
				String str = ele.getText().trim();
				if (str.equals(textToSelect.trim())) {
					select.selectByVisibleText(str);
					break;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method to Select dropdown list by index
	 * 
	 * @param element
	 * @param index
	 */

	public static void selectDDByIndex(WebElement element, int index) {

		try {
			Select select = new Select(element);
			List<WebElement> option = select.getOptions();

			if (index < option.size()) {
				select.selectByIndex(index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method is for accepting Alert.
	 */

	public static void acceptAlert() {

		try {

			Alert alert = driver.switchTo().alert();
			alert.accept();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * this method is for dismissing alert and catching exceptions if Alert is not
	 * Present.
	 */

	public static void dismissAlert() {

		try {

			Alert alert = driver.switchTo().alert();
			alert.dismiss();

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This method will return AlertText
	 * 
	 * @return Alert Text
	 */
	public static String getAlertText() {
		String message = null;
		try {
			Alert alert = driver.switchTo().alert();
			message = alert.getText();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		return message;
	}

	/**
	 * This Method Sends text to Alert text box
	 * 
	 * @param Text
	 */
	public static void SendAlertText(String Text) {
		try {
			Alert alert = driver.switchTo().alert();
			alert.sendKeys(Text);

		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This Method will switch focus to frame by Name or ID
	 * 
	 * @param nameOrId
	 */

	public static void switchToFrame(String nameOrId) {

		try {
			driver.switchTo().frame(nameOrId);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method will switch focus to frame by WebElement
	 * 
	 * @param element
	 */
	public static void switchToFrame(WebElement element) {

		try {
			driver.switchTo().frame(element);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * This Method will switch focus to frame by index
	 * 
	 * @param index
	 */

	public static void switchToFrame(int index) {

		try {
			driver.switchTo().frame(index);
		} catch (NoSuchFrameException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Method switches focus to Child Window
	 */

	public static void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		
		Set<String> windows = driver.getWindowHandles();
		
		for (String window : windows) {
			if (window.equals(mainWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
	}

	/**
	 * This Method will return Explicit Wait object
	 * 
	 * @return
	 */
	public static WebDriverWait getWaitObject() {
		WebDriverWait wait = new WebDriverWait(driver, Constants.EXPLICIT_WAIT_TIME);
		return wait;
	}

	/**
	 * This Method will take an WebElement as a parameter And wait for the element
	 * to be available for click.
	 * 
	 * @param WebElement
	 */

	public static void waitForClickability(WebElement element) {
		getWaitObject().until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**
	 *This Method will take an WebElement as a parameter And wait for the element
	 * to be visible to take action.
	 * @param element
	 */

	public static void waitForVisibility(WebElement element) {
		getWaitObject().until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * This method with wait for WebElement to be available for click and then click
	 * it
	 * 
	 * @param WebElement
	 */

	public static void waitAndClick(WebElement element) {
		waitForClickability(element);
		element.click();

	}
	
	/**
	 * This Method is for uploading image in Webpage.
	 * @param element
	 * @param filePath
	 */
	public static void fileUpload(WebElement element, String filePath) {
		element.clear();
		element.sendKeys(filePath);
	}

	/**
	 * This Method will take WebElement as an argument and click on that element
	 * @param element
	 */
	public static void click(WebElement element) {
		element.click();

	}
	
	/**
	 * This Method is for using "Thread.sleep" java wait
	 * @param second
	 */

	public static void wait(int second) {
		try {
			Thread.sleep(second * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	}

	/**
	 * This method will take Screen shot and save in specified folder
	 * 
	 * @param folderName
	 * @param testName
	 */
//	public static void takeScreenShot(String folderName, String testName) {
//		int num=0;
//		num++;
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(sourceFile, new File("target/ScreenShots/HRMS/"+folderName+"/"+testName + num + ".png"));
//
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}

	public static String takeScreenShot(String testName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		destinationfile = Constants.SCREENSHOT_FILEPATH + testName + getTimeStemp() + ".png";
		try {
			FileUtils.copyFile(sourceFile, new File(destinationfile));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationfile;
	}

	/**
	 *  this Method will return date & time for any event where it is concatenated
	 * @return [yyyy_MM_dd_HH_mm_ss]
	 */
	public static String getTimeStemp() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
		return sdf.format(date.getTime());
	}
	
	/**
	 * This Method is for creating object of Java Script Executor
	 * @return
	 */

	public static JavascriptExecutor getJSObject() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}
	
	/**
	 * This Method will take a WebElement as an argument and click on it using Java Script executor
	 * @param element
	 */
	public static void jsClick(WebElement element) {
		getJSObject().executeScript("arguments[0].click();", element);
	}

	/**
	 * This Method will take a WebElement as an argument and scroll to it using Java Script executor
	 * @param element
	 */
	public static void scrollToElement(WebElement element) {
		getJSObject().executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Method that will scroll the page down based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollDown(int pixel) {
		getJSObject().executeScript("window.scrollBy(0," + pixel + ")");
	}

	/**
	 * Method that will scroll the page up based on the passed pixel parameters
	 * 
	 * @param pixel
	 */
	public static void scrollUp(int pixel) {
		getJSObject().executeScript("window.scrollBy(0,-" + pixel + ")");
	}

	/**
	 * This Method will take screen shot
	 * 
	 * @param fileName
	 * @return byte[] of the screenshot.
	 */

	public static byte[] takeScreenShotCucumber(String fileName) {

		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] picByte = ts.getScreenshotAs(OutputType.BYTES);
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		destinationfile = Constants.SCREENSHOT_FILEPATH + fileName + getTimeStemp() + ".png";
		try {
			FileUtils.copyFile(sourceFile, new File(destinationfile));

		} catch (IOException e) {
			e.printStackTrace();
		}
		return picByte;
	}

}
