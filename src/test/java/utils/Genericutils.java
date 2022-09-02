package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class Genericutils {
	
	WebDriver driver;
	
	public Genericutils(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void switchtochild() {
		
		Set<String> handles=driver.getWindowHandles();
		Iterator<String>it=handles.iterator();

		String parent=it.next();
		String child=it.next();
		driver.switchTo().window(child);
	}

}
