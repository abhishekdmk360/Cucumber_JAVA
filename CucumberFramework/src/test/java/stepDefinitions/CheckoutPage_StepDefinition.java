package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContext;

public class CheckoutPage_StepDefinition {
	
	TestContext testContext;
	CheckoutPage checkoutPage;
	LandingPage landingPage;
	
	public CheckoutPage_StepDefinition(TestContext testContext) {
		this.testContext = testContext;
		this.checkoutPage = testContext.pageObjectManager.getCheckoutPage();
		this.landingPage = testContext.pageObjectManager.getLandingPage();
	}
	
	@Then("Verify user has ability to enter promo code and place the order")
	public void verify_promo_and_placeOrder()
	{
		Assert.assertTrue(checkoutPage.verifyPromoButton());
		Assert.assertTrue(checkoutPage.verifyPlaceOrder());
	}

}
