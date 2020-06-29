# LumiraDXblogApiTechnicalTest
This is automation suite designed to test the Swagger LumiraDX Blog API Prototype Blog API v0.2.\
The project has 35 scenarios  in total that can be located within the below feature files\
* src/test/resources/featureFiles/blogCategory.feature : Scenarios 1-12 cover the operations related to blog categories
* src/test/resources/featureFiles/blogPosts.feature : Scenarios 13-35 cover the operations related to blog posts


 -python 3 (for the application
 
 Before running the automation suite the application LumiraDX blog api needs to be started follwing the instructions provided in the link below
 https://github.com/amaccormack-lumira/rest_api_demo/blob/master/README.md
 
 If the base URL has to be changed it can be done in the below file location\
 
 src/main/java/apiUtils/Base.java 
 ``` 
 public static final String BASE_URL = "http://localhost:8888/api";
 ```
 
**Note:** This automation has implemented the end point  " http://localhost:8888/api/ "\

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
 
 In order to execute the automation suite navigate to the 
 
 
 
 
