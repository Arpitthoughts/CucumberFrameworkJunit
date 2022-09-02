package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	WebDriver driver;	
By searchfield=By.id("search-field");
By product=By.cssSelector("tbody tr td:nth-child(1)");


public OffersPage(WebDriver driver) {
	this.driver=driver;
}




public void searchitem_in_OffersPage(String item) {

driver.findElement(searchfield).sendKeys(item);
}


public String getItem_from_OffersPage() {
	return driver.findElement(product).getText();
	
}

}
