package com.sqs.stepDefinitions;

import cucumber.api.java.en.Given;
import com.sqs.pageobjects.LoginPage;
import com.sqs.cucumber.TestContext;

public class LoginSteps
{
	
	LoginPage Login;
	TestContext loginContext;
	
	
	public LoginSteps(TestContext context)
	{
	 loginContext = context;
	 Login=loginContext.getPageObjectManager().getLoginPage();
	}
	
	@Given("^User is on Home Page$")
	public void home_page() throws Throwable 
	{
      Login.home_page();
	}
	


	@Given("^User enter username$")
	public void user_enter_username() throws Throwable {
		Login.enter_username("administrator");
	}

	@Given("^User enter password$")
	public void user_enter_password() throws Throwable 
	{
		Login.enter_password("root");
	}

	@Given("^User submit login button$")
	public void user_submit_login_button() throws Throwable 
	{
		Login.submit_login();
	}
    @Given("^Verify user is on My View page$")
    public void view_page() throws Throwable
    {
    	Login.my_view();
    }
	@Given("^User logout$")
	public void logout() throws Throwable
	{
	 Login.close_browser();	
	}
	


	
}
