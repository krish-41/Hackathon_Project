package PageObjectClass;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SurgeryPage extends BasePage {

 public	SurgeryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

// All Locators
@FindBy(xpath="//div[text()='Surgeries']")	
WebElement Surgeriesbutton;
@FindBy(xpath="//h1[text()='Popular Surgeries']")
WebElement popularSurgery;
	
@FindBy(xpath="//div[@class='SurgicalSolutions-module_ailmentItemWrapper__Krx-u']")	
List<WebElement> AllSurgeriesList;


	
public static List<String>Allsurgeries=new ArrayList<>();

// All Methods
public boolean validate() {
	return Surgeriesbutton.isDisplayed();
	
}

public void ClickSurgeriesOperation() 
  {
	
	Surgeriesbutton.click();
	}

public void scrollDown() 
         {
			 JavascriptExecutor js=(JavascriptExecutor)driver;
			 js.executeScript("arguments[0].scrollIntoView();",popularSurgery);
		 }
			
public void AllSurgeriesOperation() 
   {
	for(WebElement Surgery:AllSurgeriesList)
	{
		String surgery=Surgery.getText();
	   System.out.println(surgery);
	   Allsurgeries.add(surgery);
    }
  }
public void scrollUp() {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollTo(0,0)", "");
}


}
