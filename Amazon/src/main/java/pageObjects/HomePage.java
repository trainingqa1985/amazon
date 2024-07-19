package pageObjects;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	@FindBy(how = How.ID,using="twotabsearchtextbox")
	  public  WebElement searchBox; 
	@FindBy(how = How.ID,using="nav-search-submit-button")
	   public  WebElement searchButton ;
	@FindBy(how = How.CSS,using="span.a-color-state.a-text-bold")
	   public  WebElement results ;
	@FindBy(how = How.XPATH,using="//*[@id=\"search\"]//h3")
	   public  WebElement unknownresults ;
	
	
	     
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	

}
