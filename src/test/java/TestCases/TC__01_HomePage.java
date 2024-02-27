package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjectClass.HomePage;
import TestBase.BaseClass;
import UtilitiesAll.ExcelInputUtils;
import UtilitiesAll.ExcelOutputUtils;

public class TC__01_HomePage extends BaseClass{
	
@Test(groups = { "sanity", "master" })
public void validHomepage() {
log.info("**********TEST CASE 1 STARTED**********");
String Exp_Title=	driver.getTitle();
String Act_Title="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
	System.out.println(Exp_Title);
Assert.assertEquals(Exp_Title,Act_Title,"Title didn't match");
 log.info("************TEST CASE 1 SUCESSESFULLY EXECUTED***********");
}

@Test(priority=2,groups = { "regression", "master" })
public void searchDesiredoptionlocation() throws Exception {
	HomePage HP =new HomePage(driver);
	log.info("**********TEST CASE 2 STARTED**********");
	String[]City=ExcelInputUtils.City();
	HP.searchLocation(City);
	log.info("************TEST CASE 2 SUCESSESFULLY EXECUTED***********");
}

@Test(priority=3,groups = { "regression", "master" })
public void searchDesiredoptionspeciality() throws Exception {
	HomePage HP =new HomePage(driver);
	log.info("**********TEST CASE 3 STARTED**********");
	String[]City=ExcelInputUtils.City();
	HP.searchSpeciality(City);
	log.info("************TEST CASE 3 SUCESSESFULLY EXECUTED***********");
}

@Test(dependsOnMethods= {"searchDesiredoptionspeciality"},groups = { "regression", "master" })
	public void checkDetails() {
	log.info("**********TEST CASE 4 STARTED**********");
	String Actual=driver.getTitle();
	log.info("************TEST CASE 4 SUCESSESFULLY EXECUTED***********");
}

@Test(dependsOnMethods= {"checkDetails"},groups = { "regression", "master" })
public void AllFilters() throws InterruptedException{
	HomePage HP =new HomePage(driver);
	log.info("**********TEST CASE 5  STARTED**********");
	String Act_filter=HP.applyFilters();
	//Assert.assertEquals(Act_filter,"Relevance");
	log.info("************TEST CASE 5 SUCESSESFULLY EXECUTED***********");
	}

@Test(dependsOnMethods= {"AllFilters"})
public void Doctorname(){
	HomePage HP =new HomePage(driver);
	log.info("**********TEST CASE 6  STARTED**********");
	try {
		HP.allDoctorname();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		ExcelOutputUtils.ExcelOutputData();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	log.info("************TEST CASE 6 SUCESSESFULLY EXECUTED***********");
	

}

   
}
