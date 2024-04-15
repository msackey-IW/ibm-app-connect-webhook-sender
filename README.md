# DEMO THE USE OF WEBHOOKS IN IBM APP CONNECT
This guide demonstrates how to integrate IBM App Connect with a Spring Boot application using webhooks. Webhooks allow you to trigger actions in IBM App Connect from events in the SprigBoot Application, providing seamless integration between the two platforms. This is demonstrated by creating a Person object which sends a notification to Slack trough IBM App Connect.

## Required Software
- An IDE ( [Visual Studio Code](https://code.visualstudio.com/download) or [intellij IDEA](https://www.jetbrains.com/idea/download/?source=google&medium=cpc&campaign=APAC_en_AU_IDEA_Branded&term=intellij+idea&content=602143185772&gclid=EAIaIQobChMI-f3uuYnegwMVwqRmAh0_ewXKEAAYASABEgImY_D_BwE&section=windows) )
- [Postman API](https://www.postman.com/downloads/)
- [Java](https://www.oracle.com/java/technologies/downloads/) 17 at minimum installed on your local machine.
- An account with [IBM App Connect Designer](https://d80gwbszdj-designer.p-syd-c1.appconnect.automation.ibm.com/home)

## STARTING APP CONNECT DESIGNER
- Open your IBM App Connect Account
- Navigate to `dashboard -> new -> import flow`
- Import and start the `Webhook-openapi.yaml` file located in the  `app-connect-flow` folder.


##  STARTING THE SPRING-BOOT APPLICATION
- Open the terminal and navigate to the directory for your application
- Run the code below to clone the application from github
```bash
git clone https://github.com/msackey-IW/ibm-app-connect-webhook-sender
```
- Run `cd ibm-app-connect-webhook-sender`
- Run `mvn clean spring-boot:run`
- The application should now be ready to take requests.

## TESTING THE INTEGRATION
- Open the Postman Application
- Send a `POST` request to the url below
```
http://localhost:8080/send-webhook
```
- You should now receive a notification on slack confirming a new individual has been created.


For more information, refer to the [IBM App Connect](https://www.ibm.com/docs/en/app-connect/saas)