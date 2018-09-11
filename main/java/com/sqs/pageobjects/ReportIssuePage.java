package com.sqs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sqs.managers.FileReaderManager;

public class ReportIssuePage {
	
	public static WebDriver driver;
	public ReportIssuePage(WebDriver driver) 
	{
		ReportIssuePage.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using ="form-title")
	  private WebElement fm_ReportText;
	
	@FindBy(how = How.XPATH, using ="//a[contains(text(),'Report Issue')]")
	  private WebElement lk_ReportIssue;
	
	@FindBy(how = How.NAME, using ="category_id")
	  private WebElement drp_Category;

	@FindBy(how = How.NAME, using ="reproducibility")
	  private WebElement drp_Reprodu;
	
	@FindBy(how = How.NAME, using ="severity")
	  private WebElement drp_Severity;
	
	@FindBy(how = How.NAME, using ="priority")
	  private WebElement drp_Priority;
	
	@FindBy(how = How.ID, using ="platform")
	  private WebElement txbx_platform;
	
	@FindBy(how = How.ID, using ="os")
	  private WebElement txbx_os;
	
	@FindBy(how=How.ID,using="os_build")
	private WebElement txbx_osv;
	
	@FindBy(how = How.ID, using ="handler_id")
	  private WebElement drp_Assign;
	
	@FindBy(how = How.NAME, using ="summary")
	  private WebElement txbx_summary;
	
	@FindBy(how = How.NAME, using ="description")
	  private WebElement txar_description;
	
	@FindBy(how = How.NAME, using ="view_state")
	  private WebElement rb_status;
	
	@FindBy(how = How.ID, using ="report_stay")
	  private WebElement ckbx_report;
	
	@FindBy(how = How.CLASS_NAME, using ="button")
	  private WebElement but_ReportIssue;
	
	public void home_page_login() 
	  {
		  System.setProperty("webdriver.firefox.bin",FileReaderManager.getInstance().getConfigReader().getDriverPath());

		  String URL="http://localhost:8080/mantisbt/login_page.php";
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.findElement(By.name("username")).sendKeys("administrator");
		  driver.findElement(By.name("password")).sendKeys("root");
		  driver.findElement(By.className("button")).click();
		  
	  }	
	
	public void view_text()
	  {
	   String sText=fm_ReportText.getText();
	   if (sText.contains("Enter Report Details"))
	   {
		System.out.println("User is on report issue page");   
	   }
	   else
	   {
		   System.out.println("User is not on report issue page");
	   }
	  }
	
	public void click_report()
	  {
		String Ltext=lk_ReportIssue.getText();
		System.out.println(Ltext);
		lk_ReportIssue.click();	   
	  }
	
	public void select_category(String sCategory)
	  {
	   Select drpCategory=new Select(drp_Category);
	   drpCategory.selectByValue(sCategory);
	   
	  }
	public void select_Reproducibility(String sReport)
	  {
	   Select drpReport=new Select(drp_Reprodu);
	   drpReport.selectByValue(sReport);
	   
	  }
	public void select_Priority(String sPriority)
	  {
	   Select drpPriority=new Select(drp_Priority);
	   drpPriority.selectByValue(sPriority);
	   
	  }
	public void select_Severity(String sSeverity)
	  {
	   Select drpSeverity=new Select(drp_Severity);
	   drpSeverity.selectByValue(sSeverity);
	   
	  }
	
	public void enter_Platform(String sPlatform)
	{
		txbx_platform.sendKeys(sPlatform);
		
	}
	public void enter_OS(String sOS)
	{
		txbx_os.sendKeys(sOS);
		
	}
	public void enter_OSV(String sOSV)
	{
	  txbx_osv.sendKeys(sOSV);
	}
	public void enter_summary(String sSummary)
	{
	 txbx_summary.sendKeys(sSummary);	
	}
	public void enter_description(String sDesc)
	{
     txar_description.sendKeys(sDesc);
	}
	public void select_Reportcb()
	{
	ckbx_report.click();
	
	}
	public void submit_issue() throws InterruptedException
	{
		but_ReportIssue.click();
		Thread.sleep(2000);
		driver.close();
	}
	
	}
