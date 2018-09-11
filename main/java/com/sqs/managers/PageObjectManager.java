package com.sqs.managers;

import org.openqa.selenium.WebDriver;

import com.sqs.pageobjects.AssignIssuePage;
import com.sqs.pageobjects.HomePage;
import com.sqs.pageobjects.LoginPage;
import com.sqs.pageobjects.ReportIssuePage;
import com.sqs.pageobjects.UpdateIssuePage;
import com.sqs.pageobjects.ViewIssuePage;

public class PageObjectManager 
{

	private WebDriver driver;
	private LoginPage LoginPg; 
	private HomePage Homepg;
	private ReportIssuePage Reportpg;
	private ViewIssuePage Viewpg;
	private AssignIssuePage Assignpg;
	private UpdateIssuePage Updagepg;
	public PageObjectManager(WebDriver driver) 
	{
		 
		this.driver = driver;
 
	}
	public LoginPage getLoginPage(){
		 
		return (LoginPg == null) ? LoginPg = new LoginPage(driver) : LoginPg;
 
	}
   public HomePage getHomePage()
   {
	   return(Homepg==null) ? Homepg=new HomePage(driver): Homepg;
   }
   public ReportIssuePage getReportPAge()
   {
	   return(Reportpg==null) ? Reportpg= new ReportIssuePage(driver):Reportpg;
   }
   public ViewIssuePage getIssuePage()
   {
	   return(Viewpg==null) ? Viewpg= new ViewIssuePage(driver):Viewpg;
	   
   }
   public AssignIssuePage getAssignPage()
   {
	   return (Assignpg==null) ? Assignpg=new AssignIssuePage(driver):Assignpg;
   }
   public UpdateIssuePage getUpdatePage()
   {
	   return (Updagepg==null) ? Updagepg=new UpdateIssuePage(driver):Updagepg;
   }
   
}




