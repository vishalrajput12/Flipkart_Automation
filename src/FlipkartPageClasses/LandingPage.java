package FlipkartPageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class LandingPage extends PageBaseClass {
	
	public ExtentTest logger;
	
	public LandingPage(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}
	
	@FindBy(xpath="/html/body/div[2]/div/div/button")
	public WebElement cancelPopUp;
	
	@FindBy(xpath="//*[@name='q']")
	public WebElement searchBox;
	
	@FindBy(xpath="//*[@type='submit']")
	public WebElement search;
	
	public Specifications quickSearch(String searchCategory) {
		
		try {
			cancelPopUp.click();
			searchBox.sendKeys(searchCategory);
			search.click();
			
			reportPass("Searching Success : Category [Bluetooth Headphones]");
			
		} catch(Exception a) {
			reportFail(a.getMessage());
		}
		
		Specifications specification = new Specifications(driver, logger);
		PageFactory.initElements(driver, specification);
		return specification;
	
	}
}
