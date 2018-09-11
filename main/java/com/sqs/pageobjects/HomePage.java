package com.sqs.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sqs.managers.FileReaderManager;

public class HomePage 
{
	public static WebDriver driver;
	public HomePage(WebDriver driver) 
	{
		HomePage.driver = driver; 
		PageFactory.initElements(driver, this);

	}
  @FindBy(how = How.NAME, using ="username")
  private WebElement txtbx_UserName;
  
  @FindBy(how = How.NAME, using ="password")
  private WebElement txtbx_Password;
  
  @FindBy(how = How.CLASS_NAME, using ="button")
  private WebElement but_Login;
  
  @FindBy(how=How.XPATH,using="//img[contains(@alt,'MantisBT')]")
  private WebElement img_MBT;
  
  @FindBy(how=How.XPATH,using="//a[contains(text(),'Lost your password?')]")
  private WebElement link_forgotpassword;
  
  
  public void navigate_to_home()
  {
	  System.setProperty("webdriver.firefox.bin",FileReaderManager.getInstance().getConfigReader().getDriverPath());
//	  driver = new FirefoxDriver();
	  String URL="http://localhost:8080/mantisbt/login_page.php";
	  driver.get(URL);
	  driver.manage().window().maximize();
  }
  
  
  public void enter_username()
  {
	  boolean txb;
	  txb=txtbx_UserName.isEnabled();
	  System.out.println("The user name text box is visible :-> " +txb);
  }
  
  public void enter_password()
  {
	  boolean txp;
	  txp=txtbx_Password.isDisplayed();
	  System.out.println("The password textbox is visible :-> "+txp);
  }
  public void submit_login()
  {
	  boolean but;
	  but=but_Login.isDisplayed();
	  System.out.println("Login button is displayed :-> " +but);
  }
  public void fogot_link()
  {
	  boolean flink;
	  flink=link_forgotpassword.isDisplayed();
	  System.out.println("Forgot password link is displayed :-> " +flink);
  }
  
  public void image_mbt()
  {
	  boolean imbt;
	  imbt=img_MBT.isDisplayed();  
	  System.out.println("MBT image is displayed :-> " +imbt); 
  }
  public void close_browser()
  {
	driver.close();  
  }
	
}
