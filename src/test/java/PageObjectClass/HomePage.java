package PageObjectClass;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import TestBase.BaseClass;
import UtilitiesAll.ExcelInputUtils;

public class HomePage extends BasePage {

 public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 
//  All the Locators
@FindBy(xpath="//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--locality']")	
WebElement locationsearchBox;
@FindBy(xpath="//span[@class='c-omni-clear']")	
WebElement clearbutton;
@FindBy(xpath="//input[@placeholder='Search location']")	
WebElement Firstsearchcontext;
@FindBy(xpath="(//div[@class='c-omni-suggestion-item'])[1]")	
WebElement searchoption;
@FindBy(xpath="//div[@class='c-omni__wrapper u-clearfix c-omni__wrapper--keyword']")	
WebElement SecondsearchBox;
@FindBy(xpath="//input[@placeholder='Search doctors, clinics, hospitals, etc.']")	
WebElement Secondsearchcontext;
@FindBy(xpath="(//div[@class='c-omni-suggestion-item'])[1]")	
WebElement Secondsearchoption;
@FindBy(xpath="//div[@role='button']")	
List<WebElement> Filters;
@FindBy(xpath="//h2[@class=\"doctor-name\"]")	
List<WebElement> Doctorname;
@FindBy(xpath="//p[@class=\"c-profile__description\"]")	
WebElement DoctorDescription;
@FindBy(xpath="//li[@class='c-dropdown__list__item']")	
List<WebElement> dropdownlist;
@FindBy(xpath="//div[@class='c-filter__select--radio u-d-inlineblock u-valign--middle u-pos-rel']")	
List<WebElement> radiobuttonlist;
@FindBy(xpath="//span[@class=\"u-c-pointer u-t-link\"]")	
WebElement morebutton;

//All Methods
public static LinkedHashMap<String,String>DocName=new LinkedHashMap<>();


public void searchLocation(String[] City) throws InterruptedException {
	locationsearchBox.click();
	clearbutton.click();
	System.out.println(City[0]);
	Firstsearchcontext.sendKeys(City[0]);
	Thread.sleep(2000);
	searchoption.click();
	}
public void searchSpeciality(String[] City) throws InterruptedException {
	System.out.println(City[1]);
    Secondsearchcontext.sendKeys(City[1]);
    Thread.sleep(3000);
	JavascriptExecutor js =(JavascriptExecutor)driver;
    js.executeScript("arguments[0].click()",Secondsearchoption);
}

public String applyFilters() throws InterruptedException{
	String filter = null;
	for(int i=0;i<=4;i++) {
		System.out.println(Filters.get(i).getText());
		filter=Filters.get(i).getText();
		
		if(Filters.get(i).getText().equals("Gender")) {
			Filters.get(i).click();
			int randomIndex= new Random().nextInt(2);
			JavascriptExecutor js =(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click()",dropdownlist.get(randomIndex));
		    Thread.sleep(3000);
		    continue;
		}
		
		else if(Filters.get(i).getText().equals("Patient Stories")) {
			Filters.get(i).click();
			int randomIndex= new Random().nextInt(2,5);
			JavascriptExecutor js =(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click()",dropdownlist.get(randomIndex));
		    Thread.sleep(3000);
		    continue;
		    //dropdownlist.get(randomIndex).click();
		}
	
		else if(Filters.get(i).getText().equals("Experience")) {
			Filters.get(i).click();
			int randomIndex= new Random().nextInt(5,9);
			JavascriptExecutor js =(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click()",dropdownlist.get(randomIndex));
		    Thread.sleep(3000);
		    //dropdownlist.get(randomIndex).click();
		}

		else if(Filters.get(i).getText().equals("All Filters")) {
			Filters.get(i).click();
			//for fees 
			int randomIndex= new Random().nextInt(4);
			JavascriptExecutor js =(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click()",radiobuttonlist.get(randomIndex));
		    Thread.sleep(3000);
		    //	radiobuttonlist.get(randomIndex).click();
	
			//for Availability
//		    Filters.get(i).click();
//			int randomIndex1= new Random().nextInt(4,8);
//			JavascriptExecutor js1 =(JavascriptExecutor)driver;
//		    js1.executeScript("arguments[0].click()",radiobuttonlist.get(randomIndex1));
//		    Thread.sleep(3000);
		    //	radiobuttonlist.get(randomIndex1).click();
			
		}
		try{
			if(Filters.get(i).getText().equals("Relevance")) 
			{
			Filters.get(i).click();
			int randomIndex= new Random().nextInt(9,12);
			JavascriptExecutor js =(JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click()",dropdownlist.get(randomIndex));
		    Thread.sleep(3000);
		    }
		}
			catch(Exception e) {
				
			}
		
		}
	return filter;
	}
	
public void allDoctorname()
   {
	
		String Doctor_Name = null;
		int loopsize = Math.min(5, Doctorname.size());
		  for(int i=0;i<loopsize;i++)
	  {
		 try 
		 {
			 Doctor_Name =Doctorname.get(i).getText();
		     System.out.println(Doctor_Name);
		     Doctorname.get(i).click();
		     Set<String> windowIDs=driver.getWindowHandles();
		     List<String> kjc = new ArrayList(windowIDs);
		     String parentwindow=kjc.get(0);
		     String childwindow=kjc.get(1);
		     driver.switchTo().window(childwindow);
		     try{morebutton.click();}
		     catch(Exception e) {}
		     String Description= DoctorDescription.getText();
		     System.out.println(Description); 
		     DocName.put(Doctor_Name, Description);
		     driver.close();
		     driver.switchTo().window(parentwindow);
		  }
		     catch(Exception e) 
		     {
			 
		      }
	  } 	
}
}
