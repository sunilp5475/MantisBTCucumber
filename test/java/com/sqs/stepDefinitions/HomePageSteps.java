package com.sqs.stepDefinitions;

import com.sqs.cucumber.TestContext;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import com.sqs.pageobjects.HomePage;

public class HomePageSteps 
{
	
	HomePage Home;
	TestContext testContext;
	
	public HomePageSteps(TestContext context) {
		testContext = context;
		Home = testContext.getPageObjectManager().getHomePage();
	}
	
	@Given("^User on home page$")
	public void user_on_home_page() throws Throwable 
	{
       Home.navigate_to_home();
	}
	@Then("^user name input box visible$")
	public void user_name_input_box_visible()throws Throwable
	{
		Home.enter_username();  
	}
	@Then("^password name input box visible$")
	public void password_name_input_box_visible()throws Throwable
	{
	   Home.enter_password();	   
	}
	@Then("^login button is available$")
	public void login_button_is_available()throws Throwable
	{
	   Home.submit_login();	   
	}
	@Then("^forgot password link is visible$")
	public void forgot_password_link_is_visible()throws Throwable
	{
	   Home.fogot_link();
	}
	@Then("^MantisBT image is displayed$")
	public void MantisBT_image_is_displayed() throws Throwable
	{
		Home.image_mbt();
	}
	@Then("^close browser$")
	public void close_browser() throws Throwable
	{
		Home.close_browser();	
	}
}
