# SOFTWARE DESIGN PROJECT
******
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)     ![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white) ![Postman](https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=postman&logoColor=white) ![MySQL](https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white) ![Apache Groovy](https://img.shields.io/badge/Apache%20Groovy-4298B8.svg?style=for-the-badge&logo=Apache+Groovy&logoColor=white)

### PROJECT THEME :
##### A platform that enables clients to procure services from a vendor. A client can make an account on the platform, order a service, the admin gets notified that a service has been ordered. 
### FEATURES :
- administration of the available services from the admin page
- management of user accounts, including their creation and modification
- the ability to procure a service through the platform
- a notifications system that allows users to be notified through the email every time an update is made to his account or an order
- a notifications system that allows admins to be notified through the admin panel or by email every time a user makes an order
- catalog with filters, allowing users to create filters for their needs


### DATABASE SCHEME :
![Database](https://i.postimg.cc/zDbXW70G/db-schema.png)

### ENDPOINTS :
- USER : add, delete, update, getAll, getById
- ADMIN : add, delete
- ORDER : add, delete, update, getAll, getById
- PRODUCT : add, delete, update, getAll, getById

### JUNIT TESTING : 
The JUnit testing was made for the service classes available, all methods were tested. Testing was made with the Mockito library for mocking the objects, mocking dependencies, and to make assertions about the behavior of the code
By writing these tests we were able to catch and fix issues early in the development process saving time and effort in the long run.
This also ensures reliability and easy maintenance of the code.
JUnit tests were created for all the classes that include business logic.
