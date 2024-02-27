Feature: Practo automation Home page

Scenario: Title Verification
Given Launching the driver
When User fetch title and verify it


Scenario: Searching for City and Speciality
Given User navigate to Hospital page
When User search for City
And User search for Speaciality

Scenario: Applying Filters
Given User apply City and Speciality
When User Apply all the filters

Scenario: Extracting Doctor name
Given User apply all filters
When User extract first five doctor name





