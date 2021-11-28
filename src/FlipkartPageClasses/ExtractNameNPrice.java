package FlipkartPageClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.ExtentTest;

import baseClasses.PageBaseClass;

public class ExtractNameNPrice extends PageBaseClass {

	public ExtentTest logger;

	public ExtractNameNPrice(WebDriver driver, ExtentTest logger) {
		super(driver, logger);
	}

	@FindBy(className = "s1Q9rs")
	public List<WebElement> productName;

	@FindBy(className = "_30jeq3")
	public List<WebElement> productPrice;

	public void productsDesciption() {

		try {
			String p_name;
			String p_price;
			int p_p_price;

			for (int i = 0; i < 5; i++) {
				p_name = productName.get(i).getText();
				p_price = productPrice.get(i).getText();
				p_price = p_price.replaceAll("[^0-9]", "");
				p_p_price = Integer.parseInt(p_price);

				System.out.println(
						"Product [" + (i + 1) + "]" + " : Product Name : " + p_name + " Product Price : " + p_p_price);
			}
			
		} catch (Exception a) {
			reportFail(a.getMessage());
		}
	}
}
