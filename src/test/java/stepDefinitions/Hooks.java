package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContainerSetup;

public class Hooks {
	
	TestContainerSetup testcontext;

	public Hooks(TestContainerSetup testcontext) {
		this.testcontext=testcontext;
	}
	
	
	@After
	public void AfterScenarioclosebrowser() throws IOException {
		
		testcontext.testBase.WebDriverManager().quit();
		
		
	}
	
	
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException {
		WebDriver driver=testcontext.testBase.WebDriverManager();	
		if(scenario.isFailed()) {
			System.out.println("This is addScreenShot method");
			File sourcepath=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			byte [] filecontent=FileUtils.readFileToByteArray(sourcepath);
			scenario.attach(filecontent, "image/png", "image");
			
			
		}
		
		
	}
}
