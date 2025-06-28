package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContext {
	
	public WebDriver driver;
	public String landingPageProductName;
	public BaseTest baseTest;
	public PageObjectManager pageObjectManager;
	public GenericUtils genericUtils;
	
	public TestContext() throws IOException {
		baseTest = new BaseTest();
		driver = baseTest.WebDriverManager();
		pageObjectManager = new PageObjectManager(driver);
		genericUtils = new GenericUtils(driver);
	}

}
