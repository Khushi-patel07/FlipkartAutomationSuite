#www.flipkart.com Website Automation Suite Information :

<h4>To run the www.flipkart.com Automation Suite from command line in the project folder:</h4>

1. mvn clean test -DsuiteXmlfile= LoginTest.xml.<br>
2. mvn clean test -DsuiteXmlfile= HomeTest.xml.<br>
3. mvn clean test -DsuiteXmlfile= SearchboxTest.xml.<br>
4. mvn clean test -DsuiteXmlfile= CartTest.xml.<br>
5. mvn clean test -DsuiteXmlfile= TravelTest.xml.<br>
6. mvn clean test -DsuiteXmlfile= OtherOptionsTest.xml.</h4></h4>

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

- **Base Test**:-The main class which defines @BeforeMethod - to open the browser and get the name of the text-@AfterMethod -to      quit the browser- After Test-to close the extent report.<br>
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

- Drivers folder kept all browsers which are used to test website.<br>
- Resources folder consist config.properties file and TestData.xlsx file.<br>
- Jars folder contain Screenshot.jar file(reusable libraries)for taking screenshots.<br>

#####Headless Mode:
- Headless mode is a way to run browsers without the actual browser UI being spawned. its running browsers like IE, Chrome, FF,  EDGE without showing actual windows of browsers. In headless mode there is no need a visible UI shell.<br>

#####Logger Implementation:
- Implement logger using Log4j2 in Lig4j2.xml.<br>
- Logging is an important feature that helps developers to trace out the errors.It is use for tracking events that happen when some software runs.<br>
- Logs gets placed under Logs folder.<br> 

