package com.sqs.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.sqs.managers.FileReaderManager;

public class UpdateIssuePage 
{
	public static WebDriver driver;
	public UpdateIssuePage(WebDriver driver) 
	{
		UpdateIssuePage.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(how=How.CLASS_NAME,using="width75")
	private WebElement tbl_assign;
	
	@FindBy(how=How.XPATH,using="//img[@alt='Edit']")
	 private WebElement img_edit;
	
	@FindBy(how=How.NAME,using="category_id")
	private WebElement sel_category;
	
	@FindBy(how=How.NAME,using="priority")
	private WebElement sel_priority;
	
	@FindBy(how=How.NAME,using="severity")
	private WebElement sel_severity;
	
	@FindBy(how=How.NAME,using="reproducibility")
	private WebElement sel_reproducibility;
	
	@FindBy(how=How.NAME,using="resolution")
	private WebElement sel_resolution;
	
	@FindBy(how=How.XPATH,using=("//input[@value='Update Information']"))
	private WebElement but_update;
	
	@FindBy(how=How.NAME,using="search")
	private WebElement txbx_search;
	
	@FindBy(how=How.NAME,using="filter")
	private WebElement but_filter;

	@FindBy (how=How.ID,using=("filter_closed"))
	private WebElement tbl_filter;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'View Issues')]")
	 private WebElement lnk_viewissue;
	
	@FindBy(how=How.ID,using="buglist")
	private WebElement tbl_buglist;
	

	
	public void navigate_home_up()
	  {
		  System.setProperty("webdriver.firefox.bin",FileReaderManager.getInstance().getConfigReader().getDriverPath());
		  String URL="http://localhost:8080/mantisbt/login_page.php";
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.findElement(By.name("username")).sendKeys("administrator");
		  driver.findElement(By.name("password")).sendKeys("root");
		  driver.findElement(By.className("button")).click();
		  
	  }
	public void search_issue_up() throws InterruptedException
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
		img_edit=tbl_buglist.findElement(By.xpath("//img[@alt='Edit']"));
		img_edit.click();
	}
	public void select_cat(String sCat)
	{
		Select drp_Category=new Select(sel_category);
		drp_Category.selectByValue(sCat);
	}
	public void select_priority_up(String sPri)
	{
		Select drp_Priority=new Select(sel_priority);
		drp_Priority.selectByValue(sPri);
	}
	public void select_severity_up(String sSev)
	{
		Select drp_Severity=new Select(sel_severity);
		drp_Severity.selectByValue(sSev);
	}
	public void select_repo_up(String sRep)
	{
		Select drp_Reproducibility=new Select(sel_reproducibility);
		drp_Reproducibility.selectByValue(sRep);
	}
	public void select_resolution_up(String sRes)
	{
		Select drp_Resolution=new Select(sel_resolution);
		drp_Resolution.selectByValue(sRes);
	}
	public void update_issue() throws InterruptedException
	{
		but_update.click();
		Thread.sleep(2000);
		driver.close();
	}
	
}
