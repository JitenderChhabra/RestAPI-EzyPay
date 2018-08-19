## Rest-Assured Automation Example ##

###  Overview
---
This project provides an example of how to use the REST-assured library to functional tests for REST APIs in Java.

REST-assured is a Java library that aims to make it simpler to write out-of-process, functional tests for REST APIs, that are written in Java (or other JVM languages).

This is an example application of Rest-Assured as a basis for API test fremwork. I don't hold any strict convention, I'm just showing different posible options one can have for handling requests, responses and assertions.


### API 
-----
API used in the example is the Login API where the endpoint takes a username and password, and returns them if the login has been successful or a descriptive error if it fails.

##### Sample successful JSON response:
{

 "username": "test-user",

 "password": "abc123"

} 

##### sample failed JSON response:
{

 "Code": "UnauthorizedError",

 "Message": "UnauthorizedError: invalid username or password"

}


### Framework
---
The example REST-assured test cases are implemented in Java (8.x) using Testng (6.x) and REST-assured (2.x).



### Structure ###

This project is your standard Maven Java project with src folders and POM.xml.

### Packages ###

Total 4 packages are created as mention below:

- com.ezypay.testscripts
- com.ezypay.utills
- com.ezypay.webservices.common
- com.ezypay.webservices.methods

**TestScripts** have a "*LoginScenarios*" class where we have all the login based test scripts.

**Utills** have two classes "*EndPointURL*" & "*URL*" as the name suggests URL breaks in this classes.

**Common** package have three classes "*Common*", "*FileUtils*" & "*PropertyConstants*" containing commonly used classes.

**Methods** has "*Webservices*" class where four all API methods defined (GET, POST, PUT & DELETE).
 

### Properties ###

appSettings.properties is a simple properties file to store various configurations.

servicelogin.JSON is another properties file having user credentials which we pass through body.


