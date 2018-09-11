package com.sqs.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.sqs.managers.FileReaderManager;


public class ViewIssuePage 
{
	public static WebDriver driver;
	public ViewIssuePage(WebDriver driver) 
	{
		ViewIssuePage.driver = driver; 
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(how=How.NAME,using="search")
	private WebElement txbx_search;
	
	@FindBy(how=How.NAME,using="filter")
	private WebElement but_filter;
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'View Issues')]")
	  private WebElement lnk_viewissue;
	
	@FindBy(how=How.ID,using="buglist")
	  private WebElement tbl_Buglist;
	
	@FindBy (how=How.ID,using=("filter_closed"))
	private WebElement tbl_filter;
	
	@FindBy (how=How.NAME,using=("search"))
	private WebElement txt_search;
	

	public void navigate_home()
	  {
		  System.setProperty("webdriver.firefox.bin",FileReaderManager.getInstance().getConfigReader().getDriverPath());
		  String URL="http://localhost:8080/mantisbt/login_page.php";
		  driver.get(URL);
		  driver.manage().window().maximize();
		  driver.findElement(By.name("username")).sendKeys("administrator");
		  driver.findElement(By.name("password")).sendKeys("root");
		  driver.findElement(By.className("button")).click();
		  
	  }
	public void view_issue()
	{
		lnk_viewissue.click();
	}
	public void Enter_issue(String Issueid)
	{
		WebElement txt_Filter=tbl_filter.findElement(By.name("search"));
		txt_Filter.sendKeys(Issueid);
			
	}
	public void search_issue()
	{
		WebElement but_Filter=tbl_filter.findElement(By.name("filter"));
		but_Filter.click();
	}
	public void issue_list()
	{
		String issueID="229";
	    List<WebElement> ROWS = tbl_Buglist.findElements(By.xpath("//table[@id='buglist']/tbody/tr[*]"));
	    System.out.println("Number of rows in table = "+ROWS.size());

	    for (int cRow = 3; cRow < ROWS.size() - 1; cRow++) 
	    {
	     if(ROWS.get(cRow).getText().contains(issueID))
	     {
	    	 System.out.println("The issue id found at row "+cRow+ " and issue id is " +ROWS.get(cRow).getText());
	     }
	     
	    }
	    driver.close();
      }
	
}

