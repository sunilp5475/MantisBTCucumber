package com.sqs.stepDefinitions;

import com.sqs.cucumber.TestContext;
import com.sqs.pageobjects.AssignIssuePage;
import com.sqs.pageobjects.ViewIssuePage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class AssignIssueStep 
{

	AssignIssuePage AssignIssue;
	TestContext AssignContext;
	
	public AssignIssueStep(TestContext context)
	{
	 AssignContext = context;
	 AssignIssue=AssignContext.getPageObjectManager().getAssignPage();
	}
	ViewIssuePage vIPage;
	
	
	@Given("^User is logged in$")
	public void logged_in_user()throws Throwable 
	{
		AssignIssue.navigate_home_mantis();
	}
	@Given("^User has searched desired issue$")
	public void searched_issue()throws Throwable
	{
		AssignIssue.search_issue();
	}
	@Given("^user select issue for assign$")
	public void select_issue() throws Throwable
	{
		AssignIssue.select_issue();
	}
	@Given("^user select assign option$")
	public void select_action() throws Throwable
	{
		AssignIssue.select_option("ASSIGN");
	}
	@Given("^user click on ok$")
	public void click_ok_button() throws Throwable
	{
		AssignIssue.click_ok();
	}
	@Given("^user click on Assign issue button$")
	public void assign_issue() throws Throwable
	{
		AssignIssue.assign_issue();
	}
	@Then("^user is on view issue page$")
	public void verify_issue_updated()
	{
		AssignIssue.issue_updated();
	}
}
