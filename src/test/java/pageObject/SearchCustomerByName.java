package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerByName {
private   WebDriver ldriver;
	
@FindBy(xpath = "//input[@id='SearchFirstName']")
private WebElement firstName;

public SearchCustomerByName(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
			}
	

	public void enterFirstName(String valueOfName) {
		firstName.sendKeys(valueOfName);
		
	}


}
