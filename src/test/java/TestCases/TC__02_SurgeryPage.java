package TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;
import PageObjectClass.SurgeryPage;
import TestBase.BaseClass;
import UtilitiesAll.ExcelOutputUtils;

public class TC__02_SurgeryPage extends BaseClass {

@Test(priority=1)
public void validation(){
	log.info("**********TEST CASE 7 STARTED**********");
	SurgeryPage SP=new SurgeryPage(driver);
	Assert.assertEquals(true, SP.validate());
	 log.info("************TEST CASE 7 SUCESSESFULLY EXECUTED***********");
}	
	
@Test(priority=2)
public void SurgeriesList()  {
	log.info("**********TEST CASE 8 STARTED**********");
	SurgeryPage SP=new SurgeryPage(driver);
	SP.ClickSurgeriesOperation();
	SP.scrollDown();
	SP.AllSurgeriesOperation();
	try {
		ExcelOutputUtils.ExcelOutputData1();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	SP.scrollUp();
	log.info("************TEST CASE 8 SUCESSESFULLY EXECUTED***********");
}
	
	
}
