package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
private	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(id = "Email")
	WebElement emailBox;

	@FindBy(id = "Password")
	WebElement PasswordBox;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(linkText = "Logout")
	WebElement logOutBtn;
	
	public void enterEmail(String emaiAdd) {
		emailBox.clear();
		emailBox.sendKeys(emaiAdd);
	}

	public void enterPass(String pwd) {
		PasswordBox.clear();
		PasswordBox.sendKeys(pwd);
	}

	public void clickOnLogin() {
		submitBtn.click();
	}

	public void clickOnLogOutBtn() {
		logOutBtn.click();
	}
}
