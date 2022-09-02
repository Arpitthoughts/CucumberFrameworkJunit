package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage lpobj;
	public OffersPage opobj;
	public CheckoutPage chkoutobj;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public LandingPage getLandingPage() {
		
		lpobj=new LandingPage(driver);
	    return lpobj;
	}
	
	
public OffersPage getOffersPage() {
		
		opobj=new OffersPage(driver);
		
		return opobj;
	}

public CheckoutPage getCheckoutPage() {
	
	chkoutobj=new CheckoutPage(driver);
	
	return chkoutobj;
}

}
