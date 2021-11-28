package FlipkartPageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class Specifications extends PageBaseClass {

	public ExtentTest logger;

	public Specifications(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(xpath = "//div[text()='Popularity']")
	public WebElement popularityClick;

	@FindBy(xpath = "(//select[@class='_2YxCDZ'])[1]")
	public WebElement minPrice;

	@FindBy(xpath = "(//select[@class='_2YxCDZ'])[1]")
	public WebElement maxPrice;

	public ExtractNameNPrice filtersGenerate() {

		try {
			WebDriverWait wait1 = new WebDriverWait(driver, 40);
			wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class='_2YxCDZ'])[1]"))); 
			
			Select selectMinPrice = new Select(minPrice);
			selectMinPrice.selectByIndex(1);

			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
					"(//select[@class='_2YxCDZ'])[2]")));

			Select selectMaxPrice = new Select(maxPrice);
			selectMaxPrice.selectByIndex(1);

			popularityClick.click();

		} catch (Exception a) {
			reportFail(a.getMessage());
		}
		ExtractNameNPrice nameNPrice = new ExtractNameNPrice(driver, logger);
		PageFactory.initElements(driver, nameNPrice);
		return nameNPrice;
	}
}
