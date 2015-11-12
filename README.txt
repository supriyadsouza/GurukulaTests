***********************************************
Automation Testing of Gurukula Application
***********************************************

Automation Framework
The Automation framework has been built with Selenium, Java and TestNG. Required libraries are entered in the Maven POM file.
The Page Object Model has been employed to build the test framework. Various pages and interaction with their elements have been specified in the com.gurukula.structure package. The tests are built into a separate package called com.gurukula.tests. This divison enhances the maintainability of the test code.

Tests Automated
1. Registering a new user
2. Logging in and logging out(implicit)
3. Viewing and Editing logged in information
4. Adding/Viewing/Editing/Deleting a branch
5. Adding/Viewing/Editing/Deleting a staff

Steps to Run
1. Build the project
2. Run the testRegistration.xml file as a TestNG suite (this only tests registration functionality)
3. Run the testUseCases.xml file as a TestNG suite (this will test logging in as admin and everything else)