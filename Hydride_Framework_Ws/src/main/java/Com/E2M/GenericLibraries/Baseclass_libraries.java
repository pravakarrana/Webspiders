package Com.E2M.GenericLibraries;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import Com.E2M.ObjectRepository.LoginPage;
import Com.E2M.ObjectRepository.LogoutPage;

 
public class Baseclass_libraries 
{
	
	public static WebDriver driver;
	public static fileutil flib=new fileutil();
	
	@BeforeClass 
	public void configBc() throws IOException
	{
		System.out.println("========Lunch browser========");
		Properties pobj=flib.getpropertiesfileobject();
		String browsername=pobj.getProperty("BROWSER");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Resourse/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equals("firefox"))
		{
			driver=new FirefoxDriver();
 		}
		else if(browsername.equals("IE"))
		{
			System.setProperty("webdriver.IE.driver", "");
			driver=new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeMethod 
	public void configBm() throws IOException, Throwable
	{
		System.out.println("Login To Event2Mobile");
		
    	Properties pobj=flib.getpropertiesfileobject();
		driver.get(pobj.getProperty("URL"));
		
		 LoginPage log=PageFactory.initElements(driver, LoginPage.class);
		           log.EnterUsername(pobj.getProperty("USERNAME").trim());
		           Thread.sleep(2000);
		
	     LoginPage pro=PageFactory.initElements(driver, LoginPage.class);
		           pro.clickOnProceed();
		           Thread.sleep(2000);
		           
		 LoginPage pwd=PageFactory.initElements(driver, LoginPage.class);
		           pwd.EnterPassword(pobj.getProperty("PASSWORD"));
		           Thread.sleep(2000);
		           
		 LoginPage sub=PageFactory.initElements(driver, LoginPage.class);
		           sub.clickOnSubmit();
		
 
    }
	
	 @AfterMethod 
	 public void configAm()
	{
		 System.out.println("Logout To Event2mobile");
		 LogoutPage lout=PageFactory.initElements(driver, LogoutPage.class);
		            lout.clickOnlogout();
		  
	}
 
	 
	 @AfterClass 
	 public void configAc()
		{
			System.out.println("========close browser=========");
            driver.close();
            driver.quit();
		
	 }	
}
