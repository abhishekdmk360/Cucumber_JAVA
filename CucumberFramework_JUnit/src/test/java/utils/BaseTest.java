package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BaseTest {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException
	{
		if(driver==null)
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/global.properties");
			Properties property = new Properties();
			property.load(fis);
			String browser_properties = property.getProperty("browser");
			String browser_maven = System.getProperty("browser");
			String browser = browser_maven!=null ? browser_maven : browser_properties;
			
			// mvn test -Dcucumber.filter.tags="@PlaceOrder" -Dbrowser=chrome
			
			if(browser.equalsIgnoreCase("edge"))
			{
				System.setProperty("webdriver.edge.driver", "src/test/resources/msedgedriver.exe");
				driver = new EdgeDriver();
			}
			else if(browser.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
				driver = new ChromeDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.get(property.getProperty("url"));
		}
		return driver;
	}

}
