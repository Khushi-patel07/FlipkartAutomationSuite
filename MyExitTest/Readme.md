#www.flipkart.com Website Automation Suite Information :

<h4>To run the www.flipkart.com Automation Suite from command line in the project folder:</h4>

1. mvn clean test or mvn test -DsuiteXmlfile= LoginTest.xml.<br>
2. mvn clean test or mvn test -DsuiteXmlfile= HomeTest.xml.<br>
3. mvn clean test or mvn test -DsuiteXmlfile= SearchboxTest.xml.<br>
4. mvn clean test or mvn test -DsuiteXmlfile= CartTest.xml.<br>
5. mvn clean test or mvn test -DsuiteXmlfile= TravelTest.xml.<br>
6. mvn clean test or mvn test -DsuiteXmlfile= OtherOptionsTest.xml.</h4></h4>

**To run through jenkins:**

-download jenkins.war file<br>
-run in cmd<br>
 java -jar jenkins.war --httpPort=8080<br>
-setup jenkins<br>

**To run using github link:**

-Clone repo from the github link<br>
-gitHub link :- https://github.com/Khushi-patel07/FlipkartAutomationSuite.git<br>

**To run using bat file:**

-Double click on batchfile.bat

<h4>Testng files description:</h4>

- **LoginTest.xml**- define the tests related to user login.<br>
- **HomeTest.xml**- define the tests related to homepage of flipkart.<br> 
- **SearchboxTest**- define the test related to search text box to search products.<br>
- **CartTest.xml**- define the test to check and add product to the cart.<br>
- **TravelTest.xml**- define the test for travel services of flipkart.<br>
- **OtherOptionsTest.xml**- define all other test of flipkart website.<br>

<h4>Packages description:<br></h4>

- **.com.MyExitTest.pages**:- Defining all the pages actions and the respective object repository.<br> 
- **.com.MyExitTest.tests**:- Defining all the pages tests and assertions.<br>
- **.com.MyExitTest.utils**:- Defining all the utilities needed for the tests.<br>

##### Tests.java files description:
- **Base Test**:-The main class which defines:-<br>
          @BeforeMethod- to open the browser, to open url and get the name of the test.<br>
          @AfterMethd- to attach screenshot and to quit the browser.<br>
          @BeforeSuite- to set Extent.<br>
          @AfterSuite- to end the report.<br>
- **LoginTest**:- Includes test- to verify valid login,invalid login and blankuser login on flipkart website.<br>
- **HomeTest**:-Includes test- to verify valid sign in , invalid sign in and blankusername sign in.<br>
- **SearchboxTest**:- To Search Products.<br>
- **CartTest**:-To check and add products to the cart.<br>
- **TravelTest**:-To test travel page of flipkart.<br>
- **OtherOptionsTest**:-To test all other pages like Exploreplus,HelpCenterFlipkart,TopOffers,Advertise,BecomeASeller,
                        FlipkartYoutube,ContactUs,AboutUs,NotificationPreference,DownloadApp,GiftCards and Facebook.<br>

#####Other files description:

- Screenshot.java:- defines function to take screenshots.<br>
- ExcelReader.java:- define function to read excel sheet.<br>
- CommonUtils.java:- define function to check execution required for tests or not.<br>

#####Reports and Screenshots:

- Extent report gets generated after the run under Reports/ExtentReport.html.<br>
- Screenshots gets placed under FailedScreenshot folder.<br>

#####Drivers and Resources:

- Drivers folder kept all browsers which are used to test website<br>
                 -chromedriver.exe : drivers for chrome<br>
                 -geckodriver.exe : drivers for firefox<br>
                 -msedgedriver.exe: drivers for microsoft edge.<br>
- Resources folder consist config.properties file to use global parameters and TestData.xlsx file to read test data.<br>
- Jars folder contain Screenshot.jar file(reusable libraries)for taking screenshots.<br>

#####Headless Mode:
- Headless mode is a way to run browsers without the actual browser UI being spawned. its running browsers like IE, Chrome, FF   without showing actual windows of browsers. In headless mode there is no need a visible UI shell.<br>

#####Logger Implementation:
- Implement logger using Log4j2 in Lig4j2.xml.<br>
- Logging is an important feature that helps developers to trace out the errors.It is use for tracking events that happen when some software runs.<br>
- Logs gets placed under Logs folder.<br> 

#####Screenshots:
![Jenkins Setup](./photoes/image1.png)
![Jenkins Setup](./photoes/image2.png)
![Jenkins Setup](./photoes/image3.png)
![Jenkins Setup](./photoes/image4.png)


#####Implemented features:
-Create atleast 20 automated scenarios across different flows and screens.-**done**<br>
-Implement POM.-**done**<br>
-Test data should be read from excel.User has the ability to selective run the test cases by marking yes in the Execution Required field in excel.- **done**<br>
-Global Parameters should be read from config file like browser name, test site URL, global wait value etc. should be read from a properties file -**done**<br>
-Use proper waits i.e. implicit wait and explicit wait wherever necessary.-**done**<br>
-There should be an option to run the test cases in headless mode.-**done**<br>
-The test should run on following browsers IE, Chrome, FF - **done**<br>
-There should be an option to run the test cases in headless mode.-**done**<br>
-Use Grouping, Priority, and enable/disable when creating the TestNG Test Cases.-**done**<br>
-Assertions and error screenshot in the extent report.-**done**<br>
-Create reusable libraries and import these as jars in the current project.-**done**(com.ReusableMethod.utils)<br>
-Create a ReadMe document which has the steps to install and run the code.-**done**<br>
-Integration with github and Jenkins.-**done**<br>
-Test Suite should be executable from command line using maven.-**done**<br>
-Use Logger to implement logging in your test cases.-**done**<br>

