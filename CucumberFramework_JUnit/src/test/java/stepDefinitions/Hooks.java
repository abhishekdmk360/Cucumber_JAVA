package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContext;

public class Hooks {
	
	TestContext testContext;
	
	public Hooks(TestContext testContext) {
		this.testContext = testContext;
	}
	
	@After
	public void afterScenario()
	{
		testContext.driver.quit();
	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver = testContext.driver;
		if(scenario.isFailed())
		{
			File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
			scenario.attach(fileContent, "image/png", "image");
		}
	}

}
