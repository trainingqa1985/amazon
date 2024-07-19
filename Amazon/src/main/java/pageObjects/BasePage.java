package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public WebDriver driver;
	public BasePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getText(WebElement element)
	{
		PageFactory.initElements(driver, this);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
		
		return element.getText();
	}
	
	public WebElement findElementByid(String id)
	{
		PageFactory.initElements(driver, this);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id(id))));
		
		return driver.findElement(By.id(id));
	}

	
	public List<WebElement> findElementsByCSS(String css)
	{
		PageFactory.initElements(driver, this);
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(css))));
		
		return driver.findElements(By.cssSelector(css));
	}

}
