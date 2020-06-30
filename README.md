# LumiraDX blog API Technical Test

This is automation suite designed to test the Swagger LumiraDX Blog API Prototype Blog API v0.2.\

The project has 35 scenarios in total, that can be located within the below feature files\
* src/test/resources/featureFiles/blogCategory.feature : Scenarios 1-12 cover the operations related to blog categories
* src/test/resources/featureFiles/blogPosts.feature : Scenarios 13-35 cover the operations related to blog posts

#Tools/Framwork/Libraries
```
*JDK 14
*Maven - build tool
JUnit - assertions
Cucumber - BDD/Gherkin style feature files and runner
Rest assured - Rest api verification library
```
 
# Launch the Swagger application 
 Before running the automation suite the application LumiraDX blog api needs to be started following the instructions provided in the link below
 https://github.com/amaccormack-lumira/rest_api_demo/blob/master/README.md
 
 If the base URL has to be changed it can be done in the below file location\
 
 src/main/java/apiUtils/Base.java 
 ``` 
 public static final String BASE_URL = "http://localhost:8888/api";
 ```
 
**Note:** This automation test suite has implemented the end point  " http://localhost:8888/api/ "\

**_I was not able to load https://localhost:8889/api/_** with the instructions provided.

 
 # Executing the Automation suite
 
 This suite should work on both windows and mac platforms. However, I have tested only on windows.
 
 In order to execute the automation suite 
 
``` 
You will need:
  - Java 1.8+ installed [I ran it on JDK 14]
  - Maven installed [I used version 3.6.2]
  -Intellij or another Java IDE
 ```
 
Download a copy of the automation project from: https://github.com/VenkataBendi/LumiraDXblogApiTechnicalTest/archive/master.zip \

Once downloaded, extract the zip file, and use a Command Prompt to naviage to the the extracted project folder. The automation test can then be run using the following command:
```
mvn test
```
_Do not use **mvn clean test** as this will re-set the target folder which contains the .json files for response schema validations in the tests_\

All the 35 scenarios will be executed. A cucumber report file will be generated and can be found in the below path in the extracted project folder
'test-Test Reports/api_cucumber_report.html'

# Expected Results
All Scenarios except TC02,TC03 and TC14 will pass.\

TC02(two examples), TC03 and TC14 fail due to bugs in the api application detailed in the bug report.

**To re-run the automation test suite with the same test data, it is required to extract the swagger application file again and re-launch. If this is not performed in addition to the above failed scenarios TC28 will also fail. Hoever, TC02(first example) and TC28 fail due to invalid test data**

 
 
 
 
