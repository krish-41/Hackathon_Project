Feature: Health and Wellness
 
  @sanity
  Scenario: verify Schedule a demo button navigation
  	Given User click on For Corporate button
  	When click on Health and Wellness button
  	And User verify schedule button with Invalid Contact Number
  	And verify schedule button with Valid Information
  	Then verify Thankyou message is displayed or not
