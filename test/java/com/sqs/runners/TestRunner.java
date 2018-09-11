package com.sqs.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.cli.Main;
import org.junit.runner.RunWith;	

@SuppressWarnings("unused")
@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/functionalTests/Login.feature",glue= {"com.sqs.stepDefinitions"},plugin={"pretty","html:target/cucumber-reports"},
		monochrome = true
		)
public class TestRunner 
{

}
