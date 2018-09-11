package com.sqs.stepDefinitions;

import com.sqs.cucumber.TestContext;
import com.sqs.pageobjects.ViewIssuePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class SearchIssueStep 
{
	ViewIssuePage SearchIssue;
	TestContext ReportContext;
	
	public SearchIssueStep(TestContext context)
	{
	 ReportContext = context;
	 SearchIssue=ReportContext.getPageObjectManager().getIssuePage();
	}
	
	@Given("^User is loged in$")
	public void user_logedin() throws Throwable
	{
		SearchIssue.navigate_home();
	}
	
	@Given("^User is on view issue page$")
	public void user_is_on_view_issue_page() throws Throwable 
	{
		SearchIssue.view_issue();
		Thread.sleep(2000);
	}
	@Given("^User enter issue id in search input box$")
	public void user_enter_issue_id() throws Throwable
	{
		SearchIssue.Enter_issue("227");
	}
	@Given("^User click apply filter button$")
	public void user_click_apply_filter() throws Throwable
	{
		SearchIssue.search_issue();
	}
	@Then("^issue should display in table$")
	public void issue_should_display() throws Throwable
	{
		SearchIssue.issue_list();
	}
	
	
}
