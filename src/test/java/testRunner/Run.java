package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)

@CucumberOptions(features = "D:\\new projects\\BDDCucumber\\Features",
glue = "stepDefinition", /// glue me package ka naam rahata hai jisase step defination uthani hai
dryRun = false, // true dege to dry run karege code chalega nahi
monochrome = true,
//plugin = {"pretty","html:Report/loginPageReport.html"}
//plugin = {"pretty","json:Report/loginPageReportJSON.json"}
		tags = "@Sanity  or @Regression", // And OR [@Sanity or @Regression] [@Sanity and not @Regression]
		//plugin = { "pretty", "junit:Report/AddnewCustomer_XML.xml", "json:Report/AddNewCustomerJSON.json",
			//	"html:Report/AddNewCustomerReport.html" })
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)
public class Run extends AbstractTestNGCucumberTests    {
// IS CLASS ME KUCHH NAHI LIKHEGE 
	
}






// tags="@Sanity"  -- will Run Scenario which is tagged with Sanity . Does not matter if it has other tags as well.
//tags="@Sanity or @Regression"---  will Run Scenario tagged with Sanity or Regression
// tags="@Sanity and Regression"--will Run Scenario which is tagged with Sanity as well as Regression
// tags="@Sanity and not Regression"-- will Run Scenario which is tagged with Sanity but not Regression
