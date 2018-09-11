package com.sqs.stepDefinitions;

import com.sqs.cucumber.TestContext;
import com.sqs.pageobjects.UpdateIssuePage;

import cucumber.api.java.en.Given;

public class UpdateIssueStep 
{
	UpdateIssuePage UpdateIssue;
	TestContext UpdateContext;
	
	public UpdateIssueStep(TestContext context)
	{
		UpdateContext = context;
	 UpdateIssue=UpdateContext.getPageObjectManager().getUpdatePage();
	}
	
	@Given("^User already logged in$")
	public void logged_in_user_update()throws Throwable 
	{
		UpdateIssue.navigate_home_up();
	}
	@Given("^User has searched needed issue$")
	public void searched_issue_update()throws Throwable
	{
		UpdateIssue.search_issue_up();
	}
	@Given("^User select issue for update$")
	public void select_issue_update()throws Throwable
	{
		UpdateIssue.select_issue();
	}
	@Given("^Update Category$")
	public void select_cat()throws Throwable
	{
		UpdateIssue.select_cat("3");
	}
	@Given("^Update Priority$")
	public void select_prio()throws Throwable
	{
		UpdateIssue.select_priority_up("50");
	}
	@Given("^Update Severioty$")
	public void select_sev()throws Throwable
	{
		UpdateIssue.select_severity_up("70");
	}
	@Given("^Update Reproducibility$")
	public void select_rep()throws Throwable
	{
		UpdateIssue.select_repo_up("10");
	}
	@Given("^Update resolution$")
	public void select_res()throws Throwable
	{
		UpdateIssue.select_resolution_up("20");
	}
	@Given("^Update issue$")
	public void update_issue() throws Throwable
	{
		UpdateIssue.update_issue();
	}

	
}
