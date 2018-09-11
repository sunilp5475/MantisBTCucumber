

Feature: Login to application
  

  @Home(order=0)
  	Scenario: User navigate to home page
    Given User on home page
    And  user name input box visible
    And  password name input box visible
    And  login button is available
    And  forgot password link is visible
    And  MantisBT image is displayed 
    And  close browser 
 
    
     
  @Login(order=1)
  Scenario: User able to login MantisBT application 
    Given User is on Home Page 
    And User enter username
    And User enter password
    And User submit login button
    And Verify user is on My View page
    And User logout
   
  @ReportIssue(order=2)
  Scenario: User able to Report issue
  Given User is on Report issue page
  And User clicks on report issue link
  And Select category
  And Select Reproducibility
  And Select Severity
  And Select Priority
  And Enter Platform
  And Enter Operating System
  And Enter OS version
  And Enter Summary
  And Enter Description
  And Select Report stay
  Then Report issue
  
  @SearchIssue(order=3)
  Scenario: User able to search any issue
  Given User is loged in 
  Given User is on view issue page
  And User enter issue id in search input box
  And User click apply filter button
  Then issue should display in table
  
  @AssignIssue(order=4)
  Scenario: User able to assign any issue to assignee
  Given User is logged in
  And User has searched desired issue
  And user select issue for assign
  And user select assign option
  And user click on ok
  And user click on Assign issue button
  Then user is on view issue page
  
  @UpdateIssue(order=5)
  Scenario: User able to update any issue 
  Given User already logged in
  And User has searched needed issue
  And User select issue for update
  And Update Category
  And Update Priority
  And Update Severioty
  And Update Reproducibility
  And Update resolution
  Then Update issue