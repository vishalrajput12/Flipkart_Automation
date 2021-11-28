package TestCases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import FlipkartPageClasses.ExtractNameNPrice;
import FlipkartPageClasses.LandingPage;
import FlipkartPageClasses.Specifications;
import baseClasses.BaseTestClass;
import baseClasses.PageBaseClass;

public class SearchTests extends BaseTestClass{
	
	LandingPage landingPage;
	Specifications specification;
	ExtractNameNPrice extract;
	
	@Test
	public void searchFiltersTests() {
		
		logger = report.createTest("Flipkart Automation : Category - Bluetooth Headphones");
		
		logger.log(Status.INFO, "Starting Chrome Browser ");
		invokeBrowser("Chrome");
		
		PageBaseClass pageBase = new PageBaseClass(driver, logger);
		PageFactory.initElements(driver, pageBase);
		
		logger.log(Status.INFO, " Flipkart Website is Opening");
		landingPage = pageBase.openFlipkartApplication();
		
		specification = landingPage.quickSearch("Bluetooh Headphones");
		logger.log(Status.PASS, "Bluetooth Headphones Searched Successfully");
		
		extract = specification.filtersGenerate();
		logger.log(Status.PASS, "Filters Generated Successfully");
		
		extract.productsDesciption();
		logger.log(Status.PASS, "Top 5 headphones Name and Price Extracted Successfully");
		
		pageBase.quitBrowser();
	}
}
