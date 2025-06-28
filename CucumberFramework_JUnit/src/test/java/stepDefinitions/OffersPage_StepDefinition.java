package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContext;

public class OffersPage_StepDefinition {
	TestContext testContext;
	String offersPageProductName;
	OffersPage offersPage;
	
	public OffersPage_StepDefinition(TestContext testContext) {
		this.testContext = testContext;
		this.offersPage = testContext.pageObjectManager.getOffersPage();
	}
	
	@Then("^User searched for shortname (.+) in Offers page$")
	public void searchAndCheckProduct(String shortName) throws InterruptedException
	{
		switchtoOffersPage();
		//testContext.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		offersPage.searchProduct(shortName);
		//Thread.sleep(2000);
		//offersPageProductName = testContext.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
		offersPageProductName = offersPage.getProductName();
	}
	
	public void switchtoOffersPage()
	{
		if(testContext.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
			return;
		LandingPage landingPage = testContext.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContext.genericUtils.switchtoWindowChild();
	}
	
	@Then("Verify product name in Offers page matches with Landing Page")
	public void validateProductName()
	{
		Assert.assertEquals(offersPageProductName, testContext.landingPageProductName);
	}

}
