package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	WebDriver driver;
	
	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchBox = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");
	
	public void searchProduct(String name)
	{
		driver.findElement(searchBox).sendKeys(name);
	}
	
	public String getSearchBoxText()
	{
		return driver.findElement(searchBox).getText();
	}
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

}
