package pageObject;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
 WebDriver ldriver;

public SearchCustomerPage(WebDriver rdriver) {
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}
	
@FindBy(id = "SearchEmail")
protected  WebElement emailId;

@FindBy(id = "search-customers")
protected  WebElement searchCustomerBtn;

@FindBy(xpath = "//div[@id='customers-grid_wrapper']//tr//td[2]")
protected List<WebElement> emaiList;


public void EnterEmaiAdd(String email) {
	emailId.sendKeys(email);
}
	
public  void clickOnSearchBtn() {
	searchCustomerBtn.click();
}
public void  verifyEmailFromeTheTable(String str) {
	for(int i=0; i<emaiList.size(); i++) {
		 String emailTxt= emaiList.get(i).getText();
		if(emailTxt.equalsIgnoreCase(str)) {
			System.out.println(str);
		}
		
	}
	
}

}
