package stepDefinitions;



import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import PageObjects.CheckoutPage;
import PageObjects.LandingPage;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.TestContainerSetup;

public class CheckoutPageStepDefinition {
public WebDriver driver;
public String homepageproductName;
public TestContainerSetup testContext;
public PageObjectManager pomanager;
public CheckoutPage chkoutobj;

public CheckoutPageStepDefinition(TestContainerSetup testContext) {
	this.testContext=testContext;
	this.chkoutobj=testContext.pomanager.getCheckoutPage();	
}
	

@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String productname) throws Throwable {

chkoutobj.opencart_and_checkout_items();	
	
	
}



@And("^verify user has ability to enter promo code and place the order$")
public void verify_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {
	 
	Assert.assertTrue(chkoutobj.verifypromobtn()); 
	Assert.assertTrue(chkoutobj.verifyplaceorderbtn());
	 
}






}
