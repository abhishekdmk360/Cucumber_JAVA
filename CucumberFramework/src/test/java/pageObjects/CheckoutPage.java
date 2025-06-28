package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By promoButton = By.cssSelector(".promoBtn");
	private By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	
	public Boolean verifyPromoButton()
	{
		return driver.findElement(promoButton).isDisplayed();
	}
	
	public Boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
	}

}
