package TestRunner;


import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//FeatureFile/A_FindingDoctor.feature",
							".//FeatureFile/B_AllSurgeries.feature",
							".//FeatureFile/C_HealthandWellness.feature"},
							glue = "CucumberStepDefination",
				plugin= {"pretty","html:ExtentReports//CucumberReport//cucumberReport.html",
						"rerun:target/rerun.txt",
						  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				         }
				
)


public class TestRun {

}