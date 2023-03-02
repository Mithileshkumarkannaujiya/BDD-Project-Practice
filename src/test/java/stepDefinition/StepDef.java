package stepDefinition;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mongodb.client.model.Field;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.AddNewCustomer;
import pageObject.LoginPage;
import pageObject.SearchCustomerByName;
import pageObject.SearchCustomerPage;

public class StepDef extends BaseClass {

	@Before // ye hooks hai
	public void setUp() {
		log = LogManager.getLogger("StepDef");
	readConfig=new Properties();
		try {
			FileInputStream fis=new FileInputStream("D:\\new projects\\BDDCucumber\\config.properties");
		readConfig.load(fis);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

//	@After
//	public void screenshotIfScenatioisFailed(Scenario sc) {
//		if (sc.isFailed() == true) {
//			TakesScreenshot scrShot = ((TakesScreenshot) driver);
//			File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
//			File dest = new File("screenshot//failed.png");
//			try {
//				FileUtils.copyDirectory(srcFile, dest);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		}
//
//	}

	@AfterStep
	public void addScreenshot(Scenario sc) {
	if(sc.isFailed()) {
		String filePath="screenshots//failed.png";
		byte[] scrShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);;
		sc.attach(scrShot, "image/png", sc.getName());
	}
		
		
	}
	
	@Given("User Launch Chrome  browser")
	public void user_launch_chrome_browser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		loginPg = new LoginPage(driver);
		log.info("Browser has been launched ");
		addnewCust = new AddNewCustomer(driver); // yaha par har definition file ko initiaze karana hi
		searchCstomer = new SearchCustomerPage(driver);
		searchcstByName = new SearchCustomerByName(driver);

	}

	@When("User open URL {string}")
	public void user_open_url(String URL) {
		driver.get(URL);
		log.info("URL has been hitted succesfully" + URL);
	}

	@When("user enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String emailadd, String pwdtxt) {
		loginPg.enterEmail(emailadd);
		log.info("Email Entered succesfully ");
		loginPg.enterPass(pwdtxt);
		log.info("Password  Entered succesfully ");
	}

	@When("click on Login")
	public void click_on_login() {
		loginPg.clickOnLogin();
		log.info("Clicked on login Button successfully");
	}

	@Then("page Title should be {string}")
	public void page_title_should_be(String expTitle) {
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		if (actTitle.equals(expTitle)) {
//		Assert.assertTrue(true); // pass
			System.out.println(
					"Test has been Passed  where actual title is:" + actTitle + " the expected Title:" + expTitle);

			log.info("Test has been Passed  where actual title is:" + actTitle + " the expected Title:" + expTitle);
		} else {
			System.out.println(
					"Test has been Failed  where actual title is:" + actTitle + " the expected Title:" + expTitle);
			log.info("Test has been Failed  where actual title is:" + actTitle + " the expected Title:" + expTitle);
			// Assert.assertTrue(false); // Fail
		}
	}

	@When("user click on Log out link")
	public void user_click_on_log_out_link() {
		loginPg.clickOnLogOutBtn();
		log.info("Click On logout BTN succesfully");
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be1(String string) {

	}

	@Then("close Browser")
	public void close_browser() {
		driver.close();
		// driver.quit();
		log.info("Browser has been closed succesfully");
	}

	///// Add New Customer ///////////////////

	@Then("user  can view Dashboard")
	public void user_can_view_dashboard() {
		String actTitle = addnewCust.getPageTitle();
		String expTitle = "";

	}

	@When("user click on customer menu")
	public void user_click_on_customer_menu() {
		addnewCust.clickOnCustomerMenu();
		log.info("clicked on customer menu successfully");
	}

	@When("click on customer")
	public void click_on_customer() {
		addnewCust.clickOnCustomer();
		log.info("CLicked on customer Btn succesfully");
	}

	@When("click on Add New Button")
	public void click_on_add_new_button() {
		addnewCust.addnewcutomer();
		log.info("CLicked on add new customer Btn succesfully");
	}

	@Then("user can view Add New Cutomer Page")
	public void user_can_view_add_new_cutomer_page() {

	}

	@When("user enter Customer info")
	public void user_enter_customer_info() {
		// addnewCust.EnterEmail("mithileshkumar2831999@gmail.com");
		addnewCust.EnterEmail(generateEmailId() + "@gmail.com");
		addnewCust.enterPwd("05414274289");
		addnewCust.enterFirstName("mithilesh");
		addnewCust.enterLastName("chaudhary");
		addnewCust.selectGender("male");

		log.info("customer Information has been filled  succesfully");
	}

	@When("click on save Button")
	public void click_on_save_button() {
		addnewCust.clickOnSaveBt();
		log.info("CLicked on Save Btn succesfully");
	}

	@Then("user can view confirmation Page {string}")
	public void user_can_view_confirmation_page(String expcustomerAddedconfirmationmassage) {
		String bodyTagText = driver.findElement(By.tagName("Body")).getText();
		if (bodyTagText.contains(expcustomerAddedconfirmationmassage)) {
			System.out.println("user has created new account");
			log.info("\"user has created new account\"");
		} else {
			System.out.println("User has not created new account because details were wrong");
			log.info("\"User has not created new account because details were wrong\"");
		}

	}

	//// Search Customer Search customer by email /////

	@When("Enter customer Email")
	public void enter_customer_email() {
		searchCstomer.EnterEmaiAdd("steve_gates@nopCommerce.com	");
		log.info("customer emmail has been filled  succesfully");
	}

	@When("click on search button")
	public void click_on_search_button() {
		searchCstomer.clickOnSearchBtn();
		log.info("CLicked on  search customer Btn succesfully");
	}

	@Then("user shoud found Email in the Search table")
	public void user_shoud_found_email_in_the_search_table() {
		searchCstomer.verifyEmailFromeTheTable("steve_gates@nopCommerce.com");
	}

	/////////// Search customer by name //////////////
	@When("Enter customer Name")
	public void enter_customer_name() {
		searchcstByName.enterFirstName("victoria");
		log.info("customer Name has been filled  succesfully");
	}

//	@After
//	public void teadown() {
//		driver.close();
//		System.out.println("Broswser has been closed");
//
//	}

}
