package com.sqs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sqs.pageobjects.ViewIssuePage;
import com.sqs.managers.FileReaderManager;

public class AssignIssuePage 
{
	
	public static WebDriver driver;
	public AssignIssuePage(WebDriver driver) 
	{
		AssignIssuePage.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	ViewIssuePage vPage;
	
	@FindBy(how=How.ID,using="buglist")
	private WebElement tbl_buglist;
	
	@FindBy(how=How.CLASS_NAME,using="width75")
	private WebElement tbl_assign;
	
	@FindBy(how=How.NAME,using="bug_arr[]")
	private WebElement chbx_issue;
	
	@FindBy(how=How.NAME,using="action")
	private WebElement sel_action;

	@FindBy(how=How.XPATH ,using=("//input[@value='OK']"))
	private WebElement but_ok;
 
	@FindBy(how=How.XPATH ,using=("//input[@value='Assign Issues')]"))
	private WebElement but_assign;
	
	@FindBy(how=How.NAME,using="search")
	private WebElement txbx_search;
	
	@FindBy(how=How.NAME,using="filter")
	private WebElement but_filter;

	@FindBy (how=How.ID,using=("filter_closed"))
	private WebElement tbl_filter;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'View Issues')]")
	 private WebElement lnk_viewissue;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'administrator')]")
	private WebElement lnk_assignee;
	
	public void navigate_home_mantis()
	  {
		  System.setProperty("webdriver.firefox.bin",FileReaderManager.getInstance().getConfigReader().getDriverPath());
		  String URL="http://localhost:8080/mantisbt/login_page.php";
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.findElement(By.name("username")).sendKeys("administrator");
		  driver.findElement(By.name("password")).sendKeys("root");
		  driver.findElement(By.className("button")).click();
		  
	  }
	public void search_issue() throws InterruptedException
	{
		String issueID="229";
		lnk_viewissue.click();
		Thread.sleep(2000);
		WebElement txt_Filter=tbl_filter.findElement(By.name("search"));
		txt_Filter.sendKeys(issueID);
		WebElement but_Filter=tbl_filter.findElement(By.name("filter"));
		but_Filter.click();		
	}
	
	public void select_issue() 
	{
		chbx_issue.click();
	}
	public void select_option(String sAction)
	{
		Select drpAction=new Select(sel_action);
		drpAction.selectByValue(sAction);
	}
	public void click_ok() throws InterruptedException
	{
		but_ok=tbl_buglist.findElement(By.xpath("//input[@value='OK']"));
		but_ok.click();
		Thread.sleep(2000);
	}
	public void assign_issue() throws InterruptedException
	{
		but_assign=tbl_assign.findElement(By.xpath("//input[@value='Assign Issues']"));
		but_assign.click();
		Thread.sleep(2000);
	}
	public void issue_updated()
	{
		lnk_assignee=tbl_buglist.findElement(By.linkText("administrator"));
		boolean ldispay;
		ldispay=lnk_assignee.isDisplayed();
		if (ldispay==true)
		{
			System.out.println("Issue successfully assign to :-> " +lnk_assignee.getText());
		}
		else
		{
			System.out.println("Issue not assign to administrator ");
		}
		driver.close();
	}
	
}
