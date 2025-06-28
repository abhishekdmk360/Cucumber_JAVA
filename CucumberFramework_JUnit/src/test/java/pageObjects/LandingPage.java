package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	WebDriver driver;
	
	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	private By searchBox = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.linkText("Top Deals");
	private By cartBag = By.cssSelector("[alt='Cart']");
	private By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By increment = By.cssSelector("a.increment");
	private By addToCart = By.cssSelector(".product-action button");
	
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
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getPageTitle()
	{
		return driver.getTitle();
	}
	
	public void chekoutProducts()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkoutButton).click();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity;
		while(i>1)
		{
			driver.findElement(increment).click();
			i--;
		}
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}

}
