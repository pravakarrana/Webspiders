package Com.E2M.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
	//WebElement locators
	@FindBy(xpath="//a[@id='top1_Logout']")
	private WebElement logout;
	
 
	
	
	//Ulilisation
	public void clickOnlogout()   {
		logout.click();
	}

}
