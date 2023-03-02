package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomer {
private WebDriver ldriver;

//constructor
public AddNewCustomer(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
	

//Find webelements on the webpage

@FindBy(xpath = "//a[@href='#'  and  @class='nav-link']//i[@class='nav-icon far fa-user']//following-sibling::p[normalize-space(text()=' Customers')]")
protected WebElement customersMenu;

@FindBy(xpath = "//a[@href='/Admin/Customer/List'  and  @class='nav-link']//i[@class='nav-icon far fa-dot-circle']//following-sibling::p[normalize-space(text()=' Customers')]")
protected WebElement  customerBtn;

@FindBy(xpath = "//i[ @class='fas fa-plus-square' and normalize-space(text()=' Add new')]")
protected WebElement AddNewCustomerBtn;

@FindBy(xpath = "//input[@id='Email']")
protected WebElement EmailTxt;

@FindBy(xpath = "//input[@id='Password']")
protected WebElement passwordTxt;

@FindBy(xpath = "//input[@id='FirstName']")
protected WebElement FirstnameTxt;

@FindBy(xpath="//input[@id='LastName']")
protected WebElement lastNameTxt;

@FindBy(xpath = "//input[@id='Gender_Male']")
protected WebElement male;

@FindBy(xpath = "//input[@id='Gender_Female']")
protected WebElement female;

@FindBy(xpath = "//input[@id='DateOfBirth']")
protected WebElement Dob;

@FindBy(xpath = "//input[@id='Company']")
protected WebElement comapany;

@FindBy(xpath = "//input[@id='IsTaxExempt']")
protected WebElement isTaxExempt;

@FindBy(xpath = "//button[@name='save']")
protected WebElement saveBtn;

@FindBy(xpath = "//button[@name='save-continue']")
protected WebElement saveAndContinueEdit;

public String getPageTitle () {
	return ldriver.getTitle();
}


public void clickOnCustomerMenu() {
	customersMenu.click();
}
	
public void clickOnCustomer() {
	customerBtn.click();
}

public void addnewcutomer() {
	AddNewCustomerBtn.click();
}

public void EnterEmail(String email) {
	EmailTxt.clear();
	EmailTxt.sendKeys(email);
}

public void enterPwd(String pwd) {
	passwordTxt.clear();
	passwordTxt.sendKeys(pwd);
	}

 public void enterFirstName(String firstname) {
	 FirstnameTxt.clear();
	 FirstnameTxt.sendKeys(firstname);
 
}

public void enterLastName(String lastName) {
	lastNameTxt.clear();
	lastNameTxt.sendKeys(lastName);
	}




public void selectGender(String genderValue) {
	if(genderValue.equalsIgnoreCase("male")) {
		male.click();
	} else {
		female.click();
	}
	
}
public void clickOnSaveBt() {
	saveBtn.click();
}









}