package com.sqs.stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import com.sqs.pageobjects.ReportIssuePage;
import com.sqs.cucumber.TestContext;

public class ReportSetps 

{
	ReportIssuePage SubmitIssue;
	TestContext ReportContext;
	
	public ReportSetps(TestContext context)
	{
	 ReportContext = context;
	 SubmitIssue=ReportContext.getPageObjectManager().getReportPAge();
	}
	
	@Given("^User is on Report issue page$")
	public void user_is_on_report_issue_page() throws Throwable 
	{
		SubmitIssue.home_page_login();
	}
	
	@Given("^User clicks on report issue link$")
	public void user_clicks_report_issue_link()throws Throwable 
	{
		SubmitIssue.click_report();
	}
	
	@Given("^Select category$")
	public void select_category()throws Throwable 
	{
		SubmitIssue.select_category("2");
	}
	@Given("^Select Reproducibility$")
	public void select_Reproducibility()throws Throwable 
	{
		SubmitIssue.select_Reproducibility("30");
	}
	@Given("^Select Priority$")
	public void select_Priority()throws Throwable 
	{
		SubmitIssue.select_Priority("30");
	}
	@Given("^Select Severity$")
	public void select_Severity()throws Throwable 
	{
		SubmitIssue.select_Severity("60");
	}
	@Given("^Enter Platform$")
	public void enter_platform()throws Throwable
	{
		SubmitIssue.enter_Platform("Windows");
	}
	@Given("^Enter Operating System$")
	public void enter_OS()throws Throwable
	{
		SubmitIssue.enter_OS("Windows 10");
	}
	@Given("^Enter OS version$")
	public void enter_OSV()throws Throwable
	{
		SubmitIssue.enter_OSV("10.11.1.1");
	}
	@Given("^Enter Summary$")
	public void enter_summary()throws Throwable
	{
		SubmitIssue.enter_summary("This is for testing of cucumber selenium framework");
		
	}
	@Given("^Enter Description$")
	public void enter_Description()throws Throwable
	{
		SubmitIssue.enter_description("This description is for testing of cucumber selenium framework");
	}
	@Given("^Select Report stay$")
	public void select_report()throws Throwable
	{
		SubmitIssue.select_Reportcb();
	}
	@Then("^Report issue$")
	public void report_issue() throws Throwable
	{
		SubmitIssue.submit_issue();
	}
}
