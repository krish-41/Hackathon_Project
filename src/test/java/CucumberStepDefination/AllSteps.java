package CucumberStepDefination;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.apache.logging.log4j.Logger;
import PageObjectClass.HealthandWellnessPage;
import PageObjectClass.HomePage;
import PageObjectClass.SurgeryPage;
import TestBase.CucumberBaseClass;
import UtilitiesAll.ExcelInputUtils;
import UtilitiesAll.ExcelOutputUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AllSteps{
	public static WebDriver driver;
	public static Logger log=CucumberBaseClass.getLogger();
	
	
	@Given("Launching the driver")
	public void launching_the_driver() throws IOException {
	    driver = CucumberBaseClass.getDriver();
	    
	}

	@When("User fetch title and verify it")
	public void user_fetch_title() {
		log.info("**********Cucumber TEST CASE 1 STARTED**********");
		String Exp_Title=	driver.getTitle();
		String Act_Title="Practo | Video Consultation with Doctors, Book Doctor Appointments, Order Medicine, Diagnostic Tests";
			System.out.println(Exp_Title);
		Assert.assertEquals(Exp_Title,Act_Title,"Title didn't match");
		 log.info("************Cucumber TEST CASE 1 SUCESSESFULLY EXECUTED***********");
		}

// Second Scenario
	@Given("User navigate to Hospital page")
	public void user_navigate_to_hospital_page() {
		HomePage HP =new HomePage(driver);
		log.info("**********Cucumber TEST CASE 2 STARTED**********");
	}

	@When("User search for City")
	public void user_search_for_city() throws InterruptedException {
		HomePage HP =new HomePage(driver);
		String[] City;
		try {
			City = ExcelInputUtils.City();
			HP.searchLocation(City);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("************Cucumber TEST CASE 2 SUCESSESFULLY EXECUTED***********");
	}

	@When("User search for Speaciality")
	public void user_search_for_speaciality() throws InterruptedException {
		HomePage HP =new HomePage(driver);
		log.info("**********Cucumber TEST CASE 3 STARTED**********");
		String[] City;
		try {
			City = ExcelInputUtils.City();
			HP.searchSpeciality(City);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("************Cucumber TEST CASE 3 SUCESSESFULLY EXECUTED***********");
	}
	
	
// Third scenario
	@Given("User apply City and Speciality")
	public void user_apply_city_and_speciality() {
		HomePage HP =new HomePage(driver);
		log.info("**********Cucumber TEST CASE 5  STARTED**********");
	}

	@When("User Apply all the filters")
	public void user_apply_all_the_city_filters() {
		HomePage HP =new HomePage(driver);
		try {
			HP.applyFilters();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("************Cucumber TEST CASE 5 SUCESSESFULLY EXECUTED***********");
		}



	
//fourth Scenario
	@Given("User apply all filters")
	public void user_apply_all_filters() {
		HomePage HP =new HomePage(driver);
		log.info("**********Cucumber TEST CASE 6  STARTED**********"); 
	}

	@When("User extract first five doctor name")
	public void user_extract_first_five_doctor_name() {
		HomePage HP =new HomePage(driver);
		log.info("**********Cucumber TEST CASE 6  STARTED**********");
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
		log.info("************Cucumber TEST CASE 6 SUCESSESFULLY EXECUTED***********");
		
	}

	
	
// All surgeries Scenario
	
	@Given("User naviagte through Surgeries")
	public void user_naviagte_through_surgeries() {
		log.info("**********Cucumber TEST CASE 7 STARTED**********");
		SurgeryPage SP=new SurgeryPage(driver);
		SP.ClickSurgeriesOperation();
	}

	@When("User scroll down till surgeries")
	public void user_scroll_down_till_surgeries() {
		SurgeryPage SP=new SurgeryPage(driver);
		SP.scrollDown();
	}

	@Then("User fetch all the popular surgeries")
	public void user_fetch_all_the_popular_surgeries() {
		SurgeryPage SP=new SurgeryPage(driver);
		SP.AllSurgeriesOperation();
		try {
			ExcelOutputUtils.ExcelOutputData1();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SP.scrollUp();
		log.info("************Cucumber TEST CASE 7 SUCESSESFULLY EXECUTED***********");
	}

// Corporate page Scenario
	
	
	@Given("User click on For Corporate button")
	public void user_click_on_for_corporate_button() {
		HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
	}

	@When("click on Health and Wellness button")
	public void click_on_health_and_wellness_button() {
		HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
		HWP.click();
	}

	@When("User verify schedule button with Invalid Contact Number")
	public void user_verify_schedule_button_with_invalid_contact_number() throws InterruptedException {
		HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
		List<String> ExcelInputData;
		try {
			ExcelInputData = ExcelInputUtils.InvalidData();
			System.out.println(ExcelInputData);
			boolean Actual=HWP.ClickOnHealthwithInvalidData(ExcelInputData);
			Assert.assertEquals(Actual,false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info("************Cucumber TEST CASE 8 SUCESSESFULLY EXECUTED***********");
	}

	@When("verify schedule button with Valid Information")
	public void verify_schedule_button_with_valid_information() throws Exception {
		HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
		List<String> ExcelInputData1;
		try {
			ExcelInputData1 = ExcelInputUtils.ValidData();
			System.out.println(ExcelInputData1);
			HWP.ClickOnHealthwithValidData(ExcelInputData1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		log.info("************Cucumber TEST CASE 9 SUCESSESFULLY EXECUTED***********");
	}

	@Then("verify Thankyou message is displayed or not")
	public void verify_thankyou_message_is_displayed_or_not() {

	   
	}







}
