package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PageObjects.LandingPage;
import PageObjects.OffersPage;
import PageObjects.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import utils.TestContainerSetup;

public class OffersPageStepDefinition {
	public String offerspageproductName;
	TestContainerSetup testContext;	
	public PageObjectManager pomanager;
	
	public OffersPageStepDefinition(TestContainerSetup testContext) {
		this.testContext=testContext;
	}


	

@Then("^User searched for same shortname (.+) in offers page`$")
public void User_searched_for_same_shortname_in_offers_page(String product) throws InterruptedException {
    // Write code here that turns the phrase above into concrete actions
	//pomanager=new PageObjectManager(testContext.driver);
	OffersPage opobj=testContext.pomanager.getOffersPage();
  //OffersPage opobj=new OffersPage(testContext.driver);
	switchto_Offerspage();	
  opobj.searchitem_in_OffersPage(product);

 Thread.sleep(2000);
 offerspageproductName=opobj.getItem_from_OffersPage();
 System.out.println(offerspageproductName+ " Extracted from offerspage");
 
 
}

public void switchto_Offerspage() {
	
	//LandingPage lpobj=new LandingPage(testContext.driver);
	LandingPage lpobj=testContext.pomanager.getLandingPage();
	
	lpobj.invokeTopDeals();
	
	testContext.gnu.switchtochild();
	
}

@And("^Productname is offers page and homepage should be same$")
public void productname_is_offers_page_and_homepage_should_be_same() throws Throwable {
 
Assert.assertEquals(testContext.homepageproductName, offerspageproductName);	
}
}
