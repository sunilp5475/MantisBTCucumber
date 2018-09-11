package com.sqs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sqs.managers.FileReaderManager;
import com.sqs.stepDefinitions.HomePageSteps;

public class LoginPage 

{
	HomePageSteps Home;
	public static WebDriver driver;
	public LoginPage(WebDriver driver) 
	{
		LoginPage.driver = driver; 
		PageFactory.initElements(driver, this);

	}
  @FindBy(how = How.NAME, using ="username")
  private WebElement txtbx_UserName;
  
  @FindBy(how = How.NAME, using ="password")
  private WebElement txtbx_Password;
  
  @FindBy(how = How.CLASS_NAME, using ="button")
  private WebElement but_Login;
  
  @FindBy(how=How.XPATH,using="//a[contains(text(),'My View')]")
  private WebElement lnk_myview;
  
  @FindBy(how=How.XPATH,using="//a[contains(text(),'Logout')]")
  private WebElement lnk_logout;
  
  public void home_page() throws Throwable
  {
	  System.setProperty("webdriver.firefox.bin",FileReaderManager.getInstance().getConfigReader().getDriverPath());
//	  driver = new FirefoxDriver();
	  String URL="http://localhost:8080/mantisbt/login_page.php";
	  driver.get(URL);
	  driver.manage().window().maximize();
  }
  
  
  public void enter_username(String username)
  {
	  txtbx_UserName.sendKeys(username);
  }
  
  public void enter_password(String password)
  {
	  txtbx_Password.sendKeys(password);
  }
  public void submit_login()
  {
	  but_Login.click();
	  
  }
  public void my_view()
  {
	  Boolean lkmyview;
	  lkmyview=lnk_myview.isDisplayed();
	  System.out.println("My View link is present -:> " +lkmyview);
  }
  public void close_browser()
  {
	  lnk_logout.click();  
	  driver.close();
  }  
  
}
