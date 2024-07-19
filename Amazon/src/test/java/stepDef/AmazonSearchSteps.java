package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.HomePage;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Assert;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearchSteps  {
   WebDriver driver;
   HomePage homePage;
   public AmazonSearchSteps()
   {
	   driver=CoreDriverSteps.driver;
	   homePage=new HomePage(driver);
   }

    @Given("I am on the Amazon homepage")
    public void i_am_on_the_amazon_homepage() {
    	System.out.println(driver.getTitle());
    	// Assert.assertTrue(driver.getTitle().equals("Amazon.com. Spend less. Smile more."));
    	
    	  }

    @When("I enter {string} into the search bar")
    public void i_enter_into_the_search_bar(String searchText) {
        homePage.searchBox.sendKeys(searchText);
    }

    @When("I click the search button")
    public void i_click_the_search_button() {
   	homePage.searchButton.click();
    }

    @Then("I should see search results for {string}")
    public void i_should_see_search_results_for(String searchText) {
    //    WebElement results = driver.findElement(By.cssSelector("span.a-color-state.a-text-bold"));
        Assert.assertTrue(homePage.getText(homePage.results).contains(searchText));
    }

    @Then("the search results should include products with {string} in their name")
    public void the_search_results_should_include_products_with_in_their_name(String searchText) {
        List<WebElement> productTitles = homePage.findElementsByCSS("span.a-size-medium.a-color-base.a-text-normal");
        for (WebElement title : productTitles) {
        	System.out.println(title.getText());
        	System.out.println();
            Assert.assertTrue(title.getText().toLowerCase().contains(searchText.toLowerCase()));
        }
     
    }
    
     @Then("I should see a message saying {string}")
    public void i_should_see_a_message_saying(String string) {
    	 Assert.assertTrue(homePage.unknownresults.getText().contains("No results for unicorn spaceship in amazon-devices"));
    }
   
   
     @Then("I should see search results for {string} in the Books category")
     public void i_should_see_search_results_for_in_the_books_category(String searchText) {
    	 List<WebElement> productTitles = homePage.findElementsByCSS("span.a-size-medium.a-color-base.a-text-normal");
         for (WebElement title : productTitles) {
         	System.out.println(title.getText());
             Assert.assertTrue(title.getText().toLowerCase().contains(searchText.toLowerCase()));
         }
     }
     
   
     @Then("I should see search results that include {string} and {string}")
     public void i_should_see_search_results_that_include_and(String searchText1, String searchText2) {
         // Write code here that turns the phrase above into concrete actions
    	 List<WebElement> productTitles = homePage.findElementsByCSS("span.a-size-medium.a-color-base.a-text-normal");
         for (WebElement title : productTitles) {
         	System.out.println(title.getText());
             Assert.assertTrue(title.getText().toLowerCase().contains(searchText1.toLowerCase())
            		 ||title.getText().toLowerCase().contains(searchText2.toLowerCase()));
         }
     }









}
