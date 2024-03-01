package TestBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;

public class BaseClass {
	
public static WebDriver driver;
public static Logger log;
public static Properties prop;

@BeforeClass(groups = { "sanity","regression", "master" })
@Parameters({"os","browser"})
public static WebDriver driversetup(String os,String br) throws IOException {

//logger file 
	log= LogManager.getLogger(Test.class);
// Propeties File
	FileReader filepath=new FileReader(".//src//test//resources//ConfigFile.properties");
	prop=new Properties();
	prop.load(filepath);
	log.info("********** Launching WebDriver***********");	
	if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {

				DesiredCapabilities capabalities = new DesiredCapabilities();

				//os

				if(os.equalsIgnoreCase("windows")) {

					capabalities.setPlatform(Platform.WIN11);

				}

				else if (os.equalsIgnoreCase("mac")) {

					capabalities.setPlatform(Platform.MAC);

				}

				else {

					System.out.println("no matching os .....");

					return null;

				}

				//browser

				if(br.equalsIgnoreCase("chrome")) {

					capabalities.setBrowserName("chrome");

				}

				else if(br.equalsIgnoreCase("edge")) {

					capabalities.setBrowserName("MicrosoftEdge");

				}

				else {

					System.out.println("no matching browser .....");

					return null;

				}
	 
				 driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub") , capabalities);

			}

			else if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {

				// launching browser based on condition - locally

				if(br.equalsIgnoreCase("chrome")) {

					driver = new ChromeDriver();

					log.info("Chrome browser opened successfully");

				}

				else if(br.equalsIgnoreCase("edge")){

					driver = new EdgeDriver();

					log.info("Edge browser opened successfully");

				}

				else {

					System.out.println("no matching browser......");

					log.info("no matching browser......");

					return null;

				}
	 
			}
	driver.manage().window().maximize();
	log.info("********** Launching URL***********");
	driver.get(prop.getProperty("appUrl"));
	//driver.get("https://www.practo.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	return driver;
	
}
public String extentreportscreenshot(String tname) throws IOException {
	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());		
	TakesScreenshot takesScreenshot = ((TakesScreenshot)driver);
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	String targetFilePath=System.getProperty("user.dir")+"\\allScreenshot\\ExtentReportScreenshot\\" + tname + timeStamp +".png";
	File targetFile=new File(targetFilePath);
	sourceFile.renameTo(targetFile);	
	return targetFilePath;

}
public void captureScreen(String tname) throws IOException{
	
	TakesScreenshot ts=(TakesScreenshot)driver;
	File src=ts.getScreenshotAs(OutputType.FILE);
	File trg=new File(System.getProperty("user.dir")+"\\allScreenshot\\Screenshots\\"+tname+".png");
	FileUtils.copyFile(src, trg);
	
}
@AfterClass	
public void driverClose() {
	// close the driver
	driver.quit();
}
	


	
	
	
	
	
	
}
