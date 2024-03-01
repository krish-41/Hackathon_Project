package TestCases;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectClass.HealthandWellnessPage;
import TestBase.BaseClass;
import UtilitiesAll.DataProviders;
import UtilitiesAll.ExcelInputUtils;

public class TC__03_HealthandWellnessPage extends BaseClass{

@Test(groups = { "regression","sanity", "master" })
public void click() {
	HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
	boolean Actual=HWP.click();
	Assert.assertEquals(Actual,true);
	log.info("************TEST CASE 9 SUCESSESFULLY EXECUTED***********");
}
	
@Test(groups = { "regression", "master" })
public void clickAgainWithExcelData() throws Exception {
		
		HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
		List<String>ExcelInputData = ExcelInputUtils.InvalidData();
		System.out.println(ExcelInputData);
		boolean Actual=HWP.ClickOnHealthwithInvalidData(ExcelInputData);
		Assert.assertEquals(Actual,false);
		log.info("************TEST CASE 11 SUCESSESFULLY EXECUTED***********");
	}

@Test(dataProvider = "invalid_data_provider" , dataProviderClass = DataProviders.class )
public void clickAgainWithDataProvider(String name, String comp, String num, String email) throws Exception {
	HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
	boolean Actual=HWP.ClickOnHealthwithInvalidData(name,comp,num,email);
	Assert.assertEquals(Actual,false);
	log.info("************TEST CASE 10 SUCESSESFULLY EXECUTED***********");
}

@Test(groups = { "regression", "master" })
public void clickOnceAgain() throws Exception {
	
	HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
	List<String>ExcelInputData1 = ExcelInputUtils.ValidData();
	System.out.println(ExcelInputData1);
	HWP.ClickOnHealthwithValidData(ExcelInputData1);
	log.info("************TEST CASE 12 SUCESSESFULLY EXECUTED***********");
}

@Test(groups = { "regression", "master" })
public void validate_Thankyou() {
	HealthandWellnessPage HWP=new HealthandWellnessPage(driver);
	Assert.assertEquals(true, HWP.validate());
	log.info("************TEST CASE 13 SUCESSESFULLY EXECUTED***********");
}
	
	
	
}
