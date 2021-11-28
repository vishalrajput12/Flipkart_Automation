package baseClasses;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import FlipkartPageClasses.LandingPage;
import utilities.DateUtils;

public class PageBaseClass extends BaseTestClass {
	
	public ExtentTest logger;
	
	public PageBaseClass(WebDriver driver, ExtentTest logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	/******************* Open Flipkart *****************/

	public LandingPage openFlipkartApplication() {

		driver.get("https://www.flipkart.com/");
		LandingPage landingPage = new LandingPage(driver, logger);
		PageFactory.initElements(driver, landingPage);
		return landingPage;
	}
	
	/********************Quit Browser*******************/
	public void quitBrowser() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
	
	/*****************Reporting Functions****************/
	
	public void reportFail(String reportString) {
		logger.log(Status.FAIL, reportString);
		takeScreenShotOnFailure();
		Assert.fail(reportString);
	}
	
	public void reportPass(String reportString) {
		logger.log(Status.PASS, reportString);
	}
	
	/*****************Capture Screenshot****************/
	public void takeScreenShotOnFailure() {
		TakesScreenshot takeScreenshot = (TakesScreenshot) driver;
		File soueceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
		
		File destFile = new File(System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtils.getTimeStamp() + ".png");
		try {
			FileUtils.copyFile(soueceFile, destFile);
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\ScreenShots\\" + DateUtils.getTimeStamp() + ".png");
			
		}catch(IOException a) {
			a.printStackTrace();
		}
	}
	
	
	
}
