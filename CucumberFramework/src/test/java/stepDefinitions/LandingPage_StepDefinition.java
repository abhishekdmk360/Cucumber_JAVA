package stepDefinitions;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContext;

public class LandingPage_StepDefinition {
	TestContext testContext;
	LandingPage landingPage;
	
	public LandingPage_StepDefinition(TestContext testContext) {
		this.testContext = testContext;
		this.landingPage = testContext.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing Page")
	public void greenKart_LandingPage()
	{
		System.out.println(landingPage.getPageTitle());
		Assert.assertTrue(landingPage.getPageTitle().contains("GreenKart"));
	}
	
	@When("^User searched with shortname (.+) and extracted actual name of product$")
	public void searchAndExtractName(String shortName) throws InterruptedException
	{
		landingPage.searchProduct(shortName);
		//testContext.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		testContext.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		//testContext.landingPageProductName = testContext.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(testContext.landingPageProductName+" - is extracted from homepage");
	}
	
	@When("Adds {string} quantity of the selected product to cart")
	public void add_products_to_cart(String quantity)
	{
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}
	
	@When("User proceeds to Checkout")
	public void checkout_and_validate_products()
	{
		landingPage.chekoutProducts();
	}

}
