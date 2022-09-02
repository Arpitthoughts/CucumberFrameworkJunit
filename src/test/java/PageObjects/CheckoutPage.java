package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By cartbag =By.cssSelector("img[alt='Cart']");
	By checkoutbutton=By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promobtn=By.cssSelector(".promoBtn");
	By placeorderbtn=By.xpath("//button[contains(text(),'Place Order')]");
	
	
	
	public boolean verifypromobtn() {
	return driver.findElement(promobtn).isDisplayed();	
	}

	
	public boolean verifyplaceorderbtn() {
	return driver.findElement(placeorderbtn).isDisplayed();	
	}
	
	public void opencart_and_checkout_items() {
	 driver.findElement(cartbag).click();
	 driver.findElement(checkoutbutton).click();
	}
	

	
}
