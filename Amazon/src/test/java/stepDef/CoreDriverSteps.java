package stepDef;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CoreDriverSteps {
public static WebDriver driver;
	
	@Before
	public void launchApplication()
	{
		System.setProperty("webdriver.http.factory", "jdk-http-client");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.amazon.in/");
	}
	@After
	public void close()
	{
		driver.quit();
	}
	
	public  WebDriver getDriver()
	{
		return driver;
	}
	
	

}
