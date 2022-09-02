package stepDefinitions;



import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestContainerSetup;

public class LandingPageStepDefinition {
public WebDriver driver;
public LandingPage lpobj; 
public String homepageproductName;
public TestContainerSetup testContext;
public PageObjectManager pomanager;

public LandingPageStepDefinition(TestContainerSetup testContext) {
	this.testContext=testContext;
	this.lpobj=testContext.pomanager.getLandingPage();
}
	

@Given("User is on GreenCart Landing page")
public void user_is_on_green_cart_landing_page() throws IOException {
    // Write code here that turns the phrase above into concrete actions
	

	//testContext.testBase.WebDriverManager();
	
	Assert.assertTrue(lpobj.getTitleLandingPage().contains("GreenKart - veg and fruits kart"));
		
  
}
@When("^User searched with username (.+) and extracted actual name of product$")
public void user_searched_with_username_and_extracted_actual_name_of_product(String product) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	//pomanager=new PageObjectManager(testContext.driver);
	
	//LandingPage lpobj = new LandingPage(testContext.driver);
	lpobj.searchItem(product);
	Thread.sleep(2000);
	testContext.homepageproductName=lpobj.getItem().split("-")[0].trim();
	System.out.println(testContext.homepageproductName + " Extracted from homepage search");
	
    
}


@And("^Added \"([^\"]*)\" items of the selected product to cart$")
public void added_something_items_of_the_selected_product_to_cart(String product_count) throws Throwable {
    
	lpobj.increaseproduct(Integer.parseInt(product_count));
	
	lpobj.add_product_to_Cart();
}


}
