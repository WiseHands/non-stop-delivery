# NonStop Delivery
[NonStop delivery](http://nonstop-delivery.com/)

Requirements: 

1. MySQL 5 or higher with a schema 'wdelivery'

2. Java 8 or higher

3. Maven 3 or higher

How to set up locally:

 1. In directory src/main/resources/ copy file application.properties.example to the same directory with a name application.properties
 
 2. In application.properties file specify your MySQL username and password
 
 3. Additionally, you can specify your email login/password. You may need to set up your mail provider. Refer to https://support.google.com/accounts/answer/6010255?hl=en for example. 
 
 4. Execute 'mvn clean install -Dskip.tests=true' in root repository directory.
 
 5. Run application with 'mvn spring-boot:run'

 6. A note, you need to assign or change user roles manually.