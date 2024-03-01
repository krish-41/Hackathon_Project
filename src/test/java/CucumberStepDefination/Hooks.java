package CucumberStepDefination;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import TestBase.CucumberBaseClass;
import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
 
public class Hooks {
	static WebDriver driver;
	static Properties p;
	@BeforeAll
	public static void setup() throws IOException {
		driver = CucumberBaseClass.initilizeBrowser();
		p = CucumberBaseClass.getProperties();
		driver.get(p.getProperty("appUrl"));
		driver.manage().window().maximize();
	    CucumberBaseClass.getLogger().info("Browser Launch for cucumber test...");
 
				
	}
	@AfterAll
	public static void teardown() {
		driver.quit();
	    CucumberBaseClass.getLogger().info("Browser closed for Cucumber test...");
 
	}
	@AfterStep
	public void addScreenshot(Scenario scenario) {
		// this is for cucumber junit report  
       // if(scenario.isFailed()) 
        	TakesScreenshot ts=(TakesScreenshot) driver;
        	byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
        	scenario.attach(screenshot, "image/png",scenario.getName());

	}
}