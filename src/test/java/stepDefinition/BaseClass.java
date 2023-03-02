package stepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.*; /// ye wala package import karana hai
import org.openqa.selenium.WebDriver;
import pageObject.AddNewCustomer;
import pageObject.LoginPage;
import pageObject.SearchCustomerByName;
import pageObject.SearchCustomerPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage loginPg;
	public AddNewCustomer addnewCust;
	public SearchCustomerPage searchCstomer;
	public SearchCustomerByName searchcstByName;
	public static Logger log;
	public Properties readConfig;

	public String generateEmailId() {
		return (RandomStringUtils.randomAlphabetic(5));
	}

}
