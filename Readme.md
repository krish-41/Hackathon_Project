####****Hackathon Project-Finding Hospitals****
## Overview
This Java Selenium project automates tasks on the Practo site, including navigation, searches, and information extraction. It utilizes TestNG for testing, Apache POI for handling Excel data, Extent Report for reporting, and logging for tracking script execution.
 
 
## Test Cases
 
1.**Module 1:**
 
1. Navigate to Practo.com Homepage.
2. Enter location  (like Chennai, Bangalore, Pune, etc).
3. Enter specialist (like Dentist, Cardiologist, etc).
4. Apply filters for Patient Stories,Experience
5. Click on All Filters and select Fees, Availability and any one Sorting option.
5. Fetch First five doctors.
6. Display the first 5 Doctor details on console and store data in excel.
   
2. **Module 2:**
 
1. Navigate to Practo.com Header.
2. Go to "Surgeries".
3. Extract all the surgeries in a List.
4. Store all the surgeries in a List.
5. Display them in console output and store data in excel.

3.**Module 3:**
 
1. Navigate to Practo.com Header.
2. Click on "For Corporate" under that select "Health and Wellness Plan" .
3. Fill the form with invalid Mobile number and verify Submit button is enabled or not.
4. Fill the form with invalid Email id and verify Submit button is enabled or not.
5. Fill the form with valid data and verify Submit button is enabled or not.
6. Print the observation in console output.
7. Validate "Thank You" message is displayed or not. 

## Dependencies
- Selenium: `<4.15.0>`
- TestNG: `<7.9.0>`
- Apache POI: `<5.2.4>`
- Extent Report: `<5.1.1>`
- Logging: `<2.20.1>`
 
## Scripting Language
- Java
## Framework
- Maven `<4.0.0>`

## Author
Krishna Chaudhari (21910902)