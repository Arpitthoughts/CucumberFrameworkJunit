package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class TestContainerSetup {

	public WebDriver driver;
	public String homepageproductName;
	public PageObjectManager pomanager;
	public Genericutils  gnu;
	
	public TestBase testBase;
	
	public TestContainerSetup() throws IOException{
		
		testBase=new TestBase();
		 pomanager= new PageObjectManager(testBase.WebDriverManager());
		 gnu= new Genericutils(testBase.WebDriverManager());
	}
	
}
