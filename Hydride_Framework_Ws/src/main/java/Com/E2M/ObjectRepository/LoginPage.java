package Com.E2M.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import Com.E2M.GenericLibraries.Baseclass_libraries;

public class LoginPage extends Baseclass_libraries {
	
 	
	@FindBy(xpath="//input[@id='txtLogin']")
	private WebElement user_name;
	
	@FindBy(xpath="//div[@class='fullwidth btn-login-hld']/a[@id='btnProceed']")
	private WebElement proceed;
	
	@FindBy(xpath="//input[@id='txtPass']")
	private WebElement pass_word;
	
	@FindBy(xpath="//input[@value='Sign in']")
	private WebElement submit;
	
	
	
	
	
	public void EnterUsername(String username){
		user_name.sendKeys(username);
	}
	
	public void clickOnProceed()   {
		proceed.click();
	}
	
	public void EnterPassword(String password){
		pass_word.sendKeys(password);
	}
	
	public void clickOnSubmit()   {
		submit.click();
	}
	
	
    

}
