### RESTful WebService with AngularJS
This pretty straightforward web application shows how Java EE 7 RESTful Web Services API 
might be utilized together with popular JavaScript framework of AngularJS.

WildFly (former JBoss) application server environment, 
JAX-RS web services, client-side scripting with AngularJS and a bit of styling with Bootstrap.        

### Technology Stack
* JDK 8
* Apache Maven v.3.2
* Java EE 7.0 (JAX-RS, CDI, EJB)
* AngularJS v.1.4
* Bootstrap v.3.3.4 (CSS styling)
* WildFly Application Server v.8.2

### Build Instructions
Invoke the following maven command from the app root dir:

`mvn clean package`

Examine build log, make sure build was successful:

`[INFO] BUILD SUCCESS`

### Launch Instructions
Once the app is assembled, deploy angular-rest-consumer.war to WildFly server.

a. Client-side:
`The entry point is index.html - it carries styling onboard and contains all the clues to the involved .js files.` 
 
b. Server-side:
`ItemResource class is the root.`