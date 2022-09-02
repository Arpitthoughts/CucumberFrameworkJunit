package cucumberOptions;



import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


//html,xml,json,junit,extentreports
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features",glue="stepDefinitions",monochrome=true,tags="@placeorder or @searchorder",
plugin={"html:target/cucumber.html","json:target/cucumber.json",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
		"rerun:target/failed_scenarios.txt"})
public class JunitTestRunnerTest{


	
}