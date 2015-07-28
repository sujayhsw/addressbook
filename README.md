
#ADDRESSBOOK

Assumptions
--------------
   - Addressbook File is provided in file as input to application.File path should be provided as argument.
   - Provided Addressbook is valid as no validations for fields are provided in solution.
   - Tests uses provided sample Addressbook as test data.
   - Used Gradle as build tool, no DI containers used.
 
INSTRUCTIONS FOR EXECUTION
---------------------------
   - Application is bundled as jar.
   - You can package it with following command,

      gradlew clean build

   - after successful bundling as jar, Application can be executed using following command,
   
      java -ea -jar addressbook-1.0.jar <Addressbook-input-file-path>
